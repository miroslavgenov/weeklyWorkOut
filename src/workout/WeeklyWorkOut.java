package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import main.Main;
import muscles.Muscle;
import muscles.MuscleGroup;
import muscles.MuscleGroupUtil;

public class WeeklyWorkOut {

	int numberOfWorkOuts = 0;
	ArrayList<WorkOut> workOuts;
	ArrayList<MuscleGroupWeeklyHitFrequencyPair> muscleGroupsWeeklyHitFrequencyPairs;
	public static final int DEFAULT_NUMBER_OF_WORKOUTS = 7;

	public void initializeWorkOuts(int howMuschWorkOuts) {
		workOuts = new ArrayList<WorkOut>();
		fillWorkOutsWithEmptyWorkOut(howMuschWorkOuts);
	}

	public void fillWorkOutsWithEmptyWorkOut(int howMuschWorkOuts) {
		for (int i = 0; i < howMuschWorkOuts; i++) {
			workOuts.add(new WorkOut());
		}
	}

	public WeeklyWorkOut(int sizeOfTheWeek) {
		setNumberOfWorkOuts(sizeOfTheWeek);
		initializeWorkOuts(getNumberOfWorkOuts());
		initializeMuscleGroupsWeeklyHitFrequencyPairs();
	}

	public WeeklyWorkOut() {
		this(DEFAULT_NUMBER_OF_WORKOUTS);
	}

	public void setRandomExerciseForMusclesInMuscleGroupsInEachWorkOut() {
		for (WorkOut wc : getWorkOuts()) {
			wc.setRandomExerciseForMusclesInEachMuscleGroup();
		}
	}

	public void sortMuscleExercisesInMuscleGroupsInEachWorkOut() {
		for (WorkOut wc : getWorkOuts()) {
			wc.sortMuscleGroupsExercisesBasedOnSet();
		}
	}

	public ArrayList<MuscleGroupWeeklyHitFrequencyPair> getCopyOf(ArrayList<MuscleGroupWeeklyHitFrequencyPair> source){
		ArrayList<MuscleGroupWeeklyHitFrequencyPair> destination = new ArrayList<MuscleGroupWeeklyHitFrequencyPair>();

		for(int i=0;i<getMuscleGroupsWeeklyHitFrequencyPairs().size();i++){
			destination.add(new MuscleGroupWeeklyHitFrequencyPair(getMuscleGroupsWeeklyHitFrequencyPairs().get(i).muscleGroup,
			getMuscleGroupsWeeklyHitFrequencyPairs().get(i).weeklyHitFrequencyHit));
		}

		return destination;
	}

	public void distributeTheMuscleGroupsInEachWorkOut(){
		ArrayList<MuscleGroupWeeklyHitFrequencyPair> copy = getCopyOf(getMuscleGroupsWeeklyHitFrequencyPairs());

		for(int i=0;i<copy.size();i++){
			addMuscleGroupInEachWorkOut(copy.get(i).muscleGroup,copy.get(i).weeklyHitFrequencyHit);
		}
	}

	public void addMuscleGroupInEachWorkOut(MuscleGroup muscleGroup, int weeklyHitFrequencyHit){
		int workOutIndex = 0;
		while(weeklyHitFrequencyHit > 0 && workOutIndex < getNumberOfWorkOuts()){
			addMuscleGroupToWorkOut(workOutIndex, muscleGroup);
			weeklyHitFrequencyHit -= 1;
			workOutIndex += 1;
		}
	}

	private void addMuscleGroupToWorkOut(int workOutIndex, MuscleGroup muscleGroup) {
		workOuts.get(workOutIndex).addMuscleGroupToMuscleGroupsToWorkOut(
				new MuscleGroup(
						muscleGroup.getMuscleGroupName(), muscleGroup.getMuscleGroupPriority(), 0,
						muscleGroup.getMuscles()));
	}

	public void addMuscleGroupAndHitFrequencyToMuscleGroupsWeeklyHitFrequencyPairs(MuscleGroup mc,
			int weeklyHitFrequencyHit) {
		// TODO: weeklyHitFrequencyHit can't be greater than weekSize
		if (weeklyHitFrequencyHit >= numberOfWorkOuts || weeklyHitFrequencyHit <= 0) {
			throw new ArrayIndexOutOfBoundsException("weeklyHitFrequencyHit >= sizeOfWeek or <= 0");
		} else {
			muscleGroupsWeeklyHitFrequencyPairs.add(
					new MuscleGroupWeeklyHitFrequencyPair(new MuscleGroup(mc), weeklyHitFrequencyHit));
		}
	}

