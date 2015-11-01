package br.com.baldereducation.baldersatistics.service;

import java.util.List;

import br.com.baldereducation.baldersatistics.model.domain.to.ProgressionDTO;

/**
 * This interface declares the methods that provides CRUD operations for
 * {@link br.com.baldereducation.baldersatistics.model.domain.Student} objects.
 * 
 * @author Rogério Fontes
 */
public interface ProgressionService {

    /**
     * Creates a new todo entry.
     * 
     * @param progressionDTO
     *            The information of the created todo entry.
     * @return The information of the created todo entry.
     */
    ProgressionDTO create(ProgressionDTO progressionDTO);

    /**
     * Deletes a todo entry.
     * 
     * @param id
     *            The id of the deleted todo entry.
     * @return THe information of the deleted todo entry.
     * @throws br.com.baldereducation.baldersatistics.exception.StudentNotFoundException
     *             if no todo entry is found.
     */
    ProgressionDTO delete(String id);

    /**
     * Finds all todo entries.
     * 
     * @return The information of all todo entries.
     */
    List<ProgressionDTO> findAll();

    /**
     * Finds a single todo entry.
     * 
     * @param id
     *            The id of the requested todo entry.
     * @return The information of the requested todo entry.
     * @throws br.com.baldereducation.baldersatistics.exception.StudentNotFoundException
     *             if no todo entry is found.
     */
    ProgressionDTO findById(String id);

    /**
     * Updates the information of a todo entry.
     * 
     * @param progressionDTO
     *            The information of the updated todo entry.
     * @return The information of the updated todo entry.
     * @throws br.com.baldereducation.baldersatistics.exception.StudentNotFoundException
     *             if no todo entry is found.
     */
    ProgressionDTO update(ProgressionDTO progressionDTO);
}
