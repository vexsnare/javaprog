package multithreading;

public class ReadWriteLock {
    boolean isWriting = false;
    int readers = 0;
    int maxAllowedReaders;
    ReadWriteLock(int maxReaders) {
        this.maxAllowedReaders = maxReaders;
    }
    public synchronized void acquireReadLock() throws InterruptedException {
        while (readers == maxAllowedReaders || isWriting) {
            wait();
        }
        readers++;
        notify();
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        while (readers != 0 && isWriting) {
            wait();
        }
        isWriting = true;
    }

    public synchronized void releaseReadLock() throws InterruptedException {
        while (readers == 0) {
            wait();
        }
        readers--;
        notify();
    }

    public synchronized void releaseWriteLock() throws InterruptedException {
        isWriting = false;
        notifyAll();
    }
}
