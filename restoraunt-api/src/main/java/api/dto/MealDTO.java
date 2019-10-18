package api.dto;


public class MealDTO {

    private String uuid;

    private String name;

    private int calories;

    private int weight;

    private int price;

    public MealDTO() {
    }

    public MealDTO(String name, int calories, int weight, int price) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.price = price;
    }

    public MealDTO(String uuid, String name, int calories, int weight, int price) {
        this.uuid = uuid;
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getWeight() {
        return weight;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public boolean isExist() {
        return this.uuid != null;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "MealDTO{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
