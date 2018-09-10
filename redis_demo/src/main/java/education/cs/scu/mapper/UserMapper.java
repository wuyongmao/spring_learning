package education.cs.scu.mapper;

import education.cs.scu.entity.User;

/**
 * 
 * @author yongmao.wu
 * @since  2018年8月22日
 */
public interface UserMapper {
    User doUserLogin(User user) throws Exception;
    
    int updateUser(User user) throws Exception;
    
    
}
