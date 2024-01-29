/*
 * Provides all methods to validate codes for various types of users
 * 
 * @author Nathaniel_Hershner
 * 
 * @since 2024-01-27
 */

package GUI;

import java.sql.Connection;
import java.sql.SQLException;

public class Validators {
	
	/*
	 * Determines if service code provided is valid
	 * @param enteredCode Service code to test
	 * @return if code is valid
	 */
	
	public static boolean isValidServiceCode(String enteredCode) {
		 if (enteredCode.length() != 6) return false;
			try {
				Integer.parseInt(enteredCode);
			} catch (NumberFormatException e) {
				return false;
			}
	        try {
	            Connection connection = CreateSQL.giveConnection();
	            return CreateSQL.valueExists(connection, "providerdirectory", "codes", Integer.parseInt(enteredCode));
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }	    
	}
	
	/*
	 * Determines if member code provided is valid
	 * @param enteredCode Member code to test
	 * @return if code is valid
	 */
	
	public static boolean isValidMemberCode(String enteredCode) {
		 if (enteredCode.length() != 9) return false;
			try {
				Integer.parseInt(enteredCode);
			} catch (NumberFormatException e) {
				return false;
			}
	        try {
	        	Connection connection = CreateSQL.giveConnection();
	        	return CreateSQL.valueExists(connection, "members", "valid", Integer.parseInt(enteredCode));
	        	
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	 }
	
	 public static boolean isSuspendedMemberCode(String enteredCode) {
		 if (enteredCode.length() != 9) return false;
			try {
				Integer.parseInt(enteredCode);
			} catch (NumberFormatException e) {
				return false;
			}
	        try {
	        	Connection connection = CreateSQL.giveConnection();
	        	return CreateSQL.valueExists(connection, "suspendedmembers", "nums", Integer.parseInt(enteredCode));
	        	
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	 }
	 
	 /*
	  * Determines if provider code is valid
	  * @param enteredCode Provider code to test
	  * @return if code is valid
	  */
	 
	 public static boolean isValidProviderCode(String enteredCode) {
		 if (enteredCode.length() != 9) return false;
			try {
				Integer.parseInt(enteredCode);
			} catch (NumberFormatException e) {
				return false;
			}
	        try {
	        	Connection connection = CreateSQL.giveConnection();
	        	return CreateSQL.valueExists(connection, "validproviders", "nums", Integer.parseInt(enteredCode));
	        	
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	 }
	 
	 /*
	  * Determines if manager code is valid
	  * @param enteredCode Manager code to test
	  * @return if code is valid
	  */
	 
	 public static boolean isValidManagerCode(String enteredCode) {
			if (enteredCode.length() != 9) return false;
			try {
				Integer.parseInt(enteredCode);
			} catch (NumberFormatException e) {
				return false;
			}
	        try {
	            Connection connection = CreateSQL.giveConnection();
	            return CreateSQL.valueExists(connection, "validmanagers", "nums", Integer.parseInt(enteredCode));
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	 }
	 
	 /*
	  * Determines if operator code is valid
	  * @param enteredCode Operator code to test
	  * @return if code is valid
	  */
	 
	 public static boolean isValidOperatorCode(String enteredCode) {
			if (enteredCode.length() != 9) return false;
			try {
				Integer.parseInt(enteredCode);
			} catch (NumberFormatException e) {
				return false;
			}
	        try {
	            Connection connection = CreateSQL.giveConnection();
	            return CreateSQL.valueExists(connection, "validoperators", "nums", Integer.parseInt(enteredCode));
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

}
