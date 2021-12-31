package topology;

import com.google.gson.annotations.SerializedName;


public class Resistor extends Component {
    @SerializedName(value = "netlist")
    private ResistorNetlist net;
    @SerializedName(value="resistance")
    private final Specifications specs;

    Resistor(String type, String id, Specifications spec, String t1, String t2){
        super(type,id);
        this.specs = spec;
    }
}
