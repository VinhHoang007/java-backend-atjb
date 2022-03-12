package general.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import general.spring.mvc.entities.Xe;
import general.spring.mvc.repositories.XeRepository;

@Service
public class XeService {
	@Autowired
	XeRepository xeRepository;
	
	public void saveXe(Xe tx) {
		xeRepository.saveXe(tx);
	}
}
