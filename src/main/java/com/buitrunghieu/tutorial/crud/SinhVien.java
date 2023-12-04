package com.buitrunghieu.tutorial.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "t_sinhvien")
public class SinhVien {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
	 	private String masv;
	 	private String hoten;
	 	private String tenkhoa;
	 	private String gioitinh;
	 	
	 	 @Min(value = 0, message = "Điểm tin nhập vào phải lớn hơn 0")
	     @Max(value = 10, message = "Điểm tin nhập vào phải nhỏ hơn hoặc bằng 10")
	 	private float diemtin;

		public SinhVien(String masv, String hoten, String tenkhoa, String gioitinh, float diemtin) {
			super();
			this.masv = masv;
			this.hoten = hoten;
			this.tenkhoa = tenkhoa;
			this.gioitinh = gioitinh;
			this.diemtin = diemtin;
		}
		
		

		public SinhVien() {
		
			
		}



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public String getTenkhoa() {
			return tenkhoa;
		}

		public void setTenkhoa(String tenkhoa) {
			this.tenkhoa = tenkhoa;
		}

		public String getGioitinh() {
			return gioitinh;
		}

		public void setGioitinh(String gioitinh) {
			this.gioitinh = gioitinh;
		}

		public float getDiemtin() {
			return diemtin;
		}

		public void setDiemtin(float diemtin) {
			this.diemtin = diemtin;
		}
	 	 
	 	 
	 	 
}
