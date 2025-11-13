package com.example.zoomanagementass3.Model;

import javafx.collections.ObservableList;

/**
 * Represents component in the structure.
 * @Author Mounsif
 */
public interface EnclosureCollection {
    void addCollection(EnclosureCollection collection);
    ObservableList<EnclosureCollection> getCollections();
    String getName();
    boolean isaComposite();
}
