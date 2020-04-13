package random.java;

public class MyException extends RuntimeException{

    static final long serialVersionUID = -3387516993124229948L;

    public MyException(){}

    public MyException(String msg){
        super(msg);
    }
}
