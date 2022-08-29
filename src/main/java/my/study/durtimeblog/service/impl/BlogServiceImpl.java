package my.study.durtimeblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import my.study.durtimeblog.entity.Blog;
import my.study.durtimeblog.mapper.BlogMapper;
import my.study.durtimeblog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author durtime
 * @since 2022-04-08
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public Page<Blog> getBlogList(int pageNum, int pageSize) {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        Page<Blog> blogPage = blogMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
        return blogPage;
    }
}
