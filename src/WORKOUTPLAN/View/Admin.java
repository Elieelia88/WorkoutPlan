package WORKOUTPLAN.View;

import WORKOUTPLAN.Controller.Controller;
import WORKOUTPLAN.Model.WorkoutPlan.Workouts.Workout;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Admin extends Application {
    private static final Controller controller = new Controller();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Add A workout
        // name,muscle,type,image,premium;

        Label lbl_workout_name_add = new Label("Name: ");
        TextField tf_workout_name_add = new TextField();

        String[] muscles_list = {"chest","back","arms","shoulder","legs"};
        Label lbl_workout_muscle_add = new Label("muscle: ");
        ComboBox<String> comboBox_workout_muscles = new ComboBox<>(FXCollections.observableArrayList(muscles_list));

        String[] types_list = {"muscle gain","weight loss"};
        Label lbl_workout_types_add = new Label("muscle: ");
        ComboBox<String> comboBox_workout_type = new ComboBox<>(FXCollections.observableArrayList(types_list));

        Label lbl_workout_image_add = new Label("image: ");
        TextField tf_workout_image_add = new TextField();

        CheckBox cb_premium = new CheckBox("premium");

        Button btn_workout_add = new Button("Add Workout");
        Label lbl_info_workout_Add = new Label();


        VBox vb_workout_add = new VBox(10);
        vb_workout_add.setPadding(new Insets(20));
        vb_workout_add.getChildren().addAll(lbl_workout_name_add,tf_workout_name_add,
                                            lbl_workout_muscle_add,comboBox_workout_muscles,
                                            lbl_workout_types_add,comboBox_workout_type,
                                            lbl_workout_image_add,tf_workout_image_add,
                                            cb_premium,btn_workout_add,lbl_info_workout_Add);

        // delete workout
        Label lbl_workout_Id_delete = new Label("enter Workout Id");
        TextField tf_workout_Id_delete = new TextField();
        Button btn_workout_delete = new Button("delete");
        Label lbl_info_workout_delete = new Label();

        VBox vb_workout_delete = new VBox(10);
        vb_workout_delete.setPadding(new Insets(20));
        vb_workout_delete.getChildren().addAll(lbl_workout_Id_delete,tf_workout_Id_delete,btn_workout_delete,lbl_info_workout_delete);


        // update workout
        Label lbl_workout_Id_update = new Label("enter Workout Id");
        TextField tf_workout_Id_update = new TextField();
        Button btn_workout_search_update = new Button("update");
        Label lbl_info_workout_search_update = new Label();

        Label lbl_workout_name_update = new Label("Name: ");
        TextField tf_workout_name_update = new TextField();

        Label lbl_workout_muscle_update = new Label("muscle: ");
        ComboBox<String> comboBox_workout_muscles_update = new ComboBox<>(FXCollections.observableArrayList(muscles_list));

        Label lbl_workout_types_update = new Label("muscle: ");
        ComboBox<String> comboBox_workout_type_update = new ComboBox<>(FXCollections.observableArrayList(types_list));

        Label lbl_workout_image_update = new Label("image: ");
        TextField tf_workout_image_update = new TextField();

        CheckBox cb_premium_update = new CheckBox("premium");

        Button btn_workout_update = new Button("update Workout");
        Label lbl_info_workout_update = new Label();

        lbl_workout_name_update.setVisible(false);
        tf_workout_name_update.setVisible(false);
        lbl_workout_muscle_update.setVisible(false);
        comboBox_workout_muscles_update.setVisible(false);
        lbl_workout_types_update.setVisible(false);
        comboBox_workout_type_update.setVisible(false);
        lbl_workout_image_update.setVisible(false);
        tf_workout_image_update.setVisible(false);
        cb_premium_update.setVisible(false);
        btn_workout_update.setVisible(false);
        lbl_info_workout_update.setVisible(false);


        VBox vb_workout_update = new VBox(10);
        vb_workout_update.setPadding(new Insets(20));
        vb_workout_update.getChildren().addAll(lbl_workout_Id_update,tf_workout_Id_update,
                btn_workout_search_update,lbl_info_workout_search_update,
                lbl_workout_name_update,tf_workout_name_update,
                lbl_workout_muscle_update,comboBox_workout_muscles_update,
                lbl_workout_types_update,comboBox_workout_type_update,
                lbl_workout_image_update,tf_workout_image_update,
                cb_premium_update,btn_workout_update,lbl_info_workout_update);

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(vb_workout_add,vb_workout_delete,vb_workout_update,controller.getWorkoutsTable());

        btn_workout_add.setOnAction(e->{

            tf_workout_Id_update.setText("");
            lbl_info_workout_search_update.setVisible(false);
            lbl_workout_name_update.setVisible(false);
            tf_workout_name_update.setVisible(false);
            lbl_workout_muscle_update.setVisible(false);
            comboBox_workout_muscles_update.setVisible(false);
            lbl_workout_types_update.setVisible(false);
            comboBox_workout_type_update.setVisible(false);
            lbl_workout_image_update.setVisible(false);
            tf_workout_image_update.setVisible(false);
            cb_premium_update.setVisible(false);
            btn_workout_update.setVisible(false);
            lbl_info_workout_update.setVisible(false);


            tf_workout_Id_delete.setText("");
            lbl_info_workout_delete.setVisible(false);


            if(tf_workout_name_add.getText().isEmpty() || tf_workout_image_add.getText().isEmpty()
               || comboBox_workout_muscles.getSelectionModel().isEmpty() || comboBox_workout_type.getSelectionModel().isEmpty())
            {
                lbl_info_workout_Add.setText("Invalid Input");
            }
            else
            {
                String name = tf_workout_name_add.getText();
                String type = types_list[comboBox_workout_type.getSelectionModel().getSelectedIndex()];
                String muscle = muscles_list[comboBox_workout_muscles.getSelectionModel().getSelectedIndex()];
                String image = tf_workout_image_add.getText();
                String pr = "0";

                if(cb_premium.isSelected())
                    pr = "1";

                controller.AddNewWorkout("workout",new String[]{name,muscle,type,image,pr});
                lbl_info_workout_Add.setText("Workout Added");

                hBox.getChildren().set(3,controller.getWorkoutsTable());
            }
            lbl_info_workout_Add.setVisible(true);
        });




        btn_workout_delete.setOnAction(e->{
            comboBox_workout_muscles.getSelectionModel().clearSelection();
            comboBox_workout_type.getSelectionModel().clearSelection();
            tf_workout_name_add.setText("");
            tf_workout_image_add.setText("");
            lbl_info_workout_Add.setVisible(false);


            tf_workout_Id_update.setText("");
            lbl_info_workout_search_update.setVisible(false);
            lbl_workout_name_update.setVisible(false);
            tf_workout_name_update.setVisible(false);
            lbl_workout_muscle_update.setVisible(false);
            comboBox_workout_muscles_update.setVisible(false);
            lbl_workout_types_update.setVisible(false);
            comboBox_workout_type_update.setVisible(false);
            lbl_workout_image_update.setVisible(false);
            tf_workout_image_update.setVisible(false);
            cb_premium_update.setVisible(false);
            btn_workout_update.setVisible(false);
            lbl_info_workout_update.setVisible(false);

            try {
                int Id = Integer.parseInt(tf_workout_Id_delete.getText());
                Workout workout = controller.getWorkout("workout",Id);

                if(workout != null)
                {
                    controller.DeleteWorkout("workout",Id);
                    lbl_info_workout_delete.setText("Workout "+Id+" deleted");
                    hBox.getChildren().set(3,controller.getWorkoutsTable());
                }
                else {
                    lbl_info_workout_delete.setText("Workout unavailable");
                }
                lbl_info_workout_delete.setVisible(true);
            }catch (NumberFormatException ex)
            {
                lbl_info_workout_delete.setText("Invalid Input");
                lbl_info_workout_delete.setVisible(true);
            }

        });





        btn_workout_search_update.setOnAction(e->{

            comboBox_workout_muscles.getSelectionModel().clearSelection();
            comboBox_workout_type.getSelectionModel().clearSelection();
            tf_workout_name_add.setText("");
            tf_workout_image_add.setText("");
            lbl_info_workout_Add.setVisible(false);


            tf_workout_Id_delete.setText("");
            lbl_info_workout_delete.setVisible(false);

            try {
                int Id = Integer.parseInt(tf_workout_Id_update.getText());
                Workout workout = controller.getWorkout("workout",Id);

                if(workout != null)
                {
                    lbl_info_workout_search_update.setVisible(false);

                    lbl_workout_name_update.setVisible(true);
                    tf_workout_name_update.setVisible(true);
                    tf_workout_name_update.setText(workout.getName());

                    lbl_workout_muscle_update.setVisible(true);
                    comboBox_workout_muscles_update.setVisible(true);

                    int i;
                    for(i =0; i < muscles_list.length; i++)
                    {
                        if(muscles_list[i].equals(workout.getMuscle().trim()))
                            break;
                    }
                    comboBox_workout_muscles_update.getSelectionModel().select(i);

                    lbl_workout_types_update.setVisible(true);
                    comboBox_workout_type_update.setVisible(true);

                    for(i =0; i < types_list.length; i++)
                    {
                        if(types_list[i].equals(workout.getType().trim()))
                            break;

                    }
                    comboBox_workout_type_update.getSelectionModel().select(i);


                    lbl_workout_image_update.setVisible(true);
                    tf_workout_image_update.setVisible(true);
                    tf_workout_image_update.setText(workout.getImage());


                    cb_premium_update.setVisible(true);
                    cb_premium_update.setSelected(Integer.parseInt(workout.getPremium()) > 0);

                    btn_workout_update.setVisible(true);
                    lbl_info_workout_update.setVisible(true);
                }
                else {
                    tf_workout_name_add.setText("");
                    tf_workout_image_add.setText("");
                    lbl_info_workout_Add.setVisible(false);


                    lbl_workout_name_update.setVisible(false);
                    tf_workout_name_update.setVisible(false);
                    lbl_workout_muscle_update.setVisible(false);
                    comboBox_workout_muscles_update.setVisible(false);
                    lbl_workout_types_update.setVisible(false);
                    comboBox_workout_type_update.setVisible(false);
                    lbl_workout_image_update.setVisible(false);
                    tf_workout_image_update.setVisible(false);
                    cb_premium_update.setVisible(false);
                    btn_workout_update.setVisible(false);
                    lbl_info_workout_update.setVisible(false);

                    tf_workout_Id_delete.setText("");
                    lbl_info_workout_delete.setVisible(false);

                    lbl_info_workout_search_update.setText("Workout unavailable");
                    lbl_info_workout_search_update.setVisible(true);


                }
            }catch (NumberFormatException ex)
            {
                lbl_info_workout_search_update.setText("Invalid Input");
                lbl_info_workout_search_update.setVisible(true);
            }

        });


        btn_workout_update.setOnAction(e->{
            if(tf_workout_name_update.getText().trim().isEmpty() || tf_workout_image_update.getText().trim().isEmpty()
                    || comboBox_workout_muscles_update.getSelectionModel().isEmpty() || comboBox_workout_type_update.getSelectionModel().isEmpty())
            {
                lbl_info_workout_update.setText("Invalid Input");
            }
            else
            {
                String name = tf_workout_name_update.getText();
                String type = types_list[comboBox_workout_type_update.getSelectionModel().getSelectedIndex()];
                String muscle = muscles_list[comboBox_workout_muscles_update.getSelectionModel().getSelectedIndex()];
                String image = tf_workout_image_update.getText();
                String pr = "0";

                if(cb_premium.isSelected())
                    pr = "1";

                controller.UpdateWorkout("workout",new String[]{"name", "muscle", "type", "image", "premium"},
                                            new String[]{name,muscle,type,image,pr},Integer.parseInt(tf_workout_Id_update.getText()));
                lbl_info_workout_update.setText("Workout updated");

                hBox.getChildren().set(3,controller.getWorkoutsTable());
            }
            lbl_info_workout_update.setVisible(true);
        });




        Scene scene = new Scene(hBox,hBox.getMaxHeight(),hBox.getMaxWidth());
        primaryStage.setTitle("Workout Plan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
