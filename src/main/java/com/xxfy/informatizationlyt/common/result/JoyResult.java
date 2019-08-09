package com.xxfy.informatizationlyt.common.result;

import java.io.Serializable;

public class JoyResult implements Serializable {
    private Boolean state;	//操作结果：bool
    private String message;	//返回信息：string
    private String detailMessage;	//返回信息：开发人员关注的信息
    private Object data = null;	//返回数据：object
    private int returnCode;		//状态码：int

    private JoyResult(Notice notice, String detailMessage, Boolean state, Object data) {
        this.state = state;
        this.message = notice.getMessage();
        this.returnCode = notice.getReturnCode();
        this.data = data;
        this.detailMessage = detailMessage;
    }

    public static JoyResult buildSuccessResult(Object data){
        return new JoyResult(Notice.EXECUTE_IS_SUCCESS,
                "",
                true,
                data
        );
    }

    public static JoyResult buildFailedResult(Notice notice, String detailMessage){
        return new JoyResult(notice,
                detailMessage,
                false,
                null
        );
    }

    public static JoyResult buildFailedResult(Notice notice, String detailMessage, Object data){
        return new JoyResult(notice,
                detailMessage,
                false,
                data
        );
    }

    public static JoyResult buildDefaultResult(){
        return new JoyResult(Notice.EXECUTE_IS_FAILED,
                "",
                false,
                null
                );
    }

    public static JoyResult buildSuccessResult(String detailMessage){
        return new JoyResult(Notice.EXECUTE_IS_SUCCESS,
                detailMessage,
                true,
                null
        );
    }

    public static JoyResult buildFailedResult(String detailMessage){
        return new JoyResult(Notice.EXECUTE_IS_FAILED,
                detailMessage,
                false,
                null
        );
    }


    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    @Override
    public String toString() {
        return "JoyResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", returnCode=" + returnCode +
                '}';
    }

}
