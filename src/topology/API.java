package topology;

import topology.adapters.PolymorphDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class API {
    private final ArrayList<Topology> topologylist;

    public API(){
        topologylist = new ArrayList<>();
    }

    public boolean readJSON(String filename) {
        File file = new File(filename);
        try {
            Scanner scan = new Scanner(file);
            String fileContent ="";
            while(scan.hasNextLine()){
                fileContent = fileContent.concat(scan.nextLine()+"\n");
            }
            topologylist.add(deserialize(fileContent));
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }
    public void writeJSON(String id,String filename) throws IOException {
        Topology topology = findTopology(id);
        String topologySTR = serialize(topology);
        File file = new File(filename);
        file.createNewFile();
        FileWriter Writer = new FileWriter(filename);
        Writer.write(topologySTR);
        Writer.close();
    }
    public Topology findTopology(String id) {
        for (Topology topology:topologylist) {
            if(topology.getId().equals(id)){
                return topology;
            }
        }
        return null;
    }
    public void deleteTopology(String id){
        Topology topology = findTopology(id);
        topologylist.remove(topology);
    }
    public ArrayList<Component> queryDevices(String id){
        Topology topology = findTopology(id);
        if(topology == null){
            return null;
        }
        return topology.getComponents();
    }
    public ArrayList<Topology> queryTopologies(){
        return topologylist;
    }
    private static Topology deserialize(String fileContent) {
        Gson gson =new GsonBuilder().registerTypeAdapter(Component.class, new PolymorphDeserializer<Component>()).create();
        return gson.fromJson(fileContent, Topology.class);
    }
    private static String serialize(Topology topology){
        Gson gson = new Gson();
        return gson.toJson(topology);
    }
}