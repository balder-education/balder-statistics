package br.com.baldereducation.baldersatistics.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baldereducation.baldersatistics.exception.StudentNotFoundException;
import br.com.baldereducation.baldersatistics.model.domain.Progression;
import br.com.baldereducation.baldersatistics.model.domain.Student;
import br.com.baldereducation.baldersatistics.model.domain.to.ProgressionDTO;
import br.com.baldereducation.baldersatistics.model.repository.ProgressionRepository;
import br.com.baldereducation.baldersatistics.model.repository.StudentRepository;

/**
 * This service class saves
 * {@link br.com.baldereducation.baldersatistics.model.domain.Student} objects
 * to MongoDB database.
 * 
 * @author Rogério Fontes
 */
@Service
public class ProgressionServiceImpl implements ProgressionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProgressionServiceImpl.class);

	@Autowired
	private ProgressionRepository repository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public ProgressionDTO create(ProgressionDTO progressionDTO) {
		LOGGER.info("Creating a new todo entry with information: {}", progressionDTO);
		Progression persisted = new Progression();
		
		persisted.setContentNumber(progressionDTO.getContentNumber());
		persisted.setProgress(progressionDTO.getProgress());
		persisted.setProgressDate(progressionDTO.getProgressDate());
		
		persisted.setStudent(findStudentByCode(progressionDTO.getStudentCode()));
		
		persisted = repository.save(persisted);
		LOGGER.info("Created a new todo entry with information: {}", persisted);

		return convertToDTO(persisted);
	}

	@Override
	public ProgressionDTO delete(String id) {
		LOGGER.info("Deleting a todo entry with id: {}", id);

		Progression deleted = findProgressionById(id);
		repository.delete(deleted);

		LOGGER.info("Deleted todo entry with informtation: {}", deleted);

		return convertToDTO(deleted);
	}

	@Override
	public List<ProgressionDTO> findAll() {
		LOGGER.info("Finding all todo entries.");

		List<Progression> progressionEntries = repository.findAll();

		LOGGER.info("Found {} todo entries", progressionEntries.size());

		return convertToDTOs(progressionEntries);
	}



	@Override
	public ProgressionDTO findById(String id) {
		LOGGER.info("Finding todo entry with id: {}", id);

		Progression found = findProgressionById(id);

		LOGGER.info("Found todo entry: {}", found);

		return convertToDTO(found);
	}

	@Override
	public ProgressionDTO update(ProgressionDTO progressionDTO) {
		LOGGER.info("Updating todo entry with information: {}", progressionDTO);

		Progression updated = findProgressionById(progressionDTO.getId());
		// updated.update(progressionDTO.getName(), progressionDTO.getEmail());
		updated = repository.save(updated);

		LOGGER.info("Updated todo entry with information: {}", updated);

		return convertToDTO(updated);
	}

	private Progression findProgressionById(String id) {
		Optional<Progression> result = repository.findOne(id);
		return result.orElseThrow(() -> new StudentNotFoundException(id));

	}
	
	private Student findStudentByCode(String code) {
		return studentRepository.findByCode(code);
	}
	
	private List<ProgressionDTO> convertToDTOs(List<Progression> models) {
		return models.stream().map(this::convertToDTO).collect(toList());
	}
	
	private ProgressionDTO convertToDTO(Progression model) {
		ProgressionDTO dto = new ProgressionDTO();

		dto.setId(model.getId());
		dto.setContentNumber(model.getContentNumber());
		dto.setProgress(model.getProgress());
		dto.setProgressDate(model.getProgressDate());
		dto.setStudentCode(model.getStudent().getCode());
		return dto;
	}
}
