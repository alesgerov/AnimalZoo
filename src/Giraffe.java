import java.util.ArrayList;

public class Giraffe extends Animal{
    {
        setLifeExpectancy(28);
        ArrayList<String> foods=new ArrayList<>();
        foods.add("hay");
        foods.add("fruit");
        setEats(foods);
    }


    @Override
    public String toString() {
        return "Giraffe{" +
                "age=" + age +
                ", gender=" + gender +
                ", health=" + health +
                '}';
    }

    @Override
    public void treat() {
        neckMassage();
    }

    private void neckMassage(){
        increaseHealth(4);
    }
}
