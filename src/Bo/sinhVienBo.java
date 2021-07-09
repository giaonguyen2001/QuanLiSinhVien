package Bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Bean.sinhVienBean;
import Dao.sinhVienDao;



public class sinhVienBo {

	sinhVienDao svDao = new sinhVienDao();
	
	ArrayList<sinhVienBean> ds;
	public ArrayList<sinhVienBean> getsv() throws Exception{
		ds=svDao.getLop();
		return ds;
	}	
	public int Import() throws Exception{
		for(sinhVienBean svbean : svDao.docFile()) {
			for(sinhVienBean sv :ds) {
				if(svbean.getMasv().equals(sv.getMasv())) return 0;
			}
			 svDao.themSql(svbean.getMasv(), svbean.getHoten(), svbean.getGioitinh(), svbean.getNgaysinh(), svbean.getMalop());
	
		}
		return 1;
}

	public ArrayList<sinhVienBean> timsv(String key) {
		ArrayList<sinhVienBean> tam = new ArrayList<sinhVienBean>();
		for(sinhVienBean dv: ds)
			if(dv.getMasv().toLowerCase().trim().contains(key.toLowerCase().trim()))
				tam.add(dv);
		return tam;
	}
	
	public int them(String masv, String hoten,  String gioitinh,String ngaysinh,String malop) throws Exception{
		for(sinhVienBean nv:ds) 
			if(nv.getMasv().equals(masv))
				return 0;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date d = f.parse(ngaysinh);
		Boolean gt = Boolean.valueOf(gioitinh);
		sinhVienBean nv = new sinhVienBean(masv, hoten, gt, d, malop);
		ds.add(nv);
		return svDao.them(masv, hoten, gioitinh, ngaysinh, malop);
	}
	
	public int xoa(String masv) throws Exception{
		for(sinhVienBean nv:ds)
			if(nv.getMasv().equals(masv)) {
				ds.remove(nv);
				return svDao.xoaSql(masv);
			}
		return 0;		
	}
	
	public int sua(String masv, String hoten,  String gioitinh,String ngaysinh,String malop) throws Exception{
		int n = ds.size();
		for(int i=0;i<n;i++) {
			sinhVienBean sv = ds.get(i);
			if(sv.getMasv().equals(masv)) {
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				Date d = f.parse(ngaysinh);
				Boolean gt = Boolean.valueOf(gioitinh);	
				sv.setHoten(hoten);
				sv.setGioitinh(gt);
				sv.setNgaysinh(d);
				sv.setMalop(malop);
				ds.set(i, sv);
				
				return svDao.suaSql(masv, ngaysinh, hoten, gioitinh, malop);
			}
		}
		return 0;
	}
}
