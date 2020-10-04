package com.wegame.controller;


import com.alibaba.fastjson.JSONObject;
import com.wegame.config.BaseController;
import com.wegame.dto.SeatUserDto;
import com.wegame.model.User;
import com.wegame.service.FriedFlowerService;
import com.wegame.tools.JsonResult;
import com.wegame.tools.utils.EnumUtils;
import com.wegame.tools.utils.ValidateUtil;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @ClassName：FriedFlowerPortController
 * @Description: 炸金花接口
 * @Author：13738700108
 * @Data 2020/3/20 22:10
 * @Version: v1.0
 **/
@RestController
@RequestMapping("/friedFlowerPort")
public class FriedFlowerPortController extends BaseController {

    @Autowired
    private FriedFlowerService ffs;

    /**
     * @api {POST} /friedFlowerPort/userSitDown 坐下
     * @apiGroup friedFlowerPort
     * @apiVersion 1.0.0
     * @apiDescription 坐下
     * @apiParam {int} type 类型
     * @apiParam {int} roomSerial 房间序号
     * @apiParam {int} userCode 用户code
     * @apiParam {int} seatSerial 座位序号
     * @apiParam {String} userImg 用户头像
     * @apiParam {String} userNickName 用户昵称
     * @apiParam {int} integral 积分
     * @apiParamExample {json} 请求样例：
     *                /friedFlowerPort/userSitDown?type=3&roomSerial=1&userCode=123&seatSerial=3&userImg="11"&userNickName="wang"&integral=11
     * @apiSuccess (200) {String} code 200:成功</br>
     *                                 401:该位置已经有人坐下了</br>
     *                                 402:被人捷足先登</br>
     * @apiSuccess (200) {String} message 信息
     * @apiSuccess (200) {String} data 返回用户信息
     * @apiSuccessExample {json} 返回样例:
     * {
     * 	"code": 200,
     * 	"message": "成功坐下",
     * 	"data": "{}"
     * }
     */
    @PostMapping("/userSitDown")
    public JsonResult userSitDown(int type,
                                  int roomId,
                                  int userId,
                                  int seatId,
                                  String userImg,
                                  String userNickName,
                                  int integral){
        //查询这个座位是否有人
        int num = ffs.selSeatHavePeople(roomId,seatId);
        if(0<num){
            return JsonResult.failure(401,"该位置已经有人坐下了");
        }else{
            int mif = ffs.SaveUserSitDown(userId,seatId,roomId);
            if (0<mif){
                ffs.sendUserSitDown(type,roomId,userId,seatId,userImg,userNickName,integral);
                return  JsonResult.success("成功坐下");
            }else{
                return JsonResult.failure(402,"被人捷足先登");
            }
        }
    }

