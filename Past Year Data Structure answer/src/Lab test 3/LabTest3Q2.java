/**
 *
 * @author U2005284 Chong Jun Yi
 */
public class LabTest3Q2 {
    public static void main(String[] args) {
        // Mesh Topology
        System.out.println("Mesh Topology");
        System.out.println("There are 4 switches in the campus.");
        System.out.println("The total number of connections required is "+numberOfConnection(4));
        System.out.println("There are 7 switches in the campus.");
        System.out.println("The total number of connections required is "+numberOfConnection(7));
        System.out.println("");
    }

    // Number of connections
    // To return the total number of connections required for n switches in the campus
    public static int numberOfConnection(int switches){
        return numberOfConnection(switches - 1, 0);
    }

    public static int numberOfConnection(int switches, int connections){
        if(switches == 0){
            return connections;
        }
        else{
            return numberOfConnection(switches - 1,connections += switches);
        }
    }
}
