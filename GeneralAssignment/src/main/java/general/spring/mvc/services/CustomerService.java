package general.spring.mvc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import general.spring.mvc.entities.Customer;
import general.spring.mvc.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Transactional
	public void saveCustomer(Customer post) {
		customerRepository.saveCustomer(post);
	}
	
	public Customer findCustomerByID(String custID) {
		return customerRepository.findCustomerByID(custID);
	}
	
	public List<Customer> getAllCustomerList() {
		return customerRepository.getAllCustomerList();
	}

	
	public List<Object[]> getPagingListDetail(int page, int totalRecodPage) {
		return customerRepository.getPagingListDetail(page, totalRecodPage);
	}
	
	public List<Object[]> getTotalMoneyServiceDetail() {
		return customerRepository.getTotalMoneyServiceDetail();
	}
	
	public List<Customer> getPagingList(int page, int totalRecodPage) {
		return customerRepository.getPagingList(page, totalRecodPage);
	}
	@Transactional
	public void deleteCustomer(String comID) {
		customerRepository.deleteCustomer(comID);
		
	}
	@Transactional
	public void updateCustomer(Customer updateCustomer) {
		customerRepository.updateCustomer(updateCustomer);
		
	}
	
	public int numberOfPage(int recordOfPage) {

		int numberPage = customerRepository.countCustomer();
		int numPageReturn = 0;
		if (numberPage % recordOfPage == 0) {
			numPageReturn = numberPage / recordOfPage;
		} else {
			numPageReturn = numberPage / recordOfPage + 1;
		}

		return numPageReturn;
	}
	
	public int numberOfPageDetail(int recordOfPage) {

		int numberPage = customerRepository.countCustomerDetail();
		int numPageReturn = 0;
		if (numberPage % recordOfPage == 0) {
			numPageReturn = numberPage / recordOfPage;
		} else {
			numPageReturn = numberPage / recordOfPage + 1;
		}

		return numPageReturn;
	}
	
	public boolean isCustomerIdDuplicate(String custID) {
		
		List<Customer> lst = customerRepository.getAllCustomerList();

		for (Customer customer : lst) {
			if(customer.getCustomerID().equalsIgnoreCase(custID)) {
				return true;
			}
		}
		
		return false;
	}
	
//	public int numberOfPageSearchResult(int recordOfPage,String name) {
//
//		int numberPage = customerRepository.countCustomerByName(name);
//		int numPageReturn = 0;
//		if (numberPage % recordOfPage == 0) {
//			numPageReturn = numberPage / recordOfPage;
//		} else {
//			numPageReturn = numberPage / recordOfPage + 1;
//		}
//
//		return numPageReturn;
//	}
//
//	public List<Customer> searchCustomerPaging(String customerName, int page, int totalRecodPage) {
//		
//		return customerRepository.searchCustomerPaging(customerName,page,totalRecodPage);
//	}
	
	public List<Customer> searchCustomer(String userName) {
		
		return customerRepository.searchCustomer(userName);
	}
	
	public List<Object[]> searchCustomerDetail(String userName) {
		
		return customerRepository.searchCustomerDetail(userName);
	}
}
