package Topology;

import com.google.gson.annotations.SerializedName;

public class transistor extends Component {
    @SerializedName(value = "netlist")
    TransistorNetlist net;
    @SerializedName(value="m(l)")
    private Specifications specs;
    transistor(String type, String id, Specifications spec, String drain, String gate, String source){
        super(type,id,spec);
    }
}
