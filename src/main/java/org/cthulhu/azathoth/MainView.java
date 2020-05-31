package org.cthulhu.azathoth;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.*;
import org.cthulhu.azathoth.repositories.BlockRepository;
import org.cthulhu.azathoth.views.blockview.BlockView;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends AppLayout implements BeforeEnterObserver {

    private Tabs tabs = new Tabs();
    private Map<Class<? extends Component>, Tab> navigationTargetToTab = new HashMap<>();

    public MainView(@Autowired BlockRepository blockRepository) {

        System.out.println("MainView");

        // Add Tabs and Views
        blockRepository.findAll().forEach(block -> {
            addMenuTab(block.getName(), BlockView.class, block.getId());
        });
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);
        final boolean touchOptimized = true;
        addToNavbar(touchOptimized, new DrawerToggle());

    }

    private void addMenuTab(String label, Class<? extends Component> target, Long id) {

        RouterLink routerLink = new RouterLink(label, target);
        Map<String, List<String>> parameters = new HashMap<>();
        List<String> blockParameters = new ArrayList<>();
        blockParameters.add(id.toString());
        parameters.put("block", blockParameters);
        routerLink.setQueryParameters(new QueryParameters(parameters));
        Tab tab = new Tab(routerLink);
        navigationTargetToTab.put(target, tab);
        tabs.add(tab);

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {

        System.out.println("BeforeEnterEvent: " + beforeEnterEvent.getNavigationTarget().getName());
        tabs.setSelectedTab(navigationTargetToTab.get(beforeEnterEvent.getNavigationTarget()));

    }
}
