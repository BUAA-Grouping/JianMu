package com.webapp.pojo;

public class JobResponse {
    private int id;
    private String title;
    private String college;
    private String campus;
    private int exceptedNumOfMember;
    private int state;
    private String profile;
    private String email;
    private String telephone;

    public JobResponse(Job job) {
        this.id = job.getId();
        this.title = job.getTitle();
        this.college = JobInfoMap.college_map.get(job.getCollege());
        this.campus = JobInfoMap.campus_map.get(job.getCampus());
        this.exceptedNumOfMember = job.getExceptedNumOfMember();
        this.state = job.getState();
        this.profile = job.getProfile();
        this.email = job.getEmail();
        this.telephone = job.getTelephone();
    }
}
