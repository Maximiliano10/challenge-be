package com.api.calculate.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.calculate.dao.PercentagesDao;
import com.api.calculate.entity.Percentages;

@Service
public class PercentagesServiceImpl implements PercentagesService {

	
	@Autowired
	PercentagesDao dao;
	
	@Override
	public void save(Percentages percentages) {
		dao.save(percentages);
	}

}
