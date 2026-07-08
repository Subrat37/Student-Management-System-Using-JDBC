import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection(){
        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //get connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Student_db",
                    "root",
                    "hacker"
            );
            return connection;
        } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return null;
    }
}
