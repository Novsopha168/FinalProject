package com.rupp.finalprojectlms.features.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder

public record UserResponse(
        Long id,
        String name,
        String email
) {

}
