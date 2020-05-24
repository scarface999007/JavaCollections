package homework5;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("Степень числа : " + pow(5,-3));
        backpack(5);
    }

    public static double pow(int num, int exponent){
        int initialExponent = 0;
        if(exponent == 0){
            return 1;
        }
        if(exponent < 0) {
            exponent = -exponent;
            initialExponent = exponent;
        }
        double res = num*pow(num, exponent-1);
        if(initialExponent == exponent){
            return 1/res;
        }
        return res;
    }

    public static  void backpack(int maxWeightBackpack){
        List<Item> items = new ArrayList<>();
        items.add(new Item("Книга", 1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("Котелок", 1, 500));
        Backpack backpack = new Backpack(maxWeightBackpack);
        backpack.bestSet(items);
        System.out.println(backpack.getBestSet().toString());
        System.out.println(backpack.getBestPrice());
    }



}

class Backpack {
    private List<Item> items;
    private int maxWeight;
    private int bestPrice;
    Backpack(int maxWeight){
        this.maxWeight = maxWeight;
    }

    public void bestSet(List<Item> items) {
        if (items.isEmpty()) {
            return;
        }

        updatePriceBestSet(items);

        for (int i = 0; i < items.size(); i++) {
            List<Item> copiedItems = new ArrayList<>(items);
            copiedItems.remove(i);
            bestSet(copiedItems);
        }
    }

    private void updatePriceBestSet(List<Item> items){
        int currentPrice = getItemsPrice(items);
        int currentWeight = getItemsWeight(items);
        if(bestPrice <= currentPrice && currentWeight <= maxWeight){
            bestPrice = getItemsPrice(items);
            this.items = items;
        }
    }


    public List<Item> getBestSet(){
        return items;
    }

    public int getItemsWeight(List<Item> items){
        int sumWeight = 0;
        for(Item item : items){
            sumWeight += item.getWeight();
        }
        return  sumWeight;
    }

    public int getItemsPrice(List<Item> items){
        int sumPrice = 0;
        for(Item item : items){
            sumPrice += item.getPrice();
        }
        return  sumPrice;
    }

    public int getBestPrice() {
        return bestPrice;
    }
}


class Item {
    String name;
    private int weight;
    private int price;
    Item(String name, int weight, int price){
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}