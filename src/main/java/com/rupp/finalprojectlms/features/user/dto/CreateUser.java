package com.rupp.finalprojectlms.features.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Builder


public record CreateUser(
        String name,
        String email
) {
    // Getters and setters
    public String getName() {
        return name;
    }



    public String getEmail() {
        return email;
    }


}
