public class Lion extends BigCat{
//    @Override
//    public boolean aMonthPasses() {
//        decreaseHealth(2);
//        //eat();
//        return true;
//    }


    @Override
    public String toString() {
        return "Lion{" +
                "age=" + age +
                ", gender=" + gender +
                ", health=" + health +
                '}';
    }

    @Override
    public void treat() {
        stroked();
    }

    @Override
    public void stroked() {
        increaseHealth(2);
    }
}
