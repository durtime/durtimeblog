package my.study.durtimeblog.service.impl;

import my.study.durtimeblog.entity.Tag;
import my.study.durtimeblog.mapper.TagMapper;
import my.study.durtimeblog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
