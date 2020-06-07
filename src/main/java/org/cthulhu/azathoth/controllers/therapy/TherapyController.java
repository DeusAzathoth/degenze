package org.cthulhu.azathoth.controllers.therapy;

import org.cthulhu.azathoth.commons.Therapy_Costants;
import org.cthulhu.azathoth.domains.Action;
import org.cthulhu.azathoth.domains.Folder;
import org.cthulhu.azathoth.domains.Therapy;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TherapyController {

    private List<Action> listOfAvailableActions = new ArrayList<>();

    TherapyController() {}

    public List<Action> getAvailableTherapies(Folder folder) {

        System.out.println("Creating list of possible actions");

        System.out.println("Gathering of the therapies");
        List<Therapy> listOfTherapies = folder.getTherapies();
        System.out.println("Gathering of the actions");
        List<Action> listOfActions = folder.getActions();

        listOfAvailableActions = compareTherapiesActions(listOfTherapies, listOfActions);

        return listOfAvailableActions;
    }

    private List<Action> compareTherapiesActions(List<Therapy> listOfTherapies,
                                                 List<Action> listOfActions) {

        List<Action> undoneActions = new ArrayList<>();
        System.out.println("Comparing lists");
        for (Therapy therapy : listOfTherapies) {
            for (Action action : listOfActions) {
                LocalDateTime time = action.getTime();
                if (time.toLocalDate() == LocalDate.now()) {
                    System.out.println("Action made today");
                    if (therapy == action.getTherapy()) {
                        System.out.println("Action from therapy made today");
                        if (therapy.getFrequency() == Therapy_Costants.BID) {
                            System.out.println();
                        }
                    } else {
                        System.out.println("Action not made today");
                        undoneActions.add(new Action(therapy));
                    }
                }
            }
        }
        return undoneActions;
    }

}
