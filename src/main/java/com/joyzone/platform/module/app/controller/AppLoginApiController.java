package com.joyzone.platform.module.app.controller;

import com.joyzone.platform.common.utils.R;
import com.joyzone.platform.core.model.PhoneBlackModel;
import com.joyzone.platform.core.service.PhoneBlackService;
import com.joyzone.platform.core.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/app_loginApi")
@Api(tags = "app注册登录相关接口",description = "AppLoginApiController")
public class AppLoginApiController {

    @Autowired
    private PhoneBlackService phoneBlackService;
    @Autowired
    private RedisService redisService;

    /**
     * zy
     * 获取手机验证码
     **/
    @PostMapping(value = "/getPhoneVcode")
    @ApiOperation(value = "获取手机验证码")
    public R getPhoneVcode(@RequestParam("phone") String phone) {
        if (phone == null) {
            return R.error("手机号不能为空.");
        }
        Map map = new HashMap();
        int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);
        String content = "您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。";

        if (isMobileNO(phone)) {
            //判断手机号是否属于黑名单
            PhoneBlackModel phoneBlack = phoneBlackService.isBlack(phone);
            if (phoneBlack != null) {
                map.put("type", 1);
                map.put("identify", null);
                return R.error("此电话号码已因不当言行被拉入黑名单!");
            }
//            Map<String, Object> map1 = Sendsms.sendMS(content, phone);
            Map<String, Object> map1 = null;
            if (map1 != null && map1.get("code").equals("2")) {
                boolean flag = redisService.set("mobile_code",String.valueOf(mobile_code),300);
                if(flag == false){
                    return R.error("缓存手机验证码失败!");
                }
                map.put("type", 0);
                map.put("identify", mobile_code);
                com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
                jsonObject.put("data", map);
                return R.ok(jsonObject.toJSONString());
            } else {
                return R.error("发送验证码失败！");
            }
        } else {
            return R.error("手机号格式不正确!");
        }
    }

    /**
     * 验证手机号格式
     *
     * @param mobiles
     * @return
     */
    public boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((1[3,4,5,6,7,8,9]))\\d{9}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


}
