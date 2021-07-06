package LabTest1;

import java.util.List;

public class FoodStore extends ShopLot implements Comparable<FoodStore>{
    private List<Item<String,Integer>> menu;

    public FoodStore(String shopName, Person contactPerson, List<Item<String, Integer>> menu, List<Person> employees) {
        super(shopName, contactPerson, employees);
        this.menu = menu;
    }

    @Override
    public int compareTo(FoodStore o){
        if(this.employees.size() > o.employees.size()){
            return 1;
        }
        else if(this.employees.size() < o.employees.size()){
            return -1;
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof FoodStore)){
            return false;
        }
        return this.contactPerson.getName().equals(((FoodStore) obj).contactPerson.getName());
    }

    public List<Item<String,Integer>> getMenu(){
        return menu;
    }

    @Override
    public String toString(){
        return "ShopLot{ shopName="+shopName+", contact="+contactPerson+", menu="+menu+", employee="+employees+" }";
    }
}
