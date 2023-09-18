package com.alex.bank.alexbank.service;

import com.alex.bank.alexbank.model.Role;
import com.alex.bank.alexbank.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl {
    private final RoleRepository roleRepository;

    public Collection<Role> allRoles () {
        return roleRepository.findAll();
    }
}
