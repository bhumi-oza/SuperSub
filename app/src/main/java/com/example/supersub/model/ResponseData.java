package com.example.supersub.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData{

	@SerializedName("illustrations")
	private List<IllustrationsItem> illustrations;

	@SerializedName("description")
	private String description;

	@SerializedName("exercise")
	private Exercise exercise;

	@SerializedName("_id")
	private String id;

	@SerializedName("video")
	private Video video;

	@SerializedName("title")
	private String title;

	@SerializedName("category")
	private String category;

	@SerializedName("subcategory")
	private String subcategory;

	public void setIllustrations(List<IllustrationsItem> illustrations){
		this.illustrations = illustrations;
	}

	public List<IllustrationsItem> getIllustrations(){
		return illustrations;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setExercise(Exercise exercise){
		this.exercise = exercise;
	}

	public Exercise getExercise(){
		return exercise;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setVideo(Video video){
		this.video = video;
	}

	public Video getVideo(){
		return video;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setSubcategory(String subcategory){
		this.subcategory = subcategory;
	}

	public String getSubcategory(){
		return subcategory;
	}

	@Override
 	public String toString(){
		return 
			"ResponseData{" + 
			"illustrations = '" + illustrations + '\'' + 
			",description = '" + description + '\'' + 
			",exercise = '" + exercise + '\'' + 
			",_id = '" + id + '\'' + 
			",video = '" + video + '\'' + 
			",title = '" + title + '\'' + 
			",category = '" + category + '\'' + 
			",subcategory = '" + subcategory + '\'' + 
			"}";
		}
}