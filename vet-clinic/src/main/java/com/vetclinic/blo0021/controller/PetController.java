package com.vetclinic.blo0021.controller;

import com.vetclinic.blo0021.model.Pet;
import com.vetclinic.blo0021.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    // Fetch all pets
    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    // Add a new pet
    @PostMapping
    public Pet addPet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }

    // Get a pet by ID
    @GetMapping("/{petID}")
    public Pet getPetById(@PathVariable Long petID) {
        return petService.getPetById(petID);
    }

    // Update a pet's details
    @PutMapping("/{petID}")
    public Pet updatePet(@PathVariable Long petID, @RequestBody Pet updatedPet) {
        return petService.updatePet(petID, updatedPet);
    }

    // Delete a pet
    @DeleteMapping("/{petID}")
    public void deletePet(@PathVariable Long petID) {
        petService.deletePet(petID);
    }
}
