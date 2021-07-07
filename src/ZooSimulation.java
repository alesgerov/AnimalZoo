import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ZooSimulation {

    public void run(int month) {
        FoodStore foodStore = new FoodStore();
        List<String> foods=new ArrayList<>();
        List<String> animalList=new ArrayList<>();
        List<String> zooKeeperWords=new ArrayList<>();
        animalList.add("bear");
        animalList.add("lion");
        animalList.add("tiger");
        animalList.add("elephant");
        animalList.add("giraffe");
        animalList.add("penguin");
        animalList.add("chimpanzee");
        animalList.add("gorilla");



        Zoo zoo = null;
        int value;

        boolean makedZoo=false;
        foods.add("steak");
        foods.add("hay");
        foods.add("celery");
        foods.add("fruit");
        foods.add("fish");
        foods.add("ice cream");
        zooKeeperWords.add("playZookeeper");
        zooKeeperWords.add("zookeeper");
        zooKeeperWords.add("physioZookeeper");
        int enclosureCount=-1;
        int zooKeeperCount=-1;


        try(
                BufferedReader inputStream=new BufferedReader(new FileReader("myZoo.txt"))
        ) {
            String line;

            while ((line=inputStream.readLine())!=null){
                String [] word;
                word=line.split(":");
                if (word[0].equals("zoo")){
                    zoo=new Zoo();
                    makedZoo=true;
                }else if (foods.contains(word[0]) && makedZoo){
                    value = Integer.parseInt(word[1]);
                    foodStore.addFood(word[0], value);
                }else if (word[0].equals("enclosure") && makedZoo){
                    Enclosure enclosure=new Enclosure();
                    zoo.setEnclosures(enclosure);
                    enclosure.setZoo(zoo);
                    value=Integer.parseInt(word[1]);
                    enclosure.addWaste(value);
                    enclosureCount++;
                    if (zooKeeperCount>-1){
                        zoo.getZooKeeper(zooKeeperCount).setEnclosure(zoo.getEnclosure(enclosureCount));
                    }
                }else if (zooKeeperWords.contains(word[0]) && makedZoo){
                    ZooKeeper zooKeeper=new ZooKeeper();
                    zoo.setZooKeepers(zooKeeper);
                    zooKeeper.setZoo(zoo);
                    zooKeeperCount++;
                    if (enclosureCount>-1){
                        zooKeeper.setEnclosure(zoo.getEnclosure(enclosureCount));
                    }
                }else if (animalList.contains(word[0]) && makedZoo){
                    Animal animal=createAnimal(word[0]);
                    List<Integer> numbersForAnimal=stringSpliter(word[1]);
                    animal.setAge(numbersForAnimal.get(1));
                    animal.setGender((char) (int)numbersForAnimal.get(0));
                    animal.setHealth(numbersForAnimal.get(2));
                    if (numbersForAnimal.size()==4){
                        animal.setEnclosure(zoo.getEnclosure(numbersForAnimal.get(3)-1));
                    }else {
                        try {
                            animal.setEnclosure(zoo.getEnclosure(enclosureCount));
                        }catch (Exception e){
                            System.out.println("There is no enclosure to assign animal");
                        }
                    }


                }
            }

            if (zoo!=null){
                zoo.setFoodStore(foodStore);
                for (int i = 0; i < month; i++) {
                    zoo.aMonthPasses();
                }
                //System.out.println((zoo.getZooKeeper(0).countOfEnclosures()));
                printZoo(zoo);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public List<Integer> stringSpliter(String word){
        String [] array=word.split(",");
        List <Integer> numbers=new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            try {
                numbers.add(Integer.parseInt(array[i]));
            }catch (NumberFormatException e){
                char a =word.charAt(i);
                numbers.add((int) a);
            }
        }
        return numbers;

    }

    public Animal createAnimal(String anim){
        Animal animal=null;
        switch (anim) {
            case "lion":
                animal = new Lion();
                break;
            case "tiger":
                animal = new Tiger();
                break;
            case "elephant":
                animal = new Elephant();
                break;
            case "giraffe":
                animal = new Giraffe();
                break;
            case "penguin":
                animal = new Penguin();
                break;
            case "chimpanzee":
                animal = new Chimpanzee();
                break;
            case "bear":
                animal = new Bear();
                break;
            case "gorilla":
                animal = new Gorilla();
                break;
        }
        return  animal;
    }

    public  void printZoo(Zoo zoo){
        System.out.println("Zoo foodstore: "+zoo.getFoodStore());
        for (int i = 0; i < zoo.getEnclosuresCount(); i++) {
            for (int j = 0; j < zoo.getEnclosure(i).size(); j++) {
                System.out.println(zoo.getEnclosure(i).getAnimal(j));
            }
            System.out.println("Enc foodstore: "+zoo.getEnclosure(i).getFoodStore());
            System.out.println("Enc waste: "+ zoo.getEnclosure(i).getWasteSize());

        }
        System.out.println(zoo.getZooKeeper(0));
    }






}
