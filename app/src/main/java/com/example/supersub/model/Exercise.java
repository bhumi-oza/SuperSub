package com.example.supersub.model;

import com.google.gson.annotations.SerializedName;

public class Exercise{

	@SerializedName("difficulty")
	private int difficulty;

	@SerializedName("restTime")
	private int restTime;

	@SerializedName("reps")
	private int reps;

	@SerializedName("sets")
	private int sets;

	@SerializedName("calories")
	private int calories;

	@SerializedName("increments")
	private Increments increments;

	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}

	public int getDifficulty(){
		return difficulty;
	}

	public void setRestTime(int restTime){
		this.restTime = restTime;
	}

	public int getRestTime(){
		return restTime;
	}

	public void setReps(int reps){
		this.reps = reps;
	}

	public int getReps(){
		return reps;
	}

	public void setSets(int sets){
		this.sets = sets;
	}

	public int getSets(){
		return sets;
	}

	public void setCalories(int calories){
		this.calories = calories;
	}

	public int getCalories(){
		return calories;
	}

	public void setIncrements(Increments increments){
		this.increments = increments;
	}

	public Increments getIncrements(){
		return increments;
	}

	@Override
 	public String toString(){
		return 
			"Exercise{" + 
			"difficulty = '" + difficulty + '\'' + 
			",restTime = '" + restTime + '\'' + 
			",reps = '" + reps + '\'' + 
			",sets = '" + sets + '\'' + 
			",calories = '" + calories + '\'' + 
			",increments = '" + increments + '\'' + 
			"}";
		}
}