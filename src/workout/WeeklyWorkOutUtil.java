package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import muscles.MuscleGroupUtil;

public class WeeklyWorkOutUtil {
    
    WeeklyWorkOutUtil(){}
    
    static ArrayList<Integer> pickHowMuchEachMuscleGroupToBeHitDuringTheWeekAndSortDESC(int muscleGroupSize, int weeklyWorkOutSize){
        ArrayList<Integer> x = pickHowMuchEachMuscleGroupToBeHitDuringTheWeek(muscleGroupSize, weeklyWorkOutSize);
        sortTheHitFrequencyDESC(x);

        return x;
    }

    static void sortTheHitFrequencyDESC(ArrayList<Integer> hitFrequency){
        Collections.sort(hitFrequency,(o1, o2) -> o2 - o1);
    }

    static ArrayList<Integer> pickHowMuchEachMuscleGroupToBeHitDuringTheWeek(int muscleGroupSize, int weeklyWorkOutSize){
		ArrayList<Integer> x = new ArrayList<Integer>();
		int muscleHitDuringTheWeek;

		for(int i = 0; i < muscleGroupSize; i++){
			muscleHitDuringTheWeek = new Random().nextInt(1,weeklyWorkOutSize);
			x.add(muscleHitDuringTheWeek);
		}

		return x;
	}

    static void addEachMuscleGroupAndHitFrequency(ArrayList<Integer> hitFrequency, WeeklyWorkOut weeklyWorkOut) {
        for(int i = 0; i < MuscleGroupUtil.muscleGroups.size(); i++){
            weeklyWorkOut.addMuscleGroupAndHitFrequencyToMuscleGroupsWeeklyHitFrequencyPairs(MuscleGroupUtil.muscleGroups.get(i), hitFrequency.get(i));
        }
    }

    public static void generateWeeklyWorkOut(WeeklyWorkOut weeklyWorkOut) {

        ArrayList<Integer> hitFrequency = WeeklyWorkOutUtil.pickHowMuchEachMuscleGroupToBeHitDuringTheWeekAndSortDESC(MuscleGroupUtil.muscleGroups.size() , weeklyWorkOut.getNumberOfWorkOuts());
				
		WeeklyWorkOutUtil.addEachMuscleGroupAndHitFrequency(hitFrequency, weeklyWorkOut);

		weeklyWorkOut.setThePriorityOfTheMusclesForEachMuscleGroupWeeklyHitFrequencyPair();
		weeklyWorkOut.distributeTheMuscleGroupsInEachWorkOut();
		weeklyWorkOut.setRandomNumberOfExerciseForMuscleGroupsBasedOnMuscleGroupPriority();
		weeklyWorkOut.setRandomlyMusclesToWorkOutInMuscleGroupsBasedOnMuscleGroupNumberOfExerciseInEachWorkOut();
		weeklyWorkOut.sortMusclesInMuscleGroupsInEachWorkOut();
		weeklyWorkOut.chaneTheMuscleGroupMusclesStructureForEachWorkOutBasedOnMusclePriority();
		weeklyWorkOut.setRandomExerciseForMusclesInMuscleGroupsInEachWorkOut();
		weeklyWorkOut.sortMuscleExercisesInMuscleGroupsInEachWorkOut();
    }
}