package compare.java;

public class Product implements Comparable{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Product){
            Product product = (Product)o;
            if(this.price > product.price){
                return 1;
            }else if(this.price < product.price){
                return -1;
            }else{
//                return 0;
                return this.name.compareTo(product.name);
            }
        }
        throw new RuntimeException("the type of object is wrong! ");

    }
}
