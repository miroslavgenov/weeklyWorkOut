package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import exercise.Exercise;
import exercise.ExerciseUtil;
import muscles.Muscle;
import muscles.MuscleGroup;
import muscles.MuscleGroupUtil;


public class WorkOut {

	ArrayList<MuscleGroup> muscleGroupsToWorkOut;

	public WorkOut() {
		WorkOutUtil.initializeMuscleGroupsToWorkOut(this);
	}

	public WorkOut(ArrayList<MuscleGroup> muscleGroupsToWorkOut) {
		WorkOutUtil.initializeMuscleGroupsToWorkOut(this);
		deepSetMuscleGroupsToWorkOut(muscleGroupsToWorkOut);
	}

	public void deepSetMuscleGroupsToWorkOut(ArrayList<MuscleGroup> sourceMuscleGroups) {
		WorkOutUtil.initializeMuscleGroupsToWorkOut(this);
		WorkOutUtil.copyValueFromSourceToDestination(sourceMuscleGroups, this);
	}

	public void setMuscleGroupsToWorkOut(ArrayList<MuscleGroup> source) {
		muscleGroupsToWorkOut = source;
	}

	public ArrayList<MuscleGroup> getMuscleGroupsToWorkOut() {
		return muscleGroupsToWorkOut;
	}

	public int getMuscleGroupsToWorkOutSize() {
		return muscleGroupsToWorkOut.size();
	}

	public boolean isMuscleGroupsToWorkOutEmpty() {
		return muscleGroupsToWorkOut.isEmpty();
	}

	public void addMuscleGroupToMuscleGroupsToWorkOut(MuscleGroup muscleGroupToWorkOut) {
		muscleGroupsToWorkOut.add(new MuscleGroup(
				muscleGroupToWorkOut.getMuscleGroupName(),
				muscleGroupToWorkOut.getMuscleGroupPriority(),
				muscleGroupToWorkOut.getMuscleGroupNumberOfExercises(),
				muscleGroupToWorkOut.getMuscles()));
	}

	public void addMuscleGroupToMuscleGroupsToWorkOut(String muscleGroupToWorkOutName) {
		muscleGroupsToWorkOut.add(new MuscleGroup(muscleGroupToWorkOutName));
	}

	public void setThePriorityOfAllMuscleGroupsFromMuscleGroupsToWorkOutBasedOnWhenTheyWasAdded() {
		for (int i = 0, priority = 0; i < getMuscleGroupsToWorkOutSize(); i++, priority++) {
			setMuscleGroupPriority(getMuscleGroupsToWorkOut().get(i), priority);
		}
	}

	public void setMuscleGroupPriority(MuscleGroup muscleGroup, int priority) {
		muscleGroup.setMuscleGroupPriority(priority);
	}

	public void showThePriorityOfTheMuscleGroupsToWorkOut() {
		for (MuscleGroup mc : muscleGroupsToWorkOut) {
			System.out.printf("MuscleGroup: %s MuscleGroupPriority: %d\n", mc.getMuscleGroupName(),
					mc.getMuscleGroupPriority());
		}
	}

	boolean isMuscleGroupToWorkOutIndexValid(int index) {
		return index < getMuscleGroupsToWorkOutSize() || index >= 0;
	}

	public void setTheExerciseNumberOfSpecificMuscleGroup(int numberOfExercise, int muscleGroupToWorkOutIndex) {
		getMuscleGroupsToWorkOut().get(muscleGroupToWorkOutIndex).setMuscleGroupNumberOfExercises(numberOfExercise);
	}

	public void showMuscleGroupsToWorkOutAndTheirNumberOfExercise() {
		System.out.println("MuscleGroups to WorkOut and their Number of exercise");
		for (MuscleGroup mc : getMuscleGroupsToWorkOut()) {
			System.out.println(mc.getMuscleGroupName() + " " + mc.getMuscleGroupNumberOfExercises());
		}
	}

	public void setExerciseNumberOfMuscleGroupBasedOnMuscleGroupPriorit(ArrayList<Integer> exerciseNumbers) {
		reverseSort(exerciseNumbers);

		for (int i = 0; i < getMuscleGroupsToWorkOutSize(); i++) {
			getMuscleGroupsToWorkOut().get(i).setMuscleGroupNumberOfExercises(exerciseNumbers.get(i));
		}
	}

	public void reverseSort(ArrayList<Integer> exerciseNumbers) {
		Collections.sort(exerciseNumbers);
		Collections.reverse(exerciseNumbers);
	}

	public void addMuscleGroupToMuscleGroupsToWorkOutAndSetPriorityOnMuscleGroupBasedOnWhenWasAdded(
			MuscleGroup muscleGroup) {
		MuscleGroup mc = new MuscleGroup(muscleGroup);
		mc.setMuscleGroupPriority(getMuscleGroupsToWorkOutSize());
		getMuscleGroupsToWorkOut().add(mc);
	}

