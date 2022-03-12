package cms.spring.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.spring.mvc.entities.Content;
import cms.spring.mvc.repositories.ContentRepository;

@Service
public class ContentServices {
	@Autowired
	ContentRepository contentRepository;
	
	public List<Content> getAllContentList() {
		return contentRepository.getAllContentList();
	}
	
	public void saveContent(Content cont) {
		contentRepository.saveContent(cont);
	}
}
