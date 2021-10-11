package com.devoid.soap.webservices.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.devoid.soap.webservices.soapcoursemanagement.soap.bean.Course;

@Component
public class CourseDetailsService {

	private static List<Course> courses = new ArrayList<>();
	
	static {
		Course course1 = new Course(1, "math", "math tutorial");
		courses.add(course1);
		
		Course course2 = new Course(2, "social", "humanoria and economy");
		courses.add(course2);
		
		Course course3 = new Course(3, "science", "basic physic and chemistry");
		courses.add(course3);
		
		Course course4 = new Course(4, "tech", "basic programming");
		courses.add(course4);	
	}
	
	public Course findById(int id) {
		for (Course course : courses) {
			if (course.getId() == id)
				return course;
		}
		return null;
	}
	
	public List<Course> findAll() {
		return courses;
	}
	
	//create deleteById method
	public int deleteById(int id) {
		Iterator<Course> itr = courses.iterator();
		while (itr.hasNext()) {
			Course course = itr.next();
			if (course.getId() == id) {
				itr.remove();
				return 1;
			}
		}
		return 0;
	}
	
	
	
}
