package br.com.baldereducation.baldersatistics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baldereducation.baldersatistics.model.domain.GenderType;
import br.com.baldereducation.baldersatistics.model.domain.Progression;
import br.com.baldereducation.baldersatistics.model.domain.Student;
import br.com.baldereducation.baldersatistics.model.repository.ProgressionRepository;
import br.com.baldereducation.baldersatistics.model.repository.StudentRepository;

@Service
public class StatiticServiceImpl implements StatiticService {

	private static final int LOW_MEDIA = 4;
	private static final int HIGH_MEDIA = 7;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ProgressionRepository progressionRepository;

	@Override
	public long meanAge() {
		List<Student> students = getAllStudents();
		return students.stream().count();
	}

	public long totalStudents() {
		return studentRepository.findAll().stream().count();
	}

	@Override
	public long findAllMaleStudents() {
		List<Student> students = getAllStudents();
		return students.stream().filter(student -> student.getGenterType().equals(GenderType.MALE.getGenderType())).count();
	}

	@Override
	public long findAllFemaleStudents() {
		List<Student> students = getAllStudents();
		return students.stream().filter(student -> student.getGenterType().equals(GenderType.FEMALE.getGenderType())).count();
	}

	@Override
	public long findAllGoodProgressions() {
		List<Student> students = getAllStudents();
		long count = 0;
		long mean = 0;
		List<Long> means = new ArrayList<Long>();
		for (Student student : students) {
			List<Progression> progression = progressionRepository.findByStudent(student);
			count = progression.stream().filter(p -> p.getProgress() > HIGH_MEDIA).count();
			mean = count / students.size();
			means.add(mean);
		}
		return means.size();
	}

	@Override
	public long findAllBadProgressions() {
		List<Student> students = getAllStudents();
		long count = 0;
		long mean = 0;
		List<Long> means = new ArrayList<Long>();
		for (Student student : students) {
			List<Progression> progression = progressionRepository.findByStudent(student);
			count = progression.stream().filter(p -> p.getProgress() < LOW_MEDIA).count();
			mean = count / students.size();
			means.add(mean);
		}
		return means.size();
	}

	private List<Student> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
}
