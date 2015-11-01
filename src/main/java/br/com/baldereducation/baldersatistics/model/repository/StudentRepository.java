package br.com.baldereducation.baldersatistics.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.com.baldereducation.baldersatistics.model.domain.Student;

/**
 * This repository provides CRUD operations for
 * {@link br.com.baldereducation.baldersatistics.model.domain.Student} objects.
 * 
 * @author Rogério Fontes
 */
public interface StudentRepository extends Repository<Student, String> {

    /**
     * Deletes a student entry from the database.
     * 
     * @param deleted
     *            The deleted student entry.
     */
    void delete(Student deleted);

    /**
     * Finds all student entries from the database.
     * 
     * @return The information of all student entries that are found from the
     *         database.
     */
    List<Student> findAll();

    /**
     * Finds the information of a single student entry.
     * 
     * @param id
     *            The id of the requested student entry.
     * @return The information of the found student entry. If no student entry is
     *         found, this method returns an empty {@link java.util.Optional}
     *         object.
     */
    Optional<Student> findOne(String id);
    
    /**
     * Finds the information of a single student entry.
     * 
     * @param code
     *            The id of the requested student entry.
     * @return The information of the found student entry. If no student entry is
     *         found, this method returns an empty {@link java.util.Optional}
     *         object.
     */
    Student findByCode(String code);

    /**
     * Saves a new student entry to the database.
     * 
     * @param saved
     *            The information of the saved student entry.
     * @return The information of the saved student entry.
     */
    Student save(Student saved);
}
