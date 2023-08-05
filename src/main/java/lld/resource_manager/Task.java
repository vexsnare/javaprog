package lld.resource_manager;

import java.util.UUID;

public class Task {
    String taskId;
    long taskStartTime;

    long taskEndTime;

    public Task() {
        this.taskId = UUID.randomUUID().toString();
    }

    public Task setStartTime(long time) {
        this.taskStartTime = time;
        return this;
    }

    public Task setEndTime(long time) {
        this.taskEndTime = time;
        return this;
    }
}
