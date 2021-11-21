package com.shippingoo.domain.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private int roleId;

    @Column(name="ROLE_NAME")
    private String name;

  //  @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   // private Set<UserRole> userRoles = new HashSet<>();


    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   // public Set<UserRole> getUserRoles() {
   //     return userRoles;
   // }

    //public void setUserRoles(Set<UserRole> userRoles) {
    //    this.userRoles = userRoles;
  //  }


}
