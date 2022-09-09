package com.plant.Service;

import java.util.List;
//import java.util.Map;
import com.plant.Model.plantDisplay;

public interface plantService {

	
    	plantDisplay addNewPlant(plantDisplay plant);

		plantDisplay updatePlant(plantDisplay plant, int id);
		
		plantDisplay getPlantById(int plantId);
		
		List<plantDisplay> getAllPlants();

		//List<plantDisplay> getAllPlantsByType(String typeOfPlant);
		
		plantDisplay deletePlant(int plantId);
		
		List<plantDisplay> costLowToHigh();
		
		List<plantDisplay> costHighToLow();

}
