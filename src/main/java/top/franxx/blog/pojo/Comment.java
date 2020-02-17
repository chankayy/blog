package top.franxx.blog.pojo;

import java.util.Date;

public class Comment {
    private Long comId;

    private Long comNewsId;

    private String comName;

    private String comImg;

    private Date comTime;

    private String comContent;

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getComNewsId() {
        return comNewsId;
    }

    public void setComNewsId(Long comNewsId) {
        this.comNewsId = comNewsId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    public String getComImg() {
        return comImg;
    }

    public void setComImg(String comImg) {
        this.comImg = comImg == null ? null : comImg.trim();
    }

    public Date getComTime() {
        return comTime;
    }

    public void setComTime(Date comTime) {
        this.comTime = comTime;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent == null ? null : comContent.trim();
    }
}