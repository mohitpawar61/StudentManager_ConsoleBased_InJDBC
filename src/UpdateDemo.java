import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateDemo {
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "mohit123"
            );
            Statement stmt = con.createStatement();
            String sql = "UPDATE employee SET empname = 'kunal' WHERE empid = 3";
            int res = stmt.executeUpdate(sql);

            if(res>0){
                System.out.println("Update successfull! Name changed");
            }
            else{
                System.out.println("Update failed");
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
