package Topology;
import Topology.adapters.JsonSubtype;
import Topology.adapters.JsonType;

@JsonType(
        property = "type",
        subtypes = {
                @JsonSubtype(clazz = Resistor.class, name = "resistor"),
                @JsonSubtype(clazz = Transistor.class, name = "nmos"),
        }
)
public abstract class Component {
    private final String type;
    private final String id;

    public Component(String type,String id){
        this.type = type;
        this.id = id;
    }
    public String getType(){
        return type;
    }
    public String getId(){return id;}
}
