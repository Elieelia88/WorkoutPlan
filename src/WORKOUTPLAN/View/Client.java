package WORKOUTPLAN.View;

import WORKOUTPLAN.Controller.Controller;
import WORKOUTPLAN.Model.WorkoutPlan.Director.WorkoutPlanDirector;
import WORKOUTPLAN.Model.WorkoutPlan.WorkoutPlans.MuscleGainWorkoutPlan;
import WORKOUTPLAN.Model.WorkoutPlan.Workouts.Workout;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Client extends Application {
    static Controller controller = new Controller();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene;
        try {
            scene = new Scene(getWorkoutPlan(), Window.getWindows().size(),Window.getWindows().size());
        } catch (IOException e) {
            scene = new Scene(generateWorkoutPlan(), Window.getWindows().size(),Window.getWindows().size());
        }
        primaryStage.setTitle("Workout Plan");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static HBox getWorkoutPlan() throws IOException {

        WorkoutPlanDirector workoutPlanDirector = new WorkoutPlanDirector();
        MuscleGainWorkoutPlan muscleGainWorkoutPlan = new MuscleGainWorkoutPlan();
        workoutPlanDirector.setWorkoutPlanBuilder(muscleGainWorkoutPlan);
        workoutPlanDirector.ConstructWorkoutPlan();


        Label lb_muscle_chest = new Label("chest Workouts");
        ListView<Workout> workouts_list_chest = GenerateListView("chest",workoutPlanDirector.getWorkoutPlan().getChestWorkout().getWorkouts());
        VBox vBox_chest = new VBox(5);
        vBox_chest.getChildren().addAll(lb_muscle_chest,workouts_list_chest);

        Label lb_muscle_back = new Label("back Workouts");
        ListView<Workout> workouts_list_back = GenerateListView("back",workoutPlanDirector.getWorkoutPlan().getBackWorkout().getWorkouts());
        VBox vBox_back = new VBox(5);
        vBox_back.getChildren().addAll(lb_muscle_back,workouts_list_back);

        Label lb_muscle_arms = new Label("Arms Workouts");
        ListView<Workout> workouts_list_arms = GenerateListView("arms",workoutPlanDirector.getWorkoutPlan().getArmsWorkout().getWorkouts());
        VBox vBox_arms = new VBox(5);
        vBox_arms.getChildren().addAll(lb_muscle_arms,workouts_list_arms);

        Label lb_muscle_shoulder = new Label("shoulder Workouts");
        ListView<Workout> workouts_list_shoulder = GenerateListView("shoulder",workoutPlanDirector.getWorkoutPlan().getShoulderWorkout().getWorkouts());
        VBox vBox_shoulder = new VBox(5);
        vBox_shoulder.getChildren().addAll(lb_muscle_shoulder,workouts_list_shoulder);

        Label lb_muscle_legs = new Label("legs Workouts");
        ListView<Workout> workouts_list_legs = GenerateListView("legs",workoutPlanDirector.getWorkoutPlan().getLegsWorkout().getWorkouts());
        VBox vBox_legs = new VBox(5);
        vBox_legs.getChildren().addAll(lb_muscle_legs,workouts_list_legs);

        HBox hBox = new HBox(10);

        hBox.getChildren().addAll(vBox_chest,vBox_back,vBox_arms,vBox_shoulder,vBox_legs);

        return hBox;
    }

    public static VBox generateWorkoutPlan()
    {
        AtomicInteger flag_chest = new AtomicInteger(0);
        Label lb_muscle_chest = new Label("chest Workouts");
        ListView<Workout> workouts_list_chest = GenerateListView("chest",null);
        Button btn_submit_chest = new Button("Submit chest workouts");
        Label lblInfo_chest = new Label();

        VBox vBox_chest = new VBox(5);
        vBox_chest.getChildren().addAll(lb_muscle_chest,workouts_list_chest,btn_submit_chest,lblInfo_chest);

        btn_submit_chest.setOnAction(e->{
            Boolean flag = setWorkoutsIds(workouts_list_chest,5,"chest");
            if(Boolean.TRUE.equals(flag)){
                flag_chest.set(1);
                lblInfo_chest.setText("chest workouts set");
                btn_submit_chest.setVisible(false);
            }
            else
            {
                lblInfo_chest.setText("Please choose 5 chest Workouts");
            }
        });

        AtomicInteger flag_back = new AtomicInteger(0);
        Label lb_muscle_back = new Label("back Workouts");
        ListView<Workout> workouts_list_back = GenerateListView("back",null);
        Button btn_submit_back = new Button("Submit back workouts");
        Label lblInfo_back = new Label();

        VBox vBox_back = new VBox(5);
        vBox_back.getChildren().addAll(lb_muscle_back,workouts_list_back,btn_submit_back,lblInfo_back);

        btn_submit_back.setOnAction(e->{
            Boolean flag = setWorkoutsIds(workouts_list_back,5,"back");
            if(Boolean.TRUE.equals(flag)){
                flag_back.set(1);
                lblInfo_back.setText("back workouts set");
                btn_submit_back.setVisible(false);
            }
            else
            {
                lblInfo_back.setText("Please choose 5 back Workouts");
            }
        });


        AtomicInteger flag_arms = new AtomicInteger(0);
        Label lb_muscle_arms = new Label("arms Workouts");
        ListView<Workout> workouts_list_arms = GenerateListView("arms",null);
        Button btn_submit_arms = new Button("Submit arms workouts");
        Label lblInfo_arms = new Label();

        VBox vBox_arms = new VBox(5);
        vBox_arms.getChildren().addAll(lb_muscle_arms,workouts_list_arms,btn_submit_arms,lblInfo_arms);

        btn_submit_arms.setOnAction(e->{
            Boolean flag = setWorkoutsIds(workouts_list_arms,6,"arms");
            if(Boolean.TRUE.equals(flag)){
                flag_arms.set(1);
                lblInfo_arms.setText("arms workouts set");
                btn_submit_arms.setVisible(false);
            }
            else
            {
                lblInfo_arms.setText("Please choose 6 arms Workouts");
            }
        });


        AtomicInteger flag_shoulder = new AtomicInteger(0);
        Label lb_muscle_shoulder = new Label("shoulder Workouts");
        ListView<Workout> workouts_list_shoulder = GenerateListView("shoulder",null);
        Button btn_submit_shoulder = new Button("Submit shoulder workouts");
        Label lblInfo_shoulder = new Label();

        VBox vBox_shoulder = new VBox(5);
        vBox_shoulder.getChildren().addAll(lb_muscle_shoulder,workouts_list_shoulder,btn_submit_shoulder,lblInfo_shoulder);

        btn_submit_shoulder.setOnAction(e->{
            Boolean flag = setWorkoutsIds(workouts_list_shoulder,4,"shoulder");
            if(Boolean.TRUE.equals(flag)){
                flag_shoulder.set(1);
                lblInfo_shoulder.setText("shoulder workouts set");
                btn_submit_shoulder.setVisible(false);
            }
            else
            {
                lblInfo_shoulder.setText("Please choose 4 shoulder Workouts");
            }
        });


        AtomicInteger flag_legs = new AtomicInteger(0);
        Label lb_muscle_legs = new Label("legs Workouts");
        ListView<Workout> workouts_list_legs = GenerateListView("legs",null);
        Button btn_submit_legs = new Button("Submit legs workouts");
        Label lblInfo_legs = new Label();

        VBox vBox_legs = new VBox(5);
        vBox_legs.getChildren().addAll(lb_muscle_legs,workouts_list_legs,btn_submit_legs,lblInfo_legs);

        btn_submit_legs.setOnAction(e->{
            Boolean flag = setWorkoutsIds(workouts_list_legs,5,"legs");
            if(Boolean.TRUE.equals(flag)){
                flag_legs.set(1);
                lblInfo_legs.setText("legs workouts set");
                btn_submit_legs.setVisible(false);
            }
            else
            {
                lblInfo_legs.setText("Please choose 5 legs Workouts");
            }
        });


        Button btnSubmitAll = new Button("Submit Plan");
        Label lblPlanInfo = new Label();

        btnSubmitAll.setOnAction(e->{
            String s = "";
            if(flag_chest.get() == 0)
                s += "Chest workouts missing\n";
            if(flag_back.get() == 0)
                s += "back workouts missing\n";
            if(flag_arms.get() == 0)
                s += "Arms workouts missing\n";
            if(flag_shoulder.get() == 0)
                s += "Shoulder workouts missing\n";
            if(flag_legs.get() == 0)
                s += "Legs workouts missing\n";
            if(s.equals(""))
                s = "Plan Completed\n";

            lblPlanInfo.setText(s);

        });

        VBox vBox = new VBox(20);
        HBox hBox = new HBox(10);

        hBox.getChildren().addAll(vBox_chest,vBox_back,vBox_arms,vBox_shoulder,vBox_legs);
        vBox.getChildren().addAll(hBox,btnSubmitAll,lblPlanInfo);

        return vBox;
    }

    public static ListView<Workout> GenerateListView(String muscle, List<Workout> workouts)
    {
        ListView<Workout> workouts_list = new ListView<>();
        workouts_list.setOrientation(Orientation.VERTICAL);
        ObservableList<Workout> _workouts_list = FXCollections.observableArrayList();
        List<Workout> workouts_chest;

        if(workouts == null)
            workouts_chest = controller.getWorkouts("workout",null,"type = 'muscle gain' and muscle = '"+muscle+"' ");
        else
            workouts_chest = workouts;

        _workouts_list.addAll(workouts_chest);
        workouts_list.setItems(_workouts_list);
        workouts_list.setCellFactory(param -> new Cell() );
        workouts_list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        return workouts_list;
    }



    public static Boolean setWorkoutsIds(ListView<Workout> listView, int nb_of_workouts_to_choose, String muscle)
    {
        ObservableList<Workout> selected = listView.getSelectionModel().getSelectedItems();
        if(selected.size() != nb_of_workouts_to_choose)
        {
            return null;
        }
        else {
                writeIDs(selected,muscle);
            return true;
        }
    }

    public static void writeIDs(List<Workout> workouts,String muscle)
    {
        try {
            FileWriter myWriter = new FileWriter("src/WORKOUTPLAN/Model/WorkoutPlan/Workouts/"+muscle+"Workout.txt");

            for (Workout workout: workouts)
                myWriter.write(workout.getWid()+"\n");

            myWriter.close();

        } catch ( IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
