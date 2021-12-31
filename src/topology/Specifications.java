package topology;

import com.google.gson.annotations.SerializedName;

public class Specifications {
    @SerializedName(value="default")
    private final float defaultValue;
    private final float min;
    private final float max;

    Specifications(float defaultValue,float min,float max){
        this.defaultValue=defaultValue;
        this.max=max;
        this.min=min;
    }
}
