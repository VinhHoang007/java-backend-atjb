package cms.spring.mvc.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.spring.mvc.entities.Member;
import cms.spring.mvc.repositories.MemberRepository;

@Service
public class MemberServices {

	@Autowired
	MemberRepository memberRepo;

	public Member findOneUserLogin(String userName) {

		return memberRepo.findOne(userName);

	}

	@Transactional
	public void saveUsers(Member user) {

		memberRepo.saveMember(user);

	}
	
	@Transactional
	public void updateMember(Member user) {
		memberRepo.updateMember(user);

	}

	public boolean checkEmailInDB(String email) {
		Member mem = new Member();
		mem = memberRepo.findOne(email);

		if (mem.getEmail().equalsIgnoreCase(email)) {
			return false;
		}
		return true;
	}
	
	public boolean checkUserNameInDB(String userName) {
		Member mem = new Member();
		mem = memberRepo.findOneByUserName(userName);

		if (mem.getUserName().equalsIgnoreCase(userName)) {
			return true;
		}
		return false;
	}

}
