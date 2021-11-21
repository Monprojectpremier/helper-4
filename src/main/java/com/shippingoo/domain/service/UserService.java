package com.shippingoo.domain.service;

import com.shippingoo.domain.User;
import com.shippingoo.domain.security.PasswordResetToken;
import com.shippingoo.domain.security.Role;
import com.shippingoo.domain.security.UserRole;

import java.util.Set;

public interface UserService {

    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);

    User findByUsername(String username);
    User findByEmail(String email);
    User save(User user);
    User findById(Long id);
   // User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User createUser(User user, Set<Role> roles) throws Exception;


}
