package br.com.baldereducation.baldersatistics.service;

public interface StatiticService {
	public long totalStudents();
	public long meanAge();
	public long findAllFemaleStudents();
	public long findAllMaleStudents();
	public long findAllGoodProgressions();
	public long findAllBadProgressions();
}
