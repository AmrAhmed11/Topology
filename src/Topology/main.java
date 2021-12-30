package Topology;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Topology.adapters.PolymorphDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class main {

    public static void main(String[] args) throws IOException {
        Topology topo =deserialize();
        serialize(topo);
        Specifications specs =new Specifications(1,2,3);
    }
    private static Topology deserialize() throws FileNotFoundException {
        File file = new File("topology.json");
        Scanner scan = new Scanner(file);
        String fileContent ="";
        while(scan.hasNextLine()){
            fileContent = fileContent.concat(scan.nextLine()+"\n");
        }
        Gson gson =new GsonBuilder().registerTypeAdapter(Component.class, new PolymorphDeserializer<Component>()).create();

        Topology topolo = gson.fromJson(fileContent, Topology.class);
        return topolo;
    }

    private static void serialize(Topology topo) throws IOException {

        Gson gson = new Gson();
        String topoloSTR = gson.toJson(topo);
        File file = new File("serialized.json");
        file.createNewFile();
        FileWriter Writer = new FileWriter("serialized.json");
        Writer.write(topoloSTR);
        Writer.close();

    }
}
