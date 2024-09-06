package com.rupp.finalprojectlms.mapper;

import com.rupp.finalprojectlms.domain.Course;
import com.rupp.finalprojectlms.domain.Enrollment;
import com.rupp.finalprojectlms.domain.User;
import com.rupp.finalprojectlms.features.course.dto.CourseResponse;
import com.rupp.finalprojectlms.features.enrollment.dto.CreateEnrollment;
import com.rupp.finalprojectlms.features.enrollment.dto.EnrollmentResponse;
import com.rupp.finalprojectlms.features.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);
    @Mapping(target = "user", source = "user")
    @Mapping(target = "course", source = "course")
    EnrollmentResponse toEnrollmentResponse(Enrollment enrollment);

    Enrollment toEnrollment(CreateEnrollment createEnrollment);
}
