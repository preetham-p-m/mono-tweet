package com.pmp.restful_web_service.model;

import jakarta.validation.constraints.Size;

public record PostRecord(long id,
        @Size(min = 10, message = "Description must be minimum of 10 characters") @Size(max = 250, message = "Description must be maximum of 250 character") String description,
        long user_id) {
}
