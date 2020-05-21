package OOP.OOP1;

public class StudentsTest2 {
    public static void main(String[] args) {
        Student1[] students = new Student1[20];

        System.out.println(students); // [LOOP.OOP1.Student1;@1d44bcfa  (type + address)
        System.out.println(students[0]); // null

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student1();

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

        StudentsTest2 test = new StudentsTest2();

        test.printLine("$");
        // print students from grade 4
        test.searchGrade(students, 6);

        test.printLine("*");
        // bubble sort score all students
        Student1[] sortedStudents = test.bubbleSort(students);

        test.print(sortedStudents);
    }




    public  void print(Student1[] students){
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    public  void searchGrade(Student1[] students, int grade){
        for (int i = 0; i < students.length; i++) {
            if(students[i].grade == grade){
                System.out.println(students[i].toString());
            }
        }
    }

    public  void printLine(String symbol){
        for (int i = 0; i < 35; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }


    public  Student1[]  bubbleSort(Student1[] students){
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - 1; j++) {
                if(students[j].score > students[j+1].score){
                    Student1 temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        return students;
    }

}


class Student1 {
    int number;
    int grade;
    int score;

    @Override
    public String toString() {
        return "Student1{" +
                "number=" + number +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }

}
