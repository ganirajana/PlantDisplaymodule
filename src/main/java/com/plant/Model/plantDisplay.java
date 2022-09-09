package com.plant.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLANT_DIS")
public class plantDisplay {
	@Id
	@Column(name="PLANT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int plantId;
	
	  @Column(name="PLANT_NAME")
	  private String plantName;
	
	  @Column(name="PLANT_TYPE")
	  private String plantType;
	    
	  @Column(name="PLANT_PRICE")
	  private float plantPrice;
	  
	  
   	public plantDisplay() {
		super();
	}

	public plantDisplay(int plantId, String plantName, String plantType, float plantPrice, String to) {
		super();
		
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantType = plantType;
		this.plantPrice = plantPrice;
		
	}

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
	 @Override
	 public String toString() {
		 return "plantdisplay [plantId=" + plantId + ", plantName=" + plantName + ", plantType=" + plantType
					+ ", plantPrice=" + plantPrice + "]";
					
	 }
	    
}
