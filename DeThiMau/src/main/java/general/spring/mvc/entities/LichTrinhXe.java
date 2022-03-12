package general.spring.mvc.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "LichTrinhXe")
@Entity(name = "LichTrinhXe")
public class LichTrinhXe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maXe", columnDefinition = "int")
	private int maXe;
	
	@Column(name = "tenTaiXe", columnDefinition = "varchar(100)")
	private String tenTaiXe;
	
	@Column(name = "maTuyen", columnDefinition = "int")
	private int maTuyen;
	
	@Id
	@Column(name = "ngayXuatBen", columnDefinition = "date")
	private LocalDate ngayXuatBen;
	
	@Id
	@Column(name = "gioXuatBen", columnDefinition = "time")
	private LocalTime gioXuatBen;
	
	@Column(name = "soLuongHanhKhach", columnDefinition = "int")
	private int soLuongHanhKhach;
	
	@ManyToOne
	@JoinColumn(name = "maTuyen",insertable = false, updatable = false)
	private TuyenXe tuyenXe;
	
	@ManyToOne
	@JoinColumn(name = "maXe",insertable = false, updatable = false)
	private Xe xe;

	public LichTrinhXe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LichTrinhXe(int maXe, String tenTaiXe, int maTuyen, LocalDate ngayXuatBen, LocalTime gioXuatBen,
			int soLuongHanhKhach) {
		super();
		this.maXe = maXe;
		this.tenTaiXe = tenTaiXe;
		this.maTuyen = maTuyen;
		this.ngayXuatBen = ngayXuatBen;
		this.gioXuatBen = gioXuatBen;
		this.soLuongHanhKhach = soLuongHanhKhach;
	}

	public int getMaXe() {
		return maXe;
	}

	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}

	public String getTenTaiXe() {
		return tenTaiXe;
	}

	public void setTenTaiXe(String tenTaiXe) {
		this.tenTaiXe = tenTaiXe;
	}

	public int getMaTuyen() {
		return maTuyen;
	}

	public void setMaTuyen(int maTuyen) {
		this.maTuyen = maTuyen;
	}

	public LocalDate getNgayXuatBen() {
		return ngayXuatBen;
	}

	public void setNgayXuatBen(LocalDate ngayXuatBen) {
		this.ngayXuatBen = ngayXuatBen;
	}

	public LocalTime getGioXuatBen() {
		return gioXuatBen;
	}

	public void setGioXuatBen(LocalTime gioXuatBen) {
		this.gioXuatBen = gioXuatBen;
	}

	public int getSoLuongHanhKhach() {
		return soLuongHanhKhach;
	}

	public void setSoLuongHanhKhach(int soLuongHanhKhach) {
		this.soLuongHanhKhach = soLuongHanhKhach;
	}

	@Override
	public String toString() {
		return "LichTrinhXe [maXe=" + maXe + ", tenTaiXe=" + tenTaiXe + ", maTuyen=" + maTuyen + ", ngayXuatBen="
				+ ngayXuatBen + ", gioXuatBen=" + gioXuatBen + ", soLuongHanhKhach=" + soLuongHanhKhach + "]";
	}
	
	
	
	
	
	
	
}
