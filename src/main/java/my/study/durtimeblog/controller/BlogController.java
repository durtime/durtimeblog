package my.study.durtimeblog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import my.study.durtimeblog.bean.RespBean;
import my.study.durtimeblog.bean.RespBeanEnum;
import my.study.durtimeblog.bean.RespTable;
import my.study.durtimeblog.entity.Blog;
import my.study.durtimeblog.entity.Tag;
import my.study.durtimeblog.service.BlogService;
import my.study.durtimeblog.service.CommentService;
import my.study.durtimeblog.service.TagService;
import my.study.durtimeblog.service.TypeService;
import my.study.durtimeblog.utils.MarkdownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author durtime
 * @since 2022-04-08
 */
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    TagService tagService;


    @Autowired
    TypeService typeService;

    @Autowired
    CommentService commentService;


    @GetMapping("blogs")
    public RespBean blogs() {
        List<Blog> list = blogService.list();
        return RespBean.success(list);
    }

    @GetMapping("blogpage")
    public RespTable blogpage(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "10") int limit) {
        Page<Blog> blogPage = blogService.getBlogList(page, limit);
        int count = blogService.count();
        return RespTable.success(count, blogPage.getRecords());
    }


    @PostMapping("blog")
    public RespBean insertBlog(Blog blog) {
        //配合查找
        String result = "";
        blog.setTags("," + blog.getTags() + ",");
        if (blogService.save(blog)) {
            result = "博客保存成功!";
        } else {
            result = "博客保存失败!";
            return RespBean.error(RespBeanEnum.ERROR, result);
        }
        return RespBean.success(result);
    }

    /**
     * 修改
     *
     * @param blog
     * @return
     */
    @PutMapping("blog")
    public RespBean updateBlog(Blog blog) {

        //先保存没有的tag
        HashSet<String> newhs = new HashSet<>();
        List<Tag> taglist = tagService.list();
        String tags = blog.getTags();
        String[] split = tags.split(",");

        for (String s : split) {
            boolean flag=true;
            for (Tag tag : taglist) {
                if (!s.equals(""))
                    if (tag.getName().equals(s)){
                        flag=false;
                    }
            }
            if(flag)
                newhs.add(s);
        }
        //保存tag
        for (String h : newhs) {
            Tag tag = new Tag();
            tag.setName(h);
            tagService.save(tag);
        }
        //修改博客
        List<Tag> taglistnew = tagService.list();
        String res = "";

        for (String s : split) {
            for (Tag tag : taglistnew) {
                if (!s.equals(""))
                    if (tag.getName().equals(s)){
                        res += tag.getId() + ",";
                    }
            }
        }

        blog.setTags(res);
        //配合查找
        String result = "";
        if (blogService.updateById(blog)) {
            result = "博客修改成功!";
        } else {
            result = "博客修改失败!";
            return RespBean.error(RespBeanEnum.ERROR, result);
        }
        return RespBean.success(result);
    }

    @DeleteMapping("blog")
    public RespBean deleteBlog(int id) {
        String result = "";
        if (blogService.removeById(id)) {
            result = "博客删除成功!";
        } else {
            result = "博客删除失败!";
            return RespBean.error(RespBeanEnum.ERROR, result);
        }
        return RespBean.success(result);
    }

    /**
     * 用于博客列表的浏览
     *
     * @param id
     * @return
     */
    @GetMapping("/admin/only_blog/{id}")
    public ModelAndView only_blog(@PathVariable Integer id) {
        Blog blog = blogService.getById(id);
        MarkdownUtil.markdownToHtmlExtens(blog.getContent());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/blogdetail");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
}
