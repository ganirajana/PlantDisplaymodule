package com.plant.dto;

import com.plant.Model.plantDisplay;

public class PlantDisplayDto {
	private int plantId;
	private String plantName;
	private String plantType;
	private float plantPrice;
	public PlantDisplayDto(plantDisplay plant) {
		super();
		this.plantId = plant.getPlantId();
		this.plantName = plant.getPlantName();
		this.plantType = plant.getPlantType();
		this.plantPrice = plant.getPlantPrice();
	}
	public PlantDisplayDto() {
		super();
		this.plantId = 1;
		this.plantName = "fjh";
		this.plantType = "type";
		this.plantPrice = 3456;
	}

	/*public PlantDisplayDto() {
		super();
	}*/
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getPlantType() {
		return plantType;
	}
	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}
	public float getPlantPrice() {
		return plantPrice;
	}
	public void setPlantPrice(float plantPrice) {
		this.plantPrice = plantPrice;
	}
	
}
