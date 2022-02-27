package WORKOUTPLAN.Model.WorkoutPlan.Builder;

import WORKOUTPLAN.Model.WorkoutPlan.WorkoutPlans.WorkoutPlan;

import java.io.IOException;

abstract public class WorkoutPlanBuilder {
    protected WorkoutPlan workoutPlan;

    public WorkoutPlan getWorkoutPlan()
    {
        return this.workoutPlan;
    }

    public void CreateWorkoutPlan()
    {
        workoutPlan = new WorkoutPlan();
    }

    public  abstract  void buildChestWorkout() throws IOException;
    public abstract  void buildShoulderWorkout() throws IOException;
    public abstract  void buildBackWorkout() throws IOException;
    public  abstract  void buildArmsWorkout() throws IOException;
    public  abstract  void buildLegsWorkout() throws IOException;
}
