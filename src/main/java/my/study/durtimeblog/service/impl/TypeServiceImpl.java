package my.study.durtimeblog.service.impl;

import my.study.durtimeblog.entity.Type;
import my.study.durtimeblog.mapper.TypeMapper;
import my.study.durtimeblog.service.TypeService;
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
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}
