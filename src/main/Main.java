package main;

import workout.WeeklyWorkOut;
import workout.WeeklyWorkOutUtil;

public class Main {

	public static void main(String[] args) {
		WeeklyWorkOut weeklyWorkOut = new WeeklyWorkOut(8);
		//maky weeklyWorkOut.genegenerateWeeklyWorkOut(){WeeklyWorkOutUtil.generatWorkOut(this)}
		WeeklyWorkOutUtil.generateWeeklyWorkOut(weeklyWorkOut);
		// weeklyWorkOut.show();
		System.out.println(weeklyWorkOut);

	}
}
