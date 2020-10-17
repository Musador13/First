import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

/**
 * @author Musa Dzhabirov
 */
public class JDBC {

    //      JDBC Драйвер и ссылка на базу данных
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/usersdb?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

    //      User and Password
    static final String USER = "root";
    static final String PASSWORD = "Musa89896616237";

    public static void main(String[] args) throws SQLException {

           /* MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("Musa89896616237");
            dataSource.setServerName("");*/

        Connection connection = null;
        Statement statement = null;

        try {
            System.out.println("Регистрация JDBC драйвера...");
            Class.forName(JDBC_DRIVER);
            System.out.println("Registration is success");
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалость загрузить драйвер");
            e.printStackTrace();
        }

        System.out.println("Подключение к базе данных");

        connection = DriverManager
                .getConnection(DATABASE_URL, USER, PASSWORD);

        if (connection != null) {
            System.out.println("Connect!");
        }

        if (connection != null) {

            System.out.println("Connect!");
            try {
                statement = connection
                        .createStatement();
                System.out.println("Выполнение запроса...ok");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String sql;

//            sql = "SELECT * FROM mans;";
            /*sql = "CREATE TABLE humans " +
                    "(id INTEGER not NULL, " +
                    "Age INTEGER not NULL, " +
                    "FirstName VARCHAR(50), " +
                    "LastName VARCHAR(50), " +
                    "PRIMARY KEY (id));";*/
            /*sql = "INSERT humans(id, Age, FirstName, LastName)" +
                    "VALUES" +
                    "(1, 20, 'Musa', 'Dzhabirov')," +
                    "(2, 21, 'Maha', 'Dzhabirov')," +
                    "(3, 51, 'Rizvan', 'Dzhabirov');";
            statement.executeUpdate(sql);
            System.out.println("Table successfully created...");
*/


            ResultSet resultSet = statement.executeQuery("SELECT * FROM humans");
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                System.out.println(firstName);
            }

//            int executeUpdate(String sql);
//            int resultGet = statement.executeUpdate(sql);
           /* ResultSet resultSet = statement.executeQuery(sql);
*/
//            System.out.println("Получение данных из базы данных...");
//            System.out.println("\nmans:");

           /* while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                int age = resultSet.getInt("Age");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");*/

           /*     System.out.println("\n==============\n");
                System.out.println("id: " + id);
                System.out.println("Age: " + age);
                System.out.println("FirstName: " + firstName);
                System.out.println("LastName: " + lastName);
            }*/

            System.out.println("Закрыте соединеия и освобождение ресурсов...");


            resultSet.close();
            statement.close();
            connection.close();

        }
        System.out.println("Connect Lose");
    }
}
