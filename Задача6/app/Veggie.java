import java.util.Random;

public class Veggie {
    private String name;
    private Float price;
    private Float amount;
    private Float sugary_index;

    Veggie(String name, Float price, Float amount, Float sugary_index) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.sugary_index = sugary_index;
    }

    public void randomAmount() {
        Random random = new Random();
        this.amount = random.nextFloat() * 99.0f + 1.0f;
    }
}
