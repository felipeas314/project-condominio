package br.com.condominio.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.condominio.models.Morador;
import br.com.condominio.models.PaginatedList;

@Repository
public class MoradorDao {
	
	   @PersistenceContext
	   private EntityManager manager;

	   public List<Morador> all()
	   {
	      return manager.createQuery("select m from Morador m", Morador.class).getResultList();
	   }

	   public void save(Morador morador)
	   {
	      manager.persist(morador);
	   }

	   public Morador findById(Integer id)
	   {
	      return manager.find(Morador.class, id);
	   }

	   public void remove(Morador morador)
	   {
	      manager.remove(morador);
	   }

	   public void update(Morador morador)
	   {
	      manager.merge(morador);
	   }

	   public PaginatedList paginated(int page, int max)
	   {
	      return new PaginatorQueryHelper().list(manager, Morador.class, page, max);
	   }

}
