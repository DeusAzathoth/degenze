package org.cthulhu.azathoth.domains;

import org.cthulhu.azathoth.security.domains.User;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.List;

@Entity
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;
    private LocalDateTime begin;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alterator_id", referencedColumnName = "id")
    private User last_mod_author;
    private LocalDateTime last_mod;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "closer_id", referencedColumnName = "id")
    private User closer;
    private boolean closed;
    private LocalDateTime end;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Therapy> therapies;

    @ManyToOne
    private Pet pet;

    @ManyToOne
    private Slot slot;

    @ManyToOne
    private Block block;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Action> actions;

    public Folder() {}

    public Folder(LocalDateTime begin, boolean closed) {
        this.begin = begin;
        this.closed = closed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public List<Therapy> getTherapies() {
        return therapies;
    }

    public void setTherapies(List<Therapy> therapies) {
        this.therapies = therapies;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getLast_mod_author() {
        return last_mod_author;
    }

    public void setLast_mod_author(User last_mod_author) {
        this.last_mod_author = last_mod_author;
    }

    public LocalDateTime getLast_mod() {
        return last_mod;
    }

    public void setLast_mod(LocalDateTime last_mod) {
        this.last_mod = last_mod;
    }

    public User getCloser() {
        return closer;
    }

    public void setCloser(User closer) {
        this.closer = closer;
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

        Folder folder = (Folder) o;

        return id != null ? id.equals(folder.id) : folder.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "id=" + id +
                ", creator=" + creator +
                ", begin=" + begin +
                ", last_mod_author=" + last_mod_author +
                ", last_mod=" + last_mod +
                ", closer=" + closer +
                ", closed=" + closed +
                ", end=" + end +
                ", pet=" + pet +
                ", slot=" + slot +
                ", block=" + block +
                '}';
    }
}
