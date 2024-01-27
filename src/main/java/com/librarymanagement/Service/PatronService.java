package com.librarymanagement.Service;

import com.librarymanagement.Repository.PatronRepository;
import com.librarymanagement.model.Patron;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

    @Transactional(readOnly = true)
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Patron getPatronById(Long patronId) {
        return patronRepository.findById(patronId)
                .orElseThrow(() -> new EntityNotFoundException("Patron not found with id: " + patronId));
    }

    @Transactional
    public Patron addPatron(Patron patron) {
        // Additional logic if needed before saving
        return patronRepository.save(patron);
    }

    @Transactional
    public Patron updatePatron(Long patronId, Patron updatedPatron) {
        Patron existingPatron = getPatronById(patronId);
        // Update existingPatron fields with updatedPatron fields
        // Save the updatedPatron
        patronRepository.save(existingPatron);
        return existingPatron;
    }

    @Transactional
    public void deletePatron(Long patronId) {
        Patron existingPatron = getPatronById(patronId);
        patronRepository.delete(existingPatron);
    }
}
