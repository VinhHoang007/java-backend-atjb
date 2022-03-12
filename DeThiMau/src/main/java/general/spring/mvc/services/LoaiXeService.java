package general.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import general.spring.mvc.entities.LoaiXe;
import general.spring.mvc.repositories.LoaiXeRepository;
@Service
public class LoaiXeService {
	@Autowired
	LoaiXeRepository loaiXeRepository;
	
	public void saveLoaiXe(LoaiXe tx) {
		loaiXeRepository.saveLoaiXe(tx);
	}
}
