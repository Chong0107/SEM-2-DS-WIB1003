package FinalExamDS2021;

public class BinarySearch {
    private static int binarySearch(int[] parcels, int parcel){
        int index = -1;
        int ScanningTime = 0;

        int low = 0;
        int high = parcels.length-1;

        while(low <= high){
            int middle = (high + low)/2;

            ScanningTime += 15;
            if(parcels[middle] == parcel){
                index = middle;
                break;
            }

            else if(parcel < parcels[middle]){
                high = middle - 1;
            }

            else
                low = middle + 1;

        }

        System.out.println("The time required for binary search (scanning) is : " + ScanningTime);
        return index;
    }
}
