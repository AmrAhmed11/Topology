package Topology;

import com.google.gson.annotations.SerializedName;


public class resistor extends Component {
    @SerializedName(value = "netlist")
    ResistorNetlist net;
    @SerializedName(value="resistance")
    private Specifications specs;

    resistor(String type, String id, Specifications spec, String t1, String t2){
        super(type,id,spec);
    }

}
