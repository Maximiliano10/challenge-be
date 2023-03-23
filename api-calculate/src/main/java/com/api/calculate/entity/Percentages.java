package com.api.calculate.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="percentages")
@Schema(name = "percentages", description = "Model represent a ercentages on database")
public class Percentages {

	@Id
	private Integer percentage;

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

		
}
