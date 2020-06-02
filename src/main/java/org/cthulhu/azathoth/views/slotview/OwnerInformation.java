package org.cthulhu.azathoth.views.slotview;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import org.cthulhu.azathoth.domains.Owner;

public class OwnerInformation extends FormLayout {

    private TextField surname = new TextField("Cognome");
    private TextField name = new TextField("Nome");
    private TextField contact = new TextField("Contatto");
    private TextArea notes = new TextArea("Note");

    private boolean writable = false;

    public OwnerInformation() {

        setWidth("90%");

        surname.setEnabled(writable);
        name.setEnabled(writable);
        contact.setEnabled(writable);
        notes.setEnabled(writable);

        Button modify = new Button("Modifica");
        modify.addClickListener(e -> {
            System.out.println("Modify button pushed");
        });

        add(surname, name, contact, notes);

    }

    public void setData(Owner owner) {

        surname.setValue(owner.getSurname());
        name.setValue(owner.getName());
        contact.setValue(owner.getContact());
        notes.setValue(owner.getNotes());

    }

    public void setEnable() {

        writable = true;

    }

    public void setDisable() {

        writable = false;

    }

}
