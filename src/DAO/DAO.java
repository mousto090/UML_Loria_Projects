/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BibalExceptions.DAOExceptions;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Jalloh
 */
public abstract class DAO<T> {

    protected Connection connection = null;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public abstract void inserer(T object) throws DAOExceptions;

    public abstract void update(T object) throws DAOExceptions;

    public abstract void delete(T object) throws DAOExceptions;

    public abstract ArrayList<T> getAll() throws DAOExceptions;

    public abstract T find(int id) throws DAOExceptions;
}
