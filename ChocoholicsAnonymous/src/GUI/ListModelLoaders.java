/*
 * Provides all methods to load ListModels.
 * 
 * @author Nathaniel_Hershner
 * 
 * @since 2024-01-27
 */

package GUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;

public class ListModelLoaders {
	
	/*
	 * Provides a ListModel of provider reports based on the provider number given
	 * @param code Provider num
	 * @return ListModel of provider reports
	 */
	
	public static DefaultListModel<String> loadListModelProviderReports(String code) {
    	List<String> reports = extractProviderReports(code);
    	DefaultListModel<String> listModel = new DefaultListModel<>();
    	for (String providerReport : reports) {
            listModel.addElement(providerReport);
        }
    	return listModel;
    }
	
	/*
	 * Extracts the provider reports for the loadListModelProviderReports method
	 * @paramm code Provider num
	 * @return list of provider reports
	 */
	
    private static List<String> extractProviderReports(String code){
    	List<String> providerReports = new ArrayList<>();
    	String line;
    	line = "Provider name: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "name", "num", code);
    	providerReports.add(line);
    	line = "Provider address: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "address", "num", code);
    	providerReports.add(line);
    	line = "Provider city: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "city", "num", code);
    	providerReports.add(line);
    	line = "Provider state: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "state", "num", code);
    	providerReports.add(line);
    	line = "Provider zipcode: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "zipcode", "num", code);
    	providerReports.add(line);
		line = "";
		addFourEmptyLines(providerReports);
		if (CreateSQL.getCountBasedOnCondition(CreateSQL.giveConnection(), "bill", "providercode", "providercode", code) == 0) {
			line = "Consultations provided: 0";
			providerReports.add(line);
			line = "Total owed: $0";
			providerReports.add(line);
			return providerReports;
		}
    	int numReports = CreateSQL.getCountBasedOnCondition(CreateSQL.giveConnection(), "bill", "providercode", "providercode", code);
    	line = "Consultations provided: " + numReports;
    	int sum = 0;
    	providerReports.add(line);
    	String[] arr = CreateSQL.getValuesBasedOnCondition(CreateSQL.giveConnection(), "bill", "servicecode", "providercode", code);
    	for (int i = 0; i < numReports; i++) sum += (Integer.parseInt(arr[i]) % 1000);
    	line = "Total owed: $" + sum;
    	providerReports.add(line);
    	return providerReports;    	
    }
    
    /*
     * Provides a ListModel of provider numbers
     * @return provider number ListModel
     */
    
	public static DefaultListModel<String> loadListModelProviderNumbers() {
    	Set<String> memberNumbers = extractProviderNumbers();
    	DefaultListModel<String> listModel = new DefaultListModel<>();
        // Add member numbers to the list model
        for (String memberNumber : memberNumbers) {
            listModel.addElement(memberNumber);
        }
        return listModel;
    }
	
	/*
	 * Gets the provider numbers for the loadListModelProviderNumbers method
	 * @return Set of provider numbers
	 */
	
	private static Set<String> extractProviderNumbers() {
    	Set<String> providerNumbers = new HashSet<>();
        String line;
        int numCodes = CreateSQL.getColumnItemCount(CreateSQL.giveConnection(), "validproviders", "nums");
        int[] arr = CreateSQL.getColumnValuesInt(CreateSQL.giveConnection(), "validproviders", "nums");
        for (int i = 0; i < numCodes; i++) {
        	line = Integer.toString(arr[i]);
        	providerNumbers.add(line);
        }
        return providerNumbers;
    }
	
	/*
	 * Provides a ListModel of member numbers
	 * @return member number ListModel
	 */
	
	public static DefaultListModel<String> loadListModelMemberNumbers() {
    	Set<String> memberNumbers = extractMemberNumbers();
    	DefaultListModel<String> listModel = new DefaultListModel<>();
        // Add member numbers to the list model
        for (String memberNumber : memberNumbers) {
            listModel.addElement(memberNumber);
        }
        return listModel;
    }
	
	/*
	 * Extracts member numbers for loadListMoodelMemberNumbers method
	 * @return Set of member numbers
	 */
	
	private static Set<String> extractMemberNumbers() {
    	Set<String> memberNumbers = new HashSet<>();

        String line;
        int numCodes = CreateSQL.getColumnItemCount(CreateSQL.giveConnection(), "members", "valid");
        int[] arr = CreateSQL.getColumnValuesInt(CreateSQL.giveConnection(), "members", "valid");
        for (int i = 0; i < numCodes; i++) {
        	line = Integer.toString(arr[i]);
        	memberNumbers.add(line);
        }
        return memberNumbers;
    }
	
