import java.util.ArrayList;

public class Enclosure {
    private ArrayList<Animal> animals=new ArrayList<>(20);
    private FoodStore foodStore=new FoodStore();
    private int waste;
    private ZooKeeper zooKeeperClass=new ZooKeeper();

    public void setZooKeeperClass(ZooKeeper zooKeeperClass) {
        this.zooKeeperClass = zooKeeperClass;
    }

    private Zoo zoo=new Zoo();

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public Animal getAnimal(int index){
        return animals.get(index);
    }

    public FoodStore getFoodStore() {
        return foodStore;
    }

    public void setFoodStore(FoodStore foodStore) {
        this.foodStore = foodStore;
    }


    public  void aMonthPasses(){
        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).aMonthPasses();
            if (animals.get(i).isDead()) this.removeAnimal(animals.get(i));
        }

    }


    @Override
    public String toString() {
        return "Enclosure{" +
                "animals=" + animals +
                ", foodStore=" + foodStore +
                ", waste=" + waste +
                '}';
    }

    public void addAnimal(Animal animal){

        if (animals.size()<20){
            animals.add(animal);
        }
    }
    public void removeAnimal(Animal animal){animals.remove(animal);}
    public int removeWaste(int num){
        this.waste=this.waste-num;
        return this.waste;

    }
    public int addWaste(int num){
        this.waste=this.waste+num;

        return this.waste;
    }

    public int getWasteSize() {
        return waste;
    }
    public int size(){return animals.size();}




}
