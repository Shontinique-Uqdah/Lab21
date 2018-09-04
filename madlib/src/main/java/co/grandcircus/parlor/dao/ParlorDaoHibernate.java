//package co.grandcircus.parlor.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import co.grandcircus.parlor.User;
//
//
//
////Similar to @Component annotation. Tells spring this should be a singleton
////that can be dependency injected. But specific to Dao. Gives spring better way
////to handle errors in our application
//@Repository
////DAOs must be transactional in order to use the EntityManager to write.
////This means that a transaction is created every time a method runs here.
//@Transactional
//public class ParlorDaoHibernate {
//	
//	//Gives access to a spring bean, a singleton, created by spring automatically and
//	//adding these annotations makes spring add it
//	
//	// Use this annotation to have Spring inject the Hibernate entity manager
//		@PersistenceContext
//		private EntityManager em;
//	
//	//Get all of the details from your database
//	public List<User> findAll() {
//		// The SELECT clause is optional in HQL. If omitted, it's basically SELECT *.
//				// When creating a a query specify the type of the results: Food.class
//				return em.createQuery("FROM User", User.class).getResultList();
//		
//	}
//	
//	
//	//Search your database by id
//	public User findByID(Long id) {
//		return em.find(User.class, id);
//	}
//	
//	//Add entry to your database
//	public void create(User user) {
//		em.persist(user);
//	}
//	
//	public void delete(Long id) {
//		// Deleting with Hibernate entity manager requires fetching a reference first.
//				User user = em.getReference(User.class, id);
//				em.remove(user);
//	}
//	
//	//Search your database by email
//	
//	public User findByEmail(String email) {
//		return em.createQuery("from User where email = :email", User.class)
//				.setParameter("email", email)
//				.getSingleResult();
//	}
//	
//		
//		public void update(User user) {
//			em.merge(user);
//		}
//
//}
