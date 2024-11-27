package com.vetclinic.blo0021.service;

import com.vetclinic.blo0021.model.Medicine;
import com.vetclinic.blo0021.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public Medicine getMedicineById(Long medicineID) {
        return medicineRepository.findById(medicineID)
                .orElseThrow(() -> new RuntimeException("Medicine not found!"));
    }

    public Medicine updateMedicine(Long medicineID, Medicine updatedMedicine) {
        Medicine medicine = getMedicineById(medicineID);
        medicine.setName(updatedMedicine.getName());
        medicine.setDescription(updatedMedicine.getDescription());
        return medicineRepository.save(medicine);
    }

    public void deleteMedicine(Long medicineID) {
        medicineRepository.deleteById(medicineID);
    }
}
