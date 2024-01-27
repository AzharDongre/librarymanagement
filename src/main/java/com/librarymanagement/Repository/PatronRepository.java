package com.librarymanagement.Repository;

import com.librarymanagement.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron,Long> {
}
