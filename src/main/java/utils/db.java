package utils;

import models.Hero;

import java.sql.*;

public class db {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    private static void conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:base\\first.s3db");
        statmt = conn.createStatement();
        System.out.println("База Подключена!");
    }

    // --------Добавим героя--------
    public static void writeHero( String name, int level, String ultimate ) throws SQLException, ClassNotFoundException {
        conn( );
        String querry=String.format("INSERT INTO 'users' ('name', 'level', 'ultimate') VALUES (%s, %s, %s);", name, level, ultimate );
        statmt.execute(querry);
        closeDB( );

        System.out.println("Таблица заполнена!");
    }

    // -------- Достанем его--------
    public static Hero readHero(int heroId) throws ClassNotFoundException, SQLException
    {
        conn( );
        String querry=String.format("SELECT * FROM heroes where id = '%s'", heroId );
        System.out.println(querry);
        resSet = statmt.executeQuery(querry);

        resSet.next(); // он всего один такой, так что не страшно
        Hero hero = new Hero(resSet.getLong("id"),
                             resSet.getString("name"),
                             resSet.getInt("level"),
                             resSet.getString("ultimate"));

        closeDB( );
        return hero;
    }

    // --------Закрытие--------
    private static void closeDB() throws SQLException
    {
        conn.close();
        if (statmt != null) statmt.close();
        if (resSet != null) resSet.close();

        System.out.println("Соединения закрыты");
    }

}