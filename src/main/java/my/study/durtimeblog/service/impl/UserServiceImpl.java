package my.study.durtimeblog.service.impl;

import my.study.durtimeblog.entity.User;
import my.study.durtimeblog.mapper.UserMapper;
import my.study.durtimeblog.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
