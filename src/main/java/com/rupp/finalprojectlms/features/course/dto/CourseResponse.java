package com.rupp.finalprojectlms.features.course.dto;

import lombok.Builder;

@Builder
public record CourseResponse(
        Long id,
        String name,
        String description
) {
}
