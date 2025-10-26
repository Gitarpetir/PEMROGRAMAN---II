package soal2;

public class Anjing extends HewanPeliharaan{
	private String warnaBulu;
	private String[] Kemampuan;
	
	public Anjing (String r, String n, String w, String[] k) {
		super(r,n);
		this.Kemampuan = k;
		this.warnaBulu = w;
	}
	
	public void displayDetailAnjing() {
		display();
		System.out.println("Memiliki warna bulu : " + warnaBulu);
		System.out.print("Memiliki kemampuan : ");
		
		for (String skill : this.Kemampuan) {
            System.out.print(skill + " ");
        }
        System.out.println();
	}
}
