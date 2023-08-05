package lld.resource_manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum GeoLocation {
    MUMBAI,
    HYD,
    AUSTIN,
    PHX,
    LONDON
}
public class DataCenter {
    GeoLocation geoLocation;
    Map<ResourceType, List<Resource>> resourceMap;

    public DataCenter(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
        this.resourceMap = new HashMap<>();
    }

    public List<Resource> ResourcesByType(ResourceType resourceType) {
        return resourceMap.get(resourceType);
    }

    public Map<ResourceType, List<Resource>> getResourceMap() {
        return this.resourceMap;
    }
}
