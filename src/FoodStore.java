import java.util.*;

public class FoodStore {
    private HashMap<String ,Integer> foods=new HashMap<>();
    private HashMap<String ,Integer> wasteValue =new HashMap<>();
    private HashMap<String ,Integer> healthValue =new HashMap<>();


    {
        addFoodHealth();
        addFoodWaste();
    }
    public void addFood(String foodName,int foodCount){

        this.foods.put(foodName,this.foods.getOrDefault(foodName,0)+foodCount);
    }

    public void takeFood(String foodName){
        this.foods.put(foodName,this.foods.getOrDefault(foodName,0)-1);
    }

    public void takeFood(String foodName,int count){
        this.foods.put(foodName,this.foods.getOrDefault(foodName,0)-count);
    }


    private void addFoodHealth(){
        healthValue.put("hay",1);
        healthValue.put("steak",3);
        healthValue.put("fruit",2);
        healthValue.put("celery",0);
        healthValue.put("fish",3);
        healthValue.put("ice cream",1);

    }
    private void addFoodWaste(){
        wasteValue.put("hay",4);
        wasteValue.put("steak",4);
        wasteValue.put("fruit",3);
        wasteValue.put("celery",1);
        wasteValue.put("fish",2);
        wasteValue.put("ice cream",3);
    }

    public HashMap<String, Integer> getFoods() {
        return foods;
    }


    public int getFoodHealth(String food){
        if (healthValue.containsKey(food)) { return healthValue.get(food); }
        return 0;
    }

    @Override
    public String toString() {
        return "FoodStore{" +
                "foods=" + foods +
                '}';
    }

    public int getWasteValue(String food) {
        if (wasteValue.containsKey(food)) {return wasteValue.get(food);}
        return 0;
    }

//    public FoodStore getFoodByCount(int count){
//        FoodStore foodStoreMove=new FoodStore();
//        Random random=new Random();
//        int countOfGotFood=0;
//        int temp=count;
//        count=count+1;
//
//        int valueForMoving=random.nextInt(count);
//        String foodName;
//        List<String> foodsArray = new ArrayList<>(this.getFoods().keySet());
//        while (countOfGotFood!=temp) {
//            int randomIndexForFoods= random.nextInt(foodsArray.size());
//            foodName=foodsArray.get(randomIndexForFoods);
//            if (this.getFoods().get(foodName)>valueForMoving){
//                foodStoreMove.addFood(foodName,valueForMoving);
//                this.takeFood(foodName,valueForMoving);
//                countOfGotFood+=valueForMoving;
//            } else if (this.getFoods().get(foodName) == valueForMoving) {
//                foodStoreMove.addFood(foodName,valueForMoving);
//                this.takeFood(foodName,valueForMoving);
//                foodsArray.remove(foodName);
//                countOfGotFood+=valueForMoving;
//            }else {
//                int countOfFood=this.getFoods().get(foodName);
//                foodStoreMove.addFood(foodName,countOfFood);
//                this.takeFood(foodName,countOfFood);
//                foodsArray.remove(foodName);
//                countOfGotFood+=countOfFood;
//            }
//            if (count==1 ){
//                return foodStoreMove;
//            }
//            count=count-valueForMoving;
//            valueForMoving=random.nextInt(count);
//        }
//
//        return foodStoreMove
//
//    }

    public FoodStore getFoodByCount(int count){
        FoodStore foodStoreMove=new FoodStore();
        boolean flag=false;
        Random random=new Random();
        int countOfGotFood=0;
        int countOfFood=0;
        int temp=count;
        count=count+1;
        int valueForMoving=random.nextInt(count);
        String foodName;
        List<String> foodsArray = new ArrayList<>(this.getFoods().keySet());
        while (countOfGotFood!=temp) {
            int randomIndexForFoods= random.nextInt(foodsArray.size());
            foodName=foodsArray.get(randomIndexForFoods);
            if (this.getFoods().get(foodName)>valueForMoving){
                foodStoreMove.addFood(foodName,valueForMoving);
                this.takeFood(foodName,valueForMoving);
                countOfGotFood+=valueForMoving;
                flag=true;

            } else if (this.getFoods().get(foodName) == valueForMoving) {
                foodStoreMove.addFood(foodName,valueForMoving);
                this.takeFood(foodName,valueForMoving);
                foodsArray.remove(foodName);
                countOfGotFood+=valueForMoving;
                flag=true;
            }else {
                countOfFood=this.getFoods().get(foodName);
                foodStoreMove.addFood(foodName,countOfFood);
                this.takeFood(foodName,countOfFood);
                foodsArray.remove(foodName);
                countOfGotFood+=countOfFood;
                flag=false;
            }
            if (flag){
                count=count-valueForMoving;
            }else {
                count=count-countOfFood;
            }
            if (count==1 ){
                return foodStoreMove;
            }
            valueForMoving=random.nextInt(count);

        }

        return foodStoreMove;

    }
}
