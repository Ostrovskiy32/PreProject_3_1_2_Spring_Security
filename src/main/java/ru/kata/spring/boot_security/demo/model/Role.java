package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
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
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) && Objects.equals(roleName, role.roleName) && Objects.equals(userSet, role.userSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, userSet);
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
