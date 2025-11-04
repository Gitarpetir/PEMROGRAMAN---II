package soal1;

public class Paint {
	private double coverage;
	
	public Paint(double r) {
		this.coverage = r;
	}
	
	public double amount(Shape s) {
		System.out.println ("Computing amount for " + s);
		double amount = s.area()/coverage;
		return amount;
	}
}

