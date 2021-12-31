package Topology;

import java.util.ArrayList;

public class Topology {
    private String id;
    private ArrayList<Component> components;

    Topology(String id, ArrayList<Component> comps) {
        this.id=id;
        components = comps;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setComponents(ArrayList<Component> comps){
        components=comps;
    }
    public ArrayList<Component> getComponents(){
        return components;
    }
    public void addComponent(Component comp){
        components.add(comp);
    }
}
