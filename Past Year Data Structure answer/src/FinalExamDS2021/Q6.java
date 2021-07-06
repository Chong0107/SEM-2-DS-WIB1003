package FinalExamDS2021;

public class Q6 {
    public static void main(String[] args) {
        int[] parcels = new int[10];
        boolean[] isAdded = new boolean[10];

        for(int i = 0; i<parcels.length; i++){
            int randomNum = (int)(Math.random() * 10);
            if(!isAdded[randomNum]){
                isAdded[randomNum] = true;
                parcels[i] = randomNum;
            }

            else {
                do {
                    randomNum = (int)(Math.random() * 10);
                } while (isAdded[randomNum]);

                isAdded[randomNum] = true;
                parcels[i] = randomNum;
            }
        }

        selectionSort(parcels);
        bubbleSort(parcels);

    }
    private static void bubbleSort(int [] parcels){
        int ScanningTime = 0;
        int SwappingTime = 0;
        for(int i = 1; i<parcels.length; i++){
            for(int j = 0; j<parcels.length - i; j++){
                ScanningTime += 30;
                if(parcels[j] > parcels[j + 1]){
                    SwappingTime += 6;
                    int temp = parcels[j];
                    parcels[j] = parcels[j + 1];
                    parcels[j + 1] = temp;
                }
            }
        }

        System.out.println("Total time for the whole bubbleSort : " + ((double)(ScanningTime + ScanningTime) / 60) + " minutes");
    }

    private static void selectionSort(int[] parcels){
        int ScanningTime = 0;
        int SwappingTime = 0;


        for(int i = 0; i < parcels.length; i++){
            ScanningTime += 15;
            int minimumTag = parcels[i];
            int minimumIndex = i;
            for(int j = i + 1; j< parcels.length; j++){
                ScanningTime += 15;
                if(minimumTag > parcels[j]){
                    minimumTag = parcels[j];
                    minimumIndex = j;
                }
            }

            if(minimumIndex != i){
                ScanningTime += 6;
                parcels[minimumIndex] = parcels[i];
                parcels[i] = minimumTag;
            }

        }

        System.out.println("Total time for the whole selectionSort : " + ((double)(ScanningTime + ScanningTime) / 60) + " minutes");
    }
}
