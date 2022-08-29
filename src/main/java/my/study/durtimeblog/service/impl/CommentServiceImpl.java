package my.study.durtimeblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import my.study.durtimeblog.entity.Comment;
import my.study.durtimeblog.mapper.CommentMapper;
import my.study.durtimeblog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author durtime
 * @since 2022-04-08
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper mapper;

    @Override
    public Map<String, List<Comment>> findCommentsByBlog(Integer id) {
        Map<String, List<Comment>> map=new HashMap<>(2);
        List<Comment> parentcomments = new ArrayList<>();
        List<Comment> soncomments = new ArrayList<>();

        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("blog",id);
        List<Comment> comments = mapper.selectList(queryWrapper);

        for (Comment comment : comments) {
            if (comment.getParent()==-1){
                parentcomments.add(comment);
            }else{
                soncomments.add(comment);
            }
        }
        map.put("parents",parentcomments);
        map.put("sons",soncomments);
        return map;
    }
}
