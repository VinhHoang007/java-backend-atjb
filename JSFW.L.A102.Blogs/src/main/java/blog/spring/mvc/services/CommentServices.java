package blog.spring.mvc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.spring.mvc.entities.CommentEntity;
import blog.spring.mvc.repositories.CommentRepository;

@Service
public class CommentServices {
	@Autowired
	CommentRepository commentRepository;
	
	@Transactional
	public void saveComments(CommentEntity cmt) {
		commentRepository.saveComments(cmt);
	}
	
	public List<CommentEntity> getAllComments() {
		return commentRepository.getAllComment();
	}
}
