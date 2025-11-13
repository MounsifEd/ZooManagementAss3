package com.example.zoomanagementass3.Model;


import javafx.collections.ObservableList;

/**
 * Class that contains enclosures.
 * The composite Class in the Composite Pattern
 * @author Mounsif
 */
public class CompositeEnclosureCollection implements EnclosureCollection {

    private final String Name;
    private ObservableList<EnclosureCollection> collections;

    public CompositeEnclosureCollection(String Name, ObservableList<EnclosureCollection> collections) {
        this.Name = Name;
        this.collections = collections;
    }

    public CompositeEnclosureCollection(String bigCats, String name) {
        Name = name;
    }

    public CompositeEnclosureCollection(String bigCats) {
        Name = bigCats;
    }


    @Override
    public void addCollection(EnclosureCollection collection) {
        this.collections.add(collection);
    }

    @Override
    public ObservableList<EnclosureCollection> getCollections() {
        return this.collections;
    }

    @Override
    public boolean isaComposite() {
        return true;
    }

    @Override
    public String getName() {
        return "";
    }

}

