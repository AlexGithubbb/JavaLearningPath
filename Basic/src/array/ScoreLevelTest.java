package array;

import java.util.Scanner;

public class ScoreLevelTest {

    public static void main(String[] args) {
        System.out.println("insert numbers of students");
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();

        System.out.println("insert score of each student");
        // assign score into array and get the max one
        int maxScore = 0;
        int[] scores = new int[nums];
        for (int i = 0; i < nums; i++) {
            scores[i] = scanner.nextInt();
            if(maxScore < scores[i]){
                maxScore = scores[i];
            }
        }

//        // get the maximum
//        int maxScore = 0;
//        for (int i = 0; i < nums; i++) {
//            if(maxScore < scores[i]){
//                maxScore = scores[i];
//            }
//        }

        System.out.println("max score is " + maxScore);

    }

}
