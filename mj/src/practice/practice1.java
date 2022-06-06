package practice;

public class practice1 {
	static void execute(Myfunction f) {
		f.run();
	}

	static Myfunction getMyFunction() {
		Myfunction f = () -> System.out.println("f3.run()"); // Myfunction의 run()메소드를 구현한 객체를 f라는 참조변수로 생성
		return f;
	}

	public static void main(String[] args) {

		Myfunction f1 = () ->System.out.println("f1.run()");
		
		Myfunction f2 = new Myfunction() {
			public void run() {      // public은 반드시 붙여야함. abstract은 구현 했으므로 제거
				System.out.println("f2.run()");
			}
		};
		
		Myfunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( ( ) -> System.out.println( "run()" ) );
		
	}
}

@FunctionalInterface
interface Myfunction {
	public abstract void run();
}
