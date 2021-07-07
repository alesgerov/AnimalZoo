import java.util.ArrayList;
import java.util.List;


public abstract class Animal {
    int age;
    char gender;
    ArrayList<String> eats;
    int health;
    int lifeExpectancy;

    Enclosure enclosure=new Enclosure();
    FoodStore foodStore=new FoodStore();

    public abstract void treat();

    public void setHealth(int health) {
        this.health = health;
    }

    public Animal(int age, char gender, int health, Enclosure enclosure) {
        this.age = age;
        this.gender = gender;
        this.health = health;
        this.enclosure = enclosure;
    }

    public  boolean aMonthPasses(){
        decreaseHealth(2);
        eat();
        gettingOlder();
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", gender=" + gender +
                ", health=" + health +
                '}';
    }

    public FoodStore getFoodStore() {
        return this.foodStore;
    }

    public Enclosure getEnclosure() {
        return this.enclosure;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setEnclosure(Enclosure enclosure1) {

        enclosure1.addAnimal(this);
    }





    public void eat(){

        //this.foodStore=getEnclosure().getFoodStore();
        for (int i = 0; i < getEats().size() && !isDead(); i++) {
            //System.out.println(this.foodStore.getFoods());
            if (this.foodStore.getFoods().get(getEats().get(i))!=null ) {
                this.increaseHealth(this.foodStore.getFoodHealth(getEats().get(i)));
                this.foodStore.takeFood(getEats().get(i));
                this.getEnclosure().addWaste(this.foodStore.getWasteValue(getEats().get(i)));
            }
        }

    }

    public int decreaseHealth(int number){
        if (this.health-number>0){
            this.health=this.health-number;
        }else {
            this.health=0;
        }
        return this.health;

    }
    public  int increaseHealth(int number){
        if (this.getHealth()+number>=10){
            this.health=10;
        }else {
        this.health=this.health+number;}
        return this.health;
    }

    public ArrayList<String> getEats() {
        return eats;
    }

    public void setEats(ArrayList<String> eats) {
        this.eats = eats;
    }

    public Animal(int age, char gender, ArrayList<String> eats, int health) {
        this.age = age;
        this.gender = gender;
        this.eats = eats;
        this.health = health;

    }


    public Animal() {
    }

    public int getAge() {
        return age;
    }



    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getHealth() {
        return health;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public boolean canEat(String food){
        for (int i = 0; i < getEats().size() ; i++) {
            if(getEats().get(i).equals(food)) return true;
        }
        return false;
    }

    public boolean isDead(){
        return this.getAge() >= this.getLifeExpectancy() || this.getHealth() == 0;
    }

    public void gettingOlder(){
        if (!isDead()) {
            this.age=this.age+1;
        }
    }

//    public void ifDeadRemove(){
//        if (isDead()) enclosure.removeAnimal(this);
//    }

}
