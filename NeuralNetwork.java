import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NeuralNetwork {
    public static void main(String[] args) {
        List<Double[]> trainData = new ArrayList<>();
        trainData.add(new Double[]{1.0, 2.0});
        trainData.add(new Double[]{2.0, 4.0});
        trainData.add(new Double[]{3.0, 6.0});
        trainData.add(new Double[]{4.0, 8.0});
        trainData.add(new Double[]{5.0, 10.0});
        trainData.add(new Double[]{6.0, 12.0});
        
        List<Double> testData = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 12; i++) {
            testData.add((double) rand.nextInt(51));
        }
        
        Net myNet = new Net(trainData);
        myNet.main();
        myNet.eval(testData);
    }
}