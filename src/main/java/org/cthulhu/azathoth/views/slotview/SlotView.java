package org.cthulhu.azathoth.views.slotview;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.*;
import org.cthulhu.azathoth.MainView;
import org.cthulhu.azathoth.controllers.therapy.TherapyController;
import org.cthulhu.azathoth.domains.Owner;
import org.cthulhu.azathoth.domains.Pet;
import org.cthulhu.azathoth.domains.Slot;
import org.cthulhu.azathoth.repositories.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Route(value = "slot", layout = MainView.class)
public class SlotView extends HorizontalLayout implements HasUrlParameter<String> {

    private Map<String, List<String>> parametersMap;

    @Autowired private SlotRepository slotRepository;
    private Optional<Slot> slot;
    private Slot foundedSlot;

    private PetInformation petInformation = new PetInformation();
    private OwnerInformation ownerInformation = new OwnerInformation();

    private TherapyController therapyController;

    public SlotView() {

        System.out.println("SlotView");

        setWidth("80%");

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String s) {

        System.out.println("Ricerco i parametri");
        Location location = beforeEvent.getLocation();
        QueryParameters queryParameters = location.getQueryParameters();
        parametersMap = queryParameters.getParameters();

        buildView();

    }

    private void buildView() {

        System.out.println("Building SlotView");

        //Accordion accordion = new Accordion();
        VerticalLayout infoCol = new VerticalLayout();

        if (parametersMap != null) {
            List<String> l = parametersMap.get("slot");
            String block_id_s = l.get(0);
            System.out.println("Ricerco lo slot numero: " + block_id_s);
            Long block_id = Long.parseLong(block_id_s);
            slot = slotRepository.findById(block_id);
        } else {
            System.out.println("ParamatersMap null");
            add(new Label("Parametri non riconosciuti"));
        }

        if (slot.isPresent()) {
            System.out.println("Slot trovato");

            foundedSlot = slot.get();

            Pet pet = foundedSlot.getPet();
            petInformation.setData(pet);
            petInformation.setDisable();
            Details petInfo = new Details(pet.getName(), petInformation);
            petInfo.addThemeVariants(DetailsVariant.SMALL,
                    DetailsVariant.REVERSE,
                    DetailsVariant.REVERSE);
            //accordion.add("Paziente", petInformation);

            Owner owner = foundedSlot.getPet().getOwner();
            ownerInformation.setData(owner);
            ownerInformation.setDisable();
            Details ownerInfo = new Details(pet.getOwner().getSurname(), ownerInformation);
            ownerInfo.addThemeVariants(DetailsVariant.SMALL,
                    DetailsVariant.REVERSE,
                    DetailsVariant.REVERSE);
            //accordion.add("Proprietario", ownerInformation);

            TextArea petNotes = new TextArea("Note");
            petNotes.setPlaceholder("Note sul paziente...");
            petNotes.setEnabled(false);

            infoCol.add(petInfo, ownerInfo, petNotes);

            VerticalLayout recovery = new VerticalLayout();
            Button goToRecovery = new Button("Ricovero");
            goToRecovery.addClickListener(e -> {
                System.out.println("GoToRecovery button pushed");
                if (goToRecovery.getUI().isPresent()) {
                    UI ui = goToRecovery.getUI().get();
                    //ui.navigate(RecoveryView.class, "block=1&slot=1");
                }
            });
            recovery.add(goToRecovery);

            add(infoCol, recovery);
        } else {
            System.out.println("Slot non trovato");
            add(new Label("Nessun dato relativo a questo slot"));
        }

    }

}
