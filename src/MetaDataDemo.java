import java.sql.*;

public class MetaDataDemo {
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/testdb",
                 "root",
                    "mohit123"
            );
            //==================================================
            //part-1 DatabaseMetaData (info about the software)
            //==================================================
            DatabaseMetaData metadb = con.getMetaData();
            System.out.println("=== Database info ===");
            System.out.println("Driver name:  "+metadb.getDriverName());
            System.out.println("Driver version:  "+metadb.getDriverVersion());
            System.out.println("Logged in user:  "+metadb.getUserName());
            System.out.println("Database URL:"  +metadb.getURL());

            //==================================================
            //part-1 DatabaseMetaData (info about the software)
            //==================================================
            Statement stmt  = con.createStatement();
           ResultSet rs = stmt.executeQuery("select * from employee");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("=== Table (ResultSet) Info ===");

            //1.How many colums are in this tables?
            int totalColumn = rsmd.getColumnCount();
            System.out.println("Total Column: "+totalColumn);

            //2. What are the names and types of columns?
            System.out.println("----------------------------------------------");
            System.out.println("Col Index  | Column Name  |  Column Type");
            System.out.println("----------------------------------------------");

            //loop from 1 to total column
            for(int i=1;i<=totalColumn;i++){
                System.out.println(
                        "  "+i+"  |  "+rsmd.getColumnName(i)+"  |  "+
                                rsmd.getColumnTypeName(i)
                );
            }
            System.out.println("-----------------------------------------");
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