	public void addMuscleGroupToMuscleGroupsToWorkOutAndSetPriorityOnMuscleGroupBasedOnWhenWasAdded(
			String muscleGroupName) {
		MuscleGroup mc = new MuscleGroup(muscleGroupName);
		mc.setMuscleGroupPriority(getMuscleGroupsToWorkOutSize());
		getMuscleGroupsToWorkOut().add(mc);
	}

	public void showMuscleGroupsToWorkOut() {
		for (MuscleGroup mc : getMuscleGroupsToWorkOut()) {
			System.out.println(mc.getMuscleGroupName());
		}
	}

	@Override
	public String toString() {
		return muscleGroupsToWorkOut + "";
	}

	public void setTheNumberOfExerciseForMuscleGroup(int muscleGroupIndex, int numberOfExercise) {
		getMuscleGroupsToWorkOut().get(muscleGroupIndex).setMuscleGroupNumberOfExercises(numberOfExercise);
	}

	public void setRandomMusclesToTrainForEachMuscleGroupBasedOnMuscleGroupExerciseNumber() {
		for (int currentMuscleGroupIndex = 0; currentMuscleGroupIndex < getMuscleGroupsToWorkOutSize(); currentMuscleGroupIndex++) {
			setRandmlyMusclesToTrainForMuscleGroupBasedOnMuscleGroupExerciseNumber(currentMuscleGroupIndex);
		}
	}

	public void setRandmlyMusclesToTrainForMuscleGroupBasedOnMuscleGroupExerciseNumber(int muscleGroupIndex) {
		MuscleGroup muscleGroup = getMuscleGroupsToWorkOut().get(muscleGroupIndex);
		ArrayList<Muscle> musclesToTrain = pickRandomMuscles(muscleGroup);

		muscleGroup.initializeMuscles();

		// sort - here we can sort the picked muscles based on priority
		muscleGroup.addMuscles(musclesToTrain);
	}

	public ArrayList<Muscle> pickRandomMuscles(MuscleGroup muscleGroup) {
		ArrayList<Muscle> musclesToTrain = new ArrayList<Muscle>();

		addRandomMuscleBasedOnMuscleGroupNumberOfExercise(musclesToTrain, muscleGroup);

		return musclesToTrain;
	}

	public void addRandomMuscleBasedOnMuscleGroupNumberOfExercise(ArrayList<Muscle> save, MuscleGroup muscleGroup) {
		for (int i = 0; i < muscleGroup.getMuscleGroupNumberOfExercises(); i++) {
			Muscle muscle = muscleGroup.getMuscles().get(pickRandomNumber(0, muscleGroup.getMuscleGroupSize()));
			save.add(new Muscle(muscle.getMuscleName(), muscle.getMusclePriority(), muscle.getMuscleExercise()));
		}
	}

	public int pickRandomMuscleIndex(MuscleGroup muscleGroup) {
		int randomMuscleIndex = new Random().nextInt(0, muscleGroup.getMuscleGroupSize());
		return randomMuscleIndex;
	}

	public void setRandomExerciseForMusclesInEachMuscleGroup() {
		for (int i = 0; i < getMuscleGroupsToWorkOutSize(); i++) {
			setRandomExerciseForEachMuscleInMuscleGroup(i);
		}
	}

	public void setRandomExerciseForEachMuscleInMuscleGroup(int muscleGroupIndex) {
		for (int i = 0; i < getMuscleGroupsToWorkOut().get(muscleGroupIndex).muscles.size(); i++) {
			setRandomExerciseForMuscleInMuscleGroup(muscleGroupIndex, i);
		}
	}

	public void setRandomExerciseForMuscleInMuscleGroup(int muscleGroupIndex, int muscleIndex) {
		Muscle mc = getMuscleGroupsToWorkOut().get(muscleGroupIndex).muscles.get(muscleIndex);
		Exercise ex = 
		ExerciseUtil.randomlyBuildExercise(mc);
		// randomlyBuildExerciseForMuscle(mc);
		mc.setMuscleExercise(new Exercise(ex.getExerciseName(), ex.getExerciseSet(), ex.getExerciseReps()));
	}

	// public Exercise randomlyBuildExerciseForMuscle(Muscle muscle) {
	// 	Exercise exercise = new Exercise();
	// 	setExerciseNameSetReps(exercise, muscle);
	// 	return exercise;
	// }

	// void setExerciseNameSetReps(Exercise exercise, Muscle muscle) {
	// 	exercise.setExerciseName(pickRandomExerciseNameForMuscle(muscle));
	// 	exercise.setExerciseSet(pickRandomNumber(1, 4));
	// 	exercise.setExerciseReps(pickRandomReps(exercise.getExerciseSet()));
	// }

