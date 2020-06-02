package org.cthulhu.azathoth.views.slotview;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.cthulhu.azathoth.domains.Pet;

public class PetInformation extends FormLayout {

    private TextField name = new TextField("Nome");
    private TextField species = new TextField("Specie");
    private TextField race = new TextField("Razza");
    private TextField age = new TextField("Età (anni)");
    private TextField sex = new TextField("Sesso");
    private Checkbox neutered = new Checkbox("Sterilizzato?");
    private TextField weight = new TextField("Peso (kg)");

    private boolean writable = false;

    public PetInformation() {

        setWidth("90%");

        name.setEnabled(writable);
        species.setEnabled(writable);
        race.setEnabled(writable);
        age.setEnabled(writable);
        sex.setEnabled(writable);
        neutered.setEnabled(writable);
        weight.setEnabled(writable);

        Button modify = new Button("Modifica");
        modify.addClickListener(e -> {
            System.out.println("Modify button pushed");
        });

        add(name, species, race, age, sex, neutered, weight, modify);

    }

    public void setData(Pet pet) {

        name.setValue(pet.getName());
        species.setValue(pet.getSpecies());
        race.setValue(pet.getRace());
        age.setValue(pet.getAge());
        sex.setValue(pet.getSex());
        neutered.setValue(pet.isNeutered());
        weight.setValue(Float.toString(pet.getWeight()));

    }

    public void setEnable() {

        writable = true;

    }

    public void setDisable() {

        writable = false;

    }

}
