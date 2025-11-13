package com.example.zoomanagementass3.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Composite node representing a collection of enclosures.
 * @author Nelly
 */
public class CompositeEnclosureCollection implements EnclosureCollection {

    private final String compositeName;
    private final ObservableList<EnclosureCollection> children = FXCollections.observableArrayList();

    public CompositeEnclosureCollection(String name) {
        this.compositeName = name;
    }

    @Override
    public void addCollection(EnclosureCollection collection) {
        if (collection != null) {
            children.add(collection);
        }
    }

    @Override
    public ObservableList<EnclosureCollection> getCollections() {
        return children;
    }

    @Override
    public boolean isaComposite() {
        return true;
    }

    @Override
    public String getName() {
        return compositeName;
    }

    @Override
    public String toString() {
        return compositeName;
    }
}
