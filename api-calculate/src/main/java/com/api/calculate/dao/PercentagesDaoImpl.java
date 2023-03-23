package com.api.calculate.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.calculate.entity.Percentages;

@Repository
public class PercentagesDaoImpl implements PercentagesDao {

	@Autowired
	private PercentagesJpaSpring percentagesJpa;
	
	@Override
	public Percentages save(Percentages percentages) {
		percentagesJpa.deleteAll();
		return percentagesJpa.save(percentages);
	}
	
	@Override
	public List<Percentages> listPercentages () {		
		return percentagesJpa.findAll();
	}


}
