package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Bean.sinhVienBean;

public class sinhVienDao {
	public ArrayList<sinhVienBean> getLop() throws Exception{
		ArrayList<sinhVienBean> sv = new ArrayList<sinhVienBean>();
		// Tao cau lenh truy xuat
		String url = "select * from SinhVien";
		// Tao cau lenh
		PreparedStatement cmd = dungChung.cn.prepareStatement(url);
		// Thuc hien lenh
		ResultSet rs = cmd.executeQuery();
		// Duyet
		while(rs.next()) {
			String masv=rs.getString("masv");
			String hoten=rs.getString("hoten");
			Boolean gioitinh=rs.getBoolean("gioitinh");
			Date ngaysinh=rs.getDate("ngaysinh");
			String malop=rs.getString("malop");
			sinhVienBean lh = new sinhVienBean(masv, hoten, gioitinh, ngaysinh, malop);
			sv.add(lh);
		}
		rs.close();
		return sv;
	}
	public ArrayList<sinhVienBean> docFile() throws Exception{
		ArrayList<sinhVienBean> sv = new ArrayList<sinhVienBean>();
		FileReader f = new FileReader("sv.txt");
		BufferedReader read = new BufferedReader(f);
		while(true) {
			String st = read.readLine();
			if(st==null||st=="") break;
			String[] t = st.split("[;]");
			Boolean gt = Boolean.valueOf(t[2]);
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sd.parse(t[3]);
			sinhVienBean svBean = new sinhVienBean(t[0], t[1], gt, d, t[4]);
			sv.add(svBean);
			
		}
		read.close();
		return sv;
	}
	
	public int them(String masv,String hoten, String gioitinh,  String ngaysinh,String malop) throws Exception{
		String url = "insert into SinhVien(masv,hoten,gioitinh,ngaysinh,malop) values (?, ?, ?, ?, ?)";
		PreparedStatement cmd = dungChung.cn.prepareStatement(url);
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date d = f.parse(ngaysinh);
		Boolean gt = Boolean.valueOf(gioitinh);
		cmd.setString(1, masv);
		cmd.setString(2, hoten);
		cmd.setBoolean(3, gt);
		cmd.setDate(4, new java.sql.Date( d.getTime()));
		cmd.setString(5, malop);
		return cmd.executeUpdate();
	}
	
	public int themSql(String masv,  String hoten, Boolean gioitinh,Date ngaysinh,String malop) throws Exception{
		String url ="insert into SinhVien(masv,hoten,gioitinh,ngaysinh,malop) values (?, ?, ?, ?, ?)";
		PreparedStatement cmd = dungChung.cn.prepareStatement(url);
		cmd.setString(1, masv);
		cmd.setString(2, hoten);
		cmd.setBoolean(3, gioitinh);
		cmd.setDate(4,  new java.sql.Date( ngaysinh.getTime()));
		cmd.setString(5, malop);
		
		return cmd.executeUpdate();
	}
	
	public int xoaSql(String masv) throws Exception{
		String url = "delete from SinhVien where masv=?";
		PreparedStatement cmd = dungChung.cn.prepareStatement(url);
		cmd.setString(1, masv);
		return cmd.executeUpdate();
	}
	public int suaSql(String masv,  String ngaysinh,String hoten, String gioitinh,String malop) throws Exception{
		String url = "update SinhVien set hoten = ? ,  gioitinh = ? , ngaysinh = ?, malop= ?  where masv = ?";
		PreparedStatement cmd = dungChung.cn.prepareStatement(url);
		cmd.setString(1, hoten);
		cmd.setString(2, gioitinh);
		cmd.setString(3, ngaysinh);
		cmd.setString(4, malop);
		cmd.setString(5, masv);
		return cmd.executeUpdate();
	}


}
