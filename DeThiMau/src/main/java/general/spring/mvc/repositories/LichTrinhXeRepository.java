package general.spring.mvc.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LichTrinhXeRepository {
	@Autowired
	SessionFactory sf;

	public List<Object[]> getLichTrinhXe() {
		Session session = sf.openSession();
		List<Object[]> lstEntity = null;

		try {

			String hSql = "select x.maXe, x.bienSo, ltx.tenTaiXe, nx.tenNhaXe,tx.maTuyen "
					+ ",tx.tenTuyen, ltx.ngayXuatBen, ltx.gioXuatBen "
					+ "from xe x "
					+ "inner join LichTrinhXe ltx on ltx.maXe = x.maXe "
					+ "inner join NhaXe nx on nx.maNhaXe = x.maNhaXe "
					+ "inner join TuyenXe tx on ltx.maTuyen = tx.maTuyen";
			Query query = session.createNativeQuery(hSql);
			lstEntity = query.getResultList();
			if (lstEntity.isEmpty()) {
				System.out.println("Khong Ton Tai Du Lieu!");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			session.close();
		}

		return lstEntity;
	}

}
