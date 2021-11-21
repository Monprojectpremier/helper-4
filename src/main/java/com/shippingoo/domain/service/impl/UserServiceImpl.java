package com.shippingoo.domain.service.impl;

import com.shippingoo.domain.User;
import com.shippingoo.domain.security.PasswordResetToken;
import com.shippingoo.domain.security.Role;
import com.shippingoo.domain.security.UserRole;
import com.shippingoo.domain.service.UserService;
import com.shippingoo.repository.PasswordResetTokenRepository;
import com.shippingoo.repository.RoleRepository;
import com.shippingoo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public PasswordResetToken getPasswordResetToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public void createPasswordResetTokenForUser(final User user, final String token) {
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }



  /*  @Override
    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User localUser = userRepository.findByUsername(user.getUsername());

        if(localUser!=null){

            LOG.info("user {} already exists.Nothing will be done.", user.getUsername());
        } else{
            for(UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            localUser=userRepository.save(user);

        }
        return localUser;

    }*/


    @Override
    @Transactional
    public User createUser(User user, Set<Role> roles) {
        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
        } else {
            for (Role role : roles) {
                roleRepository.save(role);
                user.getRoles().add(role);
            }


            localUser = userRepository.save(user);
        }

        return localUser;
    }
}