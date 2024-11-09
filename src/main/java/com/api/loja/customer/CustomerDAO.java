package com.api.loja.customer;

import com.api.loja.address.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class CustomerDAO implements CustomerRepository{

    private final JdbcTemplate jdbcTemplate;

    public CustomerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(RegisterCustomer registerCustomer) {

        String customerSql = "INSERT INTO customer (name, email, cpf, phone) VALUES (?, ?, ?, ?)";
        // Configura o KeyHolder para capturar o ID gerado
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            //aptura o ID
            PreparedStatement ps = connection.prepareStatement(customerSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, registerCustomer.name());
            ps.setString(2, registerCustomer.email());
            ps.setString(3, registerCustomer.cpf());
            ps.setString(4, registerCustomer.phone());
            return ps;
        }, keyHolder);

        // Extrai o ID gerado, converte para BigInteger e então para Long
        BigInteger customerIdBigInt = (BigInteger) keyHolder.getKey();
        Long customerId = customerIdBigInt.longValue();

        String addressSql = "INSERT INTO address (street, neighborhood, city, state, zip, fk_customer) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(addressSql,
                registerCustomer.address().getStreet(),
                registerCustomer.address().getNeighborhood(),
                registerCustomer.address().getCity(),
                registerCustomer.address().getState(),
                registerCustomer.address().getZip(),
                customerId  // Usa o ID do cliente como FK
        );
    }

    private static class CustomerRowMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            // Mapeamento do endereço
            Address address = new Address(
                    rs.getString("street"),
                    rs.getString("neighborhood"),
                    rs.getString("city"),
                    rs.getString("state"),
                    rs.getString("zip"),
                    rs.getLong("fk_customer")
            );

            // Mapeamento do cliente (Customer)
            return new Customer(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("cpf"),
                    rs.getString("phone"),
                    address
            );
        }
    }
}
