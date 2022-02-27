package WORKOUTPLAN.View.View;

import WORKOUTPLAN.Model.WorkoutPlan.Workouts.Workout;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class View {
    public  List<Workout> workouts(List<List<String>> result) {
        List<Workout> workouts = new ArrayList<>();

        if(result != null)
        {
            for(List<String> rowInfo: result)
            {
                    workouts.add(new Workout(rowInfo.get(0),rowInfo.get(1),rowInfo.get(2),rowInfo.get(3),rowInfo.get(4),rowInfo.get(5)));
            }
        }
        return workouts;
    }

    public TableView tableWorkouts(List<List<String>> result)
    {
        String[] ColumnNames = {"wid", "name", "muscle", "type", "image", "premium"};
        TableView<Workout> table = new TableView<>();

        for(String col : ColumnNames)
        {
            TableColumn<Workout,String> Column = new TableColumn<>(col);
            Column.setCellValueFactory(new PropertyValueFactory<>(col));
            table.getColumns().add(Column);
        }
        if(result.size() != 0) {
            for (List<String> resultRow : result) {
                table.getItems().add(new Workout(resultRow.get(0), resultRow.get(1), resultRow.get(2),
                        resultRow.get(3), resultRow.get(4),resultRow.get(5)));
            }
        }
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return table;
    }
}
