package lld.resource_manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager implements ITaskManager {
    // taskID, resourceID
    Map<String, String> taskResourceMap;
    // TaskId, Task
    Map<String, Task> taskMap;

    ResourceAllocator resourceAllocator;

    Object lock;

    public TaskManager(ResourceAllocator resourceAllocator) {
        this.resourceAllocator = resourceAllocator;
        this.taskMap = new HashMap<>();
        this.taskResourceMap = new HashMap<>();
    }

    public void executeTask(Task task, ResourceType resourceType, int cpus) throws InterruptedException {
        List<Resource> resources = resourceAllocator.getAvailable(resourceType, cpus);
        Resource resource = resources.get(0);

        this.taskMap.put(task.taskId, task);
        this.runTask(task, resource);
    }
    public void runTask(Task task, Resource resource) throws InterruptedException {
        this.startTask(task, resource);
        // Running task
        Thread.sleep(5000);
        this.endTask(task, resource);
    }

    public List<Task> getRunningTasks() {
        List<Task> running = new ArrayList<>();
        for(String taskId: taskResourceMap.keySet()) {
            running.add(taskMap.get(taskId));
        }
        return running;
    }

    public List<Task> getAllTasks() {
        List<Task> running = new ArrayList<>();
        for(String taskId: taskMap.keySet()) {
            running.add(taskMap.get(taskId));
        }
        return running;
    }

    public void endTask(Task task, Resource resource) {
        resourceAllocator.removeOccupied(resource.resourceId);
        this.taskResourceMap.remove(task.taskId, resource.resourceId);
        taskMap.get(task.taskId).taskEndTime = System.currentTimeMillis();
    }

    public void startTask(Task task, Resource resource) {
        resourceAllocator.markOccupied(resource.resourceId);
        this.taskResourceMap.put(task.taskId, resource.resourceId);
        taskMap.get(task.taskId).taskStartTime = System.currentTimeMillis();
    }
}
