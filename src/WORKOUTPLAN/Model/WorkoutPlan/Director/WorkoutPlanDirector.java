package WORKOUTPLAN.Model.WorkoutPlan.Director;

import WORKOUTPLAN.Model.WorkoutPlan.Builder.WorkoutPlanBuilder;
import WORKOUTPLAN.Model.WorkoutPlan.WorkoutPlans.WorkoutPlan;

import java.io.IOException;

public class WorkoutPlanDirector {
    private WorkoutPlanBuilder workoutPlanBuilder;

    public void setWorkoutPlanBuilder(WorkoutPlanBuilder workoutPlanBuilder)
    {
        this.workoutPlanBuilder = workoutPlanBuilder;
    }

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlanBuilder.getWorkoutPlan();
    }

    public void ConstructWorkoutPlan() throws IOException {
        workoutPlanBuilder.CreateWorkoutPlan();
        workoutPlanBuilder.buildShoulderWorkout();
        workoutPlanBuilder.buildLegsWorkout();
        workoutPlanBuilder.buildArmsWorkout();
        workoutPlanBuilder.buildChestWorkout();
        workoutPlanBuilder.buildBackWorkout();
    }
}
