package com.vetclinic.blo0021.service;

import com.vetclinic.blo0021.model.Illness;
import com.vetclinic.blo0021.repository.IllnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessService {

    @Autowired
    private IllnessRepository illnessRepository;

    public List<Illness> getAllIllnesses() {
        return illnessRepository.findAll();
    }

    public Illness saveIllness(Illness illness) {
        return illnessRepository.save(illness);
    }

    public Illness getIllnessById(Long illnessID) {
        return illnessRepository.findById(illnessID)
                .orElseThrow(() -> new RuntimeException("Illness not found!"));
    }

    public Illness updateIllness(Long illnessID, Illness updatedIllness) {
        Illness illness = getIllnessById(illnessID);
        illness.setName(updatedIllness.getName());
        illness.setDescription(updatedIllness.getDescription());
        return illnessRepository.save(illness);
    }

    public void deleteIllness(Long illnessID) {
        illnessRepository.deleteById(illnessID);
    }
}
