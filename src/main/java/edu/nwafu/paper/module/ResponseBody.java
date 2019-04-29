package edu.nwafu.paper.module;

public class ResponseBody {

    private int code;

    private String msg;

    private Object body;

    public ResponseBody() {
        this.code = 200;
        this.msg = "success";
        this.body = null;
    }

    public ResponseBody(Object body) {
        this.code = 200;
        this.msg = "success";
        this.body = body;
    }

    public ResponseBody(int code, String msg) {

        this.code = code;
        this.msg = msg;
        this.body = null;
    }

    public ResponseBody(int code, String msg, Object body) {

        this.code = code;
        this.msg = msg;
        this.body = body;
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

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
