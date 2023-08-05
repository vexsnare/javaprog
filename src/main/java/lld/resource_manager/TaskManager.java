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

    public synchronized void executeTask(Task task, ResourceType resourceType, int cpus) throws InterruptedException {
        List<Resource> resources = resourceAllocator.getAvailable(resourceType, cpus);
        Resource resource = resources.get(0);
        resourceAllocator.markOccupied(resource.resourceId);
        this.taskMap.put(task.taskId, task);
        this.runTask(task.taskId);
        this.taskResourceMap.put(task.taskId, resource.resourceId);
    }
    public void runTask(String taskId) throws InterruptedException {
        this.startTask(taskId);
        Thread.sleep(5000);
        this.endTask(taskId);
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

    public void endTask(String taskId) {
        taskMap.get(taskId).taskEndTime = System.currentTimeMillis();
    }

    public void startTask(String taskId) {
        taskMap.get(taskId).taskStartTime = System.currentTimeMillis();
    }
}
