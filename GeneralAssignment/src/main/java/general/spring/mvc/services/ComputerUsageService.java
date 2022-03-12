package general.spring.mvc.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import general.spring.mvc.entities.ComputerUsage;
import general.spring.mvc.repositories.ComputerUsageRepository;


@Service
public class ComputerUsageService {
	@Autowired
 	ComputerUsageRepository computerRepository;
	
	@Transactional
	public void saveComputerUsage(ComputerUsage post) {
		computerRepository.saveComputerUsage(post);
	}
}
