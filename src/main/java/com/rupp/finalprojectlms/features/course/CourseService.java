package com.rupp.finalprojectlms.features.course;

import com.rupp.finalprojectlms.domain.Course;
import com.rupp.finalprojectlms.features.course.dto.CourseResponse;
import com.rupp.finalprojectlms.features.course.dto.CreateCourse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses();
    CourseResponse getCourseById(Long id);
    CourseResponse createCourse(Course course);
    CourseResponse updateCourse(Long id, CreateCourse CreateCourse);
    void deleteCourse(Long id);
}
