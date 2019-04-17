/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class ListExTraceData {
	private static final int ROW_COUNT = 100;
	
public void listTestData() throws PersistentException {
		model.DAOFactory lDAOFactory = model.DAOFactory.getDAOFactory();
		System.out.println("Listing TransNode...");
		model.TransNode[] modelTransNodes = lDAOFactory.getTransNodeDAO().listTransNodeByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
		int length = Math.min(modelTransNodes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modelTransNodes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Region...");
		model.Region[] modelRegions = lDAOFactory.getRegionDAO().listRegionByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
		length = Math.min(modelRegions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modelRegions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing UserInfo...");
		model.UserInfo[] modelUserInfos = lDAOFactory.getUserInfoDAO().listUserInfoByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
		length = Math.min(modelUserInfos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modelUserInfos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing CustomerInfo...");
		model.CustomerInfo[] modelCustomerInfos = lDAOFactory.getCustomerInfoDAO().listCustomerInfoByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
		length = Math.min(modelCustomerInfos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modelCustomerInfos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Posion...");
		model.Posion[] modelPosions = lDAOFactory.getPosionDAO().listPosionByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
		length = Math.min(modelPosions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modelPosions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing TransHistory...");
		model.TransHistory[] modelTransHistorys = lDAOFactory.getTransHistoryDAO().listTransHistoryByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
		length = Math.min(modelTransHistorys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modelTransHistorys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing TransPackage...");
		model.TransPackage[] modelTransPackages = lDAOFactory.getTransPackageDAO().listTransPackageByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
		length = Math.min(modelTransPackages.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modelTransPackages[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ExpreesSheet...");
		model.ExpreesSheet[] modelExpreesSheets = lDAOFactory.getExpreesSheetDAO().listExpreesSheetByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
		length = Math.min(modelExpreesSheets.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(modelExpreesSheets[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public static void main(String[] args) {
		try {
			ListExTraceData listExTraceData = new ListExTraceData();
			try {
				listExTraceData.listTestData();
			}
			finally {
				model.ExTracePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
