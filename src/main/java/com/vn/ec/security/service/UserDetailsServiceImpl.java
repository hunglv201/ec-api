package com.vn.ec.security.service;

import com.vn.ec.common.Constants;
import com.vn.ec.entity.CustomerAccount;
import com.vn.ec.repository.CustomerAccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private CustomerAccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Load by user name: ");
        Optional<CustomerAccount> userAccount = accountRepository.findByLoginIdAndDeleteFlag(username.strip(),
                Constants.DELETE_FALSE);
        if (!userAccount.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return UserDetailsImpl.build(userAccount.get());
    }

}
