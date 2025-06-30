package com.ben.joblisting.repository;

import com.ben.joblisting.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {

	MongoClient client;
	MongoConverter converter;

	public SearchRepositoryImpl(MongoClient client, MongoConverter converter) {
		this.client = client;
		this.converter = converter;
	}

	@Override
	public List<Post> findByText(String text) {
		final List<Post> posts = new ArrayList<>();

		MongoDatabase database = client.getDatabase("telusko");
		MongoCollection<Document> collection = database.getCollection("JobPost");

		AggregateIterable<Document> result = collection.aggregate(List.of(new Document("$search",
				new Document("index", "default")
						.append("text",
								new Document("query", text)
										.append("path", Arrays.asList("profile", "desc", "techs"))))));

		result.forEach(doc -> posts.add(converter.read(Post.class, doc)));

		return posts;
	}

}
