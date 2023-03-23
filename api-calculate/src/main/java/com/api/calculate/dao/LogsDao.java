package com.api.calculate.dao;

import java.util.List;

import com.api.calculate.entity.Logs;


public interface LogsDao {

	Logs save(Logs logs);
	List<Logs> getAll();
}
