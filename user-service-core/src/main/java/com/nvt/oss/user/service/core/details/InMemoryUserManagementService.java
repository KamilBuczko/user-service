package com.nvt.oss.user.service.core.details;

import com.nvt.oss.user.service.api.domain.User;
import com.nvt.oss.user.service.api.domain.UserActionResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
@Slf4j
public class InMemoryUserManagementService implements UserManagementService {

    private final Map<String, User> users = new ConcurrentHashMap<>();

    @Override
    public UserActionResult updateUser(User managedUser) {
        log.debug("Updating user: {user: {}}", managedUser);

        boolean userExists = users.containsKey(managedUser.getUserId());

        if (!userExists) {
            return UserActionResult.userDoesNotExist(managedUser.getUserId());
        }

        users.put(managedUser.getUserId(), managedUser);

        log.debug("Updated user: {user: {}}", managedUser);
        return new UserActionResult(true, managedUser, null);
    }

    @Override
    public void updateUserPassword(String userId, String password) {
        log.debug("Updating user password: {userId: {}}", userId);

        User user = users.get(userId);

        if (nonNull(user)) {
            user.setPassword(password);
            users.put(userId, user);
        }

        log.debug("Updated user password: {user: {}}", user);
    }

    @Override
    public boolean existsByEmail(String userEmail) {
        log.debug("Checking if user exists by email: {email: {}}", userEmail);

        return users.values().stream()
                .anyMatch(user -> user.getEmail().equals(userEmail));
    }

    @Override
    public UserActionResult createUser(User request) {
        log.debug("Creating user: {request: {}}", request);

        User user = users.get(request.getUserId());

        if (nonNull(user)) {
            return new UserActionResult(false, user, format("User with id %s already exists", user.getUserId()));
        }

        users.put(request.getUserId(), request);
        log.debug("Created user: {user: {}}", request);
        return new UserActionResult(true, request, null);
    }

    @Override
    public void executeUserActions(String userId, List<String> actions) {
        log.debug("Keycloak not yet integrated");
    }
}
