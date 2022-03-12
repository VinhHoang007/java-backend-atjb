package Model.DAO;

import Model.Bean.Account;

public class AccountDAO {

	public Account getAccountInforByUserName(String userName) {
		
		// query DB ... get Account by UserName..s
		Account account = new Account(userName, "Nguyen Van Ro", "Portagal");
		return account;
	}

}
