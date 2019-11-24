package zoo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Guide extends User implements Serializable {
    
    private ArrayList<GuideItinerary> guideItinerary;
    
    public Guide(String name, String address, String phone,
            LocalDate entryDate, String user, String password) {
        super(name, address, phone, entryDate, user, password);
        
        this.guideItinerary = new ArrayList<>();
    }    
    
    public void proceder(Zoo zoo) {
        char option;
        
        InputOutput.displayString("Welcome guide " + this.name);
        
        do{
            do {
                option = InputOutput.readChar(
                        "1 - View my personal data\n" +
                        "2 - View my itineraries\n" +
                        "3 - Exit" +
                        "Enter the option"
                );
            }
            while(option > '3' || option < '1');

            switch(option){
                case '1':
                    InputOutput.displayString("Name: " + name + "\n" +
                    "Address: " + address + "\n" +
                    "Phone: " + phone + "\n" + 
                    "Entry Date: " + entryDate + "\n");
                    break;

                case '2':
                    String listItinerary = listItinerary();
                    listItinerary += "\nEnter the itinerary number";

                    GuideItinerary gi = null;

                    while(gi == null){
                        int itineraryNumber = InputOutput.readInt(listItinerary);

                        if(itineraryNumber >= 0 && itineraryNumber < guideItinerary.size()){
                            gi = guideItinerary.get(itineraryNumber);
                        }
                    }

                    InputOutput.displayString(gi.detail());
                    break;
            }
        }
        while(option != 3);
    }

    public ArrayList<GuideItinerary> getGuideItinerary() {
        return guideItinerary;
    }

    public void setGuideItinerary(ArrayList<GuideItinerary> guideItinerary) {
        this.guideItinerary = guideItinerary;
    }

    public String listItinerary() {
        String list = "";
        for(int i = 0; i < this.guideItinerary.size(); i++) {
            GuideItinerary gi = this.guideItinerary.get(i);
            
            list += " " + i + " - " + gi.getItinerary().getCode() + " " + gi.getSchedule() + "\n";
        }
        
        return list;
    }

    @Override
    public void proceed(Zoo zoo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
