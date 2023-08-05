package lld.resource_manager;

public interface ITaskManager {
    public void executeTask(Task task, ResourceType resourceType, int cpus) throws InterruptedException;
}
