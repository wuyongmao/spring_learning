package education.cs.scu.service;

import education.cs.scu.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author yongmao.wu
 * @since  2018年8月22日
 */
public interface LoginService {
    boolean doUserLogin(HttpServletRequest request, User user) throws Exception;
    void doUserRegist(User user) throws Exception;
    User getUser(User user) throws Exception; 
    User updateUser(User user) throws Exception;
	int deleteUser(User user) throws Exception; 
}
