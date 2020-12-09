package com.webapp.service;

import com.webapp.pojo.Apply;
import com.webapp.pojo.User;

import java.util.List;

public interface ApplyJobService {
    boolean apply(Apply apply);

    List<Apply> query(int jobId);
}