	/*
	 * Provides ListModel of member reports based on a member number
	 * @param code Member number
	 * @return member reports ListModel
	 */
	
	public static DefaultListModel<String> loadListModelMemberReports(String code) {
    	List<String> reports = extractMemberReports(code);
    	DefaultListModel<String> listModel = new DefaultListModel<>();
    	for (String memberNumber : reports) {
            listModel.addElement(memberNumber);
        }
    	return listModel;
    }
	
	/*
	 * Extracts member reports for loadListMoodelMemberReports method
	 * @param code Member Number
	 * @return List of member reports
	 */
	
    private static List<String> extractMemberReports(String code){
    	List<String> memberReports = new ArrayList<>();
    	String line;
    	line = "Member name: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "memberinfo", "name", "num", code);
    	memberReports.add(line);
    	line = "Member address: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "memberinfo", "address", "num", code);
    	memberReports.add(line);
    	line = "Member city: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "memberinfo", "city", "num", code);
    	memberReports.add(line);
    	line = "Member state: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "memberinfo", "state", "num", code);
    	memberReports.add(line);
    	line = "Member zipcode: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "memberinfo", "zipcode", "num", code);
    	memberReports.add(line);
		line = "";
		addFourEmptyLines(memberReports);
    	int numReports = CreateSQL.getCountBasedOnCondition(CreateSQL.giveConnection(), "bill", "servicedate", "membercode", code);
    	String[] billDates = CreateSQL.getValuesBasedOnCondition(CreateSQL.giveConnection(), "bill", "billdate", "membercode", code);
    	String[] serviceDates = CreateSQL.getValuesBasedOnCondition(CreateSQL.giveConnection(), "bill", "servicedate", "membercode", code);
    	String[] comments = CreateSQL.getValuesBasedOnCondition(CreateSQL.giveConnection(), "bill", "comments", "membercode", code);
    	String[] providerCodes = CreateSQL.getValuesBasedOnCondition(CreateSQL.giveConnection(), "bill", "providercode", "membercode", code);
    	String[] serviceCodes = CreateSQL.getValuesBasedOnCondition(CreateSQL.giveConnection(), "bill", "servicecode", "membercode", code);
    	for (int i = 0; i < numReports; i++) {
    		line = "Report " + (i + 1);
    		memberReports.add(line);
    		line = "Bill date: " + billDates[i];
    		memberReports.add(line);
    		line = "Service date: " + serviceDates[i];
    		memberReports.add(line);
    		line = "Service code: " + serviceCodes[i];
    		memberReports.add(line);
    		line = "Provider code: " + providerCodes[i];
    		memberReports.add(line);
    		line = "Comments: " + comments[i];
    		memberReports.add(line);
    		if (i != numReports - 1) {
    			addFourEmptyLines(memberReports);
    		}
    	}
    	return memberReports;
    	
    }
    
    /*
     * Provides ListModel of EFT reports based on a provider code
     * @param code Provider number
     * @return ListModel of EFT reports
     */
    
