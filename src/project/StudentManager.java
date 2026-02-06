package project;

import java.sql.*;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        try{
            Connection con = DriverManager.getConnection(DBConfigstd.url,DBConfigstd.username,DBConfigstd.password);

            Scanner sc  = new Scanner(System.in);

            while(true)
            {
                System.out.println("\n===STUDENT MANAGEMENT SYSTEM ===");
                System.out.println("1. Insert Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Search Student");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");

                int choice = sc.nextInt();
                switch (choice){

                    case 1:
                        System.out.println("Enter the roll_no");
                        int roll_no = sc.nextInt();
                        System.out.println("Enter your name");
                        String name  = sc.next();
                        System.out.println("Enter the marks");
                        double marks = sc.nextDouble();

                        PreparedStatement ps =con.prepareStatement("insert into students (roll_no,name,marks) values(?,?,?)");
                        ps.setInt(1,roll_no);
                        ps.setString(2,name);
                        ps.setDouble(3,marks);

                        int rows =ps.executeUpdate();
                        System.out.println("Record inserted: "+ rows);
                        break;

                    case 2:
                        System.out.println("Enter roll_no to update");
                        int roll=sc.nextInt();
                        System.out.println("Enter new marks");
                        double newMarks=sc.nextDouble();

                      PreparedStatement ps1 =  con.prepareStatement("update students set marks=? where roll_no=?");
                        ps1.setDouble(1,newMarks);
                        ps1.setInt(2,roll);

                        int updated=ps1.executeUpdate();
                        if(updated>0){
                            System.out.println("Record updated");
                        }
                        else{
                            System.out.println("Roll number not found.");
                        }
                        break;

                    case 3:
                        System.out.println("Enter the roll_no to delete");
                        int rn = sc.nextInt();
                        PreparedStatement ps2 = con.prepareStatement("delete from students where roll_no=?");

                        ps2.setInt(1,rn);
                        int u=ps2.executeUpdate();
                        if(u>0){
                            System.out.println("Record deleted");
                        }
                        else{
                            System.out.println("Roll number not found.");
                        }
                        break;

                    case 4:
                        System.out.println("Enter the roll_no to search");
                        int rSearch=sc.nextInt();
                        PreparedStatement ps3 = con.prepareStatement("select * from students where roll_no=?");
                        ps3.setInt(1,rSearch);

                      ResultSet rs = ps3.executeQuery();
                        if(rs.next()){
                            System.out.println("Data found: "+rs.getInt(1)
                            +" | "+rs.getString(2)+" | "+rs.getDouble(3));
                        }
                        else{
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        con.close();
                        sc.close();
                        System.out.println("Existing....");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.Please try again");


                }


            }
        }catch(SQLException e){
            System.out.println("Database Error: "+e.getMessage());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
