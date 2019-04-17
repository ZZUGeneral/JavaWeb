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

import model.impl.*;
import model.dao.*;

public class DAOFactoryImpl extends DAOFactory {
	private TransNodeDAO _transNodeDAO = new TransNodeDAOImpl();
	public TransNodeDAO getTransNodeDAO() {
		return _transNodeDAO;
	}
	
	private RegionDAO _regionDAO = new RegionDAOImpl();
	public RegionDAO getRegionDAO() {
		return _regionDAO;
	}
	
	private UserInfoDAO _userInfoDAO = new UserInfoDAOImpl();
	public UserInfoDAO getUserInfoDAO() {
		return _userInfoDAO;
	}
	
	private CustomerInfoDAO _customerInfoDAO = new CustomerInfoDAOImpl();
	public CustomerInfoDAO getCustomerInfoDAO() {
		return _customerInfoDAO;
	}
	
	private PosionDAO _posionDAO = new PosionDAOImpl();
	public PosionDAO getPosionDAO() {
		return _posionDAO;
	}
	
	private TransHistoryDAO _transHistoryDAO = new TransHistoryDAOImpl();
	public TransHistoryDAO getTransHistoryDAO() {
		return _transHistoryDAO;
	}
	
	private TransPackageDAO _transPackageDAO = new TransPackageDAOImpl();
	public TransPackageDAO getTransPackageDAO() {
		return _transPackageDAO;
	}
	
	private ExpreesSheetDAO _expreesSheetDAO = new ExpreesSheetDAOImpl();
	public ExpreesSheetDAO getExpreesSheetDAO() {
		return _expreesSheetDAO;
	}
	
}

