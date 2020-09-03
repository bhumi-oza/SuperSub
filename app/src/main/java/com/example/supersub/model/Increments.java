package com.example.supersub.model;

import com.google.gson.annotations.SerializedName;

public class Increments{

	@SerializedName("duration")
	private int duration;

	public void setDuration(int duration){
		this.duration = duration;
	}

	public int getDuration(){
		return duration;
	}

	@Override
 	public String toString(){
		return 
			"Increments{" + 
			"duration = '" + duration + '\'' + 
			"}";
		}
}