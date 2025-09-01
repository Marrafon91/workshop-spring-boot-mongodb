package com.studying.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studying.workshopmongo.domain.Post;
import com.studying.workshopmongo.repository.PostRepository;
import com.studying.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Post> findByTitle(String Text) {
		return repo.findByTitleContainingIgnoreCase(Text);
	}
}
