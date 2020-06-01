package org.cthulhu.azathoth.views.blockview;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.cthulhu.azathoth.MainView;
import org.cthulhu.azathoth.domains.Block;
import org.cthulhu.azathoth.domains.Slot;
import org.cthulhu.azathoth.repositories.BlockRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Route(value = "block", layout = MainView.class)
public class BlockView extends VerticalLayout implements HasUrlParameter<String> {

    private Map<String, List<String>> parametersMap = null;
    private BlockRepository blockRepository;

    private Block foundedBlock;

    Optional<Block> block;

    public BlockView() {

        System.out.println("BlockView");

        if (parametersMap != null) {
            List<String> l = parametersMap.get("block");
            String block_id_s = l.get(0);
            System.out.println("Ricerco il blocco numero: " + block_id_s);
            Long block_id = Long.parseLong(block_id_s);
            block = blockRepository.findById(block_id);
        }

        if (block.isPresent()) {
            System.out.println("Blocco esistente nel database");
            foundedBlock = block.get();
            System.out.println("Layout: " + foundedBlock.getLayout());
            if (foundedBlock.getLayout().equalsIgnoreCase("3x2")) {
                create3x2();
            } else {
                System.out.println("Questo blocco non ha un layout");
            }
        } else {
            System.out.println("Questo blocco non esiste nel database");
        }

    }

    private void create3x2() {

        System.out.println("Creo il layout 3x2");

        HorizontalLayout row1 = new HorizontalLayout();
        row1.setWidth("80%");
        row1.getStyle().set("border", "2px solid #000000");
        HorizontalLayout row2 = new HorizontalLayout();
        row2.setWidth("80%");
        row2.getStyle().set("border", "2px solid #000000");

        List<Slot> slotList = foundedBlock.getSlots();

        slotList.forEach(slot -> {
            if (slot.getLevel() == 1) {
                row1.add(new SingleSlot(slot));
            } else if (slot.getLevel() == 2) {
                row2.add(new SingleSlot(slot));
            } else {
                System.out.println("Slot non appartenente al layout");
            }
        });

        add(row1, row2);

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String s) {

        Location location = beforeEvent.getLocation();
        QueryParameters queryParameters = location.getQueryParameters();
        Map<String, List<String>> parametersMap = queryParameters.getParameters();

    }

}
