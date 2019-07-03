package com.spring.mvc.data.service;


import java.util.List;

import com.spring.mvc.data.entity.Subject;

public interface SubjectService extends IOperations<Subject> {

	List<Subject> findBySubTitle(String subTitle);
	List<Subject> findByDuration(int duration);
}
