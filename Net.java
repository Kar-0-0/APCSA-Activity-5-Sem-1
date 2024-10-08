import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Net {
    private List<Double[]> data;
    private List<Double> weights;
    private List<Double> X;
    private List<Double> Y;
    private double learning_rate = 0.1;
    private int epochs = 100;
    private int n = 0;
    private double input;
    private double loss;
    private double dw;
    private double out;
    private int correct = 0;
    private String breaker = "----------------------------------------------------------------";
    
    public Net(List<Double[]> data) {
        this.data = data;
        this.weights = new ArrayList<>();
        this.X = new ArrayList<>();
        this.Y = new ArrayList<>();
    }
    
    public void preprocessData(List<Double[]> data) {
        for (int r = 0; r < data.size(); r++) {
            for (int c = 0; c < data.get(r).length - 1; c++) {
                X.add(data.get(r)[c]);
                Y.add(data.get(r)[c + 1]);
            }
        }
    }
    
    public void initWeights() {
        Random rand = new Random();
        for (int i = 0; i < X.size(); i++) {
            weights.add(rand.nextDouble());
        }
    }
    
    public double squaredError(double y_hat, double Y) {
        loss = Math.pow(y_hat - Y, 2);
        dw = 2 * (y_hat - Y) * X.get(n);
        return loss;
    }
    
    public double forward(double X, double W) {
        return X * W;
    }
    
    public double gradientDescent(double W, double learning_rate) {
        return W - (learning_rate * dw);
    }
    
    public void train() {
        input = X.get(n);
        
        for (int epoch = 0; epoch < epochs; epoch++) {
            out = forward(input, weights.get(n));
            loss = squaredError(out, Y.get(n));
            weights.set(n, gradientDescent(weights.get(n), learning_rate));
            
            System.out.printf("\nEpoch: %d/%d Loss: %f%n", epoch + 1, epochs, loss);
            System.out.printf("%.1f x %.1f = %.1f --> %.1f x %.1f = %.1f%n",
                    input, Y.get(n), input * 2, input, weights.get(n), out);
        }
        System.out.println(breaker.substring(0, breaker.length();
    }
    
    public void eval(List<Double> testData) {
        main();
        correct = 0;
        
        for (Double input : testData) {
            System.out.printf("\n%.1f x 2 = %.1f%n", input, forward(input, weights.get(n)));
            if (loss < 0.1) {
                correct++;
            }
        }
        System.out.printf("Eval Accuracy: %.1f%%%n", (double) correct / testData.size() * 100);
    }
    
    public void main() {
        preprocessData(data);
        initWeights();
        train();
    }
}
