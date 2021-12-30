package Topology;

import java.util.List;

public class Topology {
    private String id;
    private List<Component> components;

    Topology(String id, List<Component> comps) {
        this.id=id;
        components = comps;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setComponents(List<Component> comps){
        components=comps;
    }
    public List<Component> getComponents(){
        return components;
    }
    public void addComponent(Component comp){
        components.add(comp);
    }
}
