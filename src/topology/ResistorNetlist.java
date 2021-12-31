package topology;

public class ResistorNetlist extends Netlist {
    String t1;
    String t2;

    @Override
    public String getType() {
        return "Resistor";
    }

    @Override
    public boolean checkNetlist(String nodeId) {
        return nodeId.equals(t1) || nodeId.equals(t2);
    }
}
