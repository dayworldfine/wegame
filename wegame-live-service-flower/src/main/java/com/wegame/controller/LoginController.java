package com.wegame.controller;


import com.alibaba.fastjson.JSONObject;
import com.wegame.model.User;
import com.wegame.tools.JsonResult;
import com.wegame.tools.utils.MD5Utiles;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
public class LoginController {

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


}
