package general.spring.mvc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import general.spring.mvc.entities.Computer;
import general.spring.mvc.repositories.ComputerRepository;

@Service
public class ComputerService {
	@Autowired
	ComputerRepository computerRepository;
	
	public List<Computer> getAllComputerList() {
		return computerRepository.getAllComputerList();
	}
	
	public List<Computer> getComputerListAvailable() {
		return computerRepository.getComputerListAvailable();
	}
	
	@Transactional
	public void saveComputer(Computer post) {
		computerRepository.saveComputer(post);
	}

	@Transactional
	public void deleteComputer(int comID) {
		computerRepository.deleteComputer(comID);
		
	}

	public Computer findComputerByID(int comID) {
		return computerRepository.findComputerByID(comID);
	}
	@Transactional
	public void updateComputer(Computer updateComputer) {
		computerRepository.updateComputer(updateComputer);
	}
	
	public int numberOfPage(int recordOfPage) {

		int numberPage = computerRepository.countComputer();
		int numPageReturn = 0;
		if (numberPage % recordOfPage == 0) {
			numPageReturn = numberPage / recordOfPage;
		} else {
			numPageReturn = numberPage / recordOfPage + 1;
		}

		return numPageReturn;
	}
	
	public List<Computer> searchComputer(String userName) {
		
		return computerRepository.searchComputer(userName);
	}
	
	public List<Computer> getPagingList(int page, int totalRecodPage) {
		
		return computerRepository.getPagingList(page, totalRecodPage);
	}
}
