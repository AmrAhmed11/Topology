package topology;

public class TransistorNetlist extends Netlist {
    String drain;
    String gate;
    String source;

    @Override
    public String getType() {
        return "Transistor";
    }

    @Override
    public boolean checkNetlist(String nodeId) {
        return nodeId.equals(drain) || nodeId.equals(gate) || nodeId.equals(source);
    }
}
