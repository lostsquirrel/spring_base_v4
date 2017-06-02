package task;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

@Component
public class BeanA {

	private Queue<Integer> q = new ConcurrentLinkedQueue<>();
	
	public void methodA() {
		q.add(new Random().nextInt());
		PrintUtils.printMessage(q.toString());
	}
	
	public void methodA1() {
		q.poll();
		PrintUtils.printMessage(q.toString());
	}
}
