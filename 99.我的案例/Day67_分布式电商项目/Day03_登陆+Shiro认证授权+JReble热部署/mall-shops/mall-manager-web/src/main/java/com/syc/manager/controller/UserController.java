package com.syc.manager.controller;

import com.syc.commons.pojo.ResponseResult;
import com.syc.commons.utils.GeetestLib;
import com.syc.commons.utils.ResultUtil;
import com.syc.manager.pojo.TbUser;
import com.syc.manager.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 用户模块:登陆,注册,退出等
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 初始化极验验证码
     * 注意:需要返回给web前端一个json.@ResponseBody不可少!或者在类上用@RestController=@Controller+@ResponseBody
     */
    @ResponseBody
    @RequestMapping(value = "/geetestInit", method = RequestMethod.GET)
    public String geetesrInit(HttpServletRequest request) {
        GeetestLib gtSdk = new GeetestLib(GeetestLib.id, GeetestLib.key, GeetestLib.newfailback);

        String resStr = "{}";

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<>();

        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(param);

        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);

        return gtSdk.getResponseStr();
    }

    /**
     * 用户登陆
     */
    @ResponseBody
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseResult<Object> login(String username, String password,
                                        String challenge, String validate, String seccode,
                                        HttpServletRequest request) {
        //极验验证
        GeetestLib gtSdk = new GeetestLib(GeetestLib.id, GeetestLib.key, GeetestLib.newfailback);

        //从session中获取gt-server状态
        int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<>();

        int gtResult = 0;

        if (gt_server_status_code == 1) {
            //gt-server正常，向gt-server进行二次验证
            gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, param);
        } else {
            // gt-server非正常情况下，进行failback模式验证
            gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
        }

        if (gtResult == 1) {
            Subject subject = SecurityUtils.getSubject();
            String digest = DigestUtils.md5DigestAsHex(password.getBytes());
            UsernamePasswordToken token = new UsernamePasswordToken(username, digest);
            try {
                subject.login(token);
                return new ResultUtil<>().setData(null);
            } catch (Exception e) {
                return new ResultUtil<>().setErrorMsg("用户名或密码错误");
            }
        } else {
            // 验证失败
            System.out.println("验证失败...");
            return new ResultUtil<>().setErrorMsg("验证失败");
        }
    }

    /**
     * 退出登陆
     */
    @ResponseBody
    @RequestMapping(value = "/user/logout",method = RequestMethod.GET)
    public ResponseResult<Object> logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ResultUtil<>().setData(null);
    }
}
