package topology;

import com.google.gson.annotations.SerializedName;

public class Transistor extends Component {
    @SerializedName(value = "netlist")
    TransistorNetlist net;
    @SerializedName(value="m(l)")
    private final Specifications specs;
    Transistor(String type, String id, Specifications spec, String drain, String gate, String source){
        super(type,id);
        this.specs = spec;
    }
}
