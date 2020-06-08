import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculationServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//tao remote object
			Calculation calObject = new Calculation();
			LocateRegistry.createRegistry(1055);
			Naming.rebind("CalObj", calObject);
			System.out.println("Dang ky Cal object thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
