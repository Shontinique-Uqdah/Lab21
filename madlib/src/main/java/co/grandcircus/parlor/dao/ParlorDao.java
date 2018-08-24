package co.grandcircus.parlor.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.parlor.User;



//Similar to @Component annotation. Tells spring this should be a singleton
//that can be dependency injected. But specific to Dao. Gives spring better way
//to handle errors in our application
@Repository
public class ParlorDao {
	
	//This does everything that happens in the UsersDaoOld for us automatically
	//Gives access to a spring bean, a singleton, created by spring automatically and
	//adding these annotations makes spring add it
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Get all of the details from your database
	public List<User> findAll() {
		String sql = "SELECT * FROM Users";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
		
	}
	
	
	//Search your database by id
	public User findByID(Long id) {
		//? says that number can change...then when you query for the object...
		String  sql = "SELECT * FROM Users WHERE id = ?";
		
		//...you add a final parameter, id, which tells it that is the value that will
		//take the place of the question mark above
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
	}
	
	//Add entry to your database
	public void create(User user) {
		String sql = "INSERT INTO Users (firstName, lastName, password, email, phoneNum,"
				+ "gender, birthdate, admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(),
				user.getPhoneNum(), user.getGender(), user.getBirthdate(), user.isAdmin());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM Users WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
	
	//Search your database by id
		public User findByEmail(String email) {
			//? says that number can change...then when you query for the object...
			String  sql = "SELECT * FROM Users WHERE email = ?";
			
			//...you add a final parameter, id, which tells it that is the value that will
			//take the place of the question mark above
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), email);
		}

}
