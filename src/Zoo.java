import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private FoodStore foodStore;
    private List<Enclosure> enclosures=new ArrayList<>();
    private List<ZooKeeper> zooKeepers=new ArrayList<>();

    public List<ZooKeeper> getZooKeepers() {
        return zooKeepers;
    }

    public void setZooKeepers(ZooKeeper zooKeeper1) {
        this.zooKeepers.add(zooKeeper1);

    }

    public int countOfZooKeepers() {
        return this.zooKeepers.size();
    }

    public ZooKeeper getZooKeeper(int index) {
        return this.zooKeepers.get(index);
    }

    public FoodStore getFoodStore() {
        return foodStore;
    }

    public void setFoodStore(FoodStore foodStore) {
        this.foodStore = foodStore;
    }

    public int getEnclosuresCount() {
        return enclosures.size();
    }

    public int getFoodQuantity(String food){
        int result=this.getFoodStore().getFoods().get(food);
        return result;
    }

    public Enclosure getEnclosure(int index) {
        return enclosures.get(index);
    }

    public void setEnclosures(Enclosure enclosure1) {
        this.enclosures.add(enclosure1);
    }

    public int getAllFoodQuantity(){
        int result=0;
        var entrySet=this.getFoodStore().getFoods().values();
        for (Integer integer:entrySet) {
            result+=integer;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "foodStore=" + foodStore +
                ", enclosures=" + enclosures +
                ", zooKeepers=" + zooKeepers +
                '}';
    }

    public void aMonthPasses(){
        for (ZooKeeper zooKeeper:this.zooKeepers ) {
            zooKeeper.aMonthPasses();
        }
        for (Enclosure enclosure:this.enclosures  ) {
            enclosure.aMonthPasses();

        }
    }



}
