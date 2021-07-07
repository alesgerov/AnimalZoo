import java.util.Random;
import java.util.Scanner;

public class TestingMain {
    public static void main(String[] args) throws Exception {

        Scanner scanner=new Scanner(System.in);
        System.out.printf("Enter number of month: ");
        int n=scanner.nextInt();
        ZooSimulation s=new ZooSimulation();
        s.run(n);

    }
}
