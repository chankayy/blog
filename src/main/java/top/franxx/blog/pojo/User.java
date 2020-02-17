package top.franxx.blog.pojo;

import java.util.Date;

public class User {
    private Long usersId;

    private String userName;

    private String password;

    private String userEmail;

    private Integer userStatus;

    private Integer userGrade;

    private Date userEndTime;

    private String userSex;

    private String userDesc;

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }

    public Date getUserEndTime() {
        return userEndTime;
    }

    public void setUserEndTime(Date userEndTime) {
        this.userEndTime = userEndTime;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc == null ? null : userDesc.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "usersId=" + usersId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userStatus=" + userStatus +
                ", userGrade=" + userGrade +
                ", userEndTime=" + userEndTime +
                ", userSex='" + userSex + '\'' +
                ", userDesc='" + userDesc + '\'' +
                '}';
    }
}