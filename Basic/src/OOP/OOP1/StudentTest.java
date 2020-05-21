package OOP.OOP1;

public class StudentTest {

    public static void main(String[] args) {
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();

            // number from 1 - 20;
            students[i].number = i + 1;

            // grade from  1-6
            int grade = (int) (Math.random() * (6 -1 + 1 ) + 1);
            students[i].grade = grade;

            // get random score
            int score = (int )(Math.random() * (100 -0 + 1));
            students[i].score = score;

            System.out.println(students[i].toString());
        }

        System.out.println("********************");
        // print students from grade 4
        for (int i = 0; i < students.length; i++) {
            if(students[i].grade == 4){
                System.out.println(students[i].toString());
            }
        }

        System.out.println("********************");

        // bubble sort score all students
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - 1; j++) {
                if(students[j].score > students[j+1].score){
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

}


class Student{
    int number;
    int grade;
    int score;

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }
}
