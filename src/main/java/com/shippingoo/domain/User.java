package com.shippingoo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shippingoo.domain.security.Role;
import com.shippingoo.domain.security.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable=false, updatable=false)
    private Long id;
    @Column(name ="username", nullable = false,updatable = false)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Column(name ="email", nullable = false,updatable = false)
    private String email;
    private String phone;
   private boolean enabled=true;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<PostRequest> postRequests;

    @Transient
    private MultipartFile photo;



/*

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
   private Set <UserRole> userRoles = new HashSet<>();
*/

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set <SimpleGrantedAuthority> authorities=new HashSet<>();
        roles.forEach(role-> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return null;
    }



    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<PostRequest> getPostRequests() {
        return postRequests;
    }

    public void setPostRequests(List<PostRequest> postRequests) {
        this.postRequests = postRequests;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", enabled=" + enabled +
                ", photo=" + photo +
                ", roles=" + roles +
                '}';
    }
}
