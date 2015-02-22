package samples.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import samples.springboot.domain.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by izeye on 15. 2. 22..
 */
@Repository
public class JdbcCustomerRepository implements CustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Customer customer) {
		jdbcTemplate.update(
				"INSERT INTO customers (first_name, last_name) VALUES (?, ?)",
				customer.getFirstName(), customer.getLastName());
	}

	@Override
	public List<Customer> findAll() {
		return jdbcTemplate.query("select * from customers", customerRowMapper);
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {
		return jdbcTemplate.query(
				"select * from customers where first_name = ?", customerRowMapper, firstName);
	}

	private RowMapper<Customer> customerRowMapper = new RowMapper<Customer>() {
		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Customer(
					rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
		}
	};

}
