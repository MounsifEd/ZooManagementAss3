package com.example.zoomanagementass3.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Ian
 */

public class Enclosure implements EnclosureCollection {

    private final String name;
    private final ObservableList<Animal> animals = FXCollections.observableArrayList();

    public Enclosure(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Enclosure name required");
        this.name = name.trim();
    }

    @Override
    public String getName() { return name; }

    @Override
    public boolean isaComposite() { return false; }

    public ObservableList<Animal> getAnimals() { return animals; }

    public void addAnimal(Animal animal) {
        Objects.requireNonNull(animal, "animal");
        if (findAnimalByName(animal.getName()).isPresent()) {
            throw new IllegalArgumentException("Duplicate animal name");
        }
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) { animals.remove(animal); }

    public Optional<Animal> findAnimalByName(String name) {
        if (name == null) return Optional.empty();
        String target = name.trim();
        return animals.stream().filter(a -> a.getName().equalsIgnoreCase(target)).findFirst();
    }

    @Override
    public void addCollection(EnclosureCollection collection) {
        // leaf — no-op
    }

    @Override
    public javafx.collections.ObservableList<EnclosureCollection> getCollections() {
        return FXCollections.observableArrayList();
    }

    @Override
    public List<EnclosureCollection> getEnclosures() {
        return List.of(this);
    }

    @Override
    public String toString() { return name; }
}
