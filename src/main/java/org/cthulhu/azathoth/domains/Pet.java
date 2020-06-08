package org.cthulhu.azathoth.domains;

import org.cthulhu.azathoth.security.domains.User;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String species;
    private String race;
    private String age;
    private String sex;
    private boolean neutered;
    private float weight;
    private String notes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "block_id", referencedColumnName = "id")
    private Block block;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "slot_id", referencedColumnName = "id")
    private Slot slot;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Folder> folders = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;
    private LocalDateTime creation;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alterator_id", referencedColumnName = "id")
    private User last_mod_author;
    private LocalDateTime last_mod;


    public Pet() {}

    public Pet(String name, String species, String race, String age, String sex, boolean neutered, float weight, String notes) {
        this.name = name;
        this.species = species;
        this.race = race;
        this.age = age;
        this.sex = sex;
        this.neutered = neutered;
        this.weight = weight;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isNeutered() {
        return neutered;
    }

    public void setNeutered(boolean neutered) {
        this.neutered = neutered;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
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

        Pet pet = (Pet) o;

        return id != null ? id.equals(pet.id) : pet.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", race='" + race + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", neutered=" + neutered +
                ", weight=" + weight +
                ", notes='" + notes + '\'' +
                ", block=" + block +
                ", slot=" + slot +
                ", owner=" + owner +
                ", folders=" + folders +
                ", creator=" + creator +
                ", creation=" + creation +
                ", last_mod_author=" + last_mod_author +
                ", last_mod=" + last_mod +
                '}';
    }
}
