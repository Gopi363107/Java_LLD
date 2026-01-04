public class Online_Exam_Registeration_system {
    public static void main(String[] args) {

        // Base prototype
        UPSCApplication baseForm =
            new UPSCApplication("India", "General Studies", "Offline", 2024);

        // Clone for Candidate 1
        UPSCApplication c1 = (UPSCApplication) baseForm.clone();
        c1.candidateName = "Gopi";
        c1.id = "UPSC001";

        // Clone for Candidate 2
        UPSCApplication c2 = (UPSCApplication) baseForm.clone();
        c2.candidateName = "Adithya";
        c2.id = "UPSC002";

        c1.print();
        c2.print();
    }
}

interface ExamApplication {
    ExamApplication clone();
}

class UPSCApplication implements ExamApplication{

    String examtype;
    String Country;
    String mode;
    int year;

    String candidateName;
    String id;

    UPSCApplication(String examtype , String Country , String mode , int year){
        this.examtype = examtype;
        this.Country = Country;
        this.mode = mode;
        this.year = year;
    }

    public ExamApplication clone(){
        return new UPSCApplication(this.examtype , this.Country ,this.mode , this.year);
    }

    public void print(){
        System.out.println(candidateName + " | " + id + " | " +examtype + " | " + year + " | " + mode);
    }
    
}
