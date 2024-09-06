package com.rupp.finalprojectlms.features.course;


import com.rupp.finalprojectlms.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

