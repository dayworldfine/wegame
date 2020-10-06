package com.wegame.controller;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.wegame.config.BaseController;
import com.wegame.model.User;
import com.wegame.service.UserService;
import com.wegame.tools.JsonResult;
import com.wegame.tools.redis.RedisService;
import com.wegame.tools.utils.MD5Utiles;
import com.wegame.tools.utils.RedisUtil;
import com.wegame.tools.utils.SmsUtil;
import com.wegame.tools.utils.ValidateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName：Loogin
 * @Description: 登录接口
 * @Author：13738700108
 * @Data 2020/2/19 17:24
 * @Version: v1.0
 **/

@RestController
public class LoginController extends BaseController {

    @Autowired
    private SmsUtil smsUtil;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService userService;

   /**
        * @api {POST} /login 接口路径
        * @apiGroup login
        * @apiVersion 1.0.0
        * @apiDescription 登录
        * @apiParam {String} userName 账号
        * @apiParam {String} passWord 密码
        * @apiParamExample {json} 请求样例：
        *                ?id=bfc5bd62010f467cbbe98c9e4741733b
        * @apiSuccess (200) {String} code 200:成功</br>
        *                                 400:账号密码错误
        * @apiSuccess (200) {String} message 信息
        * @apiSuccess (200) {String} data 返回用户信息
        * @apiSuccessExample {json} 返回样例:
        * {
        * 	"code": 200,
        * 	"message": "登录成功",
        * 	"data": "{}"
        * }
        */
    @PostMapping("/login")
    public JsonResult login(String userName,
                            String passWord){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,passWord);
        try {
            subject.login(usernamePasswordToken);
            System.out.println("token:"+subject.getSession().getId());
            User user = (User) subject.getPrincipals().getPrimaryPrincipal();
            JSONObject object = new JSONObject();
            object.put("token",subject.getSession().getId());
            object.put("userId",String.valueOf(user.getId()));
            return JsonResult.success(object);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.paramError("账号密码错误");
        }
    }

    /**
     * @api {POST} /changeSubject 获取验证码
     * @apiGroup 接口小组
     * @apiVersion 1.0.0
     * @apiDescription 接口说明
     * @apiParam {String} id 机构ID
     * @apiParamExample {json} 请求样例：
     *                ?id=bfc5bd62010f467cbbe98c9e4741733b
     * @apiSuccess (200) {String} code 200:成功</br>
     *                                 404:机构不存在/ID为空</br>
     * @apiSuccess (200) {String} message 信息
     * @apiSuccess (200) {String} data 返回用户信息
     * @apiSuccessExample {json} 返回样例:
     * {
     * 	"code": 200,
     * 	"message": "登录成功",
     * 	"data": "{}"
     * }
     */
    @PostMapping("/sendSms")
    public JsonResult sendSms(String account){
        Subject subject = SecurityUtils.getSubject();

        DefaultProfile profile = DefaultProfile.getProfile(smsUtil.getRegionId(), smsUtil.getAccessKeyId(), smsUtil.getSecret());
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", smsUtil.getRegionId());
        request.putQueryParameter("PhoneNumbers", account);
        request.putQueryParameter("SignName", smsUtil.getSignName());
        request.putQueryParameter("TemplateCode", smsUtil.getTemplateCode());
        String code = SmsUtil.generalRandomVeriCode();
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        redisService.set(account,code,60l);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
            return JsonResult.failure(401,"获取验证码错误");
        } catch (ClientException e) {
            e.printStackTrace();
            return JsonResult.failure(401,"获取验证码错误");
        }
        //存入本地缓存

        return JsonResult.success("发送成功");
    }


    @PostMapping("/register")
    public JsonResult register(String userName,
                               String nickName,
                               String code,
                               String pwd,
                               String account){
       if (!redisService.get(account).toString().equals(code)){
           return  JsonResult.failure("验证码错误");
       }
        User userByUserName = userService.findUserByUserName(userName);
       if (ValidateUtil.isNotEmpty(userByUserName)){
           return JsonResult.failure("该登录账号已存在");
       }
        userService.addUser(userName,nickName,pwd,account);
        return JsonResult.success("注册成功 请使用新账号登录");
    }

    @PostMapping("/textRedis")
    public JsonResult textRedis(){
        /**
         * 测试redis发现Jedis 链接验证失败   而redis 可以正常使用  原因正在排查中
         */
        String setex = redisUtil.setex("13900000000", "666666", 60);
        String set = redisUtil.set("13900000000", "666666", 0);
        String s = redisUtil.get("13900000000", 0);
        System.out.println("s:"+s);

        redisService.set("13900000000","666666",60l);
        Object o = redisService.get("13900000000");
        System.out.println("o:"+o);

        return JsonResult.success("发送成功");
    }


}
