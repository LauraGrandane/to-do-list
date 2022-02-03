package com.companyLaura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.*;

public class Conn {

    String DB = "jdbc:mysql://localhost:3302/todolist";
    String USER = "root";
    String PASS = "11.SuNsL";
    static final String QUERY = "SELECT id, name, term, done, comment FROM todo";

    //INSERT
    public void insert() {
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Kas jādara?");
        String name = scanner1.nextLine();
        System.out.println("Līdz cikiem jāizdara? (00:00)");
        String term = scanner1.nextLine();
        System.out.println("Vai jau ir izdarīts? (+ vai -)");
        String done = scanner1.nextLine();
        System.out.println("Papildus komentāri..");
        String comment = scanner1.nextLine();

        try(
                Connection conn = DriverManager.getConnection(DB, USER, PASS);
                Statement stmt = conn.createStatement()
        ){
            String sql = "INSERT INTO todo (name, term, done, comment) VALUES ('"+name+"','"+term+"','"+done+"','"+comment+"');";
            stmt.executeUpdate(sql);
            System.out.println("Dati saglabāti!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //SELECT
    public void select() {

        try(
                Connection conn = DriverManager.getConnection(DB, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(QUERY)
        ){
            while(resultSet.next()) {
                System.out.println("id   " + resultSet.getInt("id"));
                System.out.println("kas?   " + resultSet.getString("name"));
                System.out.println("līdz cikiem?   " + resultSet.getString("term"));
                System.out.println("izdarīts?   " + resultSet.getString("done"));
                System.out.println("papildus komentāri ->  " + resultSet.getString("comment"));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //SELECT 2 - TIKAI ID UN NOSAUKUMS
    public void select2() {

        try(
                Connection conn = DriverManager.getConnection(DB, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(QUERY)
        ){
            while(resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " - " +
                        resultSet.getString("name") +  " (" + resultSet.getString("done") + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //SELECT 3 - SAKĀRTOTS PĒC LAIKIEM
    public void select3() {

        try(
                Connection conn = DriverManager.getConnection(DB, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery("SELECT id, name, term, done, comment FROM todo ORDER BY term, id;")
        ){
            while(resultSet.next()) {
                System.out.println(resultSet.getString("term") + " - " + resultSet.getString("name") +
                        " (id-" + resultSet.getInt("id") + ")");
                //System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //DELETE
    public void delete() {

        Scanner scanner2 = new Scanner(System.in);

        int id;
        do {
            System.out.println("Kurš darāmais darbs jāizdzēš no ToDo listes?");
            System.out.println("Ievadi ID numuru!");
            System.out.println("Ja nezini ID, tad ieraksti '0' un varēsi apskatīt visu sarakstu.");
            id = parseInt(scanner2.nextLine());

            if (id > 0) {
                try (
                        Connection conn = DriverManager.getConnection(DB, USER, PASS);
                        Statement stmt = conn.createStatement()
                ) {
                    String sql = "DELETE FROM todo WHERE id = " + id + "";
                    stmt.executeUpdate(sql);
                    System.out.println("Dati dzēsti!");
                    System.out.println("Bet cerams, ka darbs tika arī izdarīts, nevis tikai izdzēsts..");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                } else { select2(); }
        }
        while (Objects.equals(id, 0));
    }

    //UPDATE
    public void update() {

        Scanner scanner3 = new Scanner(System.in);

        int id;
        do {
            System.out.println("Kurš darbs jāatzīmē, ka ir izdarīts?");
            System.out.println("Ievadi ID numuru!");
            System.out.println("Ja nezini ID, tad ieraksti '0' un varēsi apskatīt visu sarakstu.");
            id = parseInt(scanner3.nextLine());

            if (id > 0) {
                try (
                        Connection conn = DriverManager.getConnection(DB, USER, PASS);
                        Statement stmt = conn.createStatement()
                ) {
                    String sql = "UPDATE todo SET done = '+' WHERE id = " + id + "";
                    stmt.executeUpdate(sql);
                    System.out.println("Dati atjaunoti!");
                    System.out.println("Labs darbiņš, kas padarīts!");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else { select2(); }
        }
        while (Objects.equals(id, 0));
    }

    //INSERT2
    public void insert2() {
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Kas jādara?");
        String name = scanner1.nextLine();

        try(
                Connection conn = DriverManager.getConnection(DB, USER, PASS);
                Statement stmt = conn.createStatement()
        ){
            String sql = "INSERT INTO todo (name, term, done, comment) VALUES ('"+name+"','23:00','-','komentāriņš');";
            stmt.executeUpdate(sql);
            System.out.println("Dati saglabāti!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
