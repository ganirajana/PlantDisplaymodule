package com.plant.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plant.Repository.plantRepository;
import com.plant.Exception.PlantIdNotFoundException;
import com.plant.Model.plantDisplay;

@Service
 public class plantServiceImpl implements plantService{

   @Autowired   
   private plantRepository plantRepo;
   
    @Override
	 public plantDisplay getPlantById(int plantId) 
    {
    	Optional<plantDisplay> plantOptional = plantRepo.findById(plantId);
    		if(plantOptional.isPresent()) {
    			
    			return plantRepo.findById(plantId).get();
    			
    		}
    		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
    }
    @Override
	 public List<plantDisplay> getAllPlants()
    {
		 return plantRepo.findAll();
    }
   /* @Override
	 public List<plantDisplay> getAllPlantsByType(String typeOfPlant)
    {
		 if(plantRepo.findByTypeOfPlant(typeOfPlant).isEmpty()) {
				throw new PlantIdNotFoundException("No plants of this types are present");
			}
			return plantRepo.findByTypeOfPlant(typeOfPlant);
	 }*/
	@Override
    public plantDisplay deletePlant(int plantId)
	{
         Optional<plantDisplay> plantOptional = plantRepo.findById(plantId);		
		 if(plantOptional.isPresent()) {
			plantDisplay here = plantOptional.get();
			plantRepo.delete(here);
			return here;
		 }
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}
	@Override
	public List<plantDisplay> costLowToHigh() 
	{
		List<plantDisplay> plants = plantRepo.findAll();
		List<plantDisplay> sortedPlants = plants.stream().sorted((plantDisplay s1,plantDisplay s2) -> (int)s1.getPlantPrice() - (int)s2.getPlantPrice()).collect(Collectors.toList());
		return sortedPlants;
	}
	@Override
	public List<plantDisplay> costHighToLow() 
	{
		List<plantDisplay> plants = plantRepo.findAll();
		List<plantDisplay> sortedPlants = plants.stream().sorted((plantDisplay s1,plantDisplay s2) -> (int)s2.getPlantPrice() - (int)s1.getPlantPrice()).collect(Collectors.toList());
		return sortedPlants;
		
	}
	@Override
	public plantDisplay addNewPlant(plantDisplay plant) {
		plantRepo.save(plant);	
		return plant;
	}
	@Override
	public plantDisplay updatePlant(plantDisplay plant, int id) 
	
	{
		Optional<plantDisplay> plantOptional = plantRepo.findById(id);
		if(plantOptional.isPresent()) {
			plantDisplay plantToBeUpdated = plantOptional.get();
			plantToBeUpdated.setPlantName(plant.getPlantName());
			plantToBeUpdated.setPlantPrice(plant.getPlantPrice());
			plantToBeUpdated.setPlantType(plant.getPlantType());
			plantRepo.save(plantToBeUpdated);
			return plantToBeUpdated;
	}
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
}
}	
