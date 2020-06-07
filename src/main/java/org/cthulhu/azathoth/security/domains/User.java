package org.cthulhu.azathoth.security.domains;

import org.cthulhu.azathoth.domains.Action;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String user;
    private String password_plain;
    private String password_crypt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Action> actions;

    public User() {}

    public User(String user, String password_plain, String password_crypt) {
        this.user = user;
        this.password_plain = password_plain;
        this.password_crypt = password_crypt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword_plain() {
        return password_plain;
    }

    public void setPassword_plain(String password_plain) {
        this.password_plain = password_plain;
    }

    public String getPassword_crypt() {
        return password_crypt;
    }

    public void setPassword_crypt(String password_crypt) {
        this.password_crypt = password_crypt;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password_plain='" + password_plain + '\'' +
                ", password_crypt='" + password_crypt + '\'' +
                '}';
    }

}
