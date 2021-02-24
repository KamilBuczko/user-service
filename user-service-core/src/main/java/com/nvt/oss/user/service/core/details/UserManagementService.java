package com.nvt.oss.user.service.core.details;

import com.nvt.oss.user.service.api.domain.User;
import com.nvt.oss.user.service.api.domain.UserActionResult;

import java.util.List;

public interface UserManagementService {

    UserActionResult createUser(User request);

    UserActionResult updateUser(User managedUser);

    void updateUserPassword(String userId, String password);

    boolean existsByEmail(String userEmail);

    void executeUserActions(String userId, List<String> actions);
}
