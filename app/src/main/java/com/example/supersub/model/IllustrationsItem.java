package com.example.supersub.model;

import com.google.gson.annotations.SerializedName;

public class IllustrationsItem{

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("caption")
	private String caption;

	@SerializedName("description")
	private String description;

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"IllustrationsItem{" + 
			"imageUrl = '" + imageUrl + '\'' + 
			",caption = '" + caption + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}