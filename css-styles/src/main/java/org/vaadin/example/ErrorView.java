/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.Route;
import javax.annotation.security.PermitAll;

/**
 *
 * @author NCI Admin
 */
@Route("error")
@PermitAll
public class ErrorView extends VerticalLayout {

    H1 h1Errors = new H1();

    Button btnGoHome = new Button("Go Home");
    
    
    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     */
    public ErrorView() {
        super();
        btnGoHome.addClickListener(e -> {
            btnGoHome.getUI().ifPresent(ui -> {
                ui.navigate("");
            });
        });
        
        add(h1Errors, btnGoHome);
    }
    
}
