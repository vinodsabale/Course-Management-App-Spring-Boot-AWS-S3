package com.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.Course;
import com.Repository.CourseRepository;

@Service
public class CourseService {
	 private final CourseRepository courseRepository;
	    private final S3Service s3Service;

	    public CourseService(CourseRepository courseRepository, S3Service s3Service) {
	        this.courseRepository = courseRepository;
	        this.s3Service = s3Service;
	    }
	  public void saveCourse(Course course,MultipartFile imageFile) {
		  if(imageFile !=null && !imageFile.isEmpty()) {
			  String imageUrl=s3Service.uploadFile(imageFile);
			  course.setCourseImageUrl(imageUrl);
		  }
		  courseRepository.save(course);
	  }
	  public List<Course> getAllCourse(){
		  return courseRepository.findAll();
	  }
	
}
