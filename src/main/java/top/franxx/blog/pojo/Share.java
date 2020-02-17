package top.franxx.blog.pojo;

import java.util.Date;

public class Share {
    private Long shareId;

    private String shareName;

    private String shareUrl;

    private String shareIntro;

    private String shareStatus;

    private String shareClassify;

    private String shareDownload;

    private String shareImg;

    private String shareAuthor;

    private Date shareTime;

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName == null ? null : shareName.trim();
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
    }

    public String getShareIntro() {
        return shareIntro;
    }

    public void setShareIntro(String shareIntro) {
        this.shareIntro = shareIntro == null ? null : shareIntro.trim();
    }

    public String getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(String shareStatus) {
        this.shareStatus = shareStatus == null ? null : shareStatus.trim();
    }

    public String getShareClassify() {
        return shareClassify;
    }

    public void setShareClassify(String shareClassify) {
        this.shareClassify = shareClassify == null ? null : shareClassify.trim();
    }

    public String getShareDownload() {
        return shareDownload;
    }

    public void setShareDownload(String shareDownload) {
        this.shareDownload = shareDownload == null ? null : shareDownload.trim();
    }

    public String getShareImg() {
        return shareImg;
    }

    public void setShareImg(String shareImg) {
        this.shareImg = shareImg == null ? null : shareImg.trim();
    }

    public String getShareAuthor() {
        return shareAuthor;
    }

    public void setShareAuthor(String shareAuthor) {
        this.shareAuthor = shareAuthor == null ? null : shareAuthor.trim();
    }

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }
}