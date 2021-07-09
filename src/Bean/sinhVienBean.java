package Bean;

import java.util.Date;

public class sinhVienBean {
	private String masv;
	private String hoten;
	private Boolean gioitinh;
	private Date ngaysinh;
	private String malop;
	
	public sinhVienBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public sinhVienBean(String masv, String hoten, Boolean gioitinh, Date ngaysinh, String malop) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.malop = malop;
	}
	
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Boolean getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	
}
