public class Tiger extends BigCat{




    @Override
    public void treat() {
        stroked();
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "age=" + age +
                ", gender=" + gender +
                ", health=" + health +
                '}';
    }

    @Override
    public void stroked() {
        increaseHealth(3);
    }
}
