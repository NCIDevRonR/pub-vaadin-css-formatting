package org.vaadin.example;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.data.renderer.ComponentRenderer;

import java.util.List;

@Route
@CssImport("./styles/styles.css")
public class MainView extends VerticalLayout {

    public MainView() {
        Grid<Person> grid = new Grid<>(Person.class);
        grid.setItems(getPeople());

        Label lblHiya = new Label("What's going on, folks?");
        grid.setItemDetailsRenderer(new ComponentRenderer<>(person -> {
            Span span = new Span(person.getName());
            if (person.getName().equalsIgnoreCase("John Doe")) {
                span.addClassName("blue-background-row");
            }
            return span;
        }));
        lblHiya.addClassName("red-bold-text");

        add(grid, lblHiya);
    }

    private List<Person> getPeople() {
        return List.of(
                new Person("John Doe", 30),
                new Person("Jane Doe", 25)
        );
    }

    public static class Person {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
