import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcInsertDemo {

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

            String query = "INSERT INTO  students(id,name,age) values (4,'Ankit', 25)";

            int  updated =  stmt.executeUpdate(query);

            System.out.println("Inserted "+ updated + " Rows");


        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
