package ru.kata.spring.boot_security.demo.model;

<<<<<<< HEAD
=======

>>>>>>> 6435524 (first commit)
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.Collection;
=======
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

>>>>>>> 6435524 (first commit)
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "name")
<<<<<<< HEAD
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Byte age;
    @Column(name = "citizenship")
    private String citizenship;
    @Column(name = "userame")
    private String username;
    @Column(name = "password")
    private String password;
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Collection<Role> roles;

    public User(String name, String surname, Byte age, String citizenship, String username, String password, Collection<Role> roles) {
=======
    @NotBlank(message = "The field must not have zero and no more than 50 characters")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "The field must not have zero and no more than 50 characters")
    private String surname;
    @NotBlank
    private Byte age;
    @Column(name = "citizenship")
    @NotBlank(message = "The field must not have zero and no more than 50 characters")
    private String citizenship;
    @Column(name = "username", unique = true)
    @NotBlank(message = "The field must not have zero and no more than 50 characters")
    private String username;
    @Column(name = "password")
    @NotBlank(message = "The field must not have zero and no more than 50 characters")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role", joinColumns = {@JoinColumn(name = "userId")},
    inverseJoinColumns = @JoinColumn (name = "roleId"))
    private Collection <Role> roles;

    public User() {

    }

    public User(String name, String surname, Byte age, String citizenship, String username, String password, Set<Role> roles) {
>>>>>>> 6435524 (first commit)
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.citizenship = citizenship;
        this.username = username;
        this.password = password;
        this.roles = roles;
<<<<<<< HEAD
    }

    public User() {

    }

    public Long getUserId() {
        return userId;
    }
=======

    }
    public void setRole(Collection<Role> roles) { this.roles = roles; }
>>>>>>> 6435524 (first commit)

    public void setUserId(Long userId) {
        this.userId = userId;
    }

<<<<<<< HEAD
    public String getName() {
        return name;
    }

=======
>>>>>>> 6435524 (first commit)
    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
    public String getSurname() {
        return surname;
    }

=======
>>>>>>> 6435524 (first commit)
    public void setSurname(String surname) {
        this.surname = surname;
    }

<<<<<<< HEAD
    public Byte getAge() {
        return age;
    }

=======
>>>>>>> 6435524 (first commit)
    public void setAge(Byte age) {
        this.age = age;
    }

<<<<<<< HEAD
    public String getCitizenship() {
        return citizenship;
    }

=======
>>>>>>> 6435524 (first commit)
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

<<<<<<< HEAD
    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

=======
>>>>>>> 6435524 (first commit)
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

<<<<<<< HEAD
    @Override
=======
    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Byte getAge() {
        return age;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public Collection<Role> getRoles() { return roles; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

>>>>>>> 6435524 (first commit)
    public String getPassword() {
        return password;
    }

<<<<<<< HEAD
    @Override
=======
>>>>>>> 6435524 (first commit)
    public String getUsername() {
        return username;
    }

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
        return true;
    }
<<<<<<< HEAD
=======

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(age, user.age) && Objects.equals(password, user.password) && Objects.equals(username, user.username) && Objects.equals(citizenship, user.citizenship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surname, age, citizenship, username, password);
    }
>>>>>>> 6435524 (first commit)
}
