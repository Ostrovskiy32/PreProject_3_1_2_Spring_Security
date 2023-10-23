package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

<<<<<<< HEAD

=======
>>>>>>> 6435524 (first commit)
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
<<<<<<< HEAD
    @Column
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Set<User> userSet;

    public Role() {

    }


    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName, Set<User> userSet) {
        this.roleName = roleName;
        this.userSet = userSet;
=======

    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> userSet;

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    public Role(String role) {
        this.role = role;
    }

    public Role(String role, long roleId) {
        this.roleId = roleId;
        this.role = role;
    }

    public Role() {

    }
    @Override
    public String toString() {
        return getRole().substring(getRole().indexOf('_') + 1);
>>>>>>> 6435524 (first commit)
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

<<<<<<< HEAD
    public String getRoleName() {
        return roleName;
    }

    public void setUserName(String userName) {
        this.roleName = userName;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
=======
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return userSet;
    }

    public void setUsers(Set<User> users) {
        this.userSet = users;
>>>>>>> 6435524 (first commit)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
<<<<<<< HEAD
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) && Objects.equals(roleName, role.roleName) && Objects.equals(userSet, role.userSet);
=======
        Role role1 = (Role) o;
        return Objects.equals(roleId, role1.roleId) && Objects.equals(role, role1.role);
>>>>>>> 6435524 (first commit)
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(roleId, roleName, userSet);
=======
        return Objects.hash(roleId, role);
>>>>>>> 6435524 (first commit)
    }

    @Override
    public String getAuthority() {
<<<<<<< HEAD
        return getRoleName();
=======
        return role;
>>>>>>> 6435524 (first commit)
    }
}
