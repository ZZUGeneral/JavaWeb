package ts.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import ts.daoBase.BaseDao;
import ts.model.CustomerInfo;
import ts.model.ExpressSheet;

public class ExpressSheetDao extends BaseDao<ExpressSheet, String> {
	private RegionDao regionDao;

	public RegionDao getRegionDao() {
		return regionDao;
	}

	public void setRegionDao(RegionDao dao) {
		this.regionDao = dao;
	}

	public ExpressSheetDao() {
		super(ExpressSheet.class);
	}

	public ExpressSheet get(String id) {
		ExpressSheet es = super.get(id);
		System.err.println(es+"========================================11111111111111111111111111111111");
		CustomerInfo ci = es.getRecever();
		if (ci != null)
			ci.setRegionString(regionDao.getRegionNameByID(ci.getRegionCode()));
		CustomerInfo cs = es.getSender();
		if (cs != null)
			cs.setRegionString(regionDao.getRegionNameByID(cs.getRegionCode()));
		return es;
	}

	// 获得指定包裹ID的所有快件列表
	public List<ExpressSheet> getListInPackage(String pkg_id) {
		String sql = "{alias}.ID in (select ExpressSheetID from TransPackageContent where TransPackageID = '" + pkg_id
				+ "' and Status = 0)";
		List<ExpressSheet> list = new ArrayList<ExpressSheet>();
		list = findBy("ID", true, Restrictions.sqlRestriction(sql));
		for (ExpressSheet es : list) {
			CustomerInfo ci = es.getRecever();
			if (ci != null)
				ci.setRegionString(regionDao.getRegionNameByID(ci.getRegionCode()));
			CustomerInfo cs = es.getSender();
			if (cs != null)
				cs.setRegionString(regionDao.getRegionNameByID(cs.getRegionCode()));
		}
		return list;
	}
}
