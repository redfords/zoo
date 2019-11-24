package zoo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Keeper extends User implements Serializable {
    
    private ArrayList<KeeperSpecies> keeperSpecies;
            
    public Keeper(String name, String address, String phone,
            LocalDate entryDate, String user, String password) {
        super(name, address, phone, entryDate, user, password);
     
        keeperSpecies = new ArrayList<>();
    }
    
    @Override
    public void proceed(Zoo zoo) {
        InputOutput.displayString("Welcome keeper " + this.name);
        char option;
        
        do{
            do {
             option = InputOutput.readChar(
                    "1 - View my personal data\n" +
                    "2 - View my species\n" +
                    "3 - Exit" +
                    "Enter the option"
            );
            }
            while(option > '3' || option < '1');

            switch(option){
                case '1':
                    InputOutput.readString("Name: " + name + "\n" +
                    "Address: " + address + "\n" +
                    "Phone: " + phone + "\n" + 
                    "Entry Date: " + entryDate + "\n");
                    break;

                case '2':
                    String listSpecies = listSpecies();
                    listSpecies += "\nEnter the species number";

                    KeeperSpecies ks = null;

                    while(ks == null){
                        int speciesNumber = InputOutput.readInt(listSpecies);

                        if(speciesNumber >= 0 && speciesNumber < keeperSpecies.size()){
                            ks = keeperSpecies.get(speciesNumber);
                        }
                    }

                    InputOutput.readString(ks.detail());
                    break;
            }
        }
        while(option != 3);
    }
    
    public ArrayList<KeeperSpecies> getKeeperSpecies() {
        return keeperSpecies;
    }

    public void setKeeperSpecies(ArrayList<KeeperSpecies> keeperSpecies) {
        this.keeperSpecies = keeperSpecies;
    }

    public String listSpecies() {
        
        String list = "";
        for(int i = 0; i < keeperSpecies.size(); i++) {
            KeeperSpecies ks = this.keeperSpecies.get(i);
            
            list += " " + i + " - " + ks.getSpecies().getScientificName() + "\n";
        }
        
        return list;
    }
    
}
