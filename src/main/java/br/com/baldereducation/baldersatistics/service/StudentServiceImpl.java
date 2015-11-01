package br.com.baldereducation.baldersatistics.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baldereducation.baldersatistics.exception.StudentNotFoundException;
import br.com.baldereducation.baldersatistics.model.domain.Student;
import br.com.baldereducation.baldersatistics.model.domain.to.StundentDTO;
import br.com.baldereducation.baldersatistics.model.repository.StudentRepository;

/**
 * This service class saves
 * {@link br.com.baldereducation.baldersatistics.model.domain.Student} objects
 * to MongoDB database.
 * 
 * @author Rogério Fontes
 */
@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepository repository;

	@Override
	public StundentDTO create(StundentDTO studentDTO) {
		LOGGER.info("Creating a new todo entry with information: {}", studentDTO);
		
		Student persisted = new Student.StudentBuilder(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getCode()).build();
		
		persisted = repository.save(persisted);
		LOGGER.info("Created a new todo entry with information: {}", persisted);

		return convertToDTO(persisted);
	}

	@Override
	public StundentDTO delete(String id) {
		LOGGER.info("Deleting a todo entry with id: {}", id);

		Student deleted = findStudentById(id);
		repository.delete(deleted);

		LOGGER.info("Deleted todo entry with informtation: {}", deleted);

		return convertToDTO(deleted);
	}

	@Override
	public List<StundentDTO> findAll() {
		LOGGER.info("Finding all todo entries.");

		List<Student> todoEntries = repository.findAll();

		LOGGER.info("Found {} todo entries", todoEntries.size());

		return convertToDTOs(todoEntries);
	}

	private List<StundentDTO> convertToDTOs(List<Student> models) {
		return models.stream().map(this::convertToDTO).collect(toList());
	}

	@Override
	public StundentDTO findById(String id) {
		LOGGER.info("Finding todo entry with id: {}", id);

		Student found = findStudentById(id);

		LOGGER.info("Found todo entry: {}", found);

		return convertToDTO(found);
	}

	@Override
	public StundentDTO update(StundentDTO studentDTO) {
		LOGGER.info("Updating todo entry with information: {}", studentDTO);

		Student updated = findStudentById(studentDTO.getId());
		// updated.update(studentDTO.getName(), studentDTO.getEmail());
		updated = repository.save(updated);

		LOGGER.info("Updated todo entry with information: {}", updated);

		return convertToDTO(updated);
	}

	private Student findStudentById(String id) {
		Optional<Student> result = repository.findOne(id);
		return result.orElseThrow(() -> new StudentNotFoundException(id));

	}
	

	private StundentDTO convertToDTO(Student model) {
		StundentDTO dto = new StundentDTO();

		dto.setId(model.getId());
		dto.setEmail(model.getEmail());
		dto.setName(model.getName());

		return dto;
	}
}
