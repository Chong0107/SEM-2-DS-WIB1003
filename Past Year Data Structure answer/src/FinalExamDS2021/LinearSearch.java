package FinalExamDS2021;

public class LinearSearch {
    private static void linearSearch(int[] parcels, int requiredParcel){
        int index = 0;
        int time = 0;

        for(int i = 0; i<parcels.length; i++){
            time += 15;
            if(i == requiredParcel) {
                index = i;
                break;
            }
        }

        System.out.println("The parcel is at position " + index);
        System.out.println("the time required is : " + ((double)time/60) + " minutes");
    }
}
