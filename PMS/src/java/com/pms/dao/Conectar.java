/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Farith S
 */
public class Conectar {

    static Connection cnn;
    static PreparedStatement pst;
    static ResultSet rs;

    private Conectar() {
    }

    private static void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "ca54sa69");
        } catch (SQLException e) {
            System.out.println("Error de MySQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    public static Connection getInstace() {
        if (cnn == null) {
            conectar();
        }
        return cnn;
    }

    public static int insertar(String sentencia) {
        int res = 0;
        getInstace();
        try {
            pst = cnn.prepareStatement(sentencia);
            res = pst.executeUpdate();
            return res;

        } catch (Exception e) {
            System.out.print("error insertar:" + e.getMessage());
        }

        return res;

    }

    public static ResultSet Consultar(String sentencia) {

        getInstace();
        try {
            pst = cnn.prepareStatement(sentencia);
            rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.print("error insertar:" + e.getMessage());

        }

        return rs;

    }
}
