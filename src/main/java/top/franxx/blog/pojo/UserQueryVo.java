package top.franxx.blog.pojo;

import java.util.List;

/**
 * user包装类，用于参数绑定
 */
public class UserQueryVo {
    private List<Long> usersIds;

    public UserQueryVo() {
    }

    public UserQueryVo(List<Long> usersIds) {
        this.usersIds = usersIds;
    }

    public List<Long> getUsersIds() {
        return usersIds;
    }

    public void setUsersIds(List<Long> usersIds) {
        this.usersIds = usersIds;
    }
}
