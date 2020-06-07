package org.cthulhu.azathoth.views.blockview;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.cthulhu.azathoth.MainView;
import org.cthulhu.azathoth.domains.Block;
import org.cthulhu.azathoth.domains.Slot;
import org.cthulhu.azathoth.repositories.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Route(value = "block", layout = MainView.class)
public class BlockView extends VerticalLayout implements HasUrlParameter<String> {

    private Map<String, List<String>> parametersMap;

    @Autowired private BlockRepository blockRepository;
    private Block foundedBlock;
    Optional<Block> block;

    public BlockView() {

        System.out.println("BlockView");

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
                SingleSlot ss = new SingleSlot();
                ss.setSlot(slot);
                row1.add(ss);
            } else if (slot.getLevel() == 2) {
                SingleSlot ss = new SingleSlot();
                ss.setSlot(slot);
                row2.add(ss);
            } else {
                System.out.println("Slot non appartenente al layout");
            }
        });

        add(row1, row2);

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

    }

    private void buildView() {

        System.out.println("Building Block View");

        if (parametersMap != null) {
            List<String> l = parametersMap.get("block");
            String block_id_s = l.get(0);
            System.out.println("Ricerco il blocco numero: " + block_id_s);
            Long block_id = Long.parseLong(block_id_s);
            block = blockRepository.findById(block_id);
        } else {
            System.out.println("ParamatersMap null");
            add(new Label("Parametri non riconosciuti"));
        }

        if (block.isPresent()) {
            System.out.println("Blocco esistente nel database");
            foundedBlock = block.get();
            System.out.println("Layout: " + foundedBlock.getLayout());
            if (foundedBlock.getLayout().equalsIgnoreCase("3x2")) {
                create3x2();
            } else {
                System.out.println("Questo blocco non ha un layout");
                add(new Label("Nessun Layout selezionato"));
            }
        } else {
            System.out.println("Questo blocco non esiste nel database");
            add(new Label("Non esiste il blocco nel database"));
        }

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String s) {

        System.out.println("Ricerco i parametri");
        Location location = beforeEvent.getLocation();
        QueryParameters queryParameters = location.getQueryParameters();
        parametersMap = queryParameters.getParameters();

        buildView();

    }

}
