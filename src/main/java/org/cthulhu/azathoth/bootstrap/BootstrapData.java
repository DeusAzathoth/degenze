package org.cthulhu.azathoth.bootstrap;

import org.cthulhu.azathoth.domains.Block;
import org.cthulhu.azathoth.domains.Slot;
import org.cthulhu.azathoth.repositories.BlockRepository;
import org.cthulhu.azathoth.repositories.SlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BlockRepository blockRepository;
    private final SlotRepository slotRepository;

    public BootstrapData(BlockRepository blockRepository, SlotRepository slotRepository) {
        this.blockRepository = blockRepository;
        this.slotRepository = slotRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Block 1
        Block block1 = new Block("Block 1", "Degenza", "3x2");
        blockRepository.save(block1);
        // Slot A1
        Slot a1 = new Slot("a1", 1, true, true);
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
        Slot b1 = new Slot("b1", 2,true, true);
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

    }
}
