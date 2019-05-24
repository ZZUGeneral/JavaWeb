package ts.daoImpl;

import java.util.List;

import ts.daoBase.BaseDao;
import ts.model.Position;


public class PositionDao extends BaseDao<Position, Integer>{
	

	Position p;
	TransNodeDao transNodeDao;
	
	public PositionDao(){
		super(Position.class);
	}
	
//	public Position findPositionByTid(String tid) {
//
//		TransNode transNode = transNodeDao.get(tid);
//		int posCode = transNode.getPoscode();
//		Position p = get(posCode);
//		return p;
//	}
	public List<Position> findByPosCode(String posCode) {
		return findLike("posCode", posCode+"%", "posCode", true);
	}

	
}
