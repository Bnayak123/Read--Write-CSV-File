package com.spark.readAndWriteCSVFile.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spark.readAndWriteCSVFile.helper.CSVHelper;
import com.spark.readAndWriteCSVFile.model.Tutorial;
import com.spark.readAndWriteCSVFile.repository.TutorialRepo;

@Service
public class CSVSrvice {
	@Autowired
	TutorialRepo tutorialRepo;

	public void save(MultipartFile file) {
		try {
			List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
			tutorialRepo.saveAll(tutorials);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

	public List<Tutorial> getAllTutorials() {
		return tutorialRepo.findAll();
	}
}
