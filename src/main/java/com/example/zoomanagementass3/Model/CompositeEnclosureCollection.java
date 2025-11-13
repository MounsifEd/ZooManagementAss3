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
    private final ObservableList<EnclosureCollection> aComponent;

    @Override
    public void addCollection(EnclosureCollection collection) {
        aComponent.add(collection);
    }

    private final ObservableList<EnclosureCollection> aCollection;

    public CompositeEnclosureCollection(String pName) {
        this.aCollection = FXCollections.observableArrayList();
        this.aName = pName;
    }

    public void addCollection(EnclosureCollection collection) {
        aCollection.add(collection);
    }

    @Override
    public ObservableList<EnclosureCollection> getaComponent() {
        return aComponent;
    }

    @Override
    public boolean CompositeEnclosure() {
        return true;
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

