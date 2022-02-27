package WORKOUTPLAN.Model.WorkoutPlan.WorkoutPlans;

import WORKOUTPLAN.Model.WorkoutPlan.Workouts.*;

public class WorkoutPlan {
    private ChestWorkout chestWorkout;
    private ShoulderWorkout shoulderWorkout;
    private ArmsWorkout armsWorkout;
    private BackWorkout backWorkout;
    private LegsWorkout legsWorkout;


    public void setChestWorkout(ChestWorkout chestWorkout) {
        this.chestWorkout = chestWorkout;
    }

    public void setShoulderWorkout(ShoulderWorkout shoulderWorkout) {
        this.shoulderWorkout = shoulderWorkout;
    }

    public void setArmsWorkout(ArmsWorkout armsWorkout) {
        this.armsWorkout = armsWorkout;
    }

    public void setBackWorkout(BackWorkout backWorkout) {
        this.backWorkout = backWorkout;
    }

    public void setLegsWorkout(LegsWorkout legsWorkout) {
        this.legsWorkout = legsWorkout;
    }

    public ChestWorkout getChestWorkout() {
        return chestWorkout;
    }

    public ShoulderWorkout getShoulderWorkout() {
        return shoulderWorkout;
    }

    public ArmsWorkout getArmsWorkout() {
        return armsWorkout;
    }

    public BackWorkout getBackWorkout() {
        return backWorkout;
    }

    public LegsWorkout getLegsWorkout() {
        return legsWorkout;
    }

    @Override
    public String toString() {
        return "WorkoutPlan\n" +
                "------------"+
                "\n" + chestWorkout +
                "\n" + shoulderWorkout +
                "\n" + armsWorkout +
                "\n" + backWorkout +
                "\n" + legsWorkout;
    }
}
