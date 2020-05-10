package jdbc.bean;

import java.sql.Date;

public class Customer {

    private int id;
    private String name123;
    private String email;
    private Date birthD;

    public Customer() {
    }

    public Customer(int id, String name123, String email, Date birthD) {
        this.id = id;
        this.name123 = name123;
        this.email = email;
        this.birthD = birthD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name123;
    }

    public void setName(String name123) {
        this.name123 = name123;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birthD;
    }

    public void setBirth(Date birthD) {
        this.birthD = birthD;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name123='" + name123 + '\'' +
                ", email='" + email + '\'' +
                ", birthD=" + birthD +
                '}';
    }
}
