package com.spark.readAndWriteCSVFile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spark.readAndWriteCSVFile.model.Tutorial;

public interface TutorialRepo extends JpaRepository<Tutorial, Long>{

}
