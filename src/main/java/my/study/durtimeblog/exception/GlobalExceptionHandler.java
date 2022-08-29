package my.study.durtimeblog.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;


/**
 * 全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView ExceptionHandler(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error/404");
        modelAndView.addObject("error",e);
        return modelAndView;
    }

}