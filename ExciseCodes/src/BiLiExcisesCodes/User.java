package BiLiExcisesCodes;

import java.io.Serializable;

/**
 * @Auther: YS
 * @Date: 2021/7/27
 * @Description: 接E64
 * @Version: 1.0
 */
//将账号和密码封装成一个对象
public class User implements Serializable {                    //使用对象流，要将类序列化
    private static final long serialVersionUID = -3667625500225453242L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
