package com.ben.joblisting.controller;

import com.ben.joblisting.model.Post;
import com.ben.joblisting.repository.PostRepository;
import com.ben.joblisting.repository.SearchRepository;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

	PostRepository postRepository;
	SearchRepository searchRepository;

	public PostController(PostRepository postRepository, SearchRepository searchRepository) {
		this.postRepository = postRepository;
		this.searchRepository = searchRepository;
	}

	@Hidden
	@RequestMapping("/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@GetMapping("/posts/{text}")
	public List<Post> search(@PathVariable String text) {
		return searchRepository.findByText(text);
	}

	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {
		return postRepository.save(post);
	}

}
