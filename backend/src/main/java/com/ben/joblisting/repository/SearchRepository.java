package com.ben.joblisting.repository;

import com.ben.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {

	List<Post> findByText(String text);

}
