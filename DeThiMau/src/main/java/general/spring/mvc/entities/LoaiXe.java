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

@Table(name = "LoaiXe")
@Entity(name = "LoaiXe")
public class LoaiXe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maLoaiXe", columnDefinition = "int")
	private int maLoaiXe;
	
	@Column(name = "moTaLoaiXe", columnDefinition = "varchar(100)")
	private String moTaLoaiXe;
	
	@Column(name = "soLuongChoNgoi", columnDefinition = "int")
	private int soLuongChoNgoi;
	
	@OneToMany(mappedBy = "loaiXe",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Xe> setXe = new HashSet<Xe>();

	public LoaiXe(String moTaLoaiXe, int soLuongChoNgoi) {
		super();
		this.moTaLoaiXe = moTaLoaiXe;
		this.soLuongChoNgoi = soLuongChoNgoi;
	}

	public LoaiXe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaLoaiXe() {
		return maLoaiXe;
	}

	public void setMaLoaiXe(int maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}

	public String getMoTaLoaiXe() {
		return moTaLoaiXe;
	}

	public void setMoTaLoaiXe(String moTaLoaiXe) {
		this.moTaLoaiXe = moTaLoaiXe;
	}

	public int getSoLuongChoNgoi() {
		return soLuongChoNgoi;
	}

	public void setSoLuongChoNgoi(int soLuongChoNgoi) {
		this.soLuongChoNgoi = soLuongChoNgoi;
	}

	public Set<Xe> getSetXe() {
		return setXe;
	}

	public void setSetXe(Set<Xe> setXe) {
		this.setXe = setXe;
	}

	@Override
	public String toString() {
		return "LoaiXe [maLoaiXe=" + maLoaiXe + ", moTaLoaiXe=" + moTaLoaiXe + ", soLuongChoNgoi=" + soLuongChoNgoi
				+ "]";
	}
	
	
	
	
}
