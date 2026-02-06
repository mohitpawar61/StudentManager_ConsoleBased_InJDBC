import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {

        //load driver
        //get connection
        //create statement
        //execute query
        //close connection

        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql//localhost:3306/testdb",
                    "root",
                    "mohit123"
            );

            //create statement
            Statement st = con.createStatement();

           ResultSet rs =  st.executeQuery("select * from employee");

           while(rs.next()){
               System.out.println(rs.getInt("empid")
               +" "+rs.getString("empname"));
           }

           con.close();

        } catch (Exception e) {
       e.printStackTrace();
        }
    }
}