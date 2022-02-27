package WORKOUTPLAN.Model.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final String[] ColumnNames = {"wid", "name", "muscle", "type", "image", "premium"};
    private static final String[] ColumnNamesWithoutId = {"name", "muscle", "type", "image", "premium"};

    private List<List<String>> executeSql(String sql, String[] ColumnNames) {
        List<List<String>> result = new ArrayList<>();

        String url = "",
                user = "",
                pass = "";

        try {
            // Connection
            Connection connection = DriverManager.getConnection(url, user, pass);

            //Statement
            Statement statement = connection.createStatement();

            //Execution
            if (ColumnNames != null) {
                ResultSet resultSet = statement.executeQuery(sql);


                while (resultSet.next()) {
                    List<String> rowData = new ArrayList<>();

                    for (String colName : ColumnNames)
                        rowData.add(resultSet.getString(colName));

                    result.add(rowData);
                }
            } else
                statement.execute(sql);

            if(result.size()==0)
                return null;
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public  List<List<String>> select(String Table, String[] Selection, String Where) {
        String sql;
        if (Selection == null) {
            Selection = ColumnNames;
            sql = "Select * from " + Table + " ";
        } else
            sql = "Select " + String.join(",", Selection) + " from " + Table + " ";

        if (Where != null)
            sql += "where " + Where;

        return executeSql(sql, Selection);
    }

    public  void delete(String Table, String Id) {
        if (getWorkout(Table, Id)!=null) {
            String sql = "delete from " + Table + " where wid = " + Id;
            executeSql(sql, null);
        }
    }

    public  void insert(String Table, String[] Data) {
        for (int i = 0; i < Data.length; i++)
            Data[i] = "'" + Data[i] + "'";

        String sql = "insert into " + Table + " values(" + String.join(",", Data) + ")";
        executeSql(sql, null);
    }

    public  void update(String Table, String[] columnNames, String[] values, String Id) {
        if (getWorkout(Table, Id)!=null) {
            for (int i = 0; i < values.length; i++)
                values[i] = "'" + values[i] + "'";

            String[] updateValues = new String[columnNames.length];

            for (int i = 0; i < columnNames.length; i++)
                updateValues[i] = columnNames[i] + "=" + values[i];

            String sql = "update " + Table + " set " + String.join(",", updateValues) + " where wid = " + Id;

            executeSql(sql, null);
        }
    }

    public List<List<String>> getWorkout(String Table, String Id) {
        return executeSql("select * from " + Table + " where wid = " + Id, ColumnNames);
    }


}
