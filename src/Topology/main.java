package Topology;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    ArrayList<Topology> topologyList;
    public static void main(String[] args) throws IOException {
        API api = new API();
        api.readJSON("topology.json");
        api.readJSON("topology1.json");
        api.readJSON("topology2.json");
        api.readJSON("topology3.json");
        api.writeJSON("top","top.json");
        api.writeJSON("top1","top1.json");
        api.writeJSON("top2","top2.json");
        api.writeJSON("top3","top3.json");
        ArrayList<Topology> topologies = api.queryTopologies();
        api.deleteTopology("top2");
        topologies = api.queryTopologies();
        ArrayList<Component> Devices = api.queryDevices("top3");
        api.deleteTopology("top3");
        api.deleteTopology("top");
        api.deleteTopology("top1");
    }
}
