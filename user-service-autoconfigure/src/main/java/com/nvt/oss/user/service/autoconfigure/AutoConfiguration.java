package com.nvt.oss.user.service.autoconfigure;

import com.nvt.oss.user.service.core.details.InMemoryUserManagementService;
import com.nvt.oss.user.service.core.details.UserManagementService;
import com.nvt.oss.user.service.core.web.UserController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
public class AutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public UserManagementService greetingService() {
        return new InMemoryUserManagementService();
    }

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnWebApplication
    @Import({UserController.class})
    public static class WebConfiguration {}
}
