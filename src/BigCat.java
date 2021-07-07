import java.util.ArrayList;

public abstract  class BigCat extends Animal {
    {
        ArrayList<String> foods=new ArrayList<>();
        foods.add("steak");
        foods.add("celery");
        setEats(foods);
        setLifeExpectancy(24);
    }
    public abstract void stroked();

}
