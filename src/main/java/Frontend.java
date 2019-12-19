import lombok.Data;

@Data
public class Frontend {
    private String title;
    private int quantity;

    public Frontend(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }
}
