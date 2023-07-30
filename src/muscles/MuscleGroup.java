package muscles;

import java.util.ArrayList;

import exercise.Exercise;

public class MuscleGroup {



    String muscleGroupName;
    int muscleGroupPriority;
    int muscleGroupNumberOfExercises;
    public ArrayList<Muscle> muscles;

    public int getMuscleGroupSize(){
        return muscles.size();
    }

    public void initializeMuscles(){
        muscles = new ArrayList<Muscle>();
    }

    public MuscleGroup(String muscleGroupName, int muscleGroupPriority){
        this(muscleGroupName, muscleGroupPriority, 0,new ArrayList<Muscle>());
    }
    
    public MuscleGroup(String muscleGroupName){
        this(muscleGroupName, 0, 0,new ArrayList<Muscle>());
    }
    
    public MuscleGroup(MuscleGroup copy){
        this(copy.muscleGroupName, copy.muscleGroupPriority, copy.muscleGroupNumberOfExercises,copy.muscles);
    }

    public MuscleGroup(String muscleGroupName, int muscleGroupPriority, int muscleGroupNumberOfExercises, ArrayList<Muscle> muscles){
        this.muscleGroupName = muscleGroupName;
        this.muscleGroupPriority = muscleGroupPriority;
        this.muscleGroupNumberOfExercises = muscleGroupNumberOfExercises;
        this.muscles = new ArrayList<Muscle>();
        
        for(Muscle mc : muscles) {
            this.muscles.add(new Muscle(mc));
        }
    }
    
    public MuscleGroup(String muscleGroupName, ArrayList<Muscle> muscles) {
        this(muscleGroupName,0,0,muscles);
    }

    public MuscleGroup(String muscleGroupName, int muscleGroupPriority, ArrayList<Muscle> muscles) {
        this(muscleGroupName, muscleGroupPriority, 0 , muscles);
    }

    public void setMuscleGroupPriority(int priorityValue){
        muscleGroupPriority = priorityValue;
    }
    
    public int getMuscleGroupPriority(){
        return muscleGroupPriority;
    }
    
    public void setMuscleGroupName(String sourceMuscleGroupName){
        muscleGroupName = sourceMuscleGroupName;
    }
    
    public String getMuscleGroupName(){
        return muscleGroupName;
    }

    public int incrementMuscleGroupNumberOfExercise(){
        setMuscleGroupNumberOfExercises(getMuscleGroupNumberOfExercises()+1);
        return getMuscleGroupNumberOfExercises();
    }
    
    public void setMuscleGroupNumberOfExercises(int source){
        muscleGroupNumberOfExercises = source;
    }

    public int getMuscleGroupNumberOfExercises(){
        return muscleGroupNumberOfExercises;
    }

    public void show(){
        System.out.printf("MucleGroupName: %s, muscleGroupPriority: %d, muscleGroupNumberOfExercise: %d\n",getMuscleGroupName(),getMuscleGroupPriority(),getMuscleGroupNumberOfExercises());
        for(Muscle mc :this.muscles){
            mc.show();
            System.out.println();
        }
    }

    public void showMuscles(){
        System.out.println(muscles);
    }

    public void showMusclesPriority() {
        for(Muscle mc : muscles){
            System.out.println(mc.getMusclePriority());
        }
    }
    

    public void setThePriorityOfAllMusclesBasedOnWhenTheyWasAdded(){
        for(int musclePriority = 0, index = 0; index < muscles.size(); musclePriority++, index++){
            muscles.get(index).setMusclePriority(musclePriority);
        }
    }

    @Override
    public String toString(){
        return muscleGroupName + " " +
        muscleGroupPriority + " " +
        muscleGroupNumberOfExercises + " " +
        muscles ;   
    }

    public void addMuscles(ArrayList<Muscle> musclesToTrain) {
        for(int i=0;i<musclesToTrain.size();i++){
            muscles.add(new Muscle(musclesToTrain.get(i).getMuscleName(),musclesToTrain.get(i).getMusclePriority(),musclesToTrain.get(i).getMuscleExercise()));
        }
    }

    public ArrayList<Muscle> getMuscles() {
        return this.muscles;
    }

    public void addMuscle(Muscle muscle) {
        muscles.add(new Muscle(muscle.getMuscleName(),muscle.getMusclePriority(),muscle.getMuscleExercise()));
    }

    public void setExerciseSetAndRepsForMuscle(Exercise exercise, int muscleIndex) {
        getMuscles().get(muscleIndex).muscleExercise.setExerciseSet(exercise.getExerciseSet());
        getMuscles().get(muscleIndex).muscleExercise.setExerciseReps(exercise.getExerciseReps());
    }

    public ArrayList<Exercise> getAllExercises() {
        ArrayList<Exercise> muscleGroupExercises = new ArrayList<Exercise>();

        for(int i=0;i<getMuscleGroupSize();i++){
            Muscle mc = getMuscles().get(i);
            muscleGroupExercises.add(new Exercise(mc.muscleExercise.getExerciseName(),mc.muscleExercise.getExerciseSet(),mc.muscleExercise.getExerciseReps()));
        }

        return muscleGroupExercises;
    }
}
