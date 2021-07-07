import java.util.ArrayList;

public class Elephant extends Animal{

    {
        ArrayList<String> foods=new ArrayList<>();
        foods.add("hay");
        foods.add("fruit");
        setLifeExpectancy(36);
        setEats(foods);
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "age=" + age +
                ", gender=" + gender +
                ", health=" + health +
                '}';
    }

    @Override
    public void treat() {
        bath();
    }
    private void bath(){
        increaseHealth(5);
    }


}
