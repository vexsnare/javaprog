package lld.resource_manager;

import java.util.List;

public interface IResourceManager {
    public void addResource(Resource resource);
    public void deleteResource(Resource resource);
    public List<Resource> getAvailableResources(ResourceType resourceType);
    public List<Resource> getAvailableResources(ResourceType resourceType, ResourceConfig resourceConfig);
}
