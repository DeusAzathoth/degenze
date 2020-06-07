package org.cthulhu.azathoth.domains;

import org.cthulhu.azathoth.security.domains.User;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.List;

@Entity
public class Therapy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String active_sub;
    private float dose;
    private String dose_um;
    private String name;
    private float concentration;
    private String concentration_um;
    private String frequency;
    private LocalDateTime begin;
    private LocalDateTime end;

    @ManyToOne
    private Folder folder;
    @ManyToOne
    private Pet pet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;
    private LocalDateTime creation;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alterator_id", referencedColumnName = "id")
    private User last_mod_author;
    private LocalDateTime last_mod;

    @OneToMany(mappedBy = "therapy", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Action> actions;

    public Therapy() {}

    public Therapy(String active_sub, float dose, String dose_um, String name,
                   float concentration, String concentration_um, String frequency,
                   LocalDateTime begin) {
        this.active_sub = active_sub;
        this.dose = dose;
        this.dose_um = dose_um;
        this.name = name;
        this.concentration = concentration;
        this.concentration_um = concentration_um;
        this.frequency = frequency;
        this.begin = begin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActive_sub() {
        return active_sub;
    }

    public void setActive_sub(String active_sub) {
        this.active_sub = active_sub;
    }

    public float getDose() {
        return dose;
    }

    public void setDose(float dose) {
        this.dose = dose;
    }

    public String getDose_um() {
        return dose_um;
    }

    public void setDose_um(String dose_um) {
        this.dose_um = dose_um;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getConcentration() {
        return concentration;
    }

    public void setConcentration(float concentration) {
        this.concentration = concentration;
    }

    public String getConcentration_um() {
        return concentration_um;
    }

    public void setConcentration_um(String concentration_um) {
        this.concentration_um = concentration_um;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
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

        Therapy therapy = (Therapy) o;

        return id != null ? id.equals(therapy.id) : therapy.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Therapy{" +
                "id=" + id +
                ", active_sub='" + active_sub + '\'' +
                ", dose=" + dose +
                ", dose_um='" + dose_um + '\'' +
                ", name='" + name + '\'' +
                ", concentration=" + concentration +
                ", concentration_um='" + concentration_um + '\'' +
                ", frequency='" + frequency + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", folder=" + folder +
                ", pet=" + pet +
                ", creator=" + creator +
                ", creation=" + creation +
                ", last_mod_author=" + last_mod_author +
                ", last_mod=" + last_mod +
                '}';
    }
}