	public void initializeMuscleGroupsWeeklyHitFrequencyPairs() {
		muscleGroupsWeeklyHitFrequencyPairs = new ArrayList<MuscleGroupWeeklyHitFrequencyPair>();
	}

	public void setMuscleGroupsWeeklyHitFrequencyPairsDeep(ArrayList<MuscleGroupWeeklyHitFrequencyPair> src) {
		for (MuscleGroupWeeklyHitFrequencyPair value : src) {
			muscleGroupsWeeklyHitFrequencyPairs.add(value);
		}
	}

	public ArrayList<MuscleGroupWeeklyHitFrequencyPair> getMuscleGroupsWeeklyHitFrequencyPairs() {
		return muscleGroupsWeeklyHitFrequencyPairs;
	}

	public void showMuscleGroupsWeeklyHitFrequencyPairs() {
		System.out.println("Show muscleGroup weekly hit frequency");
		for (MuscleGroupWeeklyHitFrequencyPair value : getMuscleGroupsWeeklyHitFrequencyPairs()) {
			System.out.printf("MuscleGroup: %s weekly hit frequency: %d\n", value.muscleGroup,
					value.weeklyHitFrequencyHit);
		}
	}

	public ArrayList<WorkOut> getWorkOuts() {
		return workOuts;
	}

	public void setWorkOutsDeep(ArrayList<WorkOut> src) {
		for (WorkOut wc : src) {
			workOuts.add(wc);
		}
	}

	public int getNumberOfWorkOuts() {
		return numberOfWorkOuts;
	}

	public void setNumberOfWorkOuts(int sizeOfTheWeek) {
		this.numberOfWorkOuts = sizeOfTheWeek;
	}

	@Override
	public String toString() {
		return numberOfWorkOuts + " " +
				muscleGroupsWeeklyHitFrequencyPairs + " " +
				workOuts;
	}

	public void setRandomlyMusclesToWorkOutInMuscleGroupsBasedOnMuscleGroupNumberOfExerciseInEachWorkOut() {
		for (int i = 0; i < getNumberOfWorkOuts(); i++) {
			getWorkOuts().get(i).setRandomMusclesToTrainForEachMuscleGroupBasedOnMuscleGroupExerciseNumber();
		}
	}

	public void setThePriorityOfTheMusclesForEachMuscleGroupWeeklyHitFrequencyPair() {
		for (MuscleGroupWeeklyHitFrequencyPair obj : getMuscleGroupsWeeklyHitFrequencyPairs()) {
			obj.muscleGroup.setThePriorityOfAllMusclesBasedOnWhenTheyWasAdded();
		}
	}

	public void setRandomNumberOfExerciseForMuscleGroupsBasedOnMuscleGroupPriority() {
		for (int i = 0; i < getNumberOfWorkOuts(); i++) {
			ArrayList<Integer> numberOfExercise = getWorkOuts().get(i).pickRandomExerciseNumberForEachMuscleGroup();

			getWorkOuts().get(i).setExerciseNumberOfMuscleGroupBasedOnMuscleGroupPriorit(numberOfExercise);
		}
	}

	public void sortMusclesInMuscleGroupsInEachWorkOut() {
		for (int i = 0; i < numberOfWorkOuts; i++) {
			getWorkOuts().get(i).sortMusclesInMuscleGroup();
		}
	}

	public void count() {
		for (MuscleGroupWeeklyHitFrequencyPair obj : getMuscleGroupsWeeklyHitFrequencyPairs()) {
			System.out.println(obj.muscleGroup);
		}
	}

	public void chaneTheMuscleGroupMusclesStructureForEachWorkOutBasedOnMusclePriority() {
		int workOutNmber = 0;
		for (WorkOut wc : getWorkOuts()) {
			// System.out.println("WorkOut" + workOutNmber);
			wc.countMusclesOccurancesFromEachMuscleGroupAndChangeMuscleGroupMuscleStructure(MuscleGroupUtil.muscleGroups);
			workOutNmber += 1;
		}

	}

	public void show() {
		System.out.println("Size of the Week: " + getNumberOfWorkOuts());
		for (WorkOut wc : getWorkOuts()) {
			wc.show();
			System.out.println();
		}
	}

}
