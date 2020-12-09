package com.webapp.pojo;

import java.io.Serializable;
import java.io.SerializablePermission;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apply implements Serializable {
    int userId;
    int jobId;
    int status;
    Timestamp applyAt;
    Timestamp replyAt;

    public Apply() {

    }

    public Apply(int userId, int jobId, int status, Timestamp applyAt, Timestamp replyAt) {
        this.userId = userId;
        this.jobId = jobId;
        this.status = status;
        this.applyAt = applyAt;
        this.replyAt = replyAt;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getApplyAt() {
        return applyAt;
    }

    public void setApplyAt(Timestamp applyAt) {
        this.applyAt = applyAt;
    }

    public Timestamp getReplyAt() {
        return replyAt;
    }

    public void setReplyAt(Timestamp replyAt) {
        this.replyAt = replyAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
