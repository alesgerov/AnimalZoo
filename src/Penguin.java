import java.util.ArrayList;

public class Penguin extends Animal{

    {
        ArrayList<String>foods=new ArrayList<>();
        foods.add("fish");
        foods.add("ice cream");
        setLifeExpectancy(15);
        setEats(foods);

    }
    @Override
    public void treat() {
        watchAFilm();
    }

    @Override
    public String toString() {
        return "Penguin{" +
                "age=" + age +
                ", gender=" + gender +
                ", health=" + health +
                '}';
    }

    private void watchAFilm() {
        increaseHealth(2);
    }


}
