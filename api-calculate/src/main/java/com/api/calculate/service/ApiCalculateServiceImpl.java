package com.api.calculate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.calculate.dao.LogsDao;
import com.api.calculate.dao.PercentagesDao;
import com.api.calculate.entity.Logs;
import com.api.calculate.entity.Percentages;

@Service
public class ApiCalculateServiceImpl implements ApiCalculateService {

	@Autowired
	LogsDao dao;
	
	@Autowired
	PercentagesDao percentagesDao;
	
	@Autowired
	@LoadBalanced
	RestTemplate template;
	
	@Override
	public Float getProcessCalculate(Float n1, Float n2) {
		
		Float result=null;
		Float percent=null;
		Percentages percentages = new Percentages();
		try {
			String response = template.getForObject("http://api-externa/getPercentage", String.class);
			//String response = template.getForObject("http://localhost:8001/getPercentage", String.class);	
			percentages.setPercentage(Integer.parseInt(response));
			percentagesDao.save(percentages);
			
			percent = Float.parseFloat(response);		
			result = (n1 + n2) + ( (n1 + n2) * percent/100);
			
			return result;
		}catch(Exception e) {
			List<Percentages> list = percentagesDao.listPercentages();
 			if (!list.isEmpty()) {			
				
				percentages = list.stream().findFirst().orElse(null);
				
				percent = Float.parseFloat(percentages.getPercentage().toString());
				result = (n1 + n2) + ( (n1 + n2) * percent/100);
				
				return result;
			}else {
				return null;
			}
		}
	}
	
    @Override
    public List<Logs> getAll() {
        return (List<Logs>) dao.getAll();
    }
    
	public void setTemplate(RestTemplate template) {
	    this.template = template;
	}
}
