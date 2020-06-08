package org.cthulhu.azathoth.domains;

import org.cthulhu.azathoth.security.domains.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
    private LocalDate begin_day;
    private LocalTime begin_time;
    private LocalDate end_day;
    private LocalTime end_time;

    @ManyToOne
    private Folder folder;
    @ManyToOne
    private Pet pet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;
    private LocalDate creation_day;
    private LocalTime creation_time;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alterator_id", referencedColumnName = "id")
    private User last_mod_author;
    private LocalDate last_mod_day;
    private LocalTime last_mod_time;

    @OneToMany(mappedBy = "therapy", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Action> actions = new ArrayList<>();

    public Therapy() {}

    public Therapy(String active_sub, float dose, String dose_um, String name, float concentration,
                   String concentration_um, String frequency, LocalDate begin_day, LocalTime begin_time) {
        this.active_sub = active_sub;
        this.dose = dose;
        this.dose_um = dose_um;
        this.name = name;
        this.concentration = concentration;
        this.concentration_um = concentration_um;
        this.frequency = frequency;
        this.begin_day = begin_day;
        this.begin_time = begin_time;
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

    public LocalDate getCreation_day() {
        return creation_day;
    }

    public void setCreation_day(LocalDate creation_day) {
        this.creation_day = creation_day;
    }

    public LocalTime getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(LocalTime creation_time) {
        this.creation_time = creation_time;
    }

    public User getLast_mod_author() {
        return last_mod_author;
    }

    public void setLast_mod_author(User last_mod_author) {
        this.last_mod_author = last_mod_author;
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
                ", begin_day=" + begin_day +
                ", begin_time=" + begin_time +
                ", end_day=" + end_day +
                ", end_time=" + end_time +
                ", folder=" + folder +
                ", pet=" + pet +
                ", creator=" + creator +
                ", creation_day=" + creation_day +
                ", creation_time=" + creation_time +
                ", last_mod_author=" + last_mod_author +
                ", last_mod_day=" + last_mod_day +
                ", last_mod_time=" + last_mod_time +
                ", actions=" + actions +
                '}';
    }
}
