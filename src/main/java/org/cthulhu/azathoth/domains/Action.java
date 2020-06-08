package org.cthulhu.azathoth.domains;

import org.cthulhu.azathoth.security.domains.User;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime time;

    @ManyToOne
    private Folder folder;

    @ManyToOne
    private Therapy therapy;

    @ManyToOne
    private User user;

    public Action() {}

    public Action(LocalDateTime time) {
        this.time = time;
    }

    public Action(Therapy therapy) {
        this.therapy = therapy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        return id != null ? id.equals(action.id) : action.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", time=" + time +
                ", therapy=" + therapy +
                ", user=" + user +
                '}';
    }
}
