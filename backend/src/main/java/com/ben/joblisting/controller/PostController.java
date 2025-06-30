package com.ben.joblisting.controller;

import com.ben.joblisting.model.Post;
import com.ben.joblisting.repository.PostRepository;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

	PostRepository repository;

	public PostController(PostRepository repository) {
		this.repository = repository;
	}

	@Hidden
	@RequestMapping("/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return repository.findAll();
	}

	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {
		return repository.save(post);
	}

}
