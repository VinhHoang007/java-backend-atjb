package Model.BO;

import Model.Bean.Account;
import Model.DAO.AccountDAO;

public class AccountBO {

	public Account getAccountInfor(String userName) {
		
		AccountDAO accountDAO = new AccountDAO();
	
		Account account = accountDAO.getAccountInforByUserName(userName);
		
		return account;
	}

}
