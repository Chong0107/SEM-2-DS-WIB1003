public class PastYear2017S1Q1 {
    public static void main(String[] args) {
        towerOfHanoi(3,"pole 1","pole 3","pole 2",2);
    }

    static int step = 0;
    public static void towerOfHanoi(int n,String from,String to,String free,int disc){
        if(n == 1){
            step++;
            System.out.println("Step "+step+": Move disc "+disc+" from "+from+" to "+to);
        }
        else if(n>1){
            towerOfHanoi(n-1,from,free,to,n-1);
            towerOfHanoi(1,from,to,free,n);
            towerOfHanoi(n-1,free,to,from,n-1);
        }
    }
}