    public static DefaultListModel<String> loadListModelEFTReport(String code){
    	DefaultListModel<String> listModel = new DefaultListModel<>();
    	int sum = 0;
    	listModel.addElement("Provider name: " + CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo" , "name", "num", code));
    	listModel.addElement("Provider Number: " + code);
    	int numReports = CreateSQL.getCountBasedOnCondition(CreateSQL.giveConnection(), "bill", "providercode", "providercode", code);
    	String[] arr = CreateSQL.getValuesBasedOnCondition(CreateSQL.giveConnection(), "bill", "servicecode", "providercode", code);
    	for (int i = 0; i < numReports; i++) sum += (Integer.parseInt(arr[i]) % 1000);
    	listModel.addElement("Amount to transfer: $" + sum);
    	return listModel;
    }
    
    /*
     * Provides ListModel of the summary report
     * @return ListModel of summary report
     */
    
    public static DefaultListModel<String> loadListModelSummaryReport(){
    	DefaultListModel<String> listModel = new DefaultListModel<>();
    	Set<String> providers = new HashSet<>();
    	int totalFee = 0;
    	String[] providerCodes = CreateSQL.getColumnValuesString(CreateSQL.giveConnection(), "bill", "providercode");
    	for (int i = 0; i < providerCodes.length; i++) providers.add(providerCodes[i]);
    	listModel.addElement("Total number of providers who provided service: " + providers.size());
    	listModel.addElement("Total number of consultations: " + CreateSQL.getColumnItemCount(CreateSQL.giveConnection(), "bill", "comments"));
    	addFourEmptyLines(listModel);
    	for (String num : providers) {
    		int sum = 0;
    		int consultations = CreateSQL.getCountBasedOnCondition(CreateSQL.giveConnection(), "bill", "providercode", "providercode", num);
    		String[] serviceCodes = CreateSQL.getValuesBasedOnCondition(CreateSQL.giveConnection(), "bill", "servicecode", "providercode", num);
        	for (int i = 0; i < consultations; i++) sum += (Integer.parseInt(serviceCodes[i]) % 1000);
        	listModel.addElement("Provider " + num + " had " + consultations + " consultations");
        	listModel.addElement("Total fee for provider: $" + sum);
        	totalFee += sum;
        	addFourEmptyLines(listModel);
    	}
    	listModel.addElement("Total fee for all providers: $" + totalFee);
    	return listModel;	
    }
    
    /*
     * Provides ListModel for main accounting procedure
     * @return main accounting procedure ListModel
     */
    
    public static DefaultListModel<String> loadListModelAccountingProcedure(){
    	DefaultListModel<String> listModel = new DefaultListModel<>();
    	String line;
    	int totalSum = 0;
    	int[] providerNums = CreateSQL.getColumnValuesInt(CreateSQL.giveConnection(), "validproviders", "nums");
    	line = "Current Providers";
    	listModel.addElement(line);
    	addFourEmptyLines(listModel);
    	for (int num : providerNums) listModel.addElement(Integer.toString(num));
    	addFourEmptyLines(listModel);
    	line = "Current Members";
    	listModel.addElement(line);
    	addFourEmptyLines(listModel);
    	int[] memberNums = CreateSQL.getColumnValuesInt(CreateSQL.giveConnection(), "members", "valid");
    	for (int num : memberNums) listModel.addElement(Integer.toString(num));
    	addFourEmptyLines(listModel);
    	int[] suspendedNums = CreateSQL.getColumnValuesInt(CreateSQL.giveConnection(), "suspendedmembers", "nums");
    	line = "Current Suspended Members";
    	listModel.addElement(line);
    	addFourEmptyLines(listModel);
    	for (int num : suspendedNums) listModel.addElement(Integer.toString(num));
    	addFourEmptyLines(listModel);
    	for (int num : providerNums) {
    		int sum = 0;
    		line = "Provider " + num;
    		listModel.addElement(line);
    		addFourEmptyLines(listModel);
        	line = "Number of consulations: " + CreateSQL.getCountBasedOnCondition(CreateSQL.giveConnection(), "bill", "providercode", "providercode", Integer.toString(num));
        	listModel.addElement(line);
        	String[] serviceCodes = CreateSQL.getValuesBasedOnCondition(CreateSQL.giveConnection(), "bill", "servicecode", "providercode", Integer.toString(num));
        	for (int i = 0; i < serviceCodes.length; i++) sum += (Integer.parseInt(serviceCodes[i]) % 1000);
        	line = "Provider is owed $" + sum;
        	totalSum += sum;
        	listModel.addElement(line);
        	addFourEmptyLines(listModel);
    	}
    	line = "Total owed to providers is $" + totalSum;
    	listModel.addElement(line);
    	return listModel;
    }
    
    /*
     * Provides ListModel of the provider directory
     * @return provider directory ListModel
     */
    
    public static DefaultListModel<String> loadListModelProviderDirectory() {
    	DefaultListModel<String> listModel = new DefaultListModel<>();
        String line;
        int numCodes = CreateSQL.getColumnItemCount(CreateSQL.giveConnection(), "providerdirectory", "codes");
        int[] arr = CreateSQL.getColumnValuesInt(CreateSQL.giveConnection(), "providerdirectory", "codes");
        String[] arr2 = CreateSQL.getColumnValuesString(CreateSQL.giveConnection(), "providerdirectory", "descriptions");
        for (int i = 0; i < numCodes; i++) {
        	line = arr[i] + "                                       " + arr2[i];
        	listModel.addElement(line);
        }
        return listModel;
    }
    
    /*
     * Adds empty lines to ListModel as needed in other methods of this class
     * @param listModel Structure to add the lines to
     */
    
    private static void addFourEmptyLines(DefaultListModel<String> listModel) {
    	listModel.addElement("");
    	listModel.addElement("");
    	listModel.addElement("");
    	listModel.addElement("");
    }
    
    /*
     * Adds empty lines to List as needed in other methods of this class
     * @param list Structure to add lines to
     */
    
    private static void addFourEmptyLines(List<String> list) {
    	list.add("");
    	list.add("");
    	list.add("");;
    	list.add("");
    }

}

