package WORKOUTPLAN.Model.WorkoutPlan.Workouts;

import java.util.ArrayList;
import java.util.List;

public class ShoulderWorkout implements MuscleWorkout{
    private List<Workout> workouts = new ArrayList<>();

    public ShoulderWorkout(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public void addWorkout(Workout workout)
    {
        workouts.add(workout);
    }

    public void removeWorkout(Workout workout)
    {
        workouts.remove(workout);
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Workout w: workouts)
            s.append(w.toString());
        return "ShoulderWorkout\n------------------------------\n"+s;
    }
}
