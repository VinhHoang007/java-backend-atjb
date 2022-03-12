package general.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import general.spring.mvc.entities.TuyenXe;
import general.spring.mvc.repositories.TuyenXeRepository;

@Service
public class TuyenXeService {
	@Autowired
	TuyenXeRepository tuyenXeRepository;
	
	public void saveTuyenXe(TuyenXe tx) {
		tuyenXeRepository.saveTuyenXe(tx);
	}
	
}
