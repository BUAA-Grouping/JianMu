package com.webapp.service.impl;

import com.webapp.pojo.Apply;
import com.webapp.service.ApplyJobService;

import java.util.List;

public class ApplyJobServiceImpl implements ApplyJobService {
    public boolean apply(Apply apply) {
        return true;
    }

    @Override
    public List<Apply> query(int jobId) {

    }
}
