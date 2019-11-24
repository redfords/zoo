package zoo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Control {    

    public void execute() {

        Zoo zoo = new Zoo();

        boolean follow = true;
        try {
            zoo = zoo.deSerializar("zoo.txt");
            InputOutput.displayString("Zoo Administration");
        } catch (Exception e) {
            zoo = loadData();
            try {
                zoo.serializar("zoo.txt");
                InputOutput.displayString("Data has been loaded, please restart.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            follow = false;
        }

        while (follow) {
            String user = InputOutput.readString("Username:");
            String password = InputOutput.readPassword("Password:");
            
            User u = zoo.findUser(user + ":" + password);

            if (u == null) {
                InputOutput.displayString("User/password incorrect.");
            } else {
                u.proceed(zoo);
                follow = InputOutput.readBoolean("Do you want to login with another username?");
            }
            
            try {
                zoo.serializar("zoo.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private Zoo loadData(){
        Zoo park;
        
        ArrayList<Species> species = new ArrayList<>();
        
        Habitat hymalaya = new Habitat("Himalayas", "Monsoon", "Forest", "Asia");
        Habitat polar = new Habitat("Polar", "Cold", "Tundra", "Arctic");
        Habitat tropical = new Habitat("Tropical", "Warm", "Jungle", "Oceania");
        Habitat farm = new Habitat("Farm", "Temperate ", "Woodland", "America");
        
        Species panda = new Species("Red Panda", "Ailurus fulgens", "Reddish-brown mammal");
        Species bear = new Species("Polar Bear", "Ursus maritimus", "Hypercarnivorous bear ");
        Species gecko = new Species("Gargoyle Gecko", "Rhacodactylus auriculatus", "Lizard");
        Species robin = new Species("American Robin", "Turdus migratorius", "Migratory songbird ");
        
        species.add(panda);
        species.add(bear);
        species.add(gecko);
        species.add(robin);
        
        panda.getHabitats().add(hymalaya);
        bear.getHabitats().add(polar);
        gecko.getHabitats().add(tropical);
        robin.getHabitats().add(farm);
        
        ArrayList<User> users = new ArrayList<>();
        
        users.add(new Admin("Anna", "537 Paper street, Bradford", "555-0153", LocalDate.of(2018,5,15), "admin", "1234"));
        users.add(new Keeper("Joe", "537 Paper street, Bradford", "555-0153", LocalDate.of(2018,6,12), "keeper", "1234"));
        users.add(new Guide("Peter", "537 Paper street, Bradford", "555-0153", LocalDate.of(2018,4,19), "guide", "1234"));
        
        ArrayList<Zone> zones = new ArrayList<>();
        
        Zone asia = new Zone("Asia", 30);
        Zone arctic = new Zone("Arctic", 20);
        Zone oceania = new Zone("Oceania", 100);
        Zone america = new Zone("America", 50);
        
        zones.add(asia);
        zones.add(arctic);
        zones.add(oceania);
        zones.add(america);
        
        asia.getSpecies().add(panda);
        arctic.getSpecies().add(bear);
        oceania.getSpecies().add(gecko);
        america.getSpecies().add(robin);
        
        park = new Zoo(species, users, zones);
        
        return park;
    }

}
