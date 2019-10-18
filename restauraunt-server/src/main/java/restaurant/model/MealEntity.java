package restaurant.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "meals")
public class MealEntity {

    @Id
    @Column(name = "uuid")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private int calories;

    @Column(name = "weight")
    private int weight;

    @Column(name = "price")
    private int price;

    public MealEntity() {
    }

    public MealEntity(String name, int calories, int weight, int price) {
        this(UUID.randomUUID().toString(), name, calories, weight, price);
    }

    public MealEntity(String uuid, String name, int calories, int weight, int price) {
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
        return "Meal{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
