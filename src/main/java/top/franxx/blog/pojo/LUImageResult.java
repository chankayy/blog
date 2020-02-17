package top.franxx.blog.pojo;

import java.util.Map;

public class LUImageResult {
    private Integer code;
    private String msg;
    private Map<String,String> data;

    public LUImageResult() {
    }

    public LUImageResult(Integer code, String msg, Map<String, String> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
