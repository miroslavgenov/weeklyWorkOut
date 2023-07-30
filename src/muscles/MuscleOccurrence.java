package muscles;

import java.util.ArrayList;

import muscles.MuscleGroupUtil;

public class MuscleOccurrence {
    ArrayList<MuscleGroup> ethalonMuscleGroups = MuscleGroupUtil.muscleGroups;
    int targetEthalonMuscleGroupIndex;
    ArrayList<Integer> muscleOccurrence;
    ArrayList<Muscle> ethalonMuscles;
    MuscleGroup muscleGroup;
    ArrayList<Muscle> muscles;
    ArrayList<MuscleGroup> muscleGroups;

    public ArrayList<Integer> getMuscleOccurrence(){
        return muscleOccurrence;
    }

    public MuscleOccurrence(){
        this.muscles = new ArrayList<Muscle>();

    }


    public MuscleOccurrence(MuscleGroup muscleGroup){


    }

    public MuscleOccurrence(ArrayList<Muscle> muscles){
        this.muscles = muscles;
        targetEthalonMuscleGroupIndex = findTheMuscleGroupBasedOnMuscleName(this.muscles.get(0).getMuscleName());        
        setEthalonMuscles(targetEthalonMuscleGroupIndex);
    }

    public void setEthalonMuscles(int targetEthalonMuscleGroupIndex){
        ethalonMuscles = ethalonMuscleGroups.get(targetEthalonMuscleGroupIndex).getMuscles();
    }

    public ArrayList<Integer> countMuscles(){
        muscleOccurrence = new ArrayList<Integer>();

        for(int i=0;i<ethalonMuscles.size();i++){
            muscleOccurrence.add(countMuscle(ethalonMuscles.get(i).getMuscleName()));
        }
        return muscleOccurrence;
    }

    private int countMuscle(String muscleName){
        int count=0;
        for(int i=0;i<muscles.size();i++){
            if(muscleName == muscles.get(i).getMuscleName()){
                count+=1;
            }
        }
        return count;
    }

    public int findTheMuscleGroupBasedOnMuscleName(String muscleName){
        for(int i=0;i<ethalonMuscleGroups.size();i++){
            if(isMuscleIn(muscleName, ethalonMuscleGroups.get(i).getMuscles())){
                return i;
            }
        }
        return -1;
    }

    public boolean isMuscleIn(String muscleName, ArrayList<Muscle> muscles){
        for(int i=0;i<muscles.size();i++){
            if(muscleName == muscles.get(i).getMuscleName()){
                return true;
            }
        }
        return false;
    }

    public int findEthalonMuscleGroupIndexBasedOnMuscleGroupName(String muscleGroupName) {
        for(int i=0;i<ethalonMuscleGroups.size();i++){
            if(ethalonMuscleGroups.get(i).getMuscleGroupName() == muscleGroupName){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<ArrayList<Integer>> countMusclesForEachMuscleGroup(ArrayList<MuscleGroup> muscleGroups) {
        System.out.println("countMusclesForEachMuscleGroup");
        
        ArrayList<ArrayList<Integer>> musclesCountedFromEachMuscleGroup = new ArrayList<ArrayList<Integer>>();
        

        this.muscleGroups = muscleGroups;


        for(int i=0;i<muscleGroups.size();i++){
            targetEthalonMuscleGroupIndex = findEthalonMuscleGroupIndexBasedOnMuscleGroupName(muscleGroups.get(i).getMuscleGroupName());
            this.ethalonMuscles = ethalonMuscleGroups.get(targetEthalonMuscleGroupIndex).getMuscles();
            this.muscles = new ArrayList<Muscle>();
            this.muscles = muscleGroups.get(i).getMuscles();
            musclesCountedFromEachMuscleGroup.add(countMuscles());
            // System.out.println(countMuscles());
        }

        return musclesCountedFromEachMuscleGroup;

    }

}
