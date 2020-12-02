package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServeurIntf extends Remote{

	public String Accueil() throws RemoteException;
	public List<String> getMessage() throws RemoteException; 
	public void EnvoieMessage (String Message) throws RemoteException;
	
	

}
 