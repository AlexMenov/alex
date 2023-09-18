package com.alex.bank.alexbank.config;

import com.alex.bank.alexbank.model.Role;
import com.alex.bank.alexbank.model.UserAccount;
import com.alex.bank.alexbank.service.RoleServiceImpl;
import com.alex.bank.alexbank.service.UserAccountServiceImpl;
import org.hibernate.cache.spi.support.CollectionReadOnlyAccess;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(16);
    }
    @Bean
    public CommandLineRunner runner(PasswordEncoder passwordEncoder,
                                    RoleServiceImpl roleService,
                                    UserAccountServiceImpl userAccountService) {
        return args -> {
            Collection<Role> roles = roleService.allRoles();
            List<UserAccount> userAccounts = roles.stream()
                    .map(role -> new UserAccount(role.getRoleName() + "_TEST",
                            passwordEncoder.encode("123456789"),
                            List.of(role)))
                    .collect(Collectors.toList());
            userAccountService.saveAllUsersAccounts(userAccounts);
        };
    }
}
