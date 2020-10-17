import java.sql.*;
/**
 * @author Musa Dzhabirov
 */
public class SkillBox {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Statement statement = null;

        Connect connect = new Connect("root", "Musa89896616237", "usersdb");
        connect.connect();

        try {
            statement = connect.connect().createStatement();
            System.out.println("good");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        /*SELECT  distinct(pl.course_name) , (count(pl.course_name)/(max(month(pl.subscription_date))-min(month(pl.subscription_date)) + 1)) AS avg_purchase
        FROM purchaselist AS pl
        where year(pl.subscription_date) = 2018
        group by pl.course_name;
        */
        String sql = ("select distinct(pl.course_name), (count(pl.course_name)/(max(month(pl.subscription_date))-min(month(pl.subscription_date)) + 1))  avg_purchase" +
                " FROM purchaselist  pl" +
                " where year(pl.subscription_date) = 2018" +
                " group by pl.course_name;");
        statement.executeQuery(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String courseName = resultSet.getString("course_name") + "\t" + resultSet.getString("avg_purchase");
            System.out.println(courseName);
        }

        resultSet.close();
        connect.disconnect();
    }
}