	// public String pickRandomExerciseNameForMuscle(Muscle muscle) {
	// 	int randomExerciseIndex = pickRandomNumber(0, muscle.getTheSizeOfTheLoadedExercises());

	// 	String pickedExerciseName = muscle.getMuscleExerciseLoader().getExerciseNames().get(randomExerciseIndex);

	// 	return pickedExerciseName;
	// }

	// public ArrayList<Integer> pickRandomReps(int set) {
	// 	ArrayList<Integer> reps = new ArrayList<Integer>();

	// 	for (int i = 0; i < set; i++) {
	// 		reps.add(pickRandomNumber(6, 13));
	// 	}

	// 	return reps;
	// }

	public int pickRandomNumber(int startNumber, int endNumber) {
		int randomNumber = new Random().nextInt(startNumber, endNumber);
		return randomNumber;
	}

	public ArrayList<Integer> pickRandomExerciseNumberForEachMuscleGroup() {
		ArrayList<Integer> randomExerciseNumbersForEachMuscleGroup = new ArrayList<Integer>();

		for (int i = 0; i < getMuscleGroupsToWorkOutSize(); i++) {
			randomExerciseNumbersForEachMuscleGroup.add(pickRandomNumber(1, 10));
		}

		return randomExerciseNumbersForEachMuscleGroup;
	}

	public void sortMusclesInMuscleGroup() {
		for (int i = 0; i < getMuscleGroupsToWorkOutSize(); i++) {
			sortEachMuscleInMuscleGroup(i);
		}
	}

	public void sortEachMuscleInMuscleGroup(int muscleGroupIndex) {
		Collections.sort(getMuscleGroupsToWorkOut().get(muscleGroupIndex).muscles,
				(o1, o2) -> o1.getMusclePriority() - o2.getMusclePriority());
	}

	public void reverseSortTwoDimentional(ArrayList<ArrayList<Integer>> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			reverseSort(numbers.get(i));
		}
	}

	// clean
	public void countMusclesOccurancesFromEachMuscleGroupAndChangeMuscleGroupMuscleStructure(
			ArrayList<MuscleGroup> ethalonMuscleGroups) {
		ArrayList<ArrayList<Integer>> musclesCountedForEachmMuscleGroup = MuscleGroupUtil.countMusclesForEachMuscleGroup(getMuscleGroupsToWorkOut());

		reverseSortTwoDimentional(musclesCountedForEachmMuscleGroup);
		
		for(int i=0;i<getMuscleGroupsToWorkOutSize();i++){
			MuscleGroupUtil.changeMuscleGroupStructure(getMuscleGroupsToWorkOut().get(i), musclesCountedForEachmMuscleGroup.get(i) );
		}
	}

	public void sortMuscleGroupsExercisesBasedOnSet() {
		for (int i = 0; i < getMuscleGroupsToWorkOutSize(); i++) {
			sortMuscleGroupExercisesBasedOnSet(i);
		}
	}

	// this function can be in class MuscleGroup but the random exercises is not
	// actualy really random
	public ArrayList<Exercise> getMusclesExercisesFromMuscleGroup(int muscleGroupIndex) {
		ArrayList<Exercise> musclesExercises = new ArrayList<Exercise>();
		addOnlyExercisesSetAndReps(musclesExercises, getMuscleGroupsToWorkOut().get(muscleGroupIndex));

		Collections.sort(musclesExercises, (o1, o2) -> o2.getExerciseSet() - o1.getExerciseSet());

		return musclesExercises;
	}

	private void addOnlyExercisesSetAndReps(ArrayList<Exercise> musclesExercises, MuscleGroup muscleGroup) {
		for (Muscle mc : muscleGroup.getMuscles()) {
			musclesExercises.add(new Exercise(mc.muscleExercise.getExerciseSet(), mc.muscleExercise.getExerciseReps()));
		}
	}

	public void sortMuscleGroupExercisesBasedOnSet(int muscleGroupIndex) {
		ArrayList<Exercise> muscleGroupExercisesSorted = getMusclesExercisesFromMuscleGroup(muscleGroupIndex);

		for (int i = 0; i < getMuscleGroupsToWorkOut().get(muscleGroupIndex).muscles.size(); i++) {
			Muscle mc = getMuscleGroupsToWorkOut().get(muscleGroupIndex).muscles.get(i);
			mc.muscleExercise.setExerciseSet(muscleGroupExercisesSorted.get(i).getExerciseSet());
			mc.muscleExercise.setExerciseReps(muscleGroupExercisesSorted.get(i).getExerciseReps());
		}
	}

	public void show() {
		for (MuscleGroup mcg : getMuscleGroupsToWorkOut()) {
			mcg.show();
		}
	}
}