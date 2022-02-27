package WORKOUTPLAN.Model.WorkoutPlan.WorkoutPlans;

import WORKOUTPLAN.Controller.Controller;
import WORKOUTPLAN.Model.WorkoutPlan.Builder.WorkoutPlanBuilder;
import WORKOUTPLAN.Model.WorkoutPlan.Workouts.*;

import java.io.IOException;

public class MuscleGainWorkoutPlan extends WorkoutPlanBuilder {
    private static final Controller controller = new Controller();

    @Override
    public void buildChestWorkout() throws IOException {
        workoutPlan.setChestWorkout(new ChestWorkout(controller.getWorkouts_from_file("src/WORKOUTPLAN/Model/WorkoutPlan/Workouts/chestWorkout.txt")));
        System.out.println("Create ChestWorkout Plan");
    }

    @Override
    public void buildShoulderWorkout() throws IOException {
        workoutPlan.setShoulderWorkout(new ShoulderWorkout(controller.getWorkouts_from_file("src/WORKOUTPLAN/Model/WorkoutPlan/Workouts/shoulderWorkout.txt")));
        System.out.println("Create ShoulderWorkout Plan");
    }

    @Override
    public void buildBackWorkout() throws IOException {
        workoutPlan.setBackWorkout(new BackWorkout(controller.getWorkouts_from_file("src/WORKOUTPLAN/Model/WorkoutPlan/Workouts/backWorkout.txt")));
        System.out.println("Create BackWorkout Plan");
    }

    @Override
    public void buildArmsWorkout() throws IOException {
        workoutPlan.setArmsWorkout(new ArmsWorkout(controller.getWorkouts_from_file("src/WORKOUTPLAN/Model/WorkoutPlan/Workouts/armsWorkout.txt")));
        System.out.println("Create ArmsWorkout Plan");
    }

    @Override
    public void buildLegsWorkout() throws IOException {
        workoutPlan.setLegsWorkout(new LegsWorkout(controller.getWorkouts_from_file("src/WORKOUTPLAN/Model/WorkoutPlan/Workouts/legsWorkout.txt")));
        System.out.println("Create LegsWorkout Plan");
    }
}
