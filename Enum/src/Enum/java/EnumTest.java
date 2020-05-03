package Enum.java;

/*
toString()
values()
valueOf()
methods are coming from Enum class, (java.util.Enum)
*/

public class EnumTest {
    public static void main(String[] args) {
        Season1 winter = Season1.WINTER;
        System.out.println(winter.toString()); // WINTER

//        System.out.println(winter.getClass().getSuperclass()); // java.lang.Enum
        System.out.println("*********");

        /* values()  reuturn the array that includes all enum objects */
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        /* valueOf() returns the enum object with Enum name "SUMMER"*/
        Season1 winter1 = Season1.valueOf("SUMMER");
        System.out.println(winter1); // SUMMER

        System.out.println("*********");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

//        winter.show();

    }
}

interface Info{
    void show();
}

enum Season1 implements Info{
    // 提供枚举类的对象
   SPRING("Spring", "flower, new life"){
        @Override
        public void show() {
            System.out.println("永春");
        }
    },
   SUMMER("Summer", "salmon thread, hot"){
       @Override
       public void show() {
           System.out.println("宁夏");
       }
   },
   FALL("Fall", "maple tree"){
       @Override
       public void show() {
           System.out.println("秋天不回来");
       }
   },
   WINTER("Winter", "freezing, chilly"){
       @Override
       public void show() {
           System.out.println("冬季到台北来看雨");
       }
   };


    // 私有化
    private final String SeasonName;
    private final String SeasonDec;

    //私有化构造器
    private Season1(String seasonName, String seasonDec){
        this.SeasonName = seasonName;
        this.SeasonDec = seasonDec;
    }

    // get method

    public String getSeasonName() {
        return SeasonName;
    }

    public String getSeasonDec() {
        return SeasonDec;
    }

    @Override
    public void show() {
        System.out.println("方法一： 重写接口的方法，但每个枚举类内部对象都只能调用这一个show" +
                "因此打印的内容不变");
    }
}
