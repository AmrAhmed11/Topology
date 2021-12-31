package topology.adapters;

public @interface JsonSubtype {
    Class<?> clazz();

    String name();
}
