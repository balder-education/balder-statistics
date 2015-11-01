package br.com.baldereducation.baldersatistics.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.com.baldereducation.baldersatistics.model.domain.Progression;
import br.com.baldereducation.baldersatistics.model.domain.Student;

/**
 * This repository provides CRUD operations for
 * {@link br.com.baldereducation.baldersatistics.model.domain.Progression} objects.
 * 
 * @author Rogério Fontes
 */
public interface ProgressionRepository extends Repository<Progression, String> {

    /**
     * Deletes a progression entry from the database.
     * 
     * @param deleted
     *            The deleted progression entry.
     */
    void delete(Progression deleted);

    /**
     * Finds all progression entries from the database.
     * 
     * @return The information of all progression entries that are found from the
     *         database.
     */
    List<Progression> findAll();

    /**
     * Finds the information of a single progression entry.
     * 
     * @param id
     *            The id of the requested progression entry.
     * @return The information of the found progression entry. If no progression entry is
     *         found, this method returns an empty {@link java.util.Optional}
     *         object.
     */
    Optional<Progression> findOne(String id);
    
    /**
     * Finds the information of a single progression entry.
     * 
     * @param user
     *            The id of the requested progression entry.
     * @return The information of the found progression entry. If no progression entry is
     *         found, this method returns an empty {@link java.util.Optional}
     *         object.
     */
    List<Progression> findByStudent(Student student);

    /**
     * Saves a new progression entry to the database.
     * 
     * @param saved
     *            The information of the saved progression entry.
     * @return The information of the saved progression entry.
     */
    Progression save(Progression saved);
}
