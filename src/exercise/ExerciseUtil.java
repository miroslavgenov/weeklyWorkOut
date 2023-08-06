package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import muscles.Muscle;

public class ExerciseUtil {
    private ExerciseUtil(){}

    public static Exercise randomlyBuildExercise(Muscle muscle){
        Exercise exercise = new Exercise();

        exercise.setExerciseName(muscle.getMuscleExerciseLoader().getExerciseNames().get(new Random().nextInt(0, muscle.getTheSizeOfTheLoadedExercises())));
        exercise.setExerciseSet(new Random().nextInt(1,4));

        ArrayList<Integer> reps = new ArrayList<Integer>();

        for(int i=0;i<exercise.getExerciseSet();i++){
            int rep = new Random().nextInt(6,13);
            reps.add(rep);
        }

        // Collections.sort(reps);
        
        
        exercise.setExerciseReps(reps);

        return exercise;
    }
}
