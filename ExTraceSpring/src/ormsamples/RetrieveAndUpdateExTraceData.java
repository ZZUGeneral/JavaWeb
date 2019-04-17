/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateExTraceData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = model.ExTracePersistentManager.instance().getSession().beginTransaction();
		try {
			model.DAOFactory lDAOFactory = model.DAOFactory.getDAOFactory();
			model.dao.TransNodeDAO lmodelTransNodeDAO = lDAOFactory.getTransNodeDAO();
			model.TransNode lmodelTransNode = lmodelTransNodeDAO.loadTransNodeByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
			// Update the properties of the persistent object
			model.ExTracePersistentManager.instance().getSession().save(lmodelTransNode);
			model.dao.RegionDAO lmodelRegionDAO = lDAOFactory.getRegionDAO();
			model.Region lmodelRegion = lmodelRegionDAO.loadRegionByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
			// Update the properties of the persistent object
			model.ExTracePersistentManager.instance().getSession().save(lmodelRegion);
			model.dao.UserInfoDAO lmodelUserInfoDAO = lDAOFactory.getUserInfoDAO();
			model.UserInfo lmodelUserInfo = lmodelUserInfoDAO.loadUserInfoByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
			// Update the properties of the persistent object
			model.ExTracePersistentManager.instance().getSession().save(lmodelUserInfo);
			model.dao.CustomerInfoDAO lmodelCustomerInfoDAO = lDAOFactory.getCustomerInfoDAO();
			model.CustomerInfo lmodelCustomerInfo = lmodelCustomerInfoDAO.loadCustomerInfoByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
			// Update the properties of the persistent object
			model.ExTracePersistentManager.instance().getSession().save(lmodelCustomerInfo);
			model.dao.PosionDAO lmodelPosionDAO = lDAOFactory.getPosionDAO();
			model.Posion lmodelPosion = lmodelPosionDAO.loadPosionByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
			// Update the properties of the persistent object
			model.ExTracePersistentManager.instance().getSession().save(lmodelPosion);
			model.dao.TransHistoryDAO lmodelTransHistoryDAO = lDAOFactory.getTransHistoryDAO();
			model.TransHistory lmodelTransHistory = lmodelTransHistoryDAO.loadTransHistoryByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
			// Update the properties of the persistent object
			model.ExTracePersistentManager.instance().getSession().save(lmodelTransHistory);
			model.dao.TransPackageDAO lmodelTransPackageDAO = lDAOFactory.getTransPackageDAO();
			model.TransPackage lmodelTransPackage = lmodelTransPackageDAO.loadTransPackageByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
			// Update the properties of the persistent object
			model.ExTracePersistentManager.instance().getSession().save(lmodelTransPackage);
			model.dao.ExpreesSheetDAO lmodelExpreesSheetDAO = lDAOFactory.getExpreesSheetDAO();
			model.ExpreesSheet lmodelExpreesSheet = lmodelExpreesSheetDAO.loadExpreesSheetByQuery(model.ExTracePersistentManager.instance().getSession(), null, null);
			// Update the properties of the persistent object
			model.ExTracePersistentManager.instance().getSession().save(lmodelExpreesSheet);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateExTraceData retrieveAndUpdateExTraceData = new RetrieveAndUpdateExTraceData();
			try {
				retrieveAndUpdateExTraceData.retrieveAndUpdateTestData();
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
