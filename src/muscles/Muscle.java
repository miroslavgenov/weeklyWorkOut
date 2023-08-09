package muscles;

import java.util.ArrayList;


import exercise.Exercise;
import exercise.ExerciseLoader;

public class Muscle  {
	
	String muscleName;
	// ArrayList<Exercise> muscleExercises;
	public ExerciseLoader muscleExerciseLoader;
	int musclePriority;
	public Exercise muscleExercise;

	public ExerciseLoader getMuscleExerciseLoader(){
		return muscleExerciseLoader;
	}

	public void setMuscleExercise(Exercise ex){
		muscleExercise = new Exercise(ex.getExerciseName(),ex.getExerciseSet(),ex.getExerciseReps());
	}

	public Muscle(){}

	public Muscle(String muscleName, int musclePriority, Exercise muscleExercise){
		setMuscleName(muscleName);
		setMusclePriority(musclePriority);
		setMuscleExercise(muscleExercise);
		setExerciseLoader(muscleName);
		muscleExerciseLoader.loadExercises();
	}

	private void setExerciseLoader(String muscleFile) {
		this.muscleExerciseLoader = new ExerciseLoader(muscleFile);
	}

	
	public Muscle(String muscleName) {
		this(muscleName, 0, new Exercise());
	}

	public Muscle(Muscle copy) {
		this(copy.muscleName,copy.musclePriority,copy.muscleExercise);
	}
	
	public int getMusclePriority(){
		return this.musclePriority;
	}
	

	@Override
	public String toString(){
		return muscleName  + " " +
		musclePriority + " " +
		muscleExercise;
	}

	public Exercise getMuscleExercise(){
		return this.muscleExercise;
	}

	public String getMuscleName() {
		return muscleName;
	}

	public void setMusclePriority(int musclePriority) {
		this.musclePriority = musclePriority;
	}

    public void setMuscleName(String muscleName) {
		this.muscleName = muscleName;
    }

    public void show() {
		System.out.println(getMuscleName()+" "+getMusclePriority());
		System.out.println(getMuscleExercise());	
    }

	public int getTheSizeOfTheLoadedExercises() {
		return getMuscleExerciseLoader().getExerciseNamesSize();
	}

}
