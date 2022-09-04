package my.study.durtimeblog.controller;


import my.study.durtimeblog.entity.Blog;
import my.study.durtimeblog.entity.Tag;
import my.study.durtimeblog.service.BlogService;
import my.study.durtimeblog.service.CommentService;
import my.study.durtimeblog.service.TagService;
import my.study.durtimeblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPageController {
    @Autowired
    BlogService blogService;

    @Autowired
    TagService tagService;


    @Autowired
    TypeService typeService;

    @Autowired
    CommentService commentService;


    /**
     * 后天管理首页
     * @return
     */
    @GetMapping({"/index"})
    public String adminindex(){
        return "admin/index-admin";
    }

    /**
     * 博客列表
     */
    @GetMapping("/blogs")
    public String blogs(){
        return "admin/blogs";
    }

    /**
     * 新增博客
     * @return
     */
    @GetMapping("/bloginput")
    public ModelAndView blog_input(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("types",typeService.list());
        mv.addObject("tags",tagService.list());
        mv.addObject("method","post");
        mv.setViewName("admin/myblog");
        return mv;
    }

    /**
     * 修改博客
     * @param blogId
     * @return
     */
    @GetMapping("/bloginput/{blogId}")
    public ModelAndView blog_input_update(@PathVariable Integer blogId){
        ModelAndView mv=new ModelAndView();
        mv.addObject("types",typeService.list());
        Blog blog = blogService.getById(blogId);
        List<Tag> taglist = tagService.list();
        String tags = blog.getTags();
        String[] split = tags.split(",");
        List<String> res = new ArrayList<>();
        for (Tag tag : taglist) {
            for (String s : split) {
                if(!s.equals(""))
                    if (tag.getId()==Integer.parseInt(s))
                        res.add(tag.getName());
            }
        }

        System.out.println(res.toString());
        mv.addObject("blog",blog);
        mv.addObject("tags",res);
        mv.addObject("method","put");
        mv.setViewName("admin/myblog");
        return mv;
    }



    @GetMapping("/comments")
    public String comments(){
        return "admin/comments";
    }

    @GetMapping("/photos")
    public String photos(){
        return "admin/photos";
    }

    @GetMapping("/tags")
    public String tags(){
        return "admin/tags";
    }

    @GetMapping("/types")
    public String types(){
        return "admin/types";
    }

    @GetMapping("/users")
    public String users(){
        return "admin/users";
    }


}
