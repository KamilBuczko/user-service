package com.nvt.oss.user.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"password"})
public class User {

    private String userId;

    private String name;

    private String surname;

    private String password;

    private String email;

    private Long createdTimestamp;

    private Boolean enabled;

    private Boolean emailVerified;

    private Map<String, String> attributes;

    private List<String> roles;

    private List<String> groups;
}
