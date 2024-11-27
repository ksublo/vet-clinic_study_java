package com.vetclinic.blo0021.controller;

import com.vetclinic.blo0021.model.Illness;
import com.vetclinic.blo0021.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/illnesses")
public class IllnessController {

    @Autowired
    private IllnessService illnessService;

    @GetMapping
    public List<Illness> getAllIllnesses() {
        return illnessService.getAllIllnesses();
    }

    @PostMapping
    public Illness addIllness(@RequestBody Illness illness) {
        return illnessService.saveIllness(illness);
    }

    @GetMapping("/{illnessID}")
    public Illness getIllnessById(@PathVariable Long illnessID) {
        return illnessService.getIllnessById(illnessID);
    }

    @PutMapping("/{illnessID}")
    public Illness updateIllness(@PathVariable Long illnessID, @RequestBody Illness updatedIllness) {
        return illnessService.updateIllness(illnessID, updatedIllness);
    }

    @DeleteMapping("/{illnessID}")
    public void deleteIllness(@PathVariable Long illnessID) {
        illnessService.deleteIllness(illnessID);
    }
}
