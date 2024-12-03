package com.vetclinic.blo0021.repository;

import com.vetclinic.blo0021.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
