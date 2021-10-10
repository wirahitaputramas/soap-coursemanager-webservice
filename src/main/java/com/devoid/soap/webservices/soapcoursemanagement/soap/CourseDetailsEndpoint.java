/* after implementing get course details */
package com.devoid.soap.webservices.soapcoursemanagement.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.devoid.courses.CourseDetails;
import com.devoid.courses.GetCourseDetailsRequest;
import com.devoid.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {

	@PayloadRoot(namespace = "http://devoid.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("SOAP web services Course");
		courseDetails.setDescription("It is a wonderful course!");
		
		response.setCourseDetails(courseDetails);
		
		return response;
	}
	
}
