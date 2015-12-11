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
import br.com.baldereducation.baldersatistics.model.domain.to.StundentDTO;
import br.com.baldereducation.baldersatistics.service.StudentService;

/**
 * This controller provides the public API that is used to manage the
 * information of student entries.
 * 
 * @author Rogério Fontes
 */
@RestController
@RequestMapping("/api/stundents")
final class StundentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StundentController.class);

    @Autowired
    private StudentService service;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    StundentDTO create(@RequestBody @Valid StundentDTO studentEntry) {
        LOGGER.info("Creating a new student entry with information: {}", studentEntry);

        StundentDTO created = service.create(studentEntry);
        LOGGER.info("Created a new student entry with information: {}", created);

        return created;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    StundentDTO delete(@PathVariable("id") String id) {
        LOGGER.info("Deleting student entry with id: {}", id);

        StundentDTO deleted = service.delete(id);
        LOGGER.info("Deleted student entry with information: {}", deleted);

        return deleted;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<StundentDTO> findAll() {
        LOGGER.info("Finding all student entries");

        List<StundentDTO> studentEntries = service.findAll();
        LOGGER.info("Found {} student entries", studentEntries.size());

        return studentEntries;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    StundentDTO findById(@PathVariable("id") String id) {
        LOGGER.info("Finding student entry with id: {}", id);

        StundentDTO studentEntry = service.findById(id);
        LOGGER.info("Found student entry with information: {}", studentEntry);

        return studentEntry;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    StundentDTO update(@RequestBody @Valid StundentDTO studentEntry) {
        LOGGER.info("Updating student entry with information: {}", studentEntry);

        StundentDTO updated = service.update(studentEntry);
        LOGGER.info("Updated student entry with information: {}", updated);

        return updated;
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/{studentId}/lesson/{lessonId}/complete")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void finished(@PathVariable("studentId") Long studentId, @PathVariable("lessonId") Long lessonId) {
    	service.finished(studentId, lessonId);
	}

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleStudentNotFound(StudentNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}
