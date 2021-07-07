import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZooKeeper {

    private List<Enclosure> enclosures=new ArrayList<>();
    private Enclosure enclosureException ;
    private Zoo zoo=new Zoo();
    private boolean flag = true;



    public void addAnimal(Enclosure enclosure2, Animal... animals) throws Exception {

        for (int i = 0; i < animals.length && enclosures.contains(enclosure2); i++) {
            for (int j = 0; j < this.countOfEnclosures(); j++) {
                if (this.getEnclosure(i).getAnimals().contains(animals[i])) {
                    flag = false;
                    enclosureException = this.getEnclosure(i);
                    break;
                }
            }
            if (flag) {
                enclosure2.addAnimal(animals[i]);
            } else {
                Exception e = new Exception(animals[i] + " already have in " + enclosureException);
                throw e;


            }
        }
    }

    public void aMonthPasses() {
        moveFood(20);
        treat();
        removeWasteByCount(20);

    }


    public void setEnclosure(Enclosure... enclosures2) {
        for (int i = 0; i < enclosures2.length; i++) {
            if (!enclosures.contains(enclosures2[i])) {
                enclosures.add(enclosures2[i]);
            }
        }

    }

    public void removeAllWaste() {
        for (int i = 0; i < this.countOfEnclosures(); i++) {
            this.getEnclosure(i).removeWaste(this.getEnclosure(i).getWasteSize());
        }
    }

    public void removeWasteByCount(int count){
        Random random=new Random();
        count=count+1;
        int value=random.nextInt(count);
        while (true){
            //System.out.println("count: "+count);
            //System.out.println("value: "+value);
            int index=random.nextInt(this.countOfEnclosures());
            if (this.getEnclosure(index).getWasteSize()-value>0){
                this.getEnclosure(index).removeWaste(value);
                count=count-value;
                value=random.nextInt(count);
            }else {
                this.getEnclosure(index).removeWaste(this.getEnclosure(index).getWasteSize());
                break;
            }
            if (count==1){
                break;
            }
        }
    }




    public void removeWaste(Enclosure enclosure1, int num) {
        if (enclosures.contains(enclosure1)) {
            enclosure1.removeWaste(num);
        }
    }

    public int countOfEnclosures() {
        return enclosures.size();
    }

    public Enclosure getEnclosure(int index) {
        return enclosures.get(index);
    }

    public void giveFood() {
        for (int i = 0; i < this.countOfEnclosures(); i++) {
            for (int j = 0; j < this.getEnclosure(i).getAnimals().size(); j++) {
                this.getEnclosure(i).getAnimal(j).eat();
            }
        }
    }

    public void treat() {
        Random random = new Random();
        for (int i = 0; i < this.countOfEnclosures(); i++) {
            if (this.getEnclosure(i).size() > 0) {
                int value = random.nextInt(this.getEnclosure(i).size());
                this.getEnclosure(i).getAnimal(value).treat();
            }
        }
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public String toString() {
        return "ZooKeeper{" +
                "enclosures=" + enclosures +
                '}';
    }


//    public void moveFood(int count){
//        Random random =new Random();
//        int randomIndexForEnclosure=random.nextInt(this.countOfEnclosures());
//        int countOfLoop=0;
//        while (countOfLoop!=this.countOfEnclosures()){
//            FoodStore foodStore1=new FoodStore();
//
//            if (this.zoo.getAllFoodQuantity()<count){
//                foodStore1=this.zoo.getFoodStore().getFoodByCount(this.zoo.getAllFoodQuantity());
//                this.getEnclosure(randomIndexForEnclosure).setFoodStore(foodStore1);
//                break;
//            }else {
//                foodStore1=this.zoo.getFoodStore().getFoodByCount(count);
//            }
//            this.getEnclosure(randomIndexForEnclosure).setFoodStore(foodStore1);
//            randomIndexForEnclosure=random.nextInt(this.countOfEnclosures());
//            countOfLoop++;
//        }
//    }

    public void moveFood(int count){
        Random random=new Random();
        int countOfLoop=0;
        boolean flag=false;
        while (countOfLoop!=this.countOfEnclosures()){
            int countOfFood=this.zoo.getAllFoodQuantity();
            FoodStore foodStore1=new FoodStore();
            Enclosure enclosure1=this.getEnclosure(countOfLoop);
            flag= countOfFood >= count;
            if (flag){
                foodStore1=this.zoo.getFoodStore().getFoodByCount(count);
                enclosure1.setFoodStore(foodStore1);
            }else {
                enclosure1=this.getEnclosure(random.nextInt(this.countOfEnclosures()));
                foodStore1=this.zoo.getFoodStore().getFoodByCount(countOfFood);
                enclosure1.setFoodStore(foodStore1);
                break;
            }
            countOfLoop++;
        }

    }


}
