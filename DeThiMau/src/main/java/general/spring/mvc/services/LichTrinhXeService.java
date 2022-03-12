package general.spring.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import general.spring.mvc.repositories.LichTrinhXeRepository;

@Service
public class LichTrinhXeService {
@Autowired
LichTrinhXeRepository lichTrinhXeRepository;
	public List<Object[]> getLichTrinhXe() {
		
		return lichTrinhXeRepository.getLichTrinhXe();
	}

}
