package exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseLoader {
	
	String fileWithExercises;
	ArrayList<String> exerciseNames;
	Scanner exerciseScanner;
	
	public String getFileWithExercises() {
		return fileWithExercises;
	}
	public void setFileWithExercises(String fileWithExercises) {
		this.fileWithExercises = fileWithExercises;
	}

	public Scanner getExerciseScanner() {
		return exerciseScanner;
	}

	public void setExerciseScanner(Scanner exerciseScanner) {
		this.exerciseScanner = exerciseScanner;
	}

	public void setExerciseNames(ArrayList<String> exerciseNames) {
		this.exerciseNames = exerciseNames;
	}

	
	public ExerciseLoader(String fileWithExercisesName) {
		setFileWithExercises(fileWithExercisesName + ".txt");
		exerciseNames = new ArrayList<String>();
	}

	public void loadExercises() {
		try {
			exerciseScanner = new Scanner(new File(fileWithExercises));

			while(exerciseScanner.hasNextLine()){
				addExerciseNamesToExerciseNamesFromFile(exerciseScanner.nextLine());
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void addExerciseNamesToExerciseNamesFromFile(String exerciseName){
		exerciseNames.add(exerciseName);
	}

	public ArrayList<String> getExerciseNames(){
		return exerciseNames;
	}

	@Override
	public String toString(){
		return fileWithExercises + " \n " +
		exerciseNames;
	}
    public int getExerciseNamesSize() {
        return exerciseNames.size();
    }

}