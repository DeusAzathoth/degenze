package org.cthulhu.azathoth.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int level;
    private boolean busy;
    private boolean ready;

    @ManyToOne
    private Block block;

    @OneToOne
    private Pet pet;

    @OneToMany(mappedBy = "slot", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Folder> folders = new ArrayList<>();

    public Slot() {}

    public Slot(String name, int level, boolean busy, boolean ready) {
    //public Slot(String name, boolean busy, boolean ready) {
        this.name = name;
        this.level = level;
        this.busy = busy;
        this.ready = ready;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Slot slot = (Slot) o;

        return id != null ? id.equals(slot.id) : slot.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
