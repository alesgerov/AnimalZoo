import java.util.ArrayList;

public abstract class Ape extends Animal{
    {
        ArrayList<String>foods=new ArrayList<>();
        foods.add("fish");
        foods.add("ice cream");
        setEats(foods);
    }
}
