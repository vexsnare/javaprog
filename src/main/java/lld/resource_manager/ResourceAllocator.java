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

    // url cpu>5 && ram < 3gb
    public List<Resource> getAvailable(ResourceType resourceType, int cpus) {
        List<Resource> resourceList = dataCenter.ResourcesByType(resourceType);
        List<Resource> filteredResources = new ArrayList<>();
        for(Resource resource: resourceList) {
            if(!occupiedResourceIds.contains(resource.resourceId) & resource.getResourceConfig().cpus >= cpus) {
                    filteredResources.add(resource);
            }
        }
        filteredResources.sort(Comparator.comparingDouble(x -> x.getResourceConfig().price));
        return filteredResources;
    }

    // findSuitableResource(List<> avResource, var ...  filters)

    public synchronized void markOccupied(String resourceId) {
        if(occupiedResourceIds.contains(resourceId)) {
            //getAvailable
            //resourceId = resourceId
        }
        this.occupiedResourceIds.add(resourceId);
    }
    public synchronized void removeOccupied(String resourceId) {
        this.occupiedResourceIds.remove(resourceId);
    }
}
