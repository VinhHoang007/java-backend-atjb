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

@Table(name = "NhaXe")
@Entity(name = "NhaXe")
public class NhaXe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maNhaXe", columnDefinition = "int")
	private int maNhaXe;
	
	@Column(name = "tenNhaXe", columnDefinition = "varchar(100)")
	private String tenNhaXe;
	
	@Column(name = "namThanhLap", columnDefinition = "int")
	private int namThanhLap;
	
	@OneToMany(mappedBy = "nhaXe",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Xe> setXe = new HashSet<Xe>();

	public NhaXe(String tenNhaXe, int namThanhLap) {
		super();
		this.tenNhaXe = tenNhaXe;
		this.namThanhLap = namThanhLap;
	}

	public NhaXe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaNhaXe() {
		return maNhaXe;
	}

	public void setMaNhaXe(int maNhaXe) {
		this.maNhaXe = maNhaXe;
	}

	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	public int getNamThanhLap() {
		return namThanhLap;
	}

	public void setNamThanhLap(int namThanhLap) {
		this.namThanhLap = namThanhLap;
	}

	@Override
	public String toString() {
		return "NhaXe [maNhaXe=" + maNhaXe + ", tenNhaXe=" + tenNhaXe + ", namThanhLap=" + namThanhLap +"]";
	}
	
	
	
	
}
