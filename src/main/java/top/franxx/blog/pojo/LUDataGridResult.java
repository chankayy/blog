package top.franxx.blog.pojo;

import java.util.List;

/**
 * layui数据表格table响应格式对象
 */
public class LUDataGridResult {
    private int code;
    private String msg;
    private int count;
    private List data;
    public static LUDataGridResult ok(List data){
        return new LUDataGridResult(0,"没有成功获取数据时显示",data.size(),data);
    }
    public LUDataGridResult() {

    }

    public LUDataGridResult(int code, String msg, int count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
