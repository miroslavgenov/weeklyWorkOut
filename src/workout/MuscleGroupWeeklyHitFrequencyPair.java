package workout;

import muscles.MuscleGroup;

public class MuscleGroupWeeklyHitFrequencyPair {
	public MuscleGroup muscleGroup;
	public int weeklyHitFrequencyHit;

	public MuscleGroupWeeklyHitFrequencyPair(MuscleGroup muscleGroup){
		this(muscleGroup, 1);
	}
	
	public MuscleGroupWeeklyHitFrequencyPair(MuscleGroupWeeklyHitFrequencyPair copy){
		this(copy.muscleGroup,copy.weeklyHitFrequencyHit);
	}

	public MuscleGroupWeeklyHitFrequencyPair(MuscleGroup muscleGroup, int weeklyHitFrequencyHit){
		
		this.muscleGroup = new MuscleGroup(muscleGroup);
		
		//maybe this throw must be in the set ?
		if(weeklyHitFrequencyHit <= 0 ){
			throw new ArrayIndexOutOfBoundsException("weeklyHitFrequencyHit can't be zero");
		}else{

			this.weeklyHitFrequencyHit = weeklyHitFrequencyHit;
		}
	}

	@Override
	public String toString(){
		return weeklyHitFrequencyHit + " " +
		muscleGroup;
	}
}
