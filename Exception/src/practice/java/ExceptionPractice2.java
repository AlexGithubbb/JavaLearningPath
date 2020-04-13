package practice.java;

import random.java.MyException;

public class ExceptionPractice2 {
    public static void main(String[] args) {
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);

            int result = ecm(x , y);
            System.out.println(result);
        }catch (NumberFormatException e){
            System.out.println("数据不一致");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch(ArithmeticException e){
            System.out.println("除0异常");
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
    }

    public static int ecm (int i, int j) throws MyException{
            if( i < 0 || j < 0){
                throw new MyException("both i and j should be positive value!");
            }
                return i/j;
    }
}
