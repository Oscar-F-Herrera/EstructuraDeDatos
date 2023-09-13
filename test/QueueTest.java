import edu.oscar.herrera.utils.Queue;

import org.junit.Test;

public class QueueTest {

    @Test
    public void inverseTest(){
        Queue<Integer> queue = new Queue<>();
        queue.offer(5);
        queue.offer(78);
        queue.offer(105);
        queue.showQueue();
        queue.inverse();
        queue.showQueue();
    }
}
