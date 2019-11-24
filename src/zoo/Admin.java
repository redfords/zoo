package zoo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Admin extends User {
    
    public Admin(String name, String address, String phone,
            LocalDate entryDate, String user, String password) {
        super(name, address, phone, entryDate, user, password);
    }

    @Override
    public void proceed(Zoo zoo) {
        char option;
        
        InputOutput.displayString("Welcome admin " + name);
        
        do{
            do {
                option = InputOutput.readChar(
                        "1 - Create itinerary\n" +
                        "2 - Delete itinerary\n" +
                        "3 - Assign species\n" +
                        "4 - Unassign species\n" +
                        "5 - Exit\n"
                );
            }
            while(option > '5' || option < '1');

            switch(option) {
                case '1':
                    createItinerary(zoo);
                    break;
                case '2':
                    deleteItinerary(zoo);
                    break;
                case '3':
                    assignSpecies(zoo);
                    break;
                case '4':
                    unassignSpecies(zoo);
                    break;
            }
        }
        while(option != '5');
    }

    private void createItinerary(Zoo zoo) {
        int code = InputOutput.readInt("Enter the code");
        int duration = InputOutput.readInt("Enter the duration");
        int lenght = InputOutput.readInt("Enter the lenght");
        int maxVisitors = InputOutput.readInt("Enter the maximum number of visitors");
        
        String listGuides = zoo.displayGuides();
        listGuides += "\nEnter the guide number";
        
        Guide guide = null;
        User user = null;
        
        while(guide == null){
            int guideNumber = InputOutput.readInt(listGuides);
            
            if(guideNumber >= 0 && guideNumber < zoo.getUsers().size()){
                user = zoo.getUsers().get(guideNumber);
                if(user instanceof Guide) {
                    guide = (Guide) user;
                } 
            }
        }
        
        Itinerary itinerary = new Itinerary(code, duration, lenght, maxVisitors);
        
        String listZones = zoo.displayZones();
        listZones += "\nEnter the zone number";
        boolean otherZone = true;
        
        while(otherZone){
            Zone zone = null;
        
            while(zone == null){
                int zoneNumber = InputOutput.readInt(listZones);

                if(zoneNumber >= 0 && zoneNumber < zoo.getZones().size()){
                    zone = zoo.getZones().get(zoneNumber); 
                }
            }
            
            itinerary.getZones().add(zone);
            
            otherZone = InputOutput.readBoolean("Do you want to add another zone?");
        }
        
        LocalTime schedule = InputOutput.readHour("Enter the hour in the format hh:mm :");
               
        GuideItinerary guideItinerary =  new GuideItinerary(schedule, itinerary);
        guide.getGuideItinerary().add(guideItinerary);
    }    

    private void assignSpecies(Zoo zoo) {
        
        String listKeepers = zoo.displayKeeper();
        listKeepers += "\nEnter the keeper name";
        
        Keeper keeper = null;
        User user = null;
        
        while(keeper == null){
            int keeperNumber = InputOutput.readInt(listKeepers);
            
            if(keeperNumber >= 0 && keeperNumber < zoo.getUsers().size()){
                user = zoo.getUsers().get(keeperNumber);
                
                if(user instanceof Keeper) {
                    keeper = (Keeper) user;
                } 
            }
        }
        
        String listSpecies = zoo.displaySpecies();
        listSpecies += "\nEnter the species name";
        
        Species species = null;
        
        while(species == null){
            int speciesNumber = InputOutput.readInt(listSpecies);
            
            if(speciesNumber >= 0 && speciesNumber < zoo.getSpecies().size()){
                species = zoo.getSpecies().get(speciesNumber);
            }
        }
       
        LocalDate date = InputOutput.readDate("Enter the date in the format aaaa-mm-dd");
               
        KeeperSpecies keeperSpecies =  new KeeperSpecies(date, species);
        keeper.getKeeperSpecies().add(keeperSpecies);
    }

    private void deleteItinerary(Zoo zoo) {
        String listGuides = zoo.displayGuides();
        listGuides += "\nEnter the guide name:";
        
        Guide guide = null;
        User user = null;
        
        while(guide == null){
            int guideNumber = InputOutput.readInt(listGuides);
            
            if(guideNumber >= 0 && guideNumber < zoo.getUsers().size()){
                user = zoo.getUsers().get(guideNumber);
                if(user instanceof Guide) {
                    guide = (Guide) user;
                } 
            }
        }
        
        String listItinerary = guide.listItinerary();
        listItinerary += "\nEnter the itinerary to delete";
        
        int itineraryNumber = -1;
        
        while(!(itineraryNumber >= 0 && itineraryNumber < guide.getGuideItinerary().size())){
            itineraryNumber = InputOutput.readInt(listItinerary); 
        }
        guide.getGuideItinerary().remove(itineraryNumber);
    }

    private void unassignSpecies(Zoo zoo) {
        
        String listKeepers = zoo.displayKeeper();
        listKeepers += "\nEnter the keeper number to see the species:";
        
        Keeper keeper = null;
        User user = null;
        
        while(keeper == null){
            int keeperNumber = InputOutput.readInt(listKeepers);
            
            if(keeperNumber >= 0 && keeperNumber < zoo.getUsers().size()){
                user = zoo.getUsers().get(keeperNumber);
                if(user instanceof Keeper){
                    keeper = (Keeper) user;
                }
            }
        }
       
        String listSpecies = keeper.listSpecies();
        listSpecies += "\nEnter the species to unassign";
        
        int speciesNumber = -1;
        
        while(!(speciesNumber >= 0 && speciesNumber < keeper.getKeeperSpecies().size())){
            speciesNumber = InputOutput.readInt(listSpecies);
        }
        keeper.getKeeperSpecies().remove(speciesNumber);
    }

    private void exitProgram(Zoo zoo) { 
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
