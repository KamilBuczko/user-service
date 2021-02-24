package com.nvt.oss.user.service.core.web;

import com.nvt.oss.user.service.api.domain.User;
import com.nvt.oss.user.service.api.domain.UserActionResult;
import com.nvt.oss.user.service.core.details.UserManagementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserManagementService userManagementService;

    @PostMapping
    public UserActionResult create(@RequestBody User request) {
        return userManagementService.createUser(request);
    }

    @PutMapping
    public UserActionResult update(User request) {
        return userManagementService.updateUser(request);
    }

    @PutMapping("/{userId}/password")
    public void updatePassword(@PathVariable("userId") String userId, String password) {
        userManagementService.updateUserPassword(userId, password);
    }

    @GetMapping("/email/{userEmail}/exist")
    public Boolean existsByEmail(@PathVariable("userEmail") String userEmail) {
        return userManagementService.existsByEmail(userEmail);
    }
}
