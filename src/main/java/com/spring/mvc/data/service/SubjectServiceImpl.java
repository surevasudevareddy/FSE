package com.spring.mvc.data.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.data.dao.SubjectDao;
import com.spring.mvc.data.entity.Subject;

@Service
@Transactional
@Component("SubjectService")
public class SubjectServiceImpl extends AbstractService<Subject> implements SubjectService {
	@Autowired
	private SubjectDao dao;
	
	
	public SubjectServiceImpl() {
		super();
	}
	
	@Override
    protected SubjectDao getDao() {
        return  dao;
    }
	
	// custom methods

    @Override
    public List<Subject> findBySubTitle(String subTitle) {
        return getDao().findBySubTitle(subTitle);
    }
    @Override
    public List<Subject> findByDuration(int duration) {
        return getDao().findByDuration(duration);
    }
}
