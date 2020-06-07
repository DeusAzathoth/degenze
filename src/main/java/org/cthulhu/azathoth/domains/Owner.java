package org.cthulhu.azathoth.domains;

import org.cthulhu.azathoth.security.domains.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String surname;
    private String name;
    private String contact;
    private String notes;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Pet pet;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;
    private LocalDateTime creation;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "alterator_id", referencedColumnName = "id")
    private User last_mod_author;
    private LocalDateTime last_mod;

    public Owner() {}

    public Owner(String surname, String name, String contact, String notes) {
        this.surname = surname;
        this.name = name;
        this.contact = contact;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        return id != null ? id.equals(owner.id) : owner.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", notes='" + notes + '\'' +
                ", pet=" + pet +
                ", creator=" + creator +
                ", creation=" + creation +
                ", last_mod_author=" + last_mod_author +
                ", last_mod=" + last_mod +
                '}';
    }
}
