package com.librarymanagement.Service;

import com.librarymanagement.Repository.PatronRepository;
import com.librarymanagement.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronServiceImpl extends PatronService {
    @Autowired
    private PatronRepository patronRepository;

    @Override
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @Override
    public Patron getPatronById(Long id) {
        return patronRepository.findById(id).orElse(null);
    }

    @Override
    public Patron addPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    @Override
    public Patron updatePatron(Long id, Patron updatedPatron) {
        Patron existingPatron = patronRepository.findById(id).orElse(null);
        if (existingPatron != null) {
            existingPatron.setName(updatedPatron.getName());
            existingPatron.setContact(updatedPatron.getContact());


            return patronRepository.save(existingPatron);
        }
        return null; // Handle not found scenario
    }

    @Override
    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
