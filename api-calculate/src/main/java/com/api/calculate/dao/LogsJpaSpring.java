package com.api.calculate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.calculate.entity.Logs;


public interface LogsJpaSpring extends JpaRepository<Logs, Integer>{

}
