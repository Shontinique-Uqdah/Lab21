package co.grandcircus.parlor.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.parlor.IceCream;



//Similar to @Component annotation. Tells spring this should be a singleton
//that can be dependency injected. But specific to Dao. Gives spring better way
//to handle errors in our application
@Repository
public class IceCreamDao {
	
	//This does everything that happens in the itemsDaoOld for us automatically
	//Gives access to a spring bean, a singleton, created by spring automatically and
	//adding these annotations makes spring add it
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Get all of the details from your database
	public List<IceCream> findAll() {
		String sql = "SELECT * FROM items";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(IceCream.class));
		
	}
	
	
	//Search your database by id
	public IceCream findByID(Long id) {
		//? says that number can change...then when you query for the object...
		String  sql = "SELECT * FROM items WHERE id = ?";
		
		//...you add a final parameter, id, which tells it that is the value that will
		//take the place of the question mark above
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(IceCream.class), id);
	}
	
	//Add entry to your database
	public void create(IceCream iceCream) {
		String sql = "INSERT INTO items (name, description, quantity, price) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, iceCream.getName(), iceCream.getDescription(), iceCream.getQuantity(),
				iceCream.getPrice());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM items WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

}
