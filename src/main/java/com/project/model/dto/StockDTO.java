package com.project.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDTO {

	private Long id;
	private String name;
	private Double price;
	private LocalDate date;
	private Double variation;

}
