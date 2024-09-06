package com.rupp.finalprojectlms.mapper;

import com.rupp.finalprojectlms.domain.Course;
import com.rupp.finalprojectlms.features.course.dto.CourseResponse;
import com.rupp.finalprojectlms.features.course.dto.CreateCourse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseResponse toCourseResponse(Course course);

    void updateCourseFromCreateCourse(CreateCourse createCourse, @MappingTarget Course course);
}
