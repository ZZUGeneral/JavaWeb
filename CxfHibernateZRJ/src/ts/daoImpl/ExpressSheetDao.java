package ts.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import ts.daoBase.BaseDao;
import ts.model.CustomerInfo;
import ts.model.ExpressSheet;

public class ExpressSheetDao extends BaseDao<ExpressSheet,String> {
	private RegionDao regionDao;
	public RegionDao getRegionDao() {
		return regionDao;
	}
	public void setRegionDao(RegionDao dao) {
		this.regionDao = dao;
	}

	public ExpressSheetDao(){
		super(ExpressSheet.class);
	}

	//��д��get����,���ͻ��������ַ�������
	public ExpressSheet get(String id) {
		ExpressSheet es = super.get(id);
		CustomerInfo ci = es.getRecever();
		if(ci!= null)
			ci.setRegionString(regionDao.getRegionNameByID(ci.getRegionCode()));	//��ȡ����������ַ���
		CustomerInfo cs = es.getSender();
		if(cs != null) 
			cs.setRegionString(regionDao.getRegionNameByID(cs.getRegionCode()));	//��ȡ����������ַ���
		return es;
	}

	//���ָ������ID�����п���б�
	public List<ExpressSheet> getListInPackage(String pkg_id) {	
		String sql = "{alias}.ID in (select ExpressSheetID from TransPackageContent where TransPackageID = '"+pkg_id+"' and Status = 0)";
		List<ExpressSheet> list = new ArrayList<ExpressSheet>();
		list = findBy("ID", true, Restrictions.sqlRestriction(sql));		
		return list;
	}
}
