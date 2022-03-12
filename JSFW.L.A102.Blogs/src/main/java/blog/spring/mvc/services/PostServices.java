package blog.spring.mvc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.spring.mvc.entities.PostEntity;
import blog.spring.mvc.repositories.PostRepository;

@Service
public class PostServices {

	@Autowired
	PostRepository postRepository;

	public List<PostEntity> getAllPostList() {
		return postRepository.getAllPostList();
	}
	
	public List<PostEntity> getPagingList(int page, int totalRecodPage) {
		return postRepository.getPagingList(page, totalRecodPage);
	}
	
	public List<PostEntity> getPostListByAccount(int authorID) {
		return postRepository.getPostListByAccount(authorID);
	}

	public PostEntity getPostEntity(int postID) {
		return postRepository.getPostEntity(postID);
	}

	@Transactional
	public void savePost(PostEntity post) {
		postRepository.savePost(post);
	}

	@Transactional
	public void deletePost(int theId) {
		postRepository.deletePost(theId);
	}

	@Transactional
	public void updatePost(PostEntity postEntity) {
		postRepository.updatePost(postEntity);
	}

	public int numberOfPage(int recordOfPage) {

		int numberPage = postRepository.countPosts();
		int numPageReturn = 0;
		if (numberPage % recordOfPage == 0) {
			numPageReturn = numberPage / recordOfPage;
		} else {
			numPageReturn = numberPage / recordOfPage + 1;
		}

		return numPageReturn;
	}

	public List<PostEntity> searchPost(int id,String title,String status) {
		return postRepository.searchPost(id,title,status);
		
	}
	
	
}
