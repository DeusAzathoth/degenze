package org.cthulhu.azathoth.bootstrap;

import org.cthulhu.azathoth.commons.Therapy_Costants;
import org.cthulhu.azathoth.domains.*;
import org.cthulhu.azathoth.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;


@Component
public class BootstrapData implements CommandLineRunner {

    private Block block1;
    private Slot a1;
    private Owner owner1;
    private Pet pet1;
    private Folder folder1;
    private Therapy onceADay;
    private Therapy twiceADay;
    private Therapy threeTimesADay;
    private Therapy plasil;

    private final BlockRepository blockRepository;
    private final SlotRepository slotRepository;
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;
    private final FolderRepository folderRepository;
    private final TherapyRepository therapyRepository;

    public BootstrapData(BlockRepository blockRepository, SlotRepository slotRepository,
                         PetRepository petRepository, OwnerRepository ownerRepository,
                         FolderRepository folderRepository, TherapyRepository therapyRepository) {
        this.blockRepository = blockRepository;
        this.slotRepository = slotRepository;
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.folderRepository = folderRepository;
        this.therapyRepository = therapyRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Block 1
        block1 = new Block("Block 1", "Degenza", "3x2");
        blockRepository.save(block1);
        // Slot A1
        a1 = new Slot("a1", 1, true, true);
        a1.setBlock(block1);
        slotRepository.save(a1);
        block1.getSlots().add(a1);
        blockRepository.save(block1);
        // Slot A2
        Slot a2 = new Slot("a2", 1,false, true);
        a2.setBlock(block1);
        slotRepository.save(a2);
        block1.getSlots().add(a2);
        blockRepository.save(block1);
        // Slot A3
        Slot a3 = new Slot("a3", 1,false, true);
        a3.setBlock(block1);
        slotRepository.save(a3);
        block1.getSlots().add(a3);
        blockRepository.save(block1);
        // Slot B1
        Slot b1 = new Slot("b1", 2,false, true);
        b1.setBlock(block1);
        slotRepository.save(b1);
        block1.getSlots().add(b1);
        blockRepository.save(block1);
        // Slot B2
        Slot b2 = new Slot("b2", 2,false, false);
        b2.setBlock(block1);
        slotRepository.save(b2);
        block1.getSlots().add(b2);
        blockRepository.save(block1);

        // Block 2
        Block block2 = new Block("Block 2", "Degenza", "3x2");
        blockRepository.save(block2);

        // Pet 1
        addPet1();

        // Folder 1
        addFolder1();

        // Therapy
        addTherapy();

    }

    private void addPet1() {
        owner1 = new Owner("Lorenzon", "Serena", "000000", "");
        ownerRepository.save(owner1);
        pet1 = new Pet("Tiffany", "Cane", "Barbone", "5",
                "Femmina", false, 5.0f, "");
        petRepository.save(pet1);
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);
        ownerRepository.save(owner1);
        a1.setPet(pet1);
        slotRepository.save(a1);
        pet1.setSlot(a1);
        petRepository.save(pet1);
    }

    private void addFolder1() {
        folder1 = new Folder(LocalDate.now(), LocalTime.now(), false);
        folder1.setPet(pet1);
        folder1.setSlot(a1);
        folder1.setBlock(block1);
        folderRepository.save(folder1);
        pet1.getFolders().add(folder1);
        petRepository.save(pet1);
        a1.getFolders().add(folder1);
        slotRepository.save(a1);
        block1.getFolders().add(folder1);
        blockRepository.save(block1);
    }

    private void addTherapy() {
        onceADay = new Therapy("Enrofloxacina", 5f, "mg/kg",
                "Xeden",
                50f, "mg/ml",
                Therapy_Costants.SID,
                LocalDate.of(2020, 5, 31),
                LocalTime.of(10, 30)

        );
        onceADay.setFolder(folder1);
        onceADay.setPet(pet1);
        therapyRepository.save(onceADay);
        twiceADay = new Therapy("Amoxicillina", 10f, "mg/kg",
                "Synulox", 500f, "mg/ml",
                Therapy_Costants.BID,
                LocalDate.of(2020, 5,31),
                LocalTime.of(10, 30));
        twiceADay.setFolder(folder1);
        twiceADay.setPet(pet1);
        therapyRepository.save(twiceADay);
        threeTimesADay = new Therapy("Tobramicina", 1f, "gtt",
                "Stilbiotic", 0f, "",
                Therapy_Costants.TID,
                LocalDate.of(2020,6,1),
                LocalTime.of(18,30));
        threeTimesADay.setFolder(folder1);
        threeTimesADay.setPet(pet1);
        therapyRepository.save(threeTimesADay);
        plasil = new Therapy("Metoclopramide", 0.4f, "mg/kg",
                "Vomend",
                10f, "mg/ml", Therapy_Costants.TID,
                LocalDate.of(2020, 6,1),
                LocalTime.of(10, 30));
        plasil.setFolder(folder1);
        plasil.setPet(pet1);
        therapyRepository.save(plasil);
    }
}
