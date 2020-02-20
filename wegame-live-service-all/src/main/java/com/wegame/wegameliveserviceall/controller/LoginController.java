package com.wegame.wegameliveserviceall.controller;

import com.wegame.wegameliveserviceall.base.JsonResult;
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
        * @apiGroup
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
        System.out.println("111111");
        return JsonResult.success();

    }
}
