package cn.duanrf.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName SecurityController
 * @Description TODO
 * @Author DRF
 * @Date 2020/4/13 9:36
 */
@Controller
public class SecurityController {


    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/loginSuccess")
    public String main(){
        return "main";
    }

    @RequestMapping("/loginFail")
    public String fail(){
        return "fial";
    }

    @RequestMapping("/order")
    public String order(){
        return "order";
    }

    @RequestMapping("/product")
    public String product(){
        return "product";
    }
    @RequestMapping("/dologout")
    public String logout(){
        return "logout";
    }
}
