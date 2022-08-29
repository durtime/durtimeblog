package my.study.durtimeblog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import my.study.durtimeblog.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author durtime
 * @since 2022-04-08
 */
public interface BlogService extends IService<Blog> {
    Page<Blog> getBlogList(int pageNum, int pageSize);
}
