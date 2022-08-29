package my.study.durtimeblog.controller;

import my.study.durtimeblog.bean.BlogViewmodel;
import my.study.durtimeblog.entity.Blog;
import my.study.durtimeblog.entity.Comment;
import my.study.durtimeblog.entity.Tag;
import my.study.durtimeblog.service.BlogService;
import my.study.durtimeblog.service.CommentService;
import my.study.durtimeblog.service.TagService;
import my.study.durtimeblog.service.TypeService;
import my.study.durtimeblog.utils.CommonUtil;
import my.study.durtimeblog.utils.MarkdownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 页面跳转控制器
 */
@Controller
public class UserPageController {
    @Autowired
    BlogService blogService;

    @Autowired
    TagService tagService;


    @Autowired
    TypeService typeService;

    @Autowired
    CommentService commentService;


    /**
     * 首页
     * @return
     */
    @GetMapping(value = {"login"})
    public String userLogin(@RequestParam Map<String,Object> map){
        return "login-user";
    }

    /**
     * 首页
     * @return
     */
    @GetMapping(value = {"index","/"})
    public String index(@RequestParam Map<String,Object> map){
        return "index";
    }


    @GetMapping(value = {"/article"})
    public String article(@RequestParam Map<String,Object> map){
        return "/article";
    }


    @GetMapping("/message")
    public String types(){
        return "/message";
    }

    @GetMapping("/link")
    public String users(){
        return "/link";
    }


    @GetMapping("/tablesel")
    public String tablesel(){
        return "/table-select";
    }

    @GetMapping("/read")
    public String read(){
        return "/read";
    }

    @GetMapping("/read/{id}")
    public ModelAndView read_blog(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/blog");

        Blog blog = blogService.getById(id);
        List<Integer> tagsindex = CommonUtil.stringTolist(blog.getTags());
        List<Tag> tags = new ArrayList<>();
        for (Integer integer : tagsindex) {
            tags.add(tagService.getById(integer));
        }
        BlogViewmodel blogViewmodel=new BlogViewmodel(blog,tags, MarkdownUtil.markdownToHtmlExtens(blog.getContent()));

        mv.addObject("blog",blogViewmodel);

        Map<String,List<Comment>> map=commentService.findCommentsByBlog(id);

        mv.addObject("parents",map.get("parents"));
        mv.addObject("sons",map.get("sons"));
        mv.addObject("type",typeService.getById(blog.getType()));

        return mv;
    }


}
