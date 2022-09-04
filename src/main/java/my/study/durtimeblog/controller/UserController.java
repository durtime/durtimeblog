package my.study.durtimeblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import my.study.durtimeblog.bean.RespBean;
import my.study.durtimeblog.entity.Comment;
import my.study.durtimeblog.entity.User;
import my.study.durtimeblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author durtime
 * @since 2022-04-08
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/user/login")
    public RespBean loginUser(@RequestParam Map<String,Object> map, HttpSession session)throws Exception{
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",map.get("username"));
        queryWrapper.eq("password",map.get("password"));
        User user=userService.getOne(queryWrapper);
        RespBean respBean = new RespBean();
        if (user!=null){
            session.setAttribute("user",user);
            respBean.setCode(200);
            respBean.setData(user.getType());
            respBean.setMsg("登录成功");
        }else {
            respBean.setCode(500);
            respBean.setMsg("用户名或密码错误，请重新输入");
        }
        return respBean;
    }

    @GetMapping("/user/logout")
    public ModelAndView logOut(HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        session.removeAttribute("user");
        modelAndView.addObject("message","用户退出成功!");
        modelAndView.setViewName("/login");
        return modelAndView;
    }
}
