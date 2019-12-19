import lombok.Data;

@Data
public class Backend {
    private String title;
    private int quantity;

    public Backend(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }
}
