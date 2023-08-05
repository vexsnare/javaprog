package lld.resource_manager;

import java.util.List;

public class Driver {
    public static void main(String[] args) throws InterruptedException {

        GeoLocation geoLocation = GeoLocation.LONDON;
        DataCenter dataCenter = new DataCenter(geoLocation);

        ResourceAllocator resourceAllocator = new ResourceAllocator(dataCenter);
        ResourceManager resourceManager = new ResourceManager(dataCenter, resourceAllocator);

        ResourceConfig resourceConfig = new ResourceConfig(4, 1000.0);
        Resource resource = new Resource(ResourceType.SERVER_INSTANCE, resourceConfig);

        ResourceConfig resourceConfig2 = new ResourceConfig(10, 1332.8);
        Resource resource2 = new Resource(ResourceType.SERVER_INSTANCE, resourceConfig2);

        ResourceConfig resourceConfig3 = new ResourceConfig(12, 90283.23);
        Resource resource3 = new Resource(ResourceType.SERVER_INSTANCE, resourceConfig3);

        resourceManager.addResource(resource);
        resourceManager.addResource(resource2);
        resourceManager.addResource(resource3);

        List<Resource> allAvailableResources = resourceManager.getAvailableResources(ResourceType.SERVER_INSTANCE);
        int count = 0;
        for (Resource avresource: allAvailableResources) {
            System.out.println("Resource " + (++count) );
            System.out.println("Resource ID: " + avresource.resourceId);
            System.out.println( "CPUS : " + avresource.getResourceConfig().cpus);
        }

        Task task = new Task();
        TaskManager taskManager = new TaskManager(resourceAllocator);
        taskManager.executeTask(task, ResourceType.SERVER_INSTANCE, 4);
        taskManager.executeTask(task, ResourceType.SERVER_INSTANCE, 12);

        List<Task> runningTask = taskManager.getRunningTasks();
        int i = 0;
        for (Task rTask: runningTask) {
            System.out.println("Task " + (++i) );
            System.out.println("Task ID: " + rTask.taskId);
            System.out.println( "TaskStartTime : " + rTask.taskStartTime);
            System.out.println( "TaskEndTime : " + rTask.taskEndTime);
        }

    }

}
