/*
 * Create SQL database if not already created. Contains methods required to access database.
 * 
 * @author Nathaniel_Hershner
 * 
 * @since 2024-01-27
 */


package GUI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreateSQL {
	
	/*
	 * CreateSQL constructor attempts to create and populate database if this had not been done before.
	 */
	
	public CreateSQL() {
		
        try (Connection connection = giveConnection()) {
            // create and populate validproviders table if it does not exist
        	if (!tableExists(connection, "validproviders")) {
        		createTable(connection, "validproviders");
        		if (!columnExistsInTable(connection, "validproviders", "nums")) {
        			addColumnToTable(connection, "validproviders", "nums", "INT");
        			int[] list = {999999999, 121212121, 123456789, 987654321, 385393502, 834592176, 609384215, 725109384, 481236790, 573892614};
        			for (int i = 0; i < 10; i++) {
        				if (!valueExists(connection, "validproviders", "nums", list[i])) {
        					insertValue(connection, "validproviders", "nums", list[i]);
        				}
        			}
        		}
        	}
        	// create and populate validoperators table if it does not exist
        	if (!tableExists(connection, "validoperators")) {
        		createTable(connection, "validoperators");
        		if (!columnExistsInTable(connection, "validoperators", "nums")) {
        			addColumnToTable(connection, "validoperators", "nums", "INT");
        			int[] list = {999999999, 232323232, 876876876, 343412121, 248975361, 697813254, 530964187, 814326509, 672148935, 395210846};
        			for (int i = 0; i < 10; i++) {
        				if (!valueExists(connection, "validoperators", "nums", list[i])) {
        					insertValue(connection, "validoperators", "nums", list[i]);
        				}
        			}
        		}
        	}
        	// create and populate validmanagers table if it does not exist
        	if (!tableExists(connection, "validmanagers")) {
        		createTable(connection, "validmanagers");
        		if (!columnExistsInTable(connection, "validmanagers", "nums")) {
        			addColumnToTable(connection, "validmanagers", "nums", "INT");
        			int[] list = {999999999, 323232323, 454454454, 155155155, 729183465, 604512837, 851937624, 463298571, 318746952, 975624183};
        			for (int i = 0; i < 10; i++) {
        				if (!valueExists(connection, "validmanagers", "nums", list[i])) {
        					insertValue(connection, "validmanagers", "nums", list[i]);
        				}
        			}
        		}
        	}
        	// create and populate members table if it does not exist
        	if (!tableExists(connection, "members")) {
        		createTable(connection, "members");
        		if (!columnExistsInTable(connection, "members", "valid")) {
        			addColumnToTable(connection, "members", "valid", "INT");
        			
        			int[] list = {999999999, 555555555, 666666666, 777777777, 572943618, 689175432, 427356189, 836914257, 514287963, 293861745};
        			
        			for (int i = 0; i < 10; i++) {
        				insertValue(connection, "members", "valid", list[i]);
        			}
        			
        		}
        	}
        	// create and populate suspendedmembers table if it does not exist
        	if (!tableExists(connection, "suspendedmembers")) {
        		createTable(connection, "suspendedmembers");
        		if (!columnExistsInTable(connection, "suspendedmembers", "nums")) {
        			addColumnToTable(connection, "suspendedmembers", "nums", "INT");
        			
        			int[] list = {999999998, 555555554, 455555555, 899999999, 476819325, 825634197, 391547682, 648273519, 752198364, 913462875};
        			for (int i = 0; i < 10; i++) {
        				insertValue(connection, "suspendedmembers", "nums", list[i]);
        			}
        			
        		}
        	}
        	// create and populate providerdirectory table if it does not exist
        	if (!tableExists(connection, "providerdirectory")) {
        		createTable(connection, "providerdirectory");
        		if (!columnExistsInTable(connection, "providerdirectory", "codes")) {
        			addColumnToTable(connection, "providerdirectory", "codes", "INT");
        			addColumnToTable(connection, "providerdirectory", "descriptions", "VARCHAR(255)");
        			int[] list = {999999, 555555, 666666, 777777, 718245, 392857, 564213, 987634, 126489, 573916};
        			String[] list2 = {"Workout and Meal Plans", "Yoga and Stretching", "Common Illness Treatment", "Alternative Medicine", "Juice Cleanse"
        							  , "Group Therapy", "Chocolate Detox", "Shock Therapy", "Aerobics Class", "Spin Cycle Class"};
        			for (int i = 0; i < 10; i++) {
        				if (!valueExists(connection, "providerdirectory", "codes", list[i]) && !valueExists(connection, "providerdirectory", "descriptions", list2[i])) {
        					insertValues(connection, "providerdirectory", "codes", "descriptions", list[i], list2[i]);
        				}
        			}
        		}
        	}
        	//create and populate bill table if it does not exist
        	if (!tableExists(connection, "bill")) {
        		createTable(connection, "bill");
        		if (!columnExistsInTable(connection, "bill", "billdate")) {
        			addColumnToTable(connection, "bill", "billdate", "VARCHAR(255)");
        			addColumnToTable(connection, "bill", "servicedate", "VARCHAR(255)");
        			addColumnToTable(connection, "bill", "servicecode", "VARCHAR(255)");
        			addColumnToTable(connection, "bill", "providercode", "VARCHAR(255)");
        			addColumnToTable(connection, "bill", "membercode", "VARCHAR(255)");
        			addColumnToTable(connection, "bill", "comments", "VARCHAR(255)");
        			String[] serviceCodes = {"392857", "987634", "573916", "777777", "573916", "666666", "392857", "126489", "718245", "564213"};
        			String[] billDates = {"07-30-2023 12:02:31", "12-21-2022 14:22:34", "12-01-2023 15:21:54", "08-19-2020 14:22:32", "01-02-2018 11:01:01"
        			                      , "03-29-2020 16:03:46", "05-20-2023 12:34:43", "09-23-2017 16:19:19", "02-27-2023 15:55:45", "04-01-2023 11:34:43"};
        			String[] serviceDates = {"07-19-2023", "12-01-2022", "11-21-2023", "08-14-2020", "12-19-2017", "03-13-2020", "05-01-2023", "09-01-2017", "02-02-2023", "03-18-2023"};
        			String[] providerCodes = {"121212121", "385393502", "609384215", "123456789", "999999999", "481236790", "609384215", "385393502", "609384215", "121212121"};
        			String[] memberCodes = {"572943618", "689175432", "666666666", "514287963", "293861745", "572943618", "999999999", "572943618", "666666666", "572943618"};
        			String[] comments = {"Interacted well with others during session", "Responded well to treatment", "Burnt the most calories of class"
        								 , "Did not benefit from treatment", "Burnt the least calories of class", "Illness is gone", "Did not interact with group"
        								 , "Flexibility increased since last visit", "Enjoyed juice", "Chocolate detox seems effective"};
        			for (int i = 0; i < 10; i++) {
        				try{
                        	CreateSQL.insertSixStringValues(CreateSQL.giveConnection(), "bill", "billdate", billDates[i], "servicedate", serviceDates[i], "servicecode", serviceCodes[i],
                        			"providercode", providerCodes[i], "membercode", memberCodes[i], "comments", comments[i]);
                        } catch (SQLException ex) {
                        	ex.printStackTrace();
                        }
        			}
        		}
        	}
        	// create and populate memberinfo table if it does not exist
        	if (!tableExists(connection, "memberinfo")) {
        		createTable(connection, "memberinfo");
        		if (!columnExistsInTable(connection, "memberinfo", "name")) {
        			addColumnToTable(connection, "memberinfo", "name", "VARCHAR(255)");
        			addColumnToTable(connection, "memberinfo", "num", "VARCHAR(255)");
        			addColumnToTable(connection, "memberinfo", "address", "VARCHAR(255)");
        			addColumnToTable(connection, "memberinfo", "city", "VARCHAR(255)");
        			addColumnToTable(connection, "memberinfo", "state", "VARCHAR(255)");
        			addColumnToTable(connection, "memberinfo", "zipcode", "VARCHAR(255)");
        			String[] names = {"Matthew King", "Trina Smith", "Kelly Allbody", "John Smart", "Demarcus Keen", "Sheila Baker", "Rose King", "Emily Vanderbilt", "Lance Wood", "Allison Baird"};
        			String[] nums = {"999999999", "555555555", "666666666", "777777777", "572943618", "689175432", "427356189", "836914257", "514287963", "293861745"};
        			String[] addresses = {"234 Right Way", "9356 Pleasant St", "733 Brick St", "223 American Rd", "123 Main Street", "456 Oak Avenue", "789 Elm Lane", "321 Pine Drive", "567 Birch Road", "890 Cedar Court"};
        			String[] cities = {"Fairfield", "Hamilton", "Colerain", "Middletown", "Seattle", "Miami", "Denver", "Atlanta", "Boston", "Dallas"};
        			String[] states = {"OH", "KY", "AL", "NY", "AL", "MI", "MS", "CO", "MA", "FL"};
        			String[] zipcodes = {"24524", "99832", "45014", "34432", "89234", "65781", "43829", "12657", "54902", "78453"};
        			for (int i = 0; i < 10; i++) {
        				try{
                        	CreateSQL.insertSixStringValues(CreateSQL.giveConnection(), "memberinfo", "name", names[i], "num", nums[i], "address", addresses[i],
                        			"city", cities[i], "state", states[i], "zipcode", zipcodes[i]);
                        } catch (SQLException ex) {
                        	ex.printStackTrace();
                        }
        			}
        		}
        	}
        	// create and populate providerinfo table if it does not exist
        	if (!tableExists(connection, "providerinfo")) {
        		createTable(connection, "providerinfo");
        		if (!columnExistsInTable(connection, "providerinfo", "name")) {
        			addColumnToTable(connection, "providerinfo", "name", "VARCHAR(255)");
        			addColumnToTable(connection, "providerinfo", "num", "VARCHAR(255)");
        			addColumnToTable(connection, "providerinfo", "address", "VARCHAR(255)");
        			addColumnToTable(connection, "providerinfo", "city", "VARCHAR(255)");
        			addColumnToTable(connection, "providerinfo", "state", "VARCHAR(255)");
        			addColumnToTable(connection, "providerinfo", "zipcode", "VARCHAR(255)");
        			String[] names = {"Dex Martin", "Christie Wahoff", "Joban Singh", "Marla Richards", "Henry Gonzalez", "Tank Frank", "Sydney Sweet", "Victoria Lane", "Lindsey Mailer", "Javier Johnston"};
        			String[] nums = {"999999999", "121212121", "123456789", "987654321", "385393502", "834592176", "609384215", "725109384", "481236790", "573892614"};
        			String[] addresses = {"34 Madid Ave", "9265 Saga St", "7323 Cobble St", "423 Dixie Rd", "234 Maple Avenue", "567 Pine Street", "890 Elm Road", "432 Oak Drive", "765 Cedar Lane", "109 Birch Court"};
        			String[] cities = {"West Chester", "Mason", "Indian Hill", "Cincinnati", "Los Angeles", "Chicago", "Houston", "Philadelphia", "Phoenix", "San Antonio"};
        			String[] states = {"PA", "LA", "NH", "FL", "OH", "NY", "CA", "WA", "NJ", "OH"};
        			String[] zipcodes = {"63524", "99222", "11014", "36322", "89124", "65732", "43895", "12678", "54903", "78456"};
        			for (int i = 0; i < 10; i++) {
        				try{
                        	CreateSQL.insertSixStringValues(CreateSQL.giveConnection(), "providerinfo", "name", names[i], "num", nums[i], "address", addresses[i],
                        			"city", cities[i], "state", states[i], "zipcode", zipcodes[i]);
                        } catch (SQLException ex) {
                        	ex.printStackTrace();
                        }
        			}
        		}
        	}

            
        } catch (SQLException e) {
            e.printStackTrace();
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
			 String jdbcUrl = "jdbc:sqlserver://DESKTOP-PV2HDT9\\SQLEXPRESS:55681;DatabaseName=ChocAn;user=nate;password=nate1;trustServerCertificate=True;";
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
