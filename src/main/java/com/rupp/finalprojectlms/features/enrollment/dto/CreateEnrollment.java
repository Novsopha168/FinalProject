package com.rupp.finalprojectlms.features.enrollment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder

public record CreateEnrollment(
        Long userId,
        Long courseId
) {

    public Long getUserId() {
        return userId;
    }

    public Long getCourseId() {

        return courseId;
    }
}
