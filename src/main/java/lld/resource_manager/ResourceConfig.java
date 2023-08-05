package lld.resource_manager;

public class ResourceConfig {
    int cpus;
    int ram;
    double price;
    int capacity;

    public ResourceConfig(int cpus, double price) {
        this.cpus = cpus;
        this.price = price;
    }
    // using Builder we can add more config
    public ResourceConfig setRam(int ram) {
        this.ram = ram;
        return this;
    }
    public ResourceConfig setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public double getPrice() {
        return this.price;
    }
}


