package ts.daoImpl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.util.Assert;

import ts.daoBase.BaseDao;
import ts.model.TransNode;

public class TransNodeDao extends BaseDao<TransNode, String>{
	public TransNodeDao(){
		super(TransNode.class);
	}

	public List<TransNode> findByRegionCode(String region_code) {
        Assert.hasText(region_code);
        return findBy("regionCode", region_code, "nodeName", true);
	}
	
	public List<TransNode> findByRegionCodeAndType(String region_code,int region_type) {
        Assert.hasText(region_code);
        List<TransNode> transNode = (List<TransNode>) findBy("regionCode",true,Restrictions.eq("regionCode", region_code),Restrictions.eq("nodeType", region_type));
		return transNode;
	}
	

}
