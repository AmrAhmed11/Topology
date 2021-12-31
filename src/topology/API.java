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

/***
 *API
 */
public class API {
    private final ArrayList<Topology> topologylist;

    /***
     *  class constructor to initialize the topologies arraylist
     */
    public API(){
        topologylist = new ArrayList<>();
    }

    /***
     * reads json file into memory
     * @param filename name of the JSON file to read from
     * @return True if the file exists, Otherwise false
     */
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

    /***
     *writes JSON file from memory to JSON file
     * @param id topology id
     * @param filename the output file name
     * @throws IOException if the file cannot be created
     */
    public void writeJSON(String id,String filename) throws IOException {
        Topology topology = findTopology(id);
        String topologySTR = serialize(topology);
        File file = new File(filename);
        file.createNewFile();
        FileWriter Writer = new FileWriter(filename);
        Writer.write(topologySTR);
        Writer.close();
    }

    /***
     *search for specific topology
     * @param id topology id
     * @return the topology if it exists, Otherwise null
     */
    public Topology findTopology(String id) {
        for (Topology topology:topologylist) {
            if(topology.getId().equals(id)){
                return topology;
            }
        }
        return null;
    }

    /***
     *delete specific topology
     * @param id topology id
     */
    public void deleteTopology(String id){
        Topology topology = findTopology(id);
        topologylist.remove(topology);
    }

    /***
     *lists the devices in a topology
     * @param id the topology id
     * @return arraylist of components
     */
    public ArrayList<Component> queryDevices(String id){
        Topology topology = findTopology(id);
        if(topology == null){
            return null;
        }
        return topology.getComponents();
    }

    /***
     *lists the topologies in the memory
     * @return arraylist of topologies
     */
    public ArrayList<Topology> queryTopologies(){
        return topologylist;
    }

    /***
     *creates topology from a JSON string
     * @param fileContent the string to JSONIFY
     * @return topology object
     */
    private static Topology deserialize(String fileContent) {
        Gson gson =new GsonBuilder().registerTypeAdapter(Component.class, new PolymorphDeserializer<Component>()).create();
        return gson.fromJson(fileContent, Topology.class);
    }

    /***
     *create JSON string from topology
     * @param topology the object to stringify
     * @return string
     */
    private static String serialize(Topology topology){
        Gson gson = new Gson();
        return gson.toJson(topology);
    }
}
