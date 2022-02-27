package WORKOUTPLAN.View;

import WORKOUTPLAN.Model.WorkoutPlan.Workouts.Workout;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cell extends ListCell<Workout>{
    VBox vBox = new VBox();
    Label lbl_workout_name = new Label();
    ImageView imgView_workout = new ImageView();

    public Cell() {
        super();
        vBox.getChildren().addAll(lbl_workout_name,imgView_workout);
    }

    public void updateItem(Workout workout, boolean empty){
        super.updateItem(workout,empty);
        setText(null);
        setGraphic(null);

        if(workout!=null && !empty)
        {
            lbl_workout_name.setText(workout.getName());
            FileInputStream input;
            try {

                input = new FileInputStream("src/WORKOUTPLAN/View/Images/"+workout.getImage());
                Image image = new Image(input,110,150,true,true);
                imgView_workout.setImage(image);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            setGraphic(vBox);
        }
    }
}
