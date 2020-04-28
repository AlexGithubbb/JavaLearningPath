package Enum.java;

public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);

        System.out.println(spring.getSeasonName());
        System.out.println(spring.getSeasonDec());
    }
}


class Season{
    // 私有化
    private final String SeasonName;
    private final String SeasonDec;

    //私有化构造器
    private Season(String seasonName, String seasonDec){
        this.SeasonName = seasonName;
        this.SeasonDec = seasonDec;
    }

    // 内部造对象
    public static final Season SPRING = new Season("Spring", "flower, new life");
    public static final Season SUMMER = new Season("Summer", "salmon thread, hot");
    public static final Season FALL = new Season("Fall", "maple tree");
    public static final Season WINTER = new Season("Winter", "freezing, chilly");

    // get method

    public String getSeasonName() {
        return SeasonName;
    }

    public String getSeasonDec() {
        return SeasonDec;
    }

    @Override
    public String toString() {
        return "Season{" +
                "SeasonName='" + SeasonName + '\'' +
                ", SeasonDec='" + SeasonDec + '\'' +
                '}';
    }
}
