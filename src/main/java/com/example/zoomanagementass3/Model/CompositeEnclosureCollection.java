package com.example.zoomanagementass3.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CompositeEnclosureCollection implements EnclosureCollection {

    private final String aName;
    private final ObservableList<EnclosureCollection> aEnclosures = FXCollections.observableArrayList();

    public CompositeEnclosureCollection(String pName) {

        this.aName = pName.trim();
    }

    @Override
    public void addCollection(EnclosureCollection collection) {
        aEnclosures.add(collection);
    }

    public ObservableList<Enclosure> getEnclosures() {

        return aEnclosures;
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
