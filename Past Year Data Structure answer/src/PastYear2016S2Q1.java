import java.util.Scanner;

public class PastYear2016S2Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Day day = new Day();
        System.out.println("The name of the day is : "+day.today());
        System.out.println("The following day of "+day.today()+" is : " +day.addDay(1));
        System.out.println("The previous day of "+day.today()+" is : "+day.previousDay());
        System.out.println("How many days to add to the specified / current day ("+day.today()+")?");
        int number = input.nextInt();
        System.out.println("The new day after the addition of "+number+" day(s) is : "+day.addDay(number));
    }
}

class Day{
    private static String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    private int day;

    public Day(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify your day in number: ");
        for(int i=0;i<days.length;i++){
            System.out.println((i+1)+" for "+days[i]);
        }
        day = sc.nextInt();
    }

    public String today(){
        return days[day - 1];
    }

    public String previousDay(){
        if(day == 1){
            return days[6];
        }
        else{
            return days[day - 2];
        }
    }

    public String addDay(int add){
        return days[(day + add - 1) % 7];
    }
}
