package com.rupp.finalprojectlms.features.enrollment.dto;

import com.rupp.finalprojectlms.features.course.dto.CourseResponse;
import com.rupp.finalprojectlms.features.user.dto.UserResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder

public record EnrollmentResponse(
        Long id,
        UserResponse user,
        CourseResponse course,
        LocalDate enrollmentDate
) {
}
