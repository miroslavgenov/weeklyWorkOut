package muscles;

import java.util.ArrayList;

public final class MuscleUtil {
    private MuscleUtil(){}

    public static ArrayList<Muscle> createMuscles(String[] muscleNames){
        ArrayList<Muscle> muscles = new ArrayList<Muscle>();
        for(String muscleName : muscleNames){
            muscles.add(new Muscle(muscleName));
        }

        return muscles;
    }
}
