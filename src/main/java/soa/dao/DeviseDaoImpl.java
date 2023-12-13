package soa.dao;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import soa.entities.Devise;

@Repository
@Transactional
public class DeviseDaoImpl implements IDeviseDao {

	@PersistenceContext
	private EntityManager em;


	public Devise save(Devise d) {
		em.persist(d);
		return d;
	}
	public List<Devise> findAll() {
		Query query=  
      em.createQuery("select p from Produit p order by p.designation");
		return query.getResultList();
	}

	public Devise findOne(Long id) {
		Devise d = em.find(Devise.class, id);
		return d;
	}


	@Override
	public Devise update(Devise devise) {
		em.merge(devise);
		return devise;
	}

	public void delete(Long id) {
		Devise d = em.find(Devise.class, id);
		em.remove(d);
		
	}

	@Override
	public List<Devise> getById(Long id) {
		Query query=
				em.createQuery("select d from Devise d where d.id like :x");
		query.setParameter("x", "%"+id+"%");
		return query.getResultList();
	}

}
