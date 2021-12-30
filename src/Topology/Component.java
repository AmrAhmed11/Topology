package Topology;
import Topology.adapters.JsonSubtype;
import Topology.adapters.JsonType;

@JsonType(
        property = "type",
        subtypes = {
                @JsonSubtype(clazz = resistor.class, name = "resistor"),
                @JsonSubtype(clazz = transistor.class, name = "nmos"),
        }
)

public abstract class Component {
    private final String type;
    private final String id;

    public Component(String type,String id,Specifications spec){
        this.type = type;
        this.id = id;
    }
    public String getType(){
        return type;
    }
    public String getId(){return id;}
}
