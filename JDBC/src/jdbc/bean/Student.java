package jdbc.bean;

public class Student {
 private int FlowID;
 private int type;
 private String IDCard;
 private String ExamCard;
 private String StudentName;
 private String Location;
 private int Grade;

    public Student() {
    }

    public Student(int flowID, int type, String IDCard, String examCard, String studentName, String location, int grade) {
        FlowID = flowID;
        this.type = type;
        this.IDCard = IDCard;
        ExamCard = examCard;
        StudentName = studentName;
        Location = location;
        Grade = grade;
    }

    public int getFlowID() {
        return FlowID;
    }

    public void setFlowID(int flowID) {
        FlowID = flowID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getExamCard() {
        return ExamCard;
    }

    public void setExamCard(String examCard) {
        ExamCard = examCard;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "FlowID=" + FlowID +
                ", type=" + type +
                ", IDCard='" + IDCard + '\'' +
                ", ExamCard='" + ExamCard + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", Location='" + Location + '\'' +
                ", Grade=" + Grade +
                '}';
    }
}
