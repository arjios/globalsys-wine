package com.globalsys.wine.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_datasheet")
public class Datasheet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String coutry;
	private String region;
	
	private String grape;
	private String classification;
	
	private String winery;
	private String harvest;
	
	private String ripening;
	private String alcohol;
	
	private Integer temperature;
	private Integer shelflife;
	
	private Integer settling;
	private String visual;
	
	public Datasheet() {
	}

}
