package education.cs.scu.entity;

import java.io.Serializable;

 
public class User  implements Serializable{
    @Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", nickName=" + nickName + "]";
	}

	private String userName;
    private String password;
    private String nickName;
    public User(){}

    public User(String userName, String password, String nickName){
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
    }
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
