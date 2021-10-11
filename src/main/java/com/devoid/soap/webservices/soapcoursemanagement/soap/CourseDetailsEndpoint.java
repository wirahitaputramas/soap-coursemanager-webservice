/* after implementing get course details */
package com.devoid.soap.webservices.soapcoursemanagement.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.devoid.courses.CourseDetails;
import com.devoid.courses.GetCourseDetailsRequest;
import com.devoid.courses.GetCourseDetailsResponse;
import com.devoid.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.devoid.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService service;

	@PayloadRoot(namespace = "http://devoid.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload	
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		
		Course course = service.findById(request.getId());

		return mapCourseDetails(mapCourse(course));
	}
	
	
	private CourseDetails mapCourse(Course course) {
		/* mapping Course to CourseDetails */
		
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		
		return courseDetails;
	}
	
	private GetCourseDetailsResponse mapCourseDetails(CourseDetails courseDetails) {
		/* Mapping CourseDetails to GetCourseDetailsResponse */
		
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(courseDetails);
		
		return response;
		
	}
	
}
