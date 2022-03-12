package general.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import general.spring.mvc.entities.NhaXe;
import general.spring.mvc.repositories.NhaXeRepository;
@Service
public class NhaXeService {
	@Autowired
	NhaXeRepository nhaXeRepository;
	
	public void saveNhaXe(NhaXe tx) {
		nhaXeRepository.saveNhaXe(tx);
	}
}
