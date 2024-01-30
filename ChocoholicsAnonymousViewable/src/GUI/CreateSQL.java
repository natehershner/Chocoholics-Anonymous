/*
 * Create SQL database if not already created. Contains methods required to access database.
 * 
 * @author Nathaniel_Hershner
 * 
 * @since 2024-01-30
 */


package GUI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class CreateSQL {
	private static Preferences prefs;
    
	/*
	 * CreateSQL constructor attempts to create and populate database if this had not been done before.
	 */
	
	public CreateSQL() {
		
		
		prefs = Preferences.userNodeForPackage(GUI.class);
		
		if (prefs.get("serverName", "").isEmpty()) {
			new SetSqlInfo();
		} else {
			new GUI();
		}
	}
	
	/*
	 * Create desired SQL table
	 * @param connection SQL connection
	 * @param tableName Name of table to create
	 */
	
	public static void createTable(Connection connection, String tableName) throws SQLException{
		try (Statement statement = connection.createStatement()){
			String createTableQueery = "CREATE TABLE " + tableName + " (testColumn INT);";
			statement.executeUpdate(createTableQueery);
		}
		
	}
	
	/*
	 * Checks if a table exists in the current database
	 * @param connection SQL connection
	 * @param name Name of table to validate
	 * @return if table exists
	 */
	
	public static boolean tableExists(Connection connection, String name) throws SQLException{
		try (Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '" + name + "'")){
			return resultSet.next();
		}
				
	}
	
	/*
	 * Checks if a value exists in a certain table and column
	 * @param connection SQL connection
	 * @param tableName Name of table to check
	 * @param columnName Name of column to check
	 * @param value Value to be checked
	 * @return if value exists
	 */
	
	public static boolean valueExists(Connection connection, String tableName, String columnName, int value) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT 1 FROM " + tableName + " WHERE " + columnName + " = ?")) {
            preparedStatement.setInt(1, value);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
	
	/*
	 * Inserts a value into certain table and column
	 * @param connection SQL connection
	 * @param tableName Table value is to be added to
	 * @param columnName column value is to be added to
	 * @param value Value to be added
	 */
	
	public static void insertValue(Connection connection, String tableName, String columnName, int value) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO " + tableName + " (" + columnName + ") VALUES (?)")) {
            preparedStatement.setInt(1, value);
            preparedStatement.executeUpdate();
        }
    }
	
	/*
	 * Inserts a string and an int into two different columns of the same table
	 * @param connection SQL connection
	 * @param tableName Table to be added to
	 * @param intColumnName Column int is to be added to
	 * @param stringColumnName Column String is to be added to
	 * @param intValue Int to be added
	 * @param stringValue String to be added
	 */
	
	public static void insertValues(Connection connection, String tableName, String intColumnName, String stringColumnName, int intValue, String stringValue) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO " + tableName + " (" + intColumnName + ", " + stringColumnName + ") VALUES (?, ?)")) {
            preparedStatement.setInt(1, intValue);
            preparedStatement.setString(2, stringValue);
            preparedStatement.executeUpdate();
        }
    }
	
	/*
	 * Inserts two ints into two different columns of the same table
	 * @param connection SQL connection
	 * @param tableName Table to be added to
	 * @param intColumnName Column first int is to be added to
	 * @param int2ColumnName Column second int is to be added to
	 * @param intValue Value to be added to intColumnName
	 * @param int2Value Value to be added to int2ColumnName
	 */
	
	public static void insertValues(Connection connection, String tableName, String intColumnName, String int2ColumnName, int intValue, int int2Value) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO " + tableName + " (" + intColumnName + ", " + int2ColumnName + ") VALUES (?, ?)")) {
            preparedStatement.setInt(1, intValue);
            preparedStatement.setInt(2, int2Value);
            preparedStatement.executeUpdate();
        }
    }
	
	/* Inserts six Strings into six different columns of the same table
	 * @param connection SQL connection
	 * @param tableName Table to be added to
	 * @param col1 First column to add to
	 * @param val1 Value to add to col1
	 * @param col2 Second column to add to
	 * @param val2 Value to add to col2
	 * @param col3 Third column to add to
	 * @param val3 Value to add to col3
	 * @param col4 Fourth column to add to
	 * @param val4 Value to add to col4
	 * @param col5 Fifth column to add to
	 * @param val5 Value to add to col5
	 * @param col6 Sixth column to add to
	 * @param val6 Value to add to col6
	 */
	
	public static void insertSixStringValues(Connection connection, String tableName, String col1, String val1, String col2, String val2, String col3, String val3, String col4, String val4, String col5, String val5, String col6, String val6) throws SQLException {
        String insertQuery = "INSERT INTO " + tableName + " (" + col1 + ", " + col2 + ", " + col3 + ", " + col4 + ", " + col5 + ", " + col6 + ") VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, val1);
            preparedStatement.setString(2, val2);
            preparedStatement.setString(3, val3);
            preparedStatement.setString(4, val4);
            preparedStatement.setString(5, val5);
            preparedStatement.setString(6, val6);
            preparedStatement.executeUpdate();
        }
    }
	
	/*
	 * Checks if a string value exists in a column in a table
	 * @param connection SQL connection
	 * @param tableName Table to check
	 * @param columnName Column to check
	 * @param value Value to check
	 * @return if value exists
	 */
	
	public static boolean valueExists(Connection connection, String tableName, String columnName, String value) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT 1 FROM " + tableName + " WHERE " + columnName + " = ?")) {
            preparedStatement.setString(1, value);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
	
	/*
	 * Inserts one String into a column in a table
	 * @param connection SQL connection
	 * @param tableName Table to add to
	 * @param columnName Column to add to
	 * @param value Value to add
	 */
	
	public static void insertValue(Connection connection, String tableName, String columnName, String value) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO " + tableName + " (" + columnName + ") VALUES (?)")) {
            preparedStatement.setString(1, value);
            preparedStatement.executeUpdate();
        }
    }
	
	/*
	 * Adds a column to a table
	 * @param connection SQL
	 * @param tableName Table column is to be added to
	 * @param columnName Name of column to be created
	 * @param columnType Type of data the new column will store
	 */
	
	public static void addColumnToTable(Connection connection, String tableName, String columnName, String columnType) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String addColumnQuery = "ALTER TABLE " + tableName + " ADD " + columnName + " " + columnType + ";";
            statement.executeUpdate(addColumnQuery);
        }
    }
	
	/*
	 * Checks if a column exists in a table
	 * @param connection SQL connection
	 * @param tableName Table to be checked
	 * @param columnName Column to check
	 * @return if column exists in table
	 */
	
	 public static boolean columnExistsInTable(Connection connection, String tableName, String columnName) throws SQLException {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(
	                "SELECT 1 FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ? AND COLUMN_NAME = ?")) {
	            preparedStatement.setString(1, tableName);
	            preparedStatement.setString(2, columnName);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                return resultSet.next();
	            }
	        }
	   }
	 
	 /*
	  * Provides SQL connection
	  * @return SQL connection
	  */
	 
	 public static Connection giveConnection() {
		 try {
			 String server = prefs.get("serverName", "");
			 String port = prefs.get("portNumber", "");
			 String dataBase = prefs.get("databaseName", "");
			 String user = prefs.get("username", "");
			 String password = prefs.get("password", "");
			 String jdbcUrl = "jdbc:sqlserver://" + server + ":" + port + ";DatabaseName=" + dataBase + ";user=" + user + ";password=" + password + ";trustServerCertificate=True;";
			 Connection connection = DriverManager.getConnection(jdbcUrl);
			 return connection;
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return null;
	 }
	 
	 /*
	  * Provides the number of values in a column in a table
	  * @param connection SQL connection
	  * @param tableName Table to be analyzed
	  * @param columnName Column to count
	  * @return number of elements in column
	  */
	 
	 public static int getColumnItemCount(Connection connection, String tableName, String columnName) {
	        // Replace with your SQL query to count items in the column
	        String sqlQuery = "SELECT COUNT(" + columnName + ") FROM " + tableName;

	        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            if (resultSet.next()) {
	                // Retrieve the count of items in the column
	                int itemCount = resultSet.getInt(1);
	                return itemCount;
	            } else {
	                // No results found
	                return 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exceptions as needed, e.g., log or throw custom exception
	            return -1; // Return a special value indicating an error
	        }
	  }
	 
	 /*
	  * Provides all int values of a column of a table
	  * @param connection SQL connection
	  * @param tableName Table to be used
	  * @param columnName Column of values
	  * @return array of values of the column
	  */
	 
	 public static int[] getColumnValuesInt(Connection connection, String tableName, String columnName) {
	        // Replace with your SQL query
	        String sqlQuery = "SELECT " + columnName + " FROM " + tableName;

	        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            List<Integer> valuesList = new ArrayList<>();

	            while (resultSet.next()) {
	                // Retrieve the value of the specified column
	                int columnValue = resultSet.getInt(columnName);
	                valuesList.add(columnValue);
	            }

	            // Convert the ArrayList to an array
	            int[] valuesArray = valuesList.stream().mapToInt(Integer::intValue).toArray();

	            return valuesArray;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exceptions as needed, e.g., log or throw custom exception
	            return new int[0]; // Return an empty array or handle errors appropriately
	        }
	 }
	 
	 /*
	  * Provide all String values of a column of a table
	  * @param connection SQL connection
	  * @param tableName Table to be used
	  * @param columnName Column of values
	  * @return array of values of the column
	  */
	 
	 public static String[] getColumnValuesString(Connection connection, String tableName, String columnName) {
	        // Replace with your SQL query
	        String sqlQuery = "SELECT " + columnName + " FROM " + tableName;

	        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            List<String> valuesList = new ArrayList<>();

	            while (resultSet.next()) {
	                // Retrieve the value of the specified column
	                String columnValue = resultSet.getString(columnName);
	                valuesList.add(columnValue);
	            }

	            // Convert the ArrayList to an array
	            String[] valuesArray = valuesList.toArray(new String[0]);

	            return valuesArray;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exceptions as needed, e.g., log or throw custom exception
	            return new String[0]; // Return an empty array or handle errors appropriately
	        }
	 }
	 
	 /*
	  * Deletes a row of values based on an int value in a column
	  * @param connection SQL connection
	  * @param table Table to be deleted from
	  * @param column Column value is to be used in
	  * @param value Condition of deleting values
	  */
	 
	 public static void deleteRow(Connection connection, String table, String column, int value) {
		 String sqlQuery = "DELETE FROM " + table + " WHERE " + column + "=?";
		 try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
	            // Set the parameter value
	            preparedStatement.setInt(1, value);
	            // Execute the delete statement
	            preparedStatement.executeUpdate();	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
	 
	 /*
	  * Deletes a row of values based on an String value in a column
	  * @param connection SQL connection
	  * @param table Table to be deleted from
	  * @param column Column value is to be used in
	  * @param value Condition of deleting values
	  */
	 
	 public static void deleteRow(Connection connection, String table, String column, String value) {
		    String sqlQuery = "DELETE FROM " + table + " WHERE " + column + "=?";
		    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
		        // Set the parameter value
		        preparedStatement.setString(1, value);
		        // Execute the delete statement
		        preparedStatement.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	 }
	 
	 /*
	  * Provides a String value based on the value provided in the column provided
	  * @param connection SQL connection
	  * @param tableName Table values come from
	  * @param toObtain Column value is to be obtained from
	  * @param columnName Column of condition parameter
	  * @param targetValue Condition Parameter
	  * @return String value of correct condition
	  */
	 
	 public static String getStringByStringValue(Connection connection, String tableName, String toObtain, String columnName, String targetValue) {
		    String result = null;
		    String sqlQuery = "SELECT " + toObtain + " FROM " + tableName + " WHERE " + columnName + " = ?";

		    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
		        // Set the parameter value
		        preparedStatement.setString(1, targetValue);

		        // Execute the query
		        try (ResultSet resultSet = preparedStatement.executeQuery()) {
		            if (resultSet.next()) {
		                // Retrieve the value from the result set
		                result = resultSet.getString(toObtain);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return result;
	 }
	 
	 /*
	  * Updates a column's value based on another column's value
	  * @param connection SQL connection
	  * @param tableName Table to update
	  * @param columnNameToUpdate Column that is going to be updated
	  * @param newValue Update value
	  * @param conditionColumn Column of the condition that is going to be checked
	  * @param conditionValue Condition to be checked
	  */
	 
	 public static void updateValue(Connection connection, String tableName, String columnNameToUpdate, String newValue, String conditionColumn, String conditionValue) {
		    String sqlQuery = "UPDATE " + tableName + " SET " + columnNameToUpdate + " = ? WHERE " + conditionColumn + " = ?";

		    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
		        // Set the new value
		        preparedStatement.setString(1, newValue);

		        // Set the condition value
		        preparedStatement.setString(2, conditionValue);

		        // Execute the update
		        preparedStatement.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	 }
	 
	 /*
	  * Provides number of elements in a column based on a condition
	  * @param connection SQL connection
	  * @param tableName Table to check
	  * @param targetColumn Column with element count to be returned
	  * @param conditionColumn Column of value to be checked
	  * @param conditionValue Value of the condition
	  * @return number of elements in targetColumn that fit condition
	  */
	 
	 public static int getCountBasedOnCondition(Connection connection, String tableName, String targetColumn,
             String conditionColumn, String conditionValue) {
		 	 int count = 0;
		 	 String sqlQuery = "SELECT COUNT(" + targetColumn + ") FROM " + tableName +
		 			 		   " WHERE " + conditionColumn + " = ?";

		 	 try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
		 		 preparedStatement.setString(1, conditionValue);

		 		 try (ResultSet resultSet = preparedStatement.executeQuery()) {
		 			 if (resultSet.next()) {
		 				 count = resultSet.getInt(1);
		 			 }
		 		 }
		 	 } catch (SQLException e) {
		 		 e.printStackTrace(); // Handle the exception as needed
		 	 }

		 	 return count;
	 }
	 
	 /*
	  * Provides array of elements based on a condition value
	  * @param connection SQL connection
	  * @param tableName Table to gather from
	  * @param targetColumn Column of values to be returned
	  * @param conditionColumn Column of condition to be checked
	  * @param conditionValue Value of condition
	  * @return array of values in targetColumn that meet condition
	  */
	 
	 public static String[] getValuesBasedOnCondition(Connection connection, String tableName, String targetColumn,
             										  String conditionColumn, String conditionValue) {
		 List<String> values = new ArrayList<>();
		 String sqlQuery = "SELECT " + targetColumn + " FROM " + tableName +
				 		   " WHERE " + conditionColumn + " = ?";

		 try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
			 preparedStatement.setString(1, conditionValue);

			 try (ResultSet resultSet = preparedStatement.executeQuery()) {
				 while (resultSet.next()) {
					 values.add(resultSet.getString(targetColumn));
				 }
			 }
		 } catch (SQLException e) {
			 e.printStackTrace(); // Handle the exception as needed
		 }

		 return values.toArray(new String[0]);
	 }
}
	