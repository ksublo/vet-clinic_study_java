package com.vetclinic.blo0021.service;

import com.vetclinic.blo0021.model.Pet;
import com.vetclinic.blo0021.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    // Fetch all pets
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    // Add a new pet
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    // Get a pet by ID
    public Pet getPetById(int petID) {
        return petRepository.findById(petID)
                .orElseThrow(() -> new RuntimeException("Pet not found!"));
    }

    // Update a pet's details
    public Pet updatePet(int petID, Pet updatedPet) {
        Pet existingPet = getPetById(petID);
        existingPet.setName(updatedPet.getName());
        existingPet.setSpecies(updatedPet.getSpecies());
        existingPet.setBreed(updatedPet.getBreed());
        existingPet.setAge(updatedPet.getAge());
        existingPet.setSex(updatedPet.getSex());
        existingPet.setWeight(updatedPet.getWeight());
        existingPet.setHost(updatedPet.getHost());
        return petRepository.save(existingPet);
    }

    // Delete a pet by ID
    public void deletePet(int petID) {
        petRepository.deleteById(petID);
    }
}
