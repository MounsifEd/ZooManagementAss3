package com.example.zoomanagementass3.Model;

import javafx.collections.ObservableList;

/**
 * Represents the common interface for both leaf ({@link Enclosure})
 * and composite ({@link CompositeEnclosureCollection}) zoo elements.
 *
 * <p>Part of the Composite Design Pattern.</p>
 */
public interface EnclosureCollection {

    /**
     * Returns the name of this enclosure or collection.
     *
     * @return the name
     */
    String getName();

    /**
     * Indicates whether this is a composite (contains other collections)
     * or a leaf node.
     *
     * @return {@code true} if composite, {@code false} otherwise
     */
    default boolean isaComposite() {
        return false;
    }

    /**
     * Adds a child collection (only supported by composites).
     *
     * @param collection the collection to add
     */
    void addCollection(EnclosureCollection collection);

    /**
     * Returns a list of child collections.
     * For leaf nodes, this returns an empty list or {@code null}.
     *
     * @return observable list of child collections
     */
    ObservableList<EnclosureCollection> getCollections();
}
