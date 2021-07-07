public class Gorilla extends Ape{
    {setLifeExpectancy(32);}


    @Override
    public String toString() {
        return "Gorilla{" +
                "age=" + age +
                ", gender=" + gender +
                ", health=" + health +
                '}';
    }

    @Override
    public void treat() {
        painting();

    }

    private void painting() {
        increaseHealth(4);
    }
}
