package com.durgesh;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONException;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.durgesh.dto.CourseDto;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class AdminLearningmanagementSystemIntegrationTests {
	
	@Test
	@Order(1)
	void getAllCoursessIntegrationTests() throws JSONException {
		String expected = "[\r\n" + 
				"  {\r\n" + 
				"    \"courseId\": 26,\r\n" + 
				"    \"courseName\": \"python general-purpose programming\",\r\n" + 
				"    \"courseDuration\": 2.5,\r\n" + 
				"    \"courseDescription\": \"Python is a high-level, general-purpose programming language Its design philosophy emphasizes code readability with the use of significant indentation Python is dynamically-typed and garbage-collected.\",\r\n" + 
				"    \"technology\": \"Python\",\r\n" + 
				"    \"launchUrl\": \"www.w3schools.com\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"courseId\": 27,\r\n" + 
				"    \"courseName\": \"Java general-purpose programming\",\r\n" + 
				"    \"courseDuration\": 3.5,\r\n" + 
				"    \"courseDescription\": \"Java is a high-level, general-purpose programming language Its design philosophy emphasizes code readability with the use of significant indentation Python is dynamically-typed and garbage-collected.\",\r\n" + 
				"    \"technology\": \"Java\",\r\n" + 
				"    \"launchUrl\": \"www.w3school.com\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"courseId\": 28,\r\n" + 
				"    \"courseName\": \"R general-purpose programming\",\r\n" + 
				"    \"courseDuration\": 3.5,\r\n" + 
				"    \"courseDescription\": \"R is a high-level, general-purpose programming language Its design philosophy emphasizes code readability with the use of significant indentation Python is dynamically-typed and garbage-collected.\",\r\n" + 
				"    \"technology\": \"R\",\r\n" + 
				"    \"launchUrl\": \"http://www.w3school.com\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"courseId\": 29,\r\n" + 
				"    \"courseName\": \"Kotlin general-purpose programming\",\r\n" + 
				"    \"courseDuration\": 4.5,\r\n" + 
				"    \"courseDescription\": \"Kotlin is a high-level, general-purpose programming language Its design philosophy emphasizes code readability with the use of significant indentation Python is dynamically-typed and garbage-collected.\",\r\n" + 
				"    \"technology\": \"Kotlin\",\r\n" + 
				"    \"launchUrl\": \"http://www.w3school.com\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"courseId\": 30,\r\n" + 
				"    \"courseName\": \"PHP general-purpose programming\",\r\n" + 
				"    \"courseDuration\": 6.5,\r\n" + 
				"    \"courseDescription\": \"PHP is a high-level, general-purpose programming language Its design philosophy emphasizes code readability with the use of significant indentation Python is dynamically-typed and garbage-collected.\",\r\n" + 
				"    \"technology\": \"PHP\",\r\n" + 
				"    \"launchUrl\": \"www.w3schools.com\"\r\n" + 
				"  }\r\n" + 
				"]";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> res = restTemplate.getForEntity("http://localhost:8090/api/v1.0/lms/Course/AllCourse", String.class);

		System.out.println(res.getBody());
		System.out.println(res.getStatusCode());
		JSONAssert.assertEquals(expected, res.getBody(), false);
	}
	
	@Test
	@Order(2)
	void getAllByTechnologyIntegrationTests() throws JSONException {
		String expected = "[{\r\n" + 
				"    \"courseId\": 26,\r\n" + 
				"    \"courseName\": \"python general-purpose programming\",\r\n" + 
				"    \"courseDuration\": 2.5,\r\n" + 
				"    \"courseDescription\": \"Python is a high-level, general-purpose programming language Its design philosophy emphasizes code readability with the use of significant indentation Python is dynamically-typed and garbage-collected.\",\r\n" + 
				"    \"technology\": \"Python\",\r\n" + 
				"    \"launchUrl\": \"www.w3schools.com\"\r\n" + 
				"  }]";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> res = restTemplate
				.getForEntity("http://localhost:8090/api/v1.0/lms/Course/getCourseByTechnology/python", String.class);

		System.out.println(res.getBody());
		System.out.println(res.getStatusCode());
		JSONAssert.assertEquals(expected, res.getBody(), false);
	}
	
	@Test
	@Order(3)
	void getAllByIdIntegrationTests() throws JSONException {
		String expected = "{\r\n" + 
				"  \"courseId\": 26,\r\n" + 
				"  \"courseName\": \"python general-purpose programming\",\r\n" + 
				"  \"courseDuration\": 2.5,\r\n" + 
				"  \"courseDescription\": \"Python is a high-level, general-purpose programming language Its design philosophy emphasizes code readability with the use of significant indentation Python is dynamically-typed and garbage-collected.\",\r\n" + 
				"  \"technology\": \"Python\",\r\n" + 
				"  \"launchUrl\": \"www.w3schools.com\"\r\n" + 
				"}";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> res = restTemplate
				.getForEntity("http://localhost:8090/api/v1.0/lms/Course/CourseBy/26", String.class);

		System.out.println(res.getBody());
		System.out.println(res.getStatusCode());
		JSONAssert.assertEquals(expected, res.getBody(), false);
	}
	@Test
	@Order(4)
	public void test_AddCourseIntegrationTest() throws Exception {

		CourseDto CourseDto=new CourseDto();
		CourseDto.setCourseName("CoreJava new version of 2. 1");
		CourseDto.setCourseDuration(3.5);
		CourseDto.setCourseDescription("core java new addition,general-purpose programming language Its design philosophy emphasizes code readability with the use of significant indentation Python is dynamically-typed and garbage-collected.");
		CourseDto.setTechnology("CoreJava");
		CourseDto.setLaunchUrl("www.java.com");
		

		String expected = "{\r\n" + 
				"    \"courseId\": 51,\r\n" + 
				"    \"courseName\": \"CoreJava new version of 2. 1\",\r\n" + 
				"    \"courseDuration\": 3.5,\r\n" + 
				"    \"courseDescription\": \"core java new addition,general-purpose programming language Its design philosophy emphasizes code readability with the use of significant indentation Python is dynamically-typed and garbage-collected.\",\r\n" + 
				"    \"technology\": \"CoreJava\",\r\n" + 
				"    \"launchUrl\": \"www.java.com\"\r\n" + 
				"  }";

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<CourseDto> request = new HttpEntity<CourseDto>(CourseDto, headers);

		ResponseEntity<String> res = restTemplate.postForEntity("http://localhost:8090/api/v1.0/lms/Course/saveCourse",request, String.class);

		System.out.println(res.getBody());
		System.out.println(res.getStatusCode());
		
		assertEquals(HttpStatus.CREATED,res.getStatusCode());
		JSONAssert.assertEquals(expected, res.getBody(), false);
	}
	
	

}
