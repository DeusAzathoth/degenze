package org.cthulhu.azathoth.views.blockview;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.QueryParameters;
import org.cthulhu.azathoth.domains.Slot;
import org.cthulhu.azathoth.repositories.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleSlot extends VerticalLayout {

    @Autowired
    private SlotRepository slotRepository;
    private Slot slot;

    private Label petName;
    private Label ownerName;
    private Label contact;
    private Button enter;

    public SingleSlot() {

        System.out.println("Slot");

        petName = new Label();
        ownerName = new Label();
        contact = new Label();

        enter = new Button("Enter");
        enter.getElement().setAttribute("aria-label", "Click me");

        add(petName, ownerName, contact, enter);

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        getStyle().set("border", "px solid #555555");

    }

    public void setSlot(Slot slot) {

        this.slot = slot;

        if (this.slot.isBusy()) {
            System.out.println("Slot occupato");
            petName.setText(slot.getPet().getName());
            ownerName.setText(slot.getPet().getOwner().getName() +
                    " " + slot.getPet().getOwner().getSurname());
            contact.setText(slot.getPet().getOwner().getContact());
            getStyle().set("background-color", "green");
            enter.addClickListener(e -> {
                System.out.println("Enter button pushed");
                if (enter.getUI().isPresent()) {
                    UI ui = enter.getUI().get();
                    Map<String, List<String>> parameters = new HashMap<>();
                    List<String> slotParameters = new ArrayList<>();
                    slotParameters.add(slot.getId().toString());
                    parameters.put("slot", slotParameters);
                    ui.navigate("slot", new QueryParameters(parameters));
                }
            });
        } else if (!this.slot.isReady()) {
            System.out.println("Slot non pronto");
            petName.setText("...");
            ownerName.setText("...");
            contact.setText("...");
            getStyle().set("background-color", "red");
            enter.setText("Pulisci");
            enter.addClickListener(e -> {
                System.out.println("Enter button pushed");
                if (enter.getUI().isPresent()) {
                    UI ui = enter.getUI().get();
                    slot.setReady(true);
                    slotRepository.save(slot);
                    getStyle().set("background-color", "grey");
                }
            });
        } else {
            System.out.println("Slot libero");
            getStyle().set("background-color", "grey");
            enter.setText("Ricovero");
            enter.addClickListener(e -> {
                System.out.println("Enter button pushed");
                if (enter.getUI().isPresent()) {
                    UI ui = enter.getUI().get();
                    slot.setReady(true);
                    slotRepository.save(slot);
                    getStyle().set("background-color", "grey");
                }
            });
        }

    }

}
