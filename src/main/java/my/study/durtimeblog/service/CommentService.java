package my.study.durtimeblog.service;

import my.study.durtimeblog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author durtime
 * @since 2022-04-08
 */
public interface CommentService extends IService<Comment> {

    Map<String, List<Comment>> findCommentsByBlog(Integer id);
}
