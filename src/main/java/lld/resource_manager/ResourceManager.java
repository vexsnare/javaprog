package lld.resource_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResourceManager implements IResourceManager {

    DataCenter dataCenter;
    ResourceAllocator resourceAllocator;
    public ResourceManager(DataCenter dataCenter, ResourceAllocator resourceAllocator) {
        this.dataCenter = dataCenter;
        this.resourceAllocator = resourceAllocator;
    }
    @Override
    public void addResource(Resource resource) {
        Map<ResourceType, List<Resource>> resourceMap = this.dataCenter.getResourceMap();
        if(resourceMap.containsKey(resource.resourceType)) {
            resourceMap.get(resource.resourceType).add(resource);
        } else {
            List<Resource> resources = new ArrayList<>();
            resources.add(resource);
            resourceMap.put(resource.resourceType, resources);
        }

        System.out.printf("Resource %s Added ", resource.resourceId);
        System.out.println();
    }

    @Override
    public void deleteResource(Resource resource) {
        List<Resource> resourceList = this.dataCenter.getResourceMap().get(resource.resourceType);
        resourceList.remove(resource);
    }

    @Override
    public List<Resource> getAvailableResources(ResourceType resourceType) {
        // pull all resources for give resourceType
       return resourceAllocator.getAvailable(resourceType, 0);
    }

    @Override
    public List<Resource> getAvailableResources(ResourceType resourceType, ResourceConfig resourceConfig) {
        return resourceAllocator.getAvailable(resourceType, resourceConfig.cpus);
    }
}
