package general.spring.mvc.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import general.spring.mvc.entities.ServiceUsage;
import general.spring.mvc.repositories.ServiceUsageRepository;

@Service
public class ServiceUsageService {
	@Autowired
 	ServiceUsageRepository serviceUsageRepository;
	
	@Transactional
	public void saveServiceUsage(ServiceUsage post) {
		serviceUsageRepository.saveServiceUsage(post);
	}
	
	
}
