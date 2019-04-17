/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package model;

import model.dao.*;

public abstract class DAOFactory {
	private static DAOFactory _factory = new DAOFactoryImpl();
	
	public static DAOFactory getDAOFactory() {
		return _factory;
	}
	
	public abstract TransNodeDAO getTransNodeDAO();
	public abstract RegionDAO getRegionDAO();
	public abstract UserInfoDAO getUserInfoDAO();
	public abstract CustomerInfoDAO getCustomerInfoDAO();
	public abstract PosionDAO getPosionDAO();
	public abstract TransHistoryDAO getTransHistoryDAO();
	public abstract TransPackageDAO getTransPackageDAO();
	public abstract ExpreesSheetDAO getExpreesSheetDAO();
}

