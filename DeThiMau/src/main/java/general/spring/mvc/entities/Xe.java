package general.spring.mvc.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "Xe")
@Entity(name = "Xe")
public class Xe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maXe", columnDefinition = "int")
	private int maXe;
	

	@Column(name = "hangSanXuat", columnDefinition = "varchar(100)")
	private String hangSanXuat;
	
	@Column(name = "maLoaiXe", columnDefinition = "int")
	private String maLoaiXe;
	
	@Column(name = "bienSo", columnDefinition = "varchar(10)")
	private String bienSo;
	
//	@DateTimeFormat(pattern = "yyyy-MM-dd") localDate
	@Column(name = "hanKiemDinh", columnDefinition = "date")
	private String hanKiemDinh;
	
	@Column(name = "maNhaXe", columnDefinition = "int")
	private int maNhaXe;
	
	@OneToMany(mappedBy = "xe",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<LichTrinhXe> setLichTrinhXe = new HashSet<LichTrinhXe>();
	
	@ManyToOne
	@JoinColumn(name = "maLoaiXe",insertable = false, updatable = false)
	private LoaiXe loaiXe;
	
	@ManyToOne
	@JoinColumn(name = "maNhaXe",insertable = false, updatable = false)
	private NhaXe nhaXe;


	public int getMaXe() {
		return maXe;
	}

	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public String getMaLoaiXe() {
		return maLoaiXe;
	}

	public void setMaLoaiXe(String maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}

	public String getBienSo() {
		return bienSo;
	}

	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}


	public int getMaNhaXe() {
		return maNhaXe;
	}

	public void setMaNhaXe(int maNhaXe) {
		this.maNhaXe = maNhaXe;
	}

	public Set<LichTrinhXe> getSetLichTrinhXe() {
		return setLichTrinhXe;
	}

	public void setSetLichTrinhXe(Set<LichTrinhXe> setLichTrinhXe) {
		this.setLichTrinhXe = setLichTrinhXe;
	}

	public LoaiXe getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}

	public NhaXe getNhaXe() {
		return nhaXe;
	}

	public void setNhaXe(NhaXe nhaXe) {
		this.nhaXe = nhaXe;
	}


	
	
	public Xe(String hangSanXuat, String maLoaiXe, String bienSo, String hanKiemDinh, int maNhaXe) {
		super();
		this.hangSanXuat = hangSanXuat;
		this.maLoaiXe = maLoaiXe;
		this.bienSo = bienSo;
		this.hanKiemDinh = hanKiemDinh;
		this.maNhaXe = maNhaXe;
	}

	public Xe() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getHanKiemDinh() {
		return hanKiemDinh;
	}

	public void setHanKiemDinh(String hanKiemDinh) {
		this.hanKiemDinh = hanKiemDinh;
	}

	@Override
	public String toString() {
		return "Xe [maXe=" + maXe + ", hangSanXuat=" + hangSanXuat + ", maLoaiXe=" + maLoaiXe + ", bienSo=" + bienSo
				+ ", hanKiemDinh=" + hanKiemDinh + ", maNhaXe=" + maNhaXe + "]";
	}
	
	
	
	
	
	
	
	
}
