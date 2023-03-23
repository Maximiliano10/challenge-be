package com.api.calculate.dao;

import java.util.List;

import com.api.calculate.entity.Percentages;

public interface PercentagesDao {
	
	Percentages save(Percentages percentages);
	List<Percentages> listPercentages ();
}
