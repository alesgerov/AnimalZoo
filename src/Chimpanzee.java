public class Chimpanzee extends Ape{
    {setLifeExpectancy(24);}
    @Override
    public void treat() {
        playChase();
    }

    private void playChase() {
        increaseHealth(4);
    }

    @Override
    public String toString() {
        return "Chimpanzee{" +
                "age=" + age +
                ", gender=" + gender +
                ", health=" + health +
                '}';
    }
}
