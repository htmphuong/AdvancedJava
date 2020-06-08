import java.rmi.Naming;

public class CalculationClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Client connection");
			CalculationItf cal = 
					(CalculationItf)Naming.lookup("rmi://localhost/CalObj");
			int tong = cal.tong2so(5, 6);
			System.out.println("tong la"+tong);
			int gt = cal.giaithua(5);
			System.out.println("Giai thua "+gt);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
