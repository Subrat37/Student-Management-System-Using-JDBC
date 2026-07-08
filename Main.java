import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true){
            System.out.println("======STUDENT MANAGEMENT SYSTEM=======");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.println("Enter Your Choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    sc.nextLine();

                    System.out.println("Enter RollNo: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();
                    System.out.println("Enter Course: ");
                    String course = sc.nextLine();

                    dao.addStudent(new Student(rollNo,name,age,course));
                    break;

                case 2:
                    dao.displayStudent();
                    break;
                case 3:
                    System.out.println("Enter RollNo: ");
                    dao.searchStudent(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Enter RollNo: ");
                    int r = sc.nextInt();

                    sc.nextLine();
                    System.out.println("Enter Name: ");
                    String n = sc.nextLine();

                    System.out.println("Enter Age: ");
                    int a = sc.nextInt();

                    sc.nextLine();
                    System.out.println("Enter Course: ");
                    String c = sc.nextLine();

                    dao.updateStudent(new Student(r,n,a,c));
                    break;
                case 5:
                    System.out.println("Enter RollNo: ");
                    dao.deleteStudent(sc.nextInt());
                    break;
                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}