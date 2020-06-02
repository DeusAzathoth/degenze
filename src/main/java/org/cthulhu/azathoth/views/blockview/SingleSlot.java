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
    SlotRepository slotRepository;

    private Button enter;

    public SingleSlot(Slot slot) {

        System.out.println("Slot");

        Label petName = new Label(slot.getName());
        Label ownerName = new Label("Owner Name");
        Label contact = new Label("Contact details");

        Button enter = new Button("Enter");
        enter.getElement().setAttribute("aria-label", "Click me");
        enter.addClickListener(e -> {
            System.out.println("Enter button pushed");
            if (enter.getUI().isPresent()) {
                UI ui = enter.getUI().get();
                if (slot.isBusy()) {
                    Map<String, List<String>> parameters = new HashMap<>();
                    List<String> slotParameters = new ArrayList<>();
                    slotParameters.add(slot.getId().toString());
                    parameters.put("slot", slotParameters);
                    ui.navigate("slot", new QueryParameters(parameters));
                } else if (!slot.isReady()) {
                    slot.setReady(true);
                    slotRepository.save(slot);
                    getStyle().set("background-color", "grey");
                } else {
                    System.out.println("Effettua un ricovero");
                }

            }
        });

        add(petName, ownerName, contact, enter);

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        getStyle().set("border", "px solid #F0F0F0");

        if (slot.isBusy()) {
            System.out.println("Slot occupato");
            getStyle().set("background-color", "green");
        } else if (!slot.isReady()) {
            System.out.println("Slot non pronto");
            getStyle().set("background-color", "red");
            enter.setText("Pulisci");
        } else {
            System.out.println("Slot libero");
            getStyle().set("background-color", "grey");
            enter.setText("Ricovero");
        }

    }

}
