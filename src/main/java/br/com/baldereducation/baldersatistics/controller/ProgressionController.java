package br.com.baldereducation.baldersatistics.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.baldereducation.baldersatistics.exception.StudentNotFoundException;
import br.com.baldereducation.baldersatistics.model.domain.to.ProgressionDTO;
import br.com.baldereducation.baldersatistics.service.ProgressionService;

/**
 * This controller provides the public API that is used to manage the
 * information of progression entries.
 * 
 * @author Rogério Fontes
 */
@RestController
@RequestMapping("/api/progressions")
final class ProgressionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProgressionController.class);

    @Autowired
    private ProgressionService service;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ProgressionDTO create(@RequestBody @Valid ProgressionDTO progressionEntry) {
        LOGGER.info("Creating a new progression entry with information: {}", progressionEntry);

        ProgressionDTO created = service.create(progressionEntry);
        LOGGER.info("Created a new progression entry with information: {}", created);

        return created;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    ProgressionDTO delete(@PathVariable("id") String id) {
        LOGGER.info("Deleting progression entry with id: {}", id);

        ProgressionDTO deleted = service.delete(id);
        LOGGER.info("Deleted progression entry with information: {}", deleted);

        return deleted;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<ProgressionDTO> findAll() {
        LOGGER.info("Finding all progression entries");

        List<ProgressionDTO> progressionEntries = service.findAll();
        LOGGER.info("Found {} progression entries", progressionEntries.size());

        return progressionEntries;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ProgressionDTO findById(@PathVariable("id") String id) {
        LOGGER.info("Finding progression entry with id: {}", id);

        ProgressionDTO progressionEntry = service.findById(id);
        LOGGER.info("Found progression entry with information: {}", progressionEntry);

        return progressionEntry;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    ProgressionDTO update(@RequestBody @Valid ProgressionDTO progressionEntry) {
        LOGGER.info("Updating progression entry with information: {}", progressionEntry);

        ProgressionDTO updated = service.update(progressionEntry);
        return updated;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleStudentNotFound(StudentNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}
