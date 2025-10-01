
package com.example.notes.repository;

import com.example.notes.entity.Description;
import org.springframework.data.jpa.repository.JpaRepository;

/** To provide CRUD operation methods. */
public interface DescriptionRepo extends JpaRepository<Description, Long> {

}
