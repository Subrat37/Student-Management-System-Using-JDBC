import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    Connection con = DBConnection.getConnection();

    //insert Student
    public void addStudent(Student s){
        String query = "insert into Student(rollNo,name,age,course)values(?,?,?,?)";
        try {
            PreparedStatement prep = con.prepareStatement(query);
            prep.setInt(1,s.getRollNo());
            prep.setString(2,s.getName());
            prep.setInt(3,s.getAge());
            prep.setString(4,s.getCourse());

            int i = prep.executeUpdate();
            if (i>0){
                System.out.println("Student Added Successfully");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Display Student
    public void displayStudent(){
        String query = "select * from Student";
        try{
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);

            while (resultSet.next()){
                System.out.println("RollNo: "+resultSet.getInt("rollNo"));
                System.out.println("Name: "+resultSet.getString("name"));
                System.out.println("Age: "+resultSet.getInt("age"));
                System.out.println("Course: "+resultSet.getString("course"));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Search Student
    public void searchStudent(int rollNo){
        String query = "select * from Student where rollNo = ?";
        try{
            PreparedStatement prep = con.prepareStatement(query);
            prep.setInt(1,rollNo);
            ResultSet resultSet = prep.executeQuery();
            if (resultSet.next()){
                System.out.println("Name: "+resultSet.getString("name"));
                System.out.println("Age: "+resultSet.getInt("age"));
                System.out.println("Course: "+resultSet.getString("course"));
            }
            else {
                System.out.println("Student Not Found");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //update Student
    public void updateStudent(Student s){
        String query1 = "update Student set name = ? ,age = ?,course = ? where rollNo =?";

        try {
            PreparedStatement prep1 = con.prepareStatement(query1);
            prep1.setString(1,s.getName());
            prep1.setInt(2,s.getAge());
            prep1.setString(3,s.getCourse());
            prep1.setInt(4,s.getRollNo());

            int row = prep1.executeUpdate();
            if (row>0){
                System.out.println("Student Updated Successfully");
            }
            else {
                System.out.println("Student not Found.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Delete Student
    public void deleteStudent(int rollNo){
        String query1 = "delete from Student where rollNo = ?";

        try {
            PreparedStatement prep1 = con.prepareStatement(query1);
            prep1.setInt(1,rollNo);

            int row = prep1.executeUpdate();
            if (row>0){
                System.out.println("Student Deleted Successfully");
            }
            else {
                System.out.println("Student not Found.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
