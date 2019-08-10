package com.xxfy.informatizationlyt.common.exception;

/**
 * Created by Administrator on 2016/9/5.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class ResponseErrorMessage extends ErrorMessage implements Cloneable {
    private String hostId;
    private String requestId;
    private Date serverTime;
    private Throwable throwable;

    public ResponseErrorMessage() {
    }

    public ResponseErrorMessage(Throwable throwable) {
        this.throwable = throwable;
    }

    public String getHostId() {
        return this.hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    @JsonIgnore
    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("<");
        builder.append("code:");
        builder.append(this.getCode());
        builder.append(", message:");
        builder.append(this.getMessage());
        builder.append(", host_id:");
        builder.append(this.hostId);
        builder.append(", server_time:");
        builder.append(this.serverTime);
        builder.append(", request_id:");
        builder.append(this.requestId);
        builder.append(", detail:");
        builder.append(this.getDetail());
        builder.append(">");
        return builder.toString();
    }

    public ResponseErrorMessage clone() {
        try {
            return (ResponseErrorMessage) super.clone();
        } catch (CloneNotSupportedException e) {

        }
        return new ResponseErrorMessage();
    }
}
