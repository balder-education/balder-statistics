package br.com.baldereducation.baldersatistics.service;

import br.com.baldereducation.baldersatistics.model.domain.to.StatisticTO;

public interface StatiticService {
	public long totalStudents();
	public long meanAge();
	public long findAllFemaleStudents();
	public long findAllMaleStudents();
	public long findAllGoodProgressions();
	public long findAllBadProgressions();
	public StatisticTO getProgression();
}
