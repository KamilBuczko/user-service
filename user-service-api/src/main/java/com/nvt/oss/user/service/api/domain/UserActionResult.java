package com.nvt.oss.user.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.lang.String.format;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserActionResult {

    private boolean success;

    private User user;

    private String errorReason;

    public static UserActionResult userDoesNotExist(String userId) {
        return UserActionResult.builder()
                .success(false)
                .user(null)
                .errorReason(format("User with id %s does not exists", userId))
                .build();
    }

}
