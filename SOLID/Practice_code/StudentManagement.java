/*
        🧩 SRP PRACTICE QUESTIONS
        🟢 Easy Level (Warm-up)

        System: Student Management

        👉 Requirement:

        A student has name and marks
        Calculate grade
        Print student report
        Save student data

        ❓ Task:

        Identify SRP violation
        Create separate classes following SRP
        Write a Main class to test

        💡 Hint:
        Think → Business logic | Printing | Persistence
*/
public class StudentManagement {
    public static void main(String[] args) {
        
        Student s1 = new Student("Aathi shankar S M",98);

        ReportCard r1 = new ReportCard();
        r1.report(s1);

        StudentRepository r = new StudentRepository();
        r.saveData(s1);

    }
}
//Business Logic
class Student{
        private String name;
        private int mark;
        private char grade;

        Student(String name,int mark){
                this.name = name;
                this.mark = mark;
                gradeFind(mark);
        }

        private void gradeFind(int mark){
                if(mark > 90){
                        grade = 'A';
                }
                else if(mark > 80){
                        grade = 'B';
                }
                else if(mark > 70){
                        grade = 'C';
                }
                else if(mark > 60){
                        grade = 'D';
                }
                else if(mark > 35){
                        grade = 'E';
                }
                else{
                        grade = 'U';
                }
        }
        
        public String getName(){
                return name;
        }
        public char getGrade(){
                return grade;
        }

}
//Printing Responsibility
class ReportCard{
        void report(Student student){
                System.out.println("__________________________________________________________");
                System.out.println("            InfiLearn International School");
                System.out.println("__________________________________________________________");
                System.out.println("Student Name       :  "+ student.getName());
                System.out.println("Student Grade      :  "+ student.getGrade());
                System.out.println("----------------------------------------------------------");
                System.out.println("Grade A - E Denotes 'PASS' Grade U - Denotes Fail in Exam");
                System.out.println("----------------------------------------------------------");
                System.out.println("                 DECIPLINED Toppers");
                System.out.println("___________________________________________________________");
        }
}
//Persistence Responsibility
class StudentRepository{
        void saveData(Student student){
                System.out.println("Data of a reportcard all saved in Student DataBase");
        }
}


