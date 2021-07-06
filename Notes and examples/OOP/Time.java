
package OOP;

// Create a class Time that represents time of the day. The class consists of attributes for
// the hour and minute. The hour value ranges from 0 to 23 and the minute value ranges
// from 0 to 59. The class consists of constructor that initializes the time and hour. The
// class also consists of a method to check whether the time is valid and a method to
// display the time in hh:mm AM or hh:mm PM. Create a Tester class to test the
// program, given output below.

public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    
    public boolean checkValid(){
        // Check for hour
        if(hour < 0 || hour > 23)
            return false;
       
        // Check for minute
        if(minute < 0 || minute > 59)
            return false;
        
        return true;
    }
    
    public void display(){
        if(checkValid() == false){
            System.out.println("Hour: "+hour+" Minute: "+minute+" Invalid time input");
        }
        else if(hour > 12){
            System.out.println("Hour: "+hour+" Minute: "+minute+" "+hour%12+":"+minute+" PM");
        }
        else{
            System.out.println("Hour: "+hour+" Minute: "+minute+" "+hour+":"+minute+" AM");
        }
    }
}

class testTime{
    public static void main(String[] args) {
        Time time1 = new Time(13,45);
        time1.checkValid();
        time1.display();
        Time time2 = new Time(33,15);
        time2.checkValid();
        time2.display();
        Time time3 = new Time(10,52);
        time3.checkValid();
        time3.display();
    }
}
