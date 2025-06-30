package com.ben.joblisting.model;

import lombok.Data;

@Data
public class Post {

	private String profile;
	private String desc;
	private int exp;
	private String[] techs;

}
