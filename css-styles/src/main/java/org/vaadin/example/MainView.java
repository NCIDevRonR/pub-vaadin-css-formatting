package org.vaadin.example;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route
@CssImport(
        themeFor = "vaadin-grid",
        value = "./styles/styles.css"
)
@CssImport("./styles/styles.css")
public class MainView extends VerticalLayout {

    public MainView() {
        Grid<Person> grid = new Grid<>(Person.class);
        grid.setItems(getPeople());

        Label lblHiya = new Label("What's going on, folks?");
        lblHiya.addClassName("red-bold-text");

        add(grid, lblHiya);
        grid.setClassNameGenerator(person -> person.getName().equalsIgnoreCase("John Doe") ? "blue-background-row" : null);
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
