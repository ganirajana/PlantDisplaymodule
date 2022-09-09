package com.plant.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.plant.Exception.PlantIdNotFoundException;
import com.plant.Model.plantDisplay;
import com.plant.Service.plantService;
import com.plant.dto.PlantDisplayDto;

@RestController
@RequestMapping("/products")
public class plantController {
	@Autowired
	private plantService plantService;
    
	@PostMapping("/admin/plant")
	public ResponseEntity<plantDisplay> addNewPlant(@RequestBody plantDisplay plant) {
		plantService.addNewPlant(plant);
		return new ResponseEntity<plantDisplay>(plant, HttpStatus.OK);
	}
	@PutMapping({"/admin/plant/id/{id}"})
	public ResponseEntity<plantDisplay> updatePlant(@RequestBody plantDisplay plant, @PathVariable int id) {
		// logger.trace("updating the whole plant having id "+ id);  
		plantService.updatePlant(plant, id);
		return new ResponseEntity<plantDisplay>(plant, HttpStatus.ACCEPTED);
	}
	@GetMapping("/customers/plant/id/{id}")
	public ResponseEntity<plantDisplay> viewPlant(@PathVariable Integer id) 
	{
		//logger.trace("fetching the plant with id "+ id);
		return new ResponseEntity<plantDisplay>(plantService.getPlantById(id), HttpStatus.OK);
	}
	@GetMapping("/customers/plants")
	public ResponseEntity<List<plantDisplay>> viewAllPlants() 
	{
		//logger.trace("fetching all the plants");
		 List<PlantDisplayDto> plants = new ArrayList<>();
	        for(plantDisplay plant: plantService.getAllPlants())
	            plants.add(new PlantDisplayDto(plant));
	        if(plants.isEmpty()) {
	        	plants.add(new PlantDisplayDto());
	            //throw new PlantIdNotFoundException();
	        } 
		return new ResponseEntity<List<plantDisplay>>(plantService.getAllPlants(), HttpStatus.OK);
	}

	/*@GetMapping("/customers/plants/typeOfPlant/{typeOfPlant}")
	public ResponseEntity<List<plantDisplay>> viewAllPlants(@PathVariable String typeOfPlant) 
	{
		//logger.trace("searching the plants of type "+typeOfPlant);
		return new ResponseEntity<List<plantDisplay>>(plantService.getAllPlantsByType(typeOfPlant), HttpStatus.OK);
	}*/
	
	@DeleteMapping("/admin/plant/id/{id}")
	public ResponseEntity<plantDisplay> deletePlant(@PathVariable int id) throws PlantIdNotFoundException{
		//logger.trace("deleting the whole plant");	
		return new ResponseEntity<plantDisplay>(plantService.deletePlant(id), HttpStatus.OK);
	}
	@GetMapping("/customers/plants/costLowToHigh")
	public ResponseEntity<List<plantDisplay>> costLowToHigh(){
		return new ResponseEntity<List<plantDisplay>>(plantService.costLowToHigh(),HttpStatus.OK);
	}
		
	@GetMapping("/customers/plants/costHighToLow")
	public ResponseEntity<List<plantDisplay>> costHighToLow(){
		return new ResponseEntity<List<plantDisplay>>(plantService.costHighToLow(),HttpStatus.OK);
	}
}
