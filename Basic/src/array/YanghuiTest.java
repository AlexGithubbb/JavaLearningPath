package array;


// YangHui triangle
public class YanghuiTest {
    public static void main(String[] args) {
        // initialize 2 dimension array
        int[][] yanghui = new int[10][];

        // assign value to it
        for (int i = 0; i < yanghui.length; i++) {
            yanghui[i] = new int[i+1];
            // assign 1 to the first and last one
            yanghui[i][0] = yanghui[i][i] = 1;
            for (int j = 1; j < yanghui[i].length -1; j++) {
                // the yanghui rules, value of target item equals to the above one + the one on the left of the above one
                yanghui[i][j] = yanghui[i-1][j] + yanghui[i-1][j-1];
            }
        }


        // iterate yanghui triangle
        for (int i = 0; i < yanghui.length; i++) {

            for (int j = 0; j < yanghui[i].length; j++) {
                System.out.print(yanghui[i][j] + " ");
            }
            System.out.println();
        }

    }



}
