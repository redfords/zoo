package zoo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Zoo implements Serializable {

    private ArrayList<Species> species;
    private ArrayList<User> users;
    private ArrayList<Zone> zones;
    
    public Zoo(){
        this.species = new ArrayList<>();
        this.users = new ArrayList<>();
        this.zones = new ArrayList<>();
    }
    
    public Zoo(ArrayList<Species> species, ArrayList<User> users,
            ArrayList<Zone> zoneas){
        this.species = species;
        this.users = users;
        this.zones = zones;
    }
    
    public User findUser(String data) {
        int i = 0;
        boolean found = false;
        User u = null;

        while (i < users.size() && !found) {
            u = users.get(i);
            if (data.equals(u.getUser() + ":" + u.getPassword())) {
                found = true;
            } else {
                i++;
            }
        }
        
        if (found) {
            return u;
        } else {
            return null;
        }
    }
    
    public Zoo deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        Zoo z = (Zoo) o.readObject();
        o.close();
        f.close();
        return z;
    }
    
    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    public ArrayList<Species> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<Species> species) {
        this.species = species;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Zone> getZones() {
        return zones;
    }

    public void setZones(ArrayList<Zone> zones) {
        this.zones = zones;
    }

    String displayGuides() {
        String list = "";
        for(int i = 0; i < this.users.size(); i++) {
            User u = this.users.get(i);
            if(u instanceof Guide){
                list += " " + i + " - " + u.getName() + " " + u.getEntryDate() + "\n";
            }
        }
        
        return list;
    }

    String displayZones() {
        String list = "";
        for(int i = 0; i < this.zones.size(); i++) {
            Zone z = this.zones.get(i);
            list += " " + i + " - " + z.getName() + "\n";
        }
        
        return list;
    }
    
    String displaySpecies() {
        String list = "";
        for(int i = 0; i < this.species.size(); i++) {
            Species e = this.species.get(i);
            list += " " + i + " - " + e.getScientificName()+ "\n";
        }
        
        return list;
    }

    String displayKeeper() {
        String list = "";
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if(u instanceof Keeper){
                list += " " + i + " - " + u.getName() + " " + u.getEntryDate() + "\n";
            }            
        }
        
        return list;
    }

}
