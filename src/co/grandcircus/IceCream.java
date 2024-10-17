package co.grandcircus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IceCream {
    private Set<String> flavors= new HashSet<String>();
    private Map<String,Integer>votes = new HashMap<String,Integer>();
    private List<String> familyMembers = new ArrayList<String>();

    public Set<String> getFlavors() {
        return flavors;
    }
    public Map<String, Integer> getVotes() {
        return votes;
    }
    public List<String> getFamilyMembers() {
        return familyMembers;
    }
    public void loadFlavors(){
        flavors.add("chocolate");
        flavors.add("vanilla");
        flavors.add("strawberry");
        flavors.add("orange");
    }

    public void loadFamily(){
        familyMembers.add("John");
        familyMembers.add("Emily");
        familyMembers.add("Steve");
        familyMembers.add("Jill");
    }

    public void displayFlavors(){
        System.out.println("Lets vote favorite ice cream flavors. Here are your options:");
        for (String aFlavor : flavors) {
            System.out.println(aFlavor);
        }
    }

    private String validateFlavor(){
        System.out.println("\nProvide your favorite flavor:");
        boolean validflavor = false;
        String userFlavor = "";
        Scanner scanner = new Scanner(System.in);
        do {
            userFlavor = scanner.nextLine().toLowerCase();
            for (String aFlavor : flavors) {
                if(aFlavor == userFlavor){
                    validflavor = true;                   
                }              
            }
        }while(!validflavor);
        scanner.close();
        return userFlavor;
    }

public void addVote(){
    String userFlavor = validateFlavor();
    Set<String> flavorKeys = votes.keySet();
    boolean hasVotes = false;
    for (String aKey : flavorKeys) {
        if (aKey == userFlavor) {
            votes.put(aKey, votes.get(aKey + 1));
            hasVotes = true;
        }
    }
    if(!hasVotes){
        votes.put(userFlavor, 1);
    }
}

public void displayFinalVotes(){
    Set<String> keys = votes.keySet();
    String firstPlace = "chocolate";
    String secondPlace = "chocolate";
    for (String aKey : keys) {
        if (votes.get(aKey) > (votes.get(firstPlace))){
            firstPlace = aKey;
        }
        if ((votes.get(aKey) < votes.get(firstPlace)) && (votes.get(aKey) > votes.get(secondPlace))){
            secondPlace = aKey;
        }
    }
    System.out.println("The flavors with the most votes are:");
    System.out.println(firstPlace);
    System.out.println(secondPlace);
}


}
