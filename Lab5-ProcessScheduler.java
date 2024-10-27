public class ProcessScheduler {
	QueueI<Process> processQueue;
	Process currentProcess; // Current process variable
	
	// Constructor to initialize processQueue
    public ProcessScheduler() {
        processQueue = new LLQueue<>();
    }
	
	public Process getCurrentProcess() {
		return currentProcess;
	}
	
	public void addProcess(Process aProcess) {
		if (currentProcess == null) {
            currentProcess = aProcess;
        } 
		else {
            processQueue.enqueue(aProcess);
        }
	}
	
	public void runNextProcess() {
		// Dequeue a process and set it as the current process
        currentProcess = processQueue.dequeue();
	}
	
	public void cancelCurrentProcess() {
		// Check if there is a current process
	    if (currentProcess != null) {
	        // Remove the current process
	       // currentProcess = null;
	        // Check if there are more processes in the queue
	        if (processQueue.size() > 0) {
	            // Set the next process in the queue as the current process
	            currentProcess = processQueue.dequeue();
	        }
	    }
	}
	
	public void printProcessQueue() {
		 if (processQueue.size() > 0) {
		        processQueue.print();
		}
	}
}
