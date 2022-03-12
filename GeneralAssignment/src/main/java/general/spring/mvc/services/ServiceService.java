package general.spring.mvc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import general.spring.mvc.entities.Services;
import general.spring.mvc.repositories.ServiceRepository;

@Service
public class ServiceService {
	@Autowired
	ServiceRepository serviceRepository;
	
	@Transactional
	public void saveService(Services post) {
		serviceRepository.saveService(post);
	}

	public List<Services> getAllServiceList() {
		return serviceRepository.getAllServiceList();
	}

	@Transactional
	public void deleteService(String serID) {
		serviceRepository.deleteService(serID);
		
	}

	public Services findServicerByID(String comID) {
		return serviceRepository.findServicerByID(comID);
	}
	
	@Transactional
	public void updateService(Services comID) {
		serviceRepository.updateService(comID);
	}
	
	public int numberOfPage(int recordOfPage) {

		int numberPage = serviceRepository.countService();
		int numPageReturn = 0;
		if (numberPage % recordOfPage == 0) {
			numPageReturn = numberPage / recordOfPage;
		} else {
			numPageReturn = numberPage / recordOfPage + 1;
		}

		return numPageReturn;
	}
	
	public List<Services> searchService(String userName) {
		
		return serviceRepository.searchService(userName);
	}
	
	public List<Services> getPagingList(int page, int totalRecodPage) {
		
		return serviceRepository.getPagingList(page, totalRecodPage);
	}
}
