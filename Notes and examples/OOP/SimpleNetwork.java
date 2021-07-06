
package OOP;

// Create a class SimpleNetwork to simulate ping command. The class consists of the
// name, IP address, subnet mask and status (on/off) of a host. The host can only ping
// each other if the hosts are from the same network. The host is from same network if
// the (host IP address AND host Subnet Mask) is equal to (destination IP address AND
// host Subnet Mask). Create a Tester class to test the program, given output below.

public class SimpleNetwork {
    private String name;
    private String IP;
    private String subnetMask;
    private String status;

    public SimpleNetwork(String name, String IP, String subnetMask, String status) {
        this.name = name;
        this.IP = IP;
        this.subnetMask = subnetMask;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getIP() {
        return IP;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public String getStatus() {
        return status;
    }
    
    public static boolean pingValid(SimpleNetwork a, SimpleNetwork b){
        if(b.getStatus().equals("DOWN")){
            System.out.println(a.getName()+" cannot ping "+b.getName()+" because the destination "+b.getName()+" is down.");
            return false;
        }
        
        if(!a.getIP().equals(b.getIP()) || !a.getSubnetMask().equals(b.getSubnetMask())){
            System.out.println(a.getName()+" cannot ping "+b.getName()+" because the destination "+b.getName()+" is located in different network.");
            return false;
        }
        
        System.out.println(a.getName()+" can ping "+b.getName());
        return true;
    }
    
    public void display(){
        System.out.println("Host name: "+name+" IP: "+IP+" Subnet Mask: "+subnetMask+" Status: "+status);
    }
}

class testSimpleNetwork{
    public static void main(String[] args) {
        /*
        SimpleNetwork s1 = new SimpleNetwork("Host 1","10.1.1.1","255.255.255.224","UP");
        SimpleNetwork s2 = new SimpleNetwork("Host 2","10.1.1.2","255.255.255.224","DOWN");
        SimpleNetwork s3 = new SimpleNetwork("Host 3","10.1.1.70","255.255.255.224","UP");
        SimpleNetwork s4 = new SimpleNetwork("Host 4","10.1.1.1","255.255.255.224","UP");
        s1.display();
        s2.display();
        s3.display();
        s4.display();
        SimpleNetwork.pingValid(s1, s2);
        SimpleNetwork.pingValid(s1, s3);
        SimpleNetwork.pingValid(s1, s4);
        */
        SimpleNetwork[] hostList = {new SimpleNetwork("Host 1", "10.1.1.1", "255.255.255.224", "UP"),
            new SimpleNetwork("Host 2", "10.1.1.2", "255.255.255.224", "DOWN"), new SimpleNetwork("Host 3", "10.1.1.70", "255.255.255.224", "UP"),
             new SimpleNetwork("Host 4", "10.1.1.1", "255.255.255.224", "UP")};
        for (int i = 0; i < hostList.length; i++) {
            hostList[i].display();
        }

        for (int i = 1; i < hostList.length; i++) {
            SimpleNetwork.pingValid(hostList[0], hostList[i]);
        }
    }
}