package com.scau.hyskjf.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.scau.hyskjf.dao.AdminMapper;
import com.scau.hyskjf.util.SMS.sendSMS;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by supiccc on 2018-08-07 17:11
 */
@RestController
//@RequestMapping("/admin")
//@Controller
public class DemoController {

    @Autowired
    AdminMapper adminMapper;

//    返回JSON示例
//    @RequestMapping(value = "1000")
//    @ResponseBody
//    public ResponseJSON pic() {
////        调用dao层
//        Admin user = adminMapper.selectByPrimaryKey(1000);
//        return new ResponseJSON(ResponseCode.SUCCESS, user);
//
//    }

//    返回页面示例，创建md5密码
    @RequestMapping(value = "/adminCreate")
    public ResponseJSON hello() {
        try {
            System.err.println(new Md5Hash("password", "13572878765", 3));
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
//        return "helloword";
        return new ResponseJSON(ResponseCode.SUCCESS);
    }

//    发送短信
    @RequestMapping(value = "/sendMessage")
    public ResponseJSON sendMessage() throws Exception {
        if (new sendSMS().send("13602800453")) {
            return new ResponseJSON(ResponseCode.SUCCESS);
        } else {
            return new ResponseJSON(ResponseCode.UNKNOWNACCOUNT);
        }

    }

}
