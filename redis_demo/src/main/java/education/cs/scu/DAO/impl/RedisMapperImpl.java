package education.cs.scu.DAO.impl;

import education.cs.scu.DAO.RedisMapper;
import education.cs.scu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author yongmao.wu
 * @since  2018年8月22日
 */
@Repository
public class RedisMapperImpl implements RedisMapper{

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    private static String USER_KEY = "ADMIN_USER";
    public User doUserLoginRedis(User user) throws Exception {
        User loginUser =  (User)redisTemplate.opsForHash().get(USER_KEY, user.getUserName());
        if(loginUser !=null){
        	System.out.println(loginUser+"====redish获取======" );
         
            return loginUser;
        }else{
        	System.out.println(loginUser+"====redish获取失败======" );

            return new User();
        }

    }

    public void doUserRegist(User user) throws Exception {
        this.redisTemplate.opsForHash().put(USER_KEY, user.getUserName(), user);
    }

}
