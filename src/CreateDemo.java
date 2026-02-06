import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDemo {
    public static void main(String args[]){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "mohit123"
            );
            Statement stmt = con.createStatement();
            String sql = "Insert into employee values(3,'kunal')";
            int res = stmt.executeUpdate(sql);

            System.out.println("Success! Row Inserted: "+res);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
