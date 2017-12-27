package com.yiaosi.aps.entity;

/**
 * 检查用户是否存在
 * Created by Administrator on 2017-11-17.
 */

public class CheckUserExistEntity {

    /**
     * status : 401
     * msg : failed
     * result : {"failedMsg":"13822544596 has been used."}
     */

    private int status;
    private String msg;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * failedMsg : 13822544596 has been used.
         */

        private String failedMsg;

        public String getFailedMsg() {
            return failedMsg;
        }

        public void setFailedMsg(String failedMsg) {
            this.failedMsg = failedMsg;
        }
    }
}
