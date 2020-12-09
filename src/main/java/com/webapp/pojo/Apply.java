package com.webapp.pojo;

public class Apply {
    int userId;
    int jobId;
    int status;
    int applyAt;
    int replyAt;

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

    public int getApplyAt() {
        return applyAt;
    }

    public void setApplyAt(int applyAt) {
        this.applyAt = applyAt;
    }

    public int getReplyAt() {
        return replyAt;
    }

    public void setReplyAt(int replyAt) {
        this.replyAt = replyAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
