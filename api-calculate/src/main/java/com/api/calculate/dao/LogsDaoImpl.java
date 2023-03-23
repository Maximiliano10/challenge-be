package com.api.calculate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.calculate.entity.Logs;


@Repository
public class LogsDaoImpl implements LogsDao{
	
	@Autowired
	private LogsJpaSpring logsJpa;

	@Override
	public Logs save(Logs logs) {
		// TODO Auto-generated method stub
		return logsJpa.save(logs);
	}

	@Override
	public List<Logs> getAll() {
		// TODO Auto-generated method stub
		return logsJpa.findAll();
	}
	
	
   

}
