package education.cs.scu.DAO;

import education.cs.scu.entity.User;

/**
 * 
 * @author yongmao.wu
 * @since  2018年8月22日
 */
public interface RedisMapper {
    User doUserLoginRedis(User user) throws Exception;
    void doUserRegist(User user) throws Exception;
}
