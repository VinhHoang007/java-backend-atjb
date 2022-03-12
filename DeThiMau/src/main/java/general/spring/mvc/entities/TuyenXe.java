package general.spring.mvc.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "TuyenXe")
@Entity(name = "TuyenXe")
public class TuyenXe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maTuyen", columnDefinition = "int")
	private int maTuyen;
	
	@Column(name = "tenTuyen", columnDefinition = "varchar(100)")
	private String tenTuyen;
	
	@Column(name = "donGia", columnDefinition = "int")
	private int donGia;
	
	@OneToMany(mappedBy = "tuyenXe",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<LichTrinhXe> stLichTrinhXe = new HashSet<LichTrinhXe>();

	public TuyenXe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TuyenXe(String tenTuyen, int donGia) {
		super();
		this.tenTuyen = tenTuyen;
		this.donGia = donGia;
	}

	public int getMaTuyen() {
		return maTuyen;
	}

	public void setMaTuyen(int maTuyen) {
		this.maTuyen = maTuyen;
	}

	public String getTenTuyen() {
		return tenTuyen;
	}

	public void setTenTuyen(String tenTuyen) {
		this.tenTuyen = tenTuyen;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "TuyenXe [maTuyen=" + maTuyen + ", tenTuyen=" + tenTuyen + ", donGia=" + donGia + "]";
	}
	
	
}
