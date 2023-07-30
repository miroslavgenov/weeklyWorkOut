package exercise;

import java.util.ArrayList;

public class Exercise {
	
	String exerciseName;
	int exerciseSet;
	ArrayList<Integer> exerciseReps;
	
	public Exercise(int exSet, ArrayList<Integer> exReps){
		this.exerciseReps = new ArrayList<Integer>();
		this.exerciseSet = exSet;
		for(int i=0;i<exerciseSet;i++){
			exerciseReps.add(exReps.get(i));
		}
	}

	public Exercise(){
		exerciseReps = new ArrayList<Integer>();
	}
	
	public Exercise(String exName, int exSet, ArrayList<Integer> exReps){
		//again change this to the set method of setExerciseSet
		if(exReps.size() > exSet){
			throw new ArrayIndexOutOfBoundsException("exReps.size() > exSet");
		}else{
			exerciseReps = new ArrayList<Integer>();

			setExerciseName(exName);
			setExerciseSet(exSet);
			setExerciseReps(exReps);
		}
	}

	public Exercise(Exercise copy) {
		this.exerciseName = copy.getExerciseName();
					exerciseReps = new ArrayList<Integer>();

		setExerciseSet(copy.getExerciseSet());
		setExerciseReps(copy.getExerciseReps()); 
	}

	public void setExerciseName(String exName) {
		this.exerciseName = exName;
	}
	
	public void setExerciseSet(int exSet) {
		this.exerciseSet = exSet;
	}
	
	public void setExerciseReps(ArrayList<Integer> exReps) {
		this.exerciseReps = new ArrayList<Integer>();
		
		for(Integer rep : exReps){
			this.exerciseReps.add(rep);
		}
	}

	public String getExerciseName() {
		return exerciseName;
	}
	
	public int getExerciseSet() {
		return exerciseSet;
	}
	
	public ArrayList<Integer> getExerciseReps() {
		return exerciseReps;
	}

	// public void addSet() {}
	public void addReps(int rep) {
		if(exerciseReps.size() < getExerciseSet()){
			exerciseReps.add(rep);
		}
	}
	
	@Override
	public String toString(){
		return exerciseName + " " +
		exerciseSet + " " +
		exerciseReps;
	}
}