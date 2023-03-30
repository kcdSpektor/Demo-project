package com.alex.z.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * This is a dummy class that crates the stored function in the posgres DB on every app startup.
 * Since we are dropping the DB on every restart.
 */
public class DummyStoredProcedureCreator {

    public DummyStoredProcedureCreator() {
        String query = "CREATE OR REPLACE FUNCTION get_accounts() RETURNS SETOF account AS $$ BEGIN RETURN QUERY SELECT * FROM account; END $$ LANGUAGE plpgsql;";
        String dbURL = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String pass = "postgres";
        try {
            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            conn.createStatement().execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
