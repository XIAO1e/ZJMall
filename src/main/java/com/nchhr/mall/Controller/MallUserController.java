package com.nchhr.mall.Controller;


import com.nchhr.mall.Enum.ExceptionEnum;
import com.nchhr.mall.RsultModel.R_data;
import com.nchhr.mall.Service.MallUserService;
import com.nchhr.mall.Utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("MallUser")
public class MallUserController {



    @Autowired
    MallUserService mallUserService;

    /**
     * 注册获取验证码
     *
     * @param phone
     * @param session
     * @return
     */
    @RequestMapping("/MallUserRegistered")
    @ResponseBody
    public R_data GetCode(String phone, HttpSession session) {
        System.out.println(phone);

        return ResultUtils.success(mallUserService.getCode(phone, session), ExceptionEnum.SUCCESS);

    }

    /**
     * 注册
     *
     * @param userPhone
     * @param code
     * @param pwd
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/RegistLogin")
    @ResponseBody
    public R_data RegistLogin(String userPhone, String code, String pwd, HttpSession session) throws Exception {
        return ResultUtils.success(mallUserService.RegistLogin(userPhone, code, pwd, session), ExceptionEnum.SUCCESS);
    }

    /**
     * 清除验证码
     *
     * @param phone
     * @param session
     * @return
     */
    @RequestMapping("/deleteCode")
    @ResponseBody
    public R_data deleteCode(String phone, HttpSession session) {
        return ResultUtils.success(mallUserService.deleteCode(phone, session), ExceptionEnum.SUCCESS);
    }

    /**
     * 重置密码需要的code
     * @param phone
     * @param session
     * @return
     */
    @RequestMapping("/ResetPassword")
    @ResponseBody
    public R_data ResetGetCode(String phone, HttpSession session) {
        System.out.println(phone);

        return ResultUtils.success(mallUserService.ResetGetCode(phone, session), ExceptionEnum.SUCCESS);

    }
    @RequestMapping("/ChangePassword")
    @ResponseBody
    public R_data ChangePassword(String newpwd,String code,String newphone,HttpSession session){

        System.out.println(newphone+":"+code+":"+newpwd);

        return ResultUtils.success(mallUserService.ChangePassword(newpwd,code,newphone,session),ExceptionEnum.SUCCESS);
    }


}
