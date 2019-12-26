package top.franxx.blog.pojo;

import java.util.Date;

public class ComReply {
    private Long replyId;

    private Long replyComId;

    private String replyName;

    private Date replyTime;

    private String replyImg;

    private String replyContent;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getReplyComId() {
        return replyComId;
    }

    public void setReplyComId(Long replyComId) {
        this.replyComId = replyComId;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName == null ? null : replyName.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyImg() {
        return replyImg;
    }

    public void setReplyImg(String replyImg) {
        this.replyImg = replyImg == null ? null : replyImg.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }
}