package com.api.calculate.service;

import java.util.List;

import com.api.calculate.entity.Logs;

public interface ApiCalculateService {

	Float getProcessCalculate(Float n1, Float n2);
	List<Logs> getAll();
}
