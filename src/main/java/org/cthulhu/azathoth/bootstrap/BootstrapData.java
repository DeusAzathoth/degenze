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

    }
}
