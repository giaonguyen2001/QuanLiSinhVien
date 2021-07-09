package Bo;

import java.util.ArrayList;

import Bean.lopHocBean;
import Dao.lopHocDao;


public class lopHocBo {
	lopHocDao lhDao = new lopHocDao();
	ArrayList<lopHocBean> ds;
	public ArrayList<lopHocBean> getlh() throws Exception{
		ds=lhDao.getLop();
		return ds;
	}
	public ArrayList<lopHocBean> timlh(String key) {
		ArrayList<lopHocBean> tam = new ArrayList<lopHocBean>();
		for(lopHocBean dv:ds)
			if(dv.getMalop().toLowerCase().trim().contains(key.toLowerCase().trim()))
				tam.add(dv);
		return tam;
	}
	public int them(String malop, String tenlop) throws Exception{
		for(lopHocBean dv:ds)
				if(dv.getMalop().equals(malop))
					return 0;
		lopHocBean dv = new lopHocBean(malop, tenlop);
		ds.add(dv);
		return lhDao.themDao(malop,tenlop);
	}
	
	public int xoa(String malop) throws Exception{
		for(lopHocBean dv:ds) {
			if(dv.getMalop().equals(malop)) 
				ds.remove(dv);
		}
		return lhDao.xoaDao(malop);
	}
	
	public int Sua(String malop, String tenlop) throws Exception{
		int n = ds.size();
		for(int i=0 ; i<n ; i++) {
			lopHocBean dv = ds.get(i);
			if(dv.getMalop().equals(malop)) {
				dv.setTenlop(tenlop);
				ds.set(i, dv);
				return lhDao.suaDao(malop, tenlop);
			}
		}
		return 0;
	}

}
