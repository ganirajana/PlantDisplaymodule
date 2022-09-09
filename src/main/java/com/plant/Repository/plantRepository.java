package com.plant.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.plant.Model.plantDisplay;

@Repository
public interface plantRepository extends JpaRepository<plantDisplay, Integer> {
	//Optional<plantDisplay> findByname(String name);
		
		//Optional<plantDisplay> findById(int id);
		//List<plantDisplay> findByTypeOfPlant(String typeOfPlant);


}
