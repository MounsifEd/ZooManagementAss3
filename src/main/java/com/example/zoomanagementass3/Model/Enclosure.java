package com.example.zoomanagementass3.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;
import java.util.Optional;

public class Enclosure implements  EnclosureCollection {
    private final String name;
    private final ObservableList<Animal> animals = FXCollections.observableArrayList();

    public Enclosure(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Enclosure name must not be empty");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public ObservableList<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        Objects.requireNonNull(animal, "animal");
        // Prevent duplicate names within the same enclosure for the same species
        if (findAnimalByName(animal.getName()).isPresent()) {
            throw new IllegalArgumentException("Animal with the same name already exists in this enclosure");
        }
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public Optional<Animal> findAnimalByName(String name) {
        if (name == null)
            return Optional.empty();
        String target = name.trim();
        return animals.stream().filter(a -> a.getName().equalsIgnoreCase(target)).findFirst();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void addCollection(EnclosureCollection collection) {

    }
}
