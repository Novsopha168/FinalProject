package com.rupp.finalprojectlms.features.course;

import com.rupp.finalprojectlms.domain.Course;
import com.rupp.finalprojectlms.features.course.dto.CourseResponse;
import com.rupp.finalprojectlms.features.course.dto.CreateCourse;
import com.rupp.finalprojectlms.mapper.CourseMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImp implements CourseService{

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;



    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toCourseResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id " + id));
        return courseMapper.toCourseResponse(course);
    }

    @Override
    public CourseResponse createCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toCourseResponse(savedCourse);
    }

    @Override
    public CourseResponse updateCourse(Long id, CreateCourse createCourse) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id " + id));

        courseMapper.updateCourseFromCreateCourse(createCourse, existingCourse);

        Course updatedCourse = courseRepository.save(existingCourse);
        return courseMapper.toCourseResponse(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new EntityNotFoundException("Course not found with id " + id);
        }
        courseRepository.deleteById(id);
    }
}
