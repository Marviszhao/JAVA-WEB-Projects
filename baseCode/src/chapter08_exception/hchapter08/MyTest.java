package chapter08_exception.hchapter08;

class A {
	public void work(int[] a) {
		String s = this.contain(a, 3);
		System.out.println("Result: " + s);
	}
	public String contain(int[] source, int dest) {
		String result = "no!";
		try {
			for (int i = 0; i < source.length; i++) {
				if (source[i] == dest)
					result = "yes!";
			}
		} catch (Exception e) {
			System.out.println("Exception Message: " + e.getMessage());
			System.out.println("Stack Trace:");
			e.printStackTrace();
			result = "error!";
		}
		return result;
	}}
public class MyTest{
	public static void main(String[] args)    {
		A tst = new A();
		tst.work(null);
	}}