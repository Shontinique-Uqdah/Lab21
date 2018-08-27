package co.grandcircus.parlor.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.grandcircus.parlor.IceCream;



//Similar to @Component annotation. Tells spring this should be a singleton
//that can be dependency injected. But specific to Dao. Gives spring better way
//to handle errors in our application
@Repository
//DAOs must be transactional in order to use the EntityManager to write.
//This means that a transaction is created every time a method runs here.
@Transactional
public class IceCreamDaoHibernate {
	
	//Gives access to a spring bean, a singleton, created by spring automatically and
	//adding these annotations makes spring add it
	
	// Use this annotation to have Spring inject the Hibernate entity manager
		@PersistenceContext
		private EntityManager em;
	
	//Get all of the details from your database
	public List<IceCream> findAll() {
		// The SELECT clause is optional in HQL. If omitted, it's basically SELECT *.
				// When creating a a query specify the type of the results: Food.class
				return em.createQuery("FROM IceCream", IceCream.class).getResultList();
		
	}
	
	
	//Search your database by id
	public IceCream findByID(Long id) {
		return em.find(IceCream.class, id);
	}
	
	public List<IceCream> findByKeyword(String keyword) {
		// HQL queries can have named parameters, such as :regex here.
		return em.createQuery("FROM IceCream WHERE LOWER(description) LIKE :regex", IceCream.class)
				.setParameter("regex", "%" + keyword.toLowerCase() + "%")
				.getResultList();
	}
	
	//Add entry to your database
	public void create(IceCream iceCream) {
		em.persist(iceCream);
	}
	
	public void delete(Long id) {
		// Deleting with Hibernate entity manager requires fetching a reference first.
				IceCream iceCream = em.getReference(IceCream.class, id);
				em.remove(iceCream);
	}
	
	//Search your database by category
		public List<IceCream> findByCategory(String category) {
			return em.createQuery("FROM IceCream WHERE LOWER(category) = :category", IceCream.class)
					.setParameter("category", category.toLowerCase())
					.getResultList();
		}


		public void update(IceCream iceCream) {
			em.merge(iceCream);
			
		}
		
		public Set<String> findAllCategories() {
			// This query returns a list of Strings, so I give it String.class
			List<String> categoryList = em.createQuery("SELECT DISTINCT category FROM IceCream", String.class)
					.getResultList();
			// Convert the List to a Set.
			return new TreeSet<>(categoryList);
		}

}
