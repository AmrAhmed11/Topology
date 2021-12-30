package Topology;

import Topology.adapters.PolymorphDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class API {
    ArrayList<Topology> topologylist;
    private void readJSON(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        String fileContent ="";
        while(scan.hasNextLine()){
            fileContent = fileContent.concat(scan.nextLine()+"\n");
        }
        topologylist.add(deserialize(fileContent));

    }
    public void writeJSON(String id) throws IOException {
        Topology topology = findTopology(id);
        String topologySTR = serialize(topology);
        File file = new File("serialized.json");
        file.createNewFile();
        FileWriter Writer = new FileWriter("serialized.json");
        Writer.write(topologySTR);
        Writer.close();
    }

    private Topology findTopology(String id) {
        for (Topology topology:topologylist) {
            if(topology.getId() == id){
                return topology;
            }
        }
        return null;
    }
    public ArrayList<Topology> queryTopologies(){
        return topologylist;
    }
    private static Topology deserialize(String fileContent) {
        Gson gson =new GsonBuilder().registerTypeAdapter(Component.class, new PolymorphDeserializer<Component>()).create();
        Topology result = gson.fromJson(fileContent, Topology.class);
        return result;
    }
    private static String serialize(Topology topology) throws IOException {
        Gson gson = new Gson();
        String topologySTR = gson.toJson(topology);
        return topologySTR;
    }
}
