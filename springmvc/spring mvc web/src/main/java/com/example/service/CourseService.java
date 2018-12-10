package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Course;

@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}
