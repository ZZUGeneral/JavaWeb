/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateExTraceData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = model.ExTracePersistentManager.instance().getSession().beginTransaction();
		try {
			model.DAOFactory lDAOFactory = model.DAOFactory.getDAOFactory();
			model.dao.TransNodeDAO lmodelTransNodeDAO = lDAOFactory.getTransNodeDAO();
			model.TransNode lmodelTransNode = lmodelTransNodeDAO.createTransNode();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : telCode, nodeType
			model.ExTracePersistentManager.instance().getSession().save(lmodelTransNode);
			model.dao.RegionDAO lmodelRegionDAO = lDAOFactory.getRegionDAO();
			model.Region lmodelRegion = lmodelRegionDAO.createRegion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : stage
			model.ExTracePersistentManager.instance().getSession().save(lmodelRegion);
			model.dao.UserInfoDAO lmodelUserInfoDAO = lDAOFactory.getUserInfoDAO();
			model.UserInfo lmodelUserInfo = lmodelUserInfoDAO.createUserInfo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : status, telCode, URull
			model.ExTracePersistentManager.instance().getSession().save(lmodelUserInfo);
			model.dao.CustomerInfoDAO lmodelCustomerInfoDAO = lDAOFactory.getCustomerInfoDAO();
			model.CustomerInfo lmodelCustomerInfo = lmodelCustomerInfoDAO.createCustomerInfo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : expreesReceiver, expreesSender, postCode
			model.ExTracePersistentManager.instance().getSession().save(lmodelCustomerInfo);
			model.dao.PosionDAO lmodelPosionDAO = lDAOFactory.getPosionDAO();
			model.Posion lmodelPosion = lmodelPosionDAO.createPosion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : y, x
			model.ExTracePersistentManager.instance().getSession().save(lmodelPosion);
			model.dao.TransHistoryDAO lmodelTransHistoryDAO = lDAOFactory.getTransHistoryDAO();
			model.TransHistory lmodelTransHistory = lmodelTransHistoryDAO.createTransHistory();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : UIDTo, UIDFrom, actTime, packeg
			model.ExTracePersistentManager.instance().getSession().save(lmodelTransHistory);
			model.dao.TransPackageDAO lmodelTransPackageDAO = lDAOFactory.getTransPackageDAO();
			model.TransPackage lmodelTransPackage = lmodelTransPackageDAO.createTransPackage();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : transHistory, expreesSheet, status
			model.ExTracePersistentManager.instance().getSession().save(lmodelTransPackage);
			model.dao.ExpreesSheetDAO lmodelExpreesSheetDAO = lDAOFactory.getExpreesSheetDAO();
			model.ExpreesSheet lmodelExpreesSheet = lmodelExpreesSheetDAO.createExpreesSheet();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : transPackage, recever, sender, type
			model.ExTracePersistentManager.instance().getSession().save(lmodelExpreesSheet);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateExTraceData createExTraceData = new CreateExTraceData();
			try {
				createExTraceData.createTestData();
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
