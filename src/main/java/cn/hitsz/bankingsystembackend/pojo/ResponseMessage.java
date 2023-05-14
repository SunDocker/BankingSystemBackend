package cn.hitsz.bankingsystembackend.pojo;

public class ResponseMessage {
    boolean success;
    Object info;

    public ResponseMessage(boolean success, Object info) {
        this.success = success;
        this.info = info;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
