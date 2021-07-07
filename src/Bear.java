import java.util.ArrayList;
import java.util.List;

public class Bear extends Animal{
    {
        ArrayList<String> foods=new ArrayList<>();
        foods.add("fish");
        foods.add("steak");
        setEats(foods);
        setLifeExpectancy(18);

    }


    private int hug(){
        return increaseHealth(3);
    }



//    @Override
//    public boolean aMonthPasses() {
//        decreaseHealth(2);
//        //eat();
//        return true;
//    }




    @Override
    public void treat() {
        hug();
    }


    @Override
    public String toString() {
        return "Bear{" +
                "age=" + age +
                ", gender=" + gender +
                ", health=" + health +
                '}';
    }
}