    /**
     * @api {POST}  /friedFlowerPort/userSetOut 准备
     * @apiGroup friedFlowerPort
     * @apiVersion 1.0.0
     * @apiDescription 准备
     * @apiParam {int} id 类型
     * @apiParam {int} id 房间序号
     * @apiParam {int} id 用户code
     * @apiParam {int} id 座位序号
     * @apiParamExample {json} 请求样例：
     *               /friedFlowerPort/userSetOut?type=3&roomSerial=1&userCode=123&seatSerial=3
     * @apiSuccess (200) {String} code 200:成功</br>
     *                                 401:准备失败</br>
     * @apiSuccess (200) {String} message 信息
     * @apiSuccess (200) {String} data 返回用户信息
     * @apiSuccessExample {json} 返回样例:
     * {
     * 	"code": 200,
     * 	"message": "准备成功",
     * 	"data": "{}"
     * }
     */
    @PostMapping("/userSetOut")
    public JsonResult userSetOut(int type,
                                 int roomId,
                                 int userId,
                                 int seatId){
//        String asd ="123123.23123";
//        Integer.valueOf(asd);
        int num =  ffs.saveUserSetOut(roomId,userId,seatId);
        if (0<num){
            //发送即时通讯有人准备
            ffs.sendUserSetOut(type,roomId,seatId);
            ExecutorService cachePool = Executors.newCachedThreadPool();
            cachePool.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    //查询 是否满足开始游戏条件
                    List<SeatUserDto> countMap= ffs.selGmaeStartCondition(roomId);
                    //如果等于0 说明进入房间的人都准备了 要开始游戏
                    List<SeatUserDto> SeatUserDtoCount = countMap.stream()
                            .filter(p -> ValidateUtil.isNotEmpty(p.getUserId()) && 0 != p.getUserId())
                            .collect(Collectors.toList());
                    List<SeatUserDto> SeatUserDtoCountSetOut = countMap.stream()
                            .filter(p -> ValidateUtil.isNotEmpty(p.getUserId()) && 0 != p.getUserId() &&p.getSeatStatus()== EnumUtils.SEAT_STATUS_ENUM.READY.getValue())
                            .collect(Collectors.toList());
                    //如果人数相等且不等于0
                    if (SeatUserDtoCount.size()==SeatUserDtoCountSetOut.size()&&ValidateUtil.isNotEmpty(SeatUserDtoCountSetOut)){
                        //发牌游戏开始
                    ffs.sendAndSaveGmaeStart(roomId, countMap,SeatUserDtoCountSetOut);

                    }
                }
            });
            return JsonResult.success("准备成功");
        }else{
            return JsonResult.failure(401,"准备失败");
        }
    }

    /**
     * @api {POST} /friedFlowerPort/userSeeCard
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
    @PostMapping("/userSeeCard")
    public JsonResult userSeeCard(int type,
                                  long roomId,
                                 long seatId,
                                 long gamblingId,
                                  int round,
                                  int sort){
        /* 1.改变这个userId*/
        long userId = getUserId();
        int num = ffs.updateUserSeeCard(userId,gamblingId,type,roomId,round,seatId,sort);
        if (num ==2){
            ffs.sendUserSeeCard(type,roomId,gamblingId,userId,seatId);
            return JsonResult.success("开拍成功");
        }else {
            return JsonResult.failure(401,"修改看牌状态失败");
        }

    }

    /**
     * @api {POST} /changeSubject 跟注
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
    @PostMapping("/userWithChip")
    public JsonResult userWithChip(int type,
                                  long roomId,
                                  long seatId,
                                  long gamblingId,
                                  int round,
                                   long integralFundus,
                                   int sort){
        /* 1.改变这个userId*/
        long userId = getUserId();
        int num = ffs.addUserWithChip(userId,gamblingId,type,roomId,round,seatId,integralFundus,sort);
        //判断要不要改变轮次 返回的是下一次的轮次
        JSONObject jsb = ffs.changGeRound(gamblingId);

        if (num >0){
            ffs.sendAddUserWithChip(type,roomId,gamblingId,userId,seatId,integralFundus,jsb.getInteger("round"),jsb.getLong("trueUserId"));

            return JsonResult.success("跟注成功");
        }else {
            return JsonResult.failure(401,"跟注失败");
        }

    }

    /**
     * @api {POST} /changeSubject 弃牌
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
    @PostMapping("/userDisCard")
    public JsonResult userDisCard(int type,
                                   long roomId,
                                   long seatId,
                                   long gamblingId,
                                   int round,
                                   int sort){
        /* 1.改变这个userId*/
        long userId = getUserId();
        /*  1.增加牌局详情操作
            2.修改牌局信息状态
            3.查询是否结束 (是 走牌局结算逻辑  否 走查询要不要改变轮次逻辑)
         */
        int num = ffs.addUserDisCard(type,roomId,seatId,gamblingId,round,sort,userId);
        if (num==2){
            //发送有人弃牌消息
            JSONObject jsb = ffs.changGeRound(gamblingId);
            ffs.sendUserDisCard(type,roomId,seatId,gamblingId,jsb.getInteger("round"),userId,jsb.getLong("trueUserId"));
            //检查
        }else {
            return  JsonResult.failure(401,"弃牌失败");
        }

        return null;
    }

    private long getUserId(){
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Long userId = user.getId();
        return userId;
    }

}
