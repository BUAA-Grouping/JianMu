package com.webapp.service;

import com.webapp.pojo.Apply;
import com.webapp.pojo.Study;

import java.util.List;

public interface StudyService {
    boolean study(Study study);

    List<Study> query(int courseId);

    boolean hadStudied(int userId, int courseId,int type);

    boolean hadPosted(int userId,int courseId);
}
