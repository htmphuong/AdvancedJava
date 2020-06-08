import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculationItf extends Remote{
	public int tong2so(int a,int b)  throws RemoteException;
	public int giaithua(int n) throws RemoteException;
	public int tru (int a,int b) throws RemoteException;
}
