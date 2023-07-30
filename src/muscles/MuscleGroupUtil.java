package muscles;

import java.util.ArrayList;
import java.util.Arrays;



public class MuscleGroupUtil {

        public static final String SHOULDER_MUSCLE_GROUP_NAME = "Shoulder";
        public static final String BACK_MUSCLE_GROUP_NAME = "Back";
        public static final String GLUTE_MUSCLE_GROUP_NAME = "Glute";
        public static final String LEG_MUSCLE_GROUP_NAME = "Leg";
        public static final String ABS_MUSCLE_GROUP_NAME = "Abs";
        public static final String CHEST_MUSCLE_GROUP_NAME = "Chest";
        public static final String ARMS_MUSCLE_GROUP_NAME = "Arms";
        public static final String CARDIO_MUSCLE_GROUP_NAME = "Cardio";
        public static final String NECK_MUSCLE_GROUP_NAME = "Neck";

        public static final String[] componentsOfShoulder = new String[] { "sideDeltoid", "rearDeltoid",
                        "frontDeltoid" };
        public static final String[] componentsOfBack = new String[] { "lats", "middleBack", "lowerBack", "trap" };
        public static final String[] componentsOfGlute = new String[] { "gluteusMaximus", "gluteusMedius",
                        "gluteusMinimus" };
        public static final String[] componentsOfLegs = new String[] { "quadriceps", "hamstring", "calve", "adductor" };
        public static final String[] componentsOfAbs = new String[] { "abdominal" };
        public static final String[] componentsOfChest = new String[] { "inclineChest", "normalChest", "lowerChest" };
        public static final String[] componentsOfArms = new String[] { "triceps", "biceps", "forearm" };
        public static final String[] componentsOfCardio = new String[] { "cardio" };
        public static final String[] componentsOfNeck = new String[] { "fronSideRearNeck" };

        public static final MuscleGroup shouldersMuscleGroup = MuscleGroupUtil.createMuscleGroupWithMuscles(
                        MuscleGroupUtil.SHOULDER_MUSCLE_GROUP_NAME, 0, MuscleUtil.createMuscles(componentsOfShoulder));
        public static final MuscleGroup backMuscleGroup = MuscleGroupUtil.createMuscleGroupWithMuscles(
                        MuscleGroupUtil.BACK_MUSCLE_GROUP_NAME, 1, MuscleUtil.createMuscles(componentsOfBack));
        public static final MuscleGroup gluteMuscleGroup = MuscleGroupUtil.createMuscleGroupWithMuscles(
                        MuscleGroupUtil.GLUTE_MUSCLE_GROUP_NAME, 2, MuscleUtil.createMuscles(componentsOfGlute));
        public static final MuscleGroup legsMuscleGroup = MuscleGroupUtil.createMuscleGroupWithMuscles(
                        MuscleGroupUtil.LEG_MUSCLE_GROUP_NAME, 3, MuscleUtil.createMuscles(componentsOfLegs));
        public static final MuscleGroup absMuscleGroup = MuscleGroupUtil.createMuscleGroupWithMuscles(
                        MuscleGroupUtil.ABS_MUSCLE_GROUP_NAME, 4, MuscleUtil.createMuscles(componentsOfAbs));
        public static final MuscleGroup chestMuscleGroup = MuscleGroupUtil.createMuscleGroupWithMuscles(
                        MuscleGroupUtil.CHEST_MUSCLE_GROUP_NAME, 5, MuscleUtil.createMuscles(componentsOfChest));
        public static final MuscleGroup armsMuscleGroup = MuscleGroupUtil.createMuscleGroupWithMuscles(
                        MuscleGroupUtil.ARMS_MUSCLE_GROUP_NAME, 6, MuscleUtil.createMuscles(componentsOfArms));
        public static final MuscleGroup cardioMuscleGroup = MuscleGroupUtil.createMuscleGroupWithMuscles(
                        MuscleGroupUtil.CARDIO_MUSCLE_GROUP_NAME, 7, MuscleUtil.createMuscles(componentsOfCardio));
        public static final MuscleGroup neckMuscleGroup = MuscleGroupUtil.createMuscleGroupWithMuscles(
                        MuscleGroupUtil.NECK_MUSCLE_GROUP_NAME, 8, MuscleUtil.createMuscles(componentsOfNeck));

        public static final ArrayList<MuscleGroup> muscleGroups = new ArrayList<MuscleGroup>(
                        Arrays.asList(
                                        shouldersMuscleGroup,
                                        backMuscleGroup,
                                        gluteMuscleGroup,
                                        legsMuscleGroup,
                                        absMuscleGroup,
                                        chestMuscleGroup,
                                        armsMuscleGroup,
                                        cardioMuscleGroup,
                                        neckMuscleGroup));

        private MuscleGroupUtil() {
        }

        public static int whichIsTheIndexOfTheMuscleGroup(String muscleGroupName) {
                for (int i = 0; i < muscleGroups.size(); i++) {
                        if (muscleGroupName == muscleGroups.get(i).getMuscleGroupName()) {
                                return i;
                        }
                }

                return -1;
        }

        public static MuscleGroup createMuscleGroupWithMuscles(String muscleGroupName, ArrayList<Muscle> muscles) {
                return new MuscleGroup(muscleGroupName, muscles);
        }

        public static MuscleGroup createMuscleGroupWithMuscles(String muscleGroupName, int muscleGroupPriority,
                        ArrayList<Muscle> muscles) {
                return new MuscleGroup(muscleGroupName, muscleGroupPriority, muscles);
        }

        public static ArrayList<Integer> countMuscles(MuscleGroup ethalonMuscleGroup ,MuscleGroup targetMuscleGroup){
                ArrayList<Integer> countedMuscles = new ArrayList<Integer>();

                for(int i=0; i < ethalonMuscleGroup.getMuscleGroupSize(); i++){
                        countedMuscles.add(0);

                        for(int j = 0; j< targetMuscleGroup.getMuscleGroupSize(); j++){
                                if( ethalonMuscleGroup.getMuscles().get(i).getMuscleName() == targetMuscleGroup.getMuscles().get(j).getMuscleName() ){
                                        int prevCount = countedMuscles.get(i);
                                        countedMuscles.set(i,prevCount);
                                }
                        }
                }

                return countedMuscles;
        }

        
}
