package org.cthulhu.azathoth.views.blockview;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.cthulhu.azathoth.domains.Slot;

public class SingleSlot extends VerticalLayout {

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
                //ui.navigate(org.cthulhu.azathoth.views.slotview.SlotView.class, "block=1&slot=1");
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
        }

    }

}
