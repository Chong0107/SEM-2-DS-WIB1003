package LabTest1;

import java.util.ArrayList;
import java.util.List;

public class ShoppingMall {
    public static void main(String[] args) {
        // McDonalds Shop
        ArrayList<Item<String,Integer>> mcDonaldMenu = new ArrayList<>();
        mcDonaldMenu.add(new Item<>("Burger",10));
        mcDonaldMenu.add(new Item<>("Fried Chicken",12));

        ArrayList<Person> mcDonaldEmployee = new ArrayList<>();
        mcDonaldEmployee.add(new Person("Jack"));
        mcDonaldEmployee.add(new Person("Jane"));

        FoodStore foodStore1 = new FoodStore("McDonalds",new Person("Mike","0101122334"),mcDonaldMenu,mcDonaldEmployee);

        // Sushi Mentai Shop
        ArrayList<Item<String,Integer>> sushiMentaiMenu = new ArrayList<>();
        sushiMentaiMenu.add(new Item<>("Chicken Katsu Don",15));
        sushiMentaiMenu.add(new Item<>("Ramen",12));

        ArrayList<Person> sushiMentaiEmployee = new ArrayList<>();
        sushiMentaiEmployee.add(new Person("Adam"));
        sushiMentaiEmployee.add(new Person("Alex"));
        sushiMentaiEmployee.add(new Person("Andrew"));

        FoodStore foodStore2 = new FoodStore("Sushi Mentai",new Person("Max","0112233445"),sushiMentaiMenu,sushiMentaiEmployee);

        // Waroeng Penyet shop
        ArrayList<Item<String,Integer>> waroengPenyetMenu = new ArrayList<>();
        waroengPenyetMenu.add(new Item<>("Ayam Penyet",10));

        ArrayList<Person> waroengPenyetEmployee = new ArrayList<>();
        waroengPenyetEmployee.add(new Person("Lex"));
        waroengPenyetEmployee.add(new Person("Leon"));

        FoodStore foodStore3 = new FoodStore("Waroeng Penyet",new Person("Mike","0101122334"),waroengPenyetMenu,waroengPenyetEmployee);

        FoodStore[] foodStores = {foodStore1,foodStore2,foodStore3};

        // Uniqlo shop
        ArrayList<Item<String,Integer>> uniqloClothes = new ArrayList<>();
        uniqloClothes.add(new Item<>("Shirt",80));
        uniqloClothes.add(new Item<>("T-shirt",60));

        ArrayList<Person> uniqloEmployee = new ArrayList<>();
        uniqloEmployee.add(new Person("Kate"));
        uniqloEmployee.add(new Person("Ken"));
        uniqloEmployee.add(new Person("Kurt"));

        FashionStore fashionStore1 = new FashionStore("Uniqlo",new Person("Nate","01999887765"),uniqloClothes,uniqloEmployee);

        // Padini shop
        ArrayList<Item<String,Integer>> padiniClothes = new ArrayList<>();
        padiniClothes.add(new Item<>("Blouse",100));
        padiniClothes.add(new Item<>("Skirt",80));

        ArrayList<Person> padiniEmployee = new ArrayList<>();
        padiniEmployee.add(new Person("Frank"));
        padiniEmployee.add(new Person("Felix"));

        FashionStore fashionStore2 = new FashionStore("Padini",new Person("Nick","0195544332"),uniqloClothes,uniqloEmployee);

        // Mango shop
        ArrayList<Item<String,Integer>> mangoClothes = new ArrayList<>();
        mangoClothes.add(new Item<>("Dress",120));

        ArrayList<Person> mangoEmployee = new ArrayList<>();
        mangoEmployee.add(new Person("Ron"));
        mangoEmployee.add(new Person("John"));

        FashionStore fashionStore3 = new FashionStore("Mango",new Person("Nicloe","0194433221"),padiniClothes,padiniEmployee);

        FashionStore[] fashionStores = {fashionStore1,fashionStore2,fashionStore3};

        // Output
        System.out.println(foodStore2);
        System.out.println(fashionStore3);

        System.out.println();
        System.out.println("Food Store with the highest number of employees: "+mostEmployees(foodStores));
        System.out.println("Fashion store with highest number of employees: "+mostEmployees(fashionStores));

        System.out.println();
        System.out.println("The contact person for McDonalds and Sushi Mentai is "+(foodStore1.equals(foodStore2)? "the same":"different"));
        System.out.println("The contact person for McDonalds and Waroeng Penyet is "+(foodStore1.equals(foodStore3)? "the same":"different"));
        System.out.println("The contact person for Sushi Mentai and Waroeng Penyet is "+(foodStore2.equals(foodStore3)? "the same":"different"));

        System.out.println("\nSushi Mentai have "+(foodStore2.compareTo(foodStore3)<= 0 ? "less":"more")+" than Waroeng Penyet");

        System.out.println();
        System.out.println("The most expensive item in McDonalds is "+mostExpensive(foodStore1).getItemName());
        System.out.println("The most expensive item in Padini is "+mostExpensive(fashionStore2).getItemName());
    }

    // To find out which shop has the most number of employees
    public static <E extends ShopLot> String mostEmployees(E[] shopLots){
        String mostEmployeesShop = "";
        int employeesCount = 0;
        for(int i=0;i<shopLots.length;i++){
            if(shopLots[i].employees.size() > employeesCount){
                employeesCount = shopLots[i].employees.size();
                mostEmployeesShop = shopLots[i].shopName;
            }
        }
        return mostEmployeesShop;
    }

    // To find out the most expensive item
    public static <E extends ShopLot> Item<String,Integer> mostExpensive(E shopLots){
        if(shopLots instanceof FoodStore){
            List<Item<String,Integer>> menu = ((FoodStore) shopLots).getMenu();
            return calculateMostExpensiveItem(menu);
        }
        else if(shopLots instanceof FashionStore){
            List<Item<String,Integer>> clothes = ((FashionStore) shopLots).getClothes();
            return calculateMostExpensiveItem(clothes);
        }
        else{
            System.out.println("Unspecified shopLot type");
            return null;
        }
    }

    // Helper method for mostExpensive() class
    private static Item<String,Integer> calculateMostExpensiveItem(List<Item<String,Integer>> items){
        Item<String,Integer> mostExpensiveItem = null;
        int mostExpensivePrice = 0;
        for(int i=0;i<items.size();i++){
            if(items.get(i).getItemCost() > mostExpensivePrice){
                mostExpensivePrice = items.get(i).getItemCost();
                mostExpensiveItem = items.get(i);
            }
        }
        return mostExpensiveItem;
    }
}
