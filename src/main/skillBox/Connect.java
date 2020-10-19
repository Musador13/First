import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Musa Dzhabirov
 */
public class Connect {

    private String db;
    private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private String user;
    private String password;

    private Connection connection;
    private Statement statement;

    public Connect(String user, String password, String db) {
        this.user = user;
        this.password = password;
        this.db = db;
    }

    public Connection connect() throws ClassNotFoundException, SQLException {

        try {
            System.out.println("Регистрация JDBC драйвера...");
            Class.forName(JDBC_DRIVER);
            System.out.println("Registration is success");
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалость загрузить драйвер");
            e.printStackTrace();
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db +
                "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false", user, password);

        if (connection != null) {
            System.out.println("Connect!");
        }
        return connection;
    }


    public void disconnect () throws SQLException, NullPointerException {
        try {
            statement.close();
            connection.close();
            System.out.println("Соединение закрыто");
        }catch (NullPointerException e){
            System.out.println("Соединение не закрыто");
        }
    }
}

