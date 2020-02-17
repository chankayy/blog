package top.franxx.blog.pojo;

import java.util.Date;

public class News {
    private Long newsId;

    private String newsName;

    private String newsAuthor;

    private String newsAbstract;

    private Integer newsStatus;

    private String newsImg;

    private Integer newsClassify;

    private String newsLook;

    private String newsTop;

    private Date newsTime;

    private Long newsLike;

    private Long newsView;

    private String content;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName == null ? null : newsName.trim();
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor == null ? null : newsAuthor.trim();
    }

    public String getNewsAbstract() {
        return newsAbstract;
    }

    public void setNewsAbstract(String newsAbstract) {
        this.newsAbstract = newsAbstract == null ? null : newsAbstract.trim();
    }

    public Integer getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg == null ? null : newsImg.trim();
    }

    public Integer getNewsClassify() {
        return newsClassify;
    }

    public void setNewsClassify(Integer newsClassify) {
        this.newsClassify = newsClassify;
    }

    public String getNewsLook() {
        return newsLook;
    }

    public void setNewsLook(String newsLook) {
        this.newsLook = newsLook == null ? null : newsLook.trim();
    }

    public String getNewsTop() {
        return newsTop;
    }

    public void setNewsTop(String newsTop) {
        this.newsTop = newsTop == null ? null : newsTop.trim();
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public Long getNewsLike() {
        return newsLike;
    }

    public void setNewsLike(Long newsLike) {
        this.newsLike = newsLike;
    }

    public Long getNewsView() {
        return newsView;
    }

    public void setNewsView(Long newsView) {
        this.newsView = newsView;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}