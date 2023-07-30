package workout;

import java.util.ArrayList;
import java.util.Collections;

import muscles.MuscleGroup;

public final class WorkOutUtil {
	private WorkOutUtil() {
	}

	

	public static void initializeMuscleGroupsToWorkOut(WorkOut wc) {
		wc.muscleGroupsToWorkOut = new ArrayList<MuscleGroup>();

	}

	public static void copyValueFromSourceToDestination(ArrayList<MuscleGroup> source,
			WorkOut wc) {
		for (int i = 0; i < source.size(); i++) {
			wc.muscleGroupsToWorkOut.add(source.get(i));
		}
	}

	public static ArrayList<Integer> getMuscleGroupsExerciseNumberInDESC(
			ArrayList<Integer> muscleGroupsExerciseNumber) {
		ArrayList<Integer> exerciseNum = new ArrayList<Integer>();
		for (Integer exNumber : muscleGroupsExerciseNumber) {
			exerciseNum.add(exNumber);
		}

		Collections.sort(exerciseNum);
		Collections.reverse(exerciseNum);

		return exerciseNum;
	}

}
