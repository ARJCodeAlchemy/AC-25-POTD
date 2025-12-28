//---------------------------------------------------------APPROACH 1 --------------------------------------------------------------------
/*
Time Complexity:
- enQueue, deQueue, Front, Rear, isEmpty, isFull → O(1)

Space Complexity:
- O(k), where k is the size of the circular queue array.

Short Explanation:
- The queue is implemented using a fixed-size array.
- Front and rear pointers move in a circular manner using modulo.
- enQueue inserts at rear, deQueue removes from front.
- Queue is empty when front == -1.
- Queue is full when next position of rear overlaps front.
*/

//--------------------------------------------------------- JAVA CODE --------------------------------------------------------------------
class MyCircularQueue {
    int[] queue;
    int k;
    int front; //front pointer to point at the first element of the queue
    int rear; //rear pointer to point at the last entered element of the queue

    public MyCircularQueue(int k) {
        queue = new int[k]; 
        this.k = k; //init the global variable k
        front = -1; //init front
        rear = -1; //init rear
    }
    
    public boolean enQueue(int value) {

        // cannot insert if queue is full
        if (isFull()) return false;

        // first insertion
        if (front == -1) {
            front = 0; //front get updated only in once case in insertion
        }

        // move rear circularly and insert
        rear = (rear + 1) % k;
        queue[rear] = value;

        return true;
    }
    
    public boolean deQueue() {

        // cannot remove if queue is empty
        if (isEmpty()) return false;

        // only one element was present
        if (front == rear) {
            front = -1; //reinit both pointers
            rear = -1;
        } 
        else {
            // move front circularly
            front = (front + 1) % k;
        }

        return true;
    }
    
    public int Front() {
        if (front == -1) return -1;
        return queue[front];
    }
    
    public int Rear() {
        if (rear == -1) return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        /*
        Queue is full in two cases:

        1) front is at index 0 and rear is at last index
           Example:
           [1, 2, 3, 4, 5]
            f           r

        2) rear is just behind front in circular manner
           Example:
           [3, 4, 5, 1, 2]
                r  f
        */
        if ((front == 0 && rear == k - 1) || front - 1 == rear)
            return true;
        return false;
    }
}


//--------------------------------------------------------- CPP CODE --------------------------------------------------------------------

class MyCircularQueue {
public:
    vector<int> queue;
    int k;
    int front;
    int rear;

    MyCircularQueue(int k) {
        queue.resize(k);
        this->k = k;
        front = -1;
        rear = -1;
    }

    bool enQueue(int value) {

        // queue is full
        if (isFull()) return false;

        // first element insertion
        if (front == -1) {
            front = 0;
        }

        // move rear circularly
        rear = (rear + 1) % k;
        queue[rear] = value;

        return true;
    }

    bool deQueue() {

        // queue is empty
        if (isEmpty()) return false;

        // only one element present
        if (front == rear) {
            front = -1;
            rear = -1;
        } 
        else {
            // move front circularly
            front = (front + 1) % k;
        }

        return true;
    }

    int Front() {
        if (front == -1) return -1;
        return queue[front];
    }

    int Rear() {
        if (rear == -1) return -1;
        return queue[rear];
    }

    bool isEmpty() {
        return front == -1;
    }

    bool isFull() {
        // same two full conditions as Java version
        if ((front == 0 && rear == k - 1) || front - 1 == rear)
            return true;
        return false;
    }
};


//--------------------------------------------------------- EXTRA INSIGHTS --------------------------------------------------------------------

🔹 Why Circular Queue?

A normal queue wastes space after dequeues.
Circular queue reuses freed space using modulo arithmetic.

//<><><><><><><><><><><><><><><><><><><><><><>><><><><><><><><><><><><><>

🔹 Core Formula to Remember
next_index = (current_index + 1) % k

This single formula is the heart of circular data structures.

//<><><><><><><><><><><><><><><><><><><><><><>><><><><><><><><><><><><><>
🔹 Interview Insight

Many candidates mess up:

full condition

empty condition

single-element removal
//<><><><><><><><><><><><><><><><><><><><><><>><><><><><><><><><><><><><>

🔹 Alternative Full Condition

A very common and cleaner full check is:

(rear + 1) % k == front

You might see this version in editorials.