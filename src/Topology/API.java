package Topology;

import Topology.adapters.PolymorphDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class API {
    ArrayList<Topology> topologylist;

    API(){
        topologylist = new ArrayList();
    }

    public void readJSON(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        String fileContent ="";
        while(scan.hasNextLine()){
            fileContent = fileContent.concat(scan.nextLine()+"\n");
        }
        topologylist.add(deserialize(fileContent));

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
    private Topology findTopology(String id) {
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
        return topology.getComponents();
    }
    public ArrayList<Topology> queryTopologies(){
        return topologylist;
    }
    public static Topology deserialize(String fileContent) {
        Gson gson =new GsonBuilder().registerTypeAdapter(Component.class, new PolymorphDeserializer<Component>()).create();
        Topology result = gson.fromJson(fileContent, Topology.class);
        return result;
    }
    public static String serialize(Topology topology) throws IOException {
        Gson gson = new Gson();
        String topologySTR = gson.toJson(topology);
        return topologySTR;
    }
}
