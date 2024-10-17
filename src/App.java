import java.util.List;
import co.grandcircus.IceCream;

public class App {
    public static void main(String[] args) throws Exception {
        IceCream iceCream = new IceCream();

        iceCream.loadFamily();
        iceCream.loadFlavors();
        
        List<String> familyMembers = iceCream.getFamilyMembers();

        for (String aMemeber : familyMembers) {
            System.out.println("Welcome " + aMemeber + "!");
            iceCream.displayFlavors();
            iceCream.addVote();
            System.out.println("Thank you for your vote " + aMemeber + "!");
        }
    }
}
