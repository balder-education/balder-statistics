package br.com.baldereducation.baldersatistics.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.baldereducation.baldersatistics.exception.StudentNotFoundException;
import br.com.baldereducation.baldersatistics.service.StatiticService;

@RestController
@RequestMapping("/api/statistics")
public class StatisticController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StundentController.class);

    @Autowired
    private StatiticService service;
   
    @RequestMapping(value = "/total-media-age-student", method = RequestMethod.GET)
    public long findAllMeanAgeStudent() {
        LOGGER.info("Finding maen age studend entries");
        long meanAge = service.meanAge();
        LOGGER.info("Found {} student entries", meanAge);

        return meanAge;
    }
    
    @RequestMapping(value = "/total-male-student", method = RequestMethod.GET)
    public long findAllMaleStudent() {
        LOGGER.info("Finding all male student entries");
        long resultAllMaleStudents = service.findAllMaleStudents();
        LOGGER.info("Found {} male student entries", resultAllMaleStudents);
        return resultAllMaleStudents;
    }
    
    @RequestMapping(value = "/total-female-student", method = RequestMethod.GET)
    public long findAllFemaleStudent() {
        LOGGER.info("Finding all female student entries");
        long resultAllFemaleStudents = service.findAllFemaleStudents();
        LOGGER.info("Found {} female student entries", resultAllFemaleStudents);
        return resultAllFemaleStudents;
    }
    
    @RequestMapping(value = "/bad-progression-student", method = RequestMethod.GET)
    public long badProgression() {
        LOGGER.info("Finding all male student entries");
        long resultBadProgressionStudents = service.totalStudents();
        LOGGER.info("Found {} male student entries", resultBadProgressionStudents);
        return resultBadProgressionStudents;
    }
   
    @RequestMapping(value = "/good-progression-student", method = RequestMethod.GET)
    public long goodProgression() {
        LOGGER.info("Finding all male student entries");
        long resultGoodProgressionStudents = service.totalStudents();
        LOGGER.info("Found {} male student entries", resultGoodProgressionStudents);
        return resultGoodProgressionStudents;
    }
   
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleStudentNotFound(StudentNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}
