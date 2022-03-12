package demo.spring.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.mvc.dtos.HomeListItemDTO;
import demo.spring.mvc.repositories.HomeRepository;

// BO
@Service
public class HomeService {

    @Autowired
    private HomeRepository homeRepository; // Không bao giờ null do autowrited với required=true

    public List<HomeListItemDTO> loadData() {
        return homeRepository.loadData();
    }
}
