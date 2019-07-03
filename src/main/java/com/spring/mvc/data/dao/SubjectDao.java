package com.spring.mvc.data.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.mvc.data.entity.Subject;

@Repository
public interface SubjectDao extends CrudRepository<Subject, Long>{
	
	List<Subject> findBySubTitle(String subTitle);
	
	@Query("SELECT s FROM Subject s WHERE s.durationInHours = :duration  ")
	List<Subject> findByDuration(@Param("duration") int duration);

}
