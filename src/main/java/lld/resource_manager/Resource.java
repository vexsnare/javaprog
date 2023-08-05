package lld.resource_manager;

import java.util.UUID;

enum ResourceType {
    SERVER_INSTANCE,
    DB_INSTANCE,
    ELB_INSTANCE
}
public class Resource {
    ResourceType resourceType;
    String resourceId;

    ResourceConfig resourceConfig;

    public ResourceConfig getResourceConfig() {
        return resourceConfig;
    }

    public Resource(ResourceType resourceType, ResourceConfig resourceConfig) {
        this.resourceType = resourceType;
        this.resourceConfig = resourceConfig;
        this.resourceId = UUID.randomUUID().toString();
    }

    public String getResourceId() {
        return this.resourceId;
    }

}
