import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {

    // Steps to Connect Db to javaClass through JDBC

    // 1. Load the Driver Class
    //2.  get Conncetion From DB
    //3. Create Statement
    //4. Execute Query

    public static void main(String[] args)  throws ClassNotFoundException{

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myStudent", "root", "root");
            Statement stmt = con.createStatement();

            String query = "select * from students";

            ResultSet rs =  stmt.executeQuery(query);
            System.out.println("______________Read Data ________________");

            while (rs.next()){
                System.out.println(
                        rs.getInt("id") + " | " + rs.getString("name") + " | "+rs.getInt("age"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
