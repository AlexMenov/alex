package com.alex.bank.alexbank.service;

import com.alex.bank.alexbank.model.UserAccount;
import com.alex.bank.alexbank.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserAccountServiceImpl {
    private final UserAccountRepository accountRepository;

    public void saveAllUsersAccounts (Collection<UserAccount> accountCollection) {
        accountRepository.saveAll(accountCollection);
    }
}
