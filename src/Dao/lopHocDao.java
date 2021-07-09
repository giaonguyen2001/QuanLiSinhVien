package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.lopHocBean;

public class lopHocDao {
	public ArrayList<lopHocBean> getLop() throws Exception{
		ArrayList<lopHocBean> ds = new ArrayList<lopHocBean>();
		// Tao cau lenh truy xuat
		String url = "select * from LopHoc";
		// Tao cau lenh
		PreparedStatement cmd = dungChung.cn.prepareStatement(url);
		// Thuc hien lenh
		ResultSet rs = cmd.executeQuery();
		// Duyet
		while(rs.next()) {
			String malop=rs.getString("malop");
			String tenlop=rs.getString("tenlop");
			lopHocBean lh = new lopHocBean(malop,tenlop);
			ds.add(lh);
		}
		rs.close();
		return ds;
	}
	public int themDao(String malop, String tenlop) throws Exception{
		String url ="insert into LopHoc(malop,tenlop) values (?, ?)";
		PreparedStatement cmd = dungChung.cn.prepareStatement(url);
		cmd.setString(1, malop);
		cmd.setString(2, tenlop);
		return cmd.executeUpdate();
	}
	
	public int xoaDao(String malop) throws Exception{
		String sql = "delete from LopHOc where malop=?";
		PreparedStatement cmd = dungChung.cn.prepareStatement(sql);
		cmd.setString(1, malop);
		return cmd.executeUpdate();
	}
	
	public int suaDao(String malop, String tenlop) throws Exception{
		String sql = "update LopHoc set tenlop = ? where malop = ? ";
		PreparedStatement cmd = dungChung.cn.prepareStatement(sql);
		cmd.setString(1, tenlop);
		cmd.setString(2, malop);
	
		return cmd.executeUpdate();
	}
	
}
