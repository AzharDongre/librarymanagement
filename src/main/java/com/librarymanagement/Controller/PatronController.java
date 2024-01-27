package com.librarymanagement.Controller;

import com.librarymanagement.Service.PatronService;
import com.librarymanagement.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public Patron getPatronById(@PathVariable Long id) {
        return patronService.getPatronById(id);
    }

    @PostMapping
    public ResponseEntity<Patron> addPatron(@RequestBody Patron patron) {
        //validation

        if (patron.getName() == null || patron.getContact() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name and contact information must be provided for adding a patron");
        }

        Patron addedPatron = patronService.addPatron(patron);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedPatron);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @RequestBody Patron updatedPatron) {
        if (updatedPatron.getName() == null || updatedPatron.getContact() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name and contact information must be provided for updating a patron");
        }

        Patron updated = patronService.updatePatron(id, updatedPatron);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patron not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
    }
}
