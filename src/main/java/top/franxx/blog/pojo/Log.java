package top.franxx.blog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Log {
    private Long logId;

    private String logUrl;

    private String logReq;

    private String logIp;

    private String logTaking;

    private Integer logStatus;

    private Long logUserId;

    private Date logTime;

    private String logContent;

    private String logController;

    private String logMethod;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl == null ? null : logUrl.trim();
    }

    public String getLogReq() {
        return logReq;
    }

    public void setLogReq(String logReq) {
        this.logReq = logReq == null ? null : logReq.trim();
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp == null ? null : logIp.trim();
    }

    public String getLogTaking() {
        return logTaking;
    }

    public void setLogTaking(String logTaking) {
        this.logTaking = logTaking == null ? null : logTaking.trim();
    }

    public Integer getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    public Long getLogUserId() {
        return logUserId;
    }

    public void setLogUserId(Long logUserId) {
        this.logUserId = logUserId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    public String getLogController() {
        return logController;
    }

    public void setLogController(String logController) {
        this.logController = logController == null ? null : logController.trim();
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod == null ? null : logMethod.trim();
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", logUrl='" + logUrl + '\'' +
                ", logReq='" + logReq + '\'' +
                ", logIp='" + logIp + '\'' +
                ", logTaking='" + logTaking + '\'' +
                ", logStatus=" + logStatus +
                ", logUserId=" + logUserId +
                ", logTime=" + logTime +
                ", logContent='" + logContent + '\'' +
                ", logController='" + logController + '\'' +
                ", logMethod='" + logMethod + '\'' +
                '}';
    }
}