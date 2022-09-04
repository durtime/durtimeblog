package my.study.durtimeblog.intercepter;

import lombok.extern.slf4j.Slf4j;
import my.study.durtimeblog.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class UserIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        User user =(User)request.getSession().getAttribute("user");
        if (user == null || user.equals(""))  {
            response.sendRedirect("/login");
            return false;
        }else if(user.getType()!=1){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}
