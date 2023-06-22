package org.example;
import entities.User;
import orm.EntityManager;

import java.sql.Connection;
import java.sql.SQLException;

import static orm.MyConnector.createConnection;
import static orm.MyConnector.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        createConnection("root", "nPcFu9W^DmCyDP*f", "custom_orm");
        Connection connection = getConnection();
        EntityManager<User> userEntityManager = new EntityManager<>(connection  );
    }
}