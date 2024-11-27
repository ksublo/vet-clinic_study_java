package com.vetclinic.blo0021.controller;

import com.vetclinic.blo0021.model.Medicine;
import com.vetclinic.blo0021.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineService.saveMedicine(medicine);
    }

    @GetMapping("/{medicineID}")
    public Medicine getMedicineById(@PathVariable Long medicineID) {
        return medicineService.getMedicineById(medicineID);
    }

    @PutMapping("/{medicineID}")
    public Medicine updateMedicine(@PathVariable Long medicineID, @RequestBody Medicine updatedMedicine) {
        return medicineService.updateMedicine(medicineID, updatedMedicine);
    }

    @DeleteMapping("/{medicineID}")
    public void deleteMedicine(@PathVariable Long medicineID) {
        medicineService.deleteMedicine(medicineID);
    }
}
