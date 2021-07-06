package LabTest1;

import java.util.List;

public class FashionStore extends ShopLot implements Comparable<FashionStore>{
    private List<Item<String,Integer>> clothes;

    public FashionStore(String shopName, Person contactPerson, List<Item<String, Integer>> clothes, List<Person> employees) {
        super(shopName, contactPerson, employees);
        this.clothes = clothes;
    }

    @Override
    public int compareTo(FashionStore o){
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
        if(!(obj instanceof FashionStore)){
            return false;
        }
        return this.contactPerson.getName().equals(((FashionStore) obj).contactPerson.getName());
    }

    public List<Item<String, Integer>> getClothes() {
        return clothes;
    }

    @Override
    public String toString(){
        return "ShopLot{ shopName="+shopName+", contact="+contactPerson+", clothes="+clothes+", employee="+employees+" }";
    }
}
