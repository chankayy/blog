package top.franxx.blog.pojo;

public class SystemParameter {
    private String cmsName;

    private String version;

    private String author;

    private String homePage;

    private String serverEnvir;

    private String dataBase;

    private String maxUpload;

    private String userRights;

    private String description;

    private String powerby;

    private String record;

    private String keywords;

    public String getCmsName() {
        return cmsName;
    }

    public void setCmsName(String cmsName) {
        this.cmsName = cmsName == null ? null : cmsName.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage == null ? null : homePage.trim();
    }

    public String getServerEnvir() {
        return serverEnvir;
    }

    public void setServerEnvir(String serverEnvir) {
        this.serverEnvir = serverEnvir == null ? null : serverEnvir.trim();
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase == null ? null : dataBase.trim();
    }

    public String getMaxUpload() {
        return maxUpload;
    }

    public void setMaxUpload(String maxUpload) {
        this.maxUpload = maxUpload == null ? null : maxUpload.trim();
    }

    public String getUserRights() {
        return userRights;
    }

    public void setUserRights(String userRights) {
        this.userRights = userRights == null ? null : userRights.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPowerby() {
        return powerby;
    }

    public void setPowerby(String powerby) {
        this.powerby = powerby == null ? null : powerby.trim();
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }
}