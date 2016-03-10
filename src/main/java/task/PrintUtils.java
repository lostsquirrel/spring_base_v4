package task;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintUtils {

	private static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	
	public static void printMessage(String msg) {
		System.out.println(String.format("excute: %s at: %s", msg, format.format(new Date())));
	}
}
