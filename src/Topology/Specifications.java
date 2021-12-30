package Topology;

import com.google.gson.annotations.SerializedName;

public class Specifications {
    @SerializedName(value="default")
    private float defaultValue;
    private float min;
    private float max;

    Specifications(float defaultValue,float min,float max){
        this.defaultValue=defaultValue;
        this.max=max;
        this.min=min;
    }
}
