package org.cthulhu.azathoth.domains;

import org.cthulhu.azathoth.security.domains.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;
    private LocalDate begin_day;
    private LocalTime begin_time;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alterator_id", referencedColumnName = "id")
    private User last_mod_author;
    private LocalDate last_mod_day;
    private LocalTime last_mod_time;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "closer_id", referencedColumnName = "id")
    private User closer;
    private boolean closed;
    private LocalDate end_day;
    private LocalTime end_time;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Therapy> therapies = new ArrayList<>();

    @ManyToOne
    private Pet pet;

    @ManyToOne
    private Slot slot;

    @ManyToOne
    private Block block;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Action> actions = new ArrayList<>();

    public Folder() {}

    public Folder(LocalDate begin_day, LocalTime begin_time, boolean closed) {
        this.begin_day = begin_day;
        this.begin_time = begin_time;
        this.closed = closed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBegin_day() {
        return begin_day;
    }

    public void setBegin_day(LocalDate begin_day) {
        this.begin_day = begin_day;
    }

    public LocalTime getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(LocalTime begin_time) {
        this.begin_time = begin_time;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public LocalDate getLast_mod_day() {
        return last_mod_day;
    }

    public void setLast_mod_day(LocalDate last_mod_day) {
        this.last_mod_day = last_mod_day;
    }

    public LocalTime getLast_mod_time() {
        return last_mod_time;
    }

    public void setLast_mod_time(LocalTime last_mod_time) {
        this.last_mod_time = last_mod_time;
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

    public LocalDate getEnd_day() {
        return end_day;
    }

    public void setEnd_day(LocalDate end_day) {
        this.end_day = end_day;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
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
                ", begin_day=" + begin_day +
                ", begin_time=" + begin_time +
                ", last_mod_author=" + last_mod_author +
                ", last_mod_day=" + last_mod_day +
                ", last_mod_time=" + last_mod_time +
                ", closer=" + closer +
                ", closed=" + closed +
                ", end_day=" + end_day +
                ", end_time=" + end_time +
                ", therapies=" + therapies +
                ", pet=" + pet +
                ", slot=" + slot +
                ", block=" + block +
                ", actions=" + actions +
                '}';
    }
}
