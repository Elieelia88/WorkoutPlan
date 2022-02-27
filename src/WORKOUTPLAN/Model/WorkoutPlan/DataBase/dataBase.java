package WORKOUTPLAN.Model.WorkoutPlan.DataBase;

import java.sql.*;

public class dataBase {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=Workouts";
        String user = "Elie";
        String pwd = "12345";

        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            /*

                    String sql = "insert into Workout (Wid, Wname) values (1,'bench press')";

                  Statement statement = connection.createStatement();
                    int rows = statement.executeUpdate(sql);

                  if(rows > 0)
                       System.out.println("Row has been inserted");

            String sql = "Select * from Workout";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("wid\t\tname");
            System.out.println("------- ---------------------------");
            while (resultSet.next())
            {
                String wname = resultSet.getString("name");
                int wid = resultSet.getInt("Wid");
                System.out.println(wid+"\t\t"+wname+"\t\t\t\t\t");
            }
            */

            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
