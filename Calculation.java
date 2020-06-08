import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculation extends UnicastRemoteObject implements CalculationItf {
	public Calculation() throws RemoteException {
		super();
	}
	public int tong2so(int a,int b) throws RemoteException{
		return (a+b);
	}
	public int giaithua(int n) throws RemoteException{
		int gt=1;
		for(int i=2;i<=n;i++) {
			gt=gt*i;
		}
		return gt;
	}
	public int tru(int a,int b) throws RemoteException{
		return (a-b);
	}
}
