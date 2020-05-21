package OOP.OOP1;

public class AnonymousObject {
    public static void main(String[] args) {
        PhoneMall phoneMall = new PhoneMall();
        // anomymous object (new Phone()), but there's still a var points to it from stack, which is the param of method show()
        phoneMall.show(new Phone(), 3000.00);
    }

}

class PhoneMall{
    public void show(Phone phone, double price){
        // same phone call sendMsg() and playMusic()
        phone.price = price;
        phone.sendMsg();
        phone.playMusic();
        phone.showPrice();
    }
}

class Phone{
    double price;
    public void sendMsg(){
        System.out.println("message sent");
    }

    public void playMusic(){
        System.out.println("music playing...");
    }

    public void showPrice(){
        System.out.println("price is: " + price);
    }

}
