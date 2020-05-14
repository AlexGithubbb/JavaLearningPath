package bean;

public class Son extends Father {

    private String sonName;
    protected int sonAge;
    public String sonBirth;

    public void printSonMsg(){

    }

    private String getSonName() {
        return sonName;
    }

    private void setSonName(String sonName) {
        this.sonName = sonName;
    }

    private int getSonAge() {
        return sonAge;
    }

    private void setSonAge(int sonAge) {
        this.sonAge = sonAge;
    }

}
