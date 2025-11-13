package com.example.zoomanagementass3.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class that contains enclosures.
 * The composite Class in the Composite Pattern
 * @author Mounsif
 */
public class CompositeEnclosureCollection implements EnclosureCollection {

    private final String aName;
    private final ObservableList<EnclosureCollection> aComponent = FXCollections.observableArrayList();

    public CompositeEnclosureCollection(String pName) {
        this.aName = pName;
    }

    @Override
    public void addCollection(EnclosureCollection collection) {
        aComponent.add(collection);
    }

    public ObservableList<EnclosureCollection> getaComponent() {
        return aComponent;
    }

    @Override
    public String getName() {
        return aName;
    }

    @Override
    public String toString() {
        return aName;
    }

}
