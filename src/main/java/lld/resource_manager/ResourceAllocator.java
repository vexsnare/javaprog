package lld.resource_manager;

import javax.xml.crypto.Data;
import java.util.*;

public class ResourceAllocator {

    DataCenter dataCenter;

    Set<String> occupiedResourceIds;
    public ResourceAllocator(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
        this.occupiedResourceIds = new HashSet<>();
    }

    public List<Resource> getAvailable(ResourceType resourceType, int cpus) {
        List<Resource> resourceList = dataCenter.ResourcesByType(resourceType);
        List<Resource> filteredResources = new ArrayList<>();
        for(Resource resource: resourceList) {
            if(resource.getResourceConfig().cpus >= cpus) {
                filteredResources.add(resource);
            }
        }
        filteredResources.sort(Comparator.comparingDouble(x -> x.getResourceConfig().price));
        return filteredResources;
    }

    public synchronized void markOccupied(String resourceId) {
        this.occupiedResourceIds.add(resourceId);
    }
}
