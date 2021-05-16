package com.webapp.service;

import com.webapp.pojo.Apply;

import java.util.List;

public interface ApplyService {
    boolean apply(Apply apply);

    List<Apply> query(int jobId);
}