package com.example.supersub.model;

import com.google.gson.annotations.SerializedName;

public class Video{

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("_id")
	private String id;

	@SerializedName("url")
	private String url;

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Video{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",_id = '" + id + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}