package com.muktevi.MyProject.dao;


import com.muktevi.MyProject.beans.Names;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MyDaoImpl {

    public static final Logger logger = LoggerFactory.getLogger(MyDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Names> getAllNames () {
        String sql = "select first_name, last_name from test.names";
        return jdbcTemplate.query(sql, new RowMapper<Names>() {
            @Override
            public Names mapRow(ResultSet rs, int rowNum) throws SQLException {
               return new Names(rs.getString("first_name"),rs.getString("last_name"));
            }
        });
    }

    public List<Names> queryByFirstName (String firstName) {
        String sql = "select first_name, last_name from test.names where first_name = ?";
        return jdbcTemplate.query(sql, new Object[]{firstName}, new RowMapper<Names>() {
            @Override
            public Names mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Names(rs.getString("first_name"), rs.getString("last_name"));
            }
        });
    }
}
