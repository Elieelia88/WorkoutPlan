package WORKOUTPLAN.Controller;

import WORKOUTPLAN.Model.WorkoutPlan.Workouts.Workout;
import WORKOUTPLAN.Model.model.Model;
import WORKOUTPLAN.View.View.View;
import javafx.scene.control.TableView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private static final Model model = new Model();
    private static final View view = new View();

    public void AddNewWorkout(String Table_Name,String[] NewWorkoutInfo)
    {
        model.insert(Table_Name,NewWorkoutInfo);
    }

    public void DeleteWorkout(String Table_Name, int ID)
    {
        model.delete(Table_Name,String.valueOf(ID));
    }

    public void UpdateWorkout(String Table_Name, String[] columnNames, String[] UpdateWorkoutInfo, int ID)
    {
        model.update(Table_Name,columnNames,UpdateWorkoutInfo,String.valueOf(ID));
    }

    public List<Workout> getWorkouts(String Table_Name,String[] columnNames, String Where)
    {
        List<List<String>> result;
        result = model.select(Table_Name,columnNames,Where);
        return view.workouts(result);
    }

    public Workout getWorkout(String Table, int Id)
    {
        List<List<String>> result;
        result = model.getWorkout("workout",String.valueOf(Id));

        if(result == null)
            return null;

        return new Workout(result.get(0).get(0),result.get(0).get(1),result.get(0).get(2),result.get(0).get(3),
                result.get(0).get(4),result.get(0).get(5));
    }


    public List<Workout> getWorkouts_from_file(String FilePath) throws IOException {

        List<Workout> workouts = new ArrayList<>();

        FileInputStream fis=new FileInputStream(FilePath);
        Scanner sc=new Scanner(fis);

        while(sc.hasNextLine())
        {
            workouts.add(getWorkout("workout",Integer.parseInt(sc.nextLine())));
        }

        sc.close();
        return workouts;
    }

    public TableView getWorkoutsTable()
    {
        List<List<String>> result;
        result = model.select("workout",null,null);
        return view.tableWorkouts(result);
    }
}
