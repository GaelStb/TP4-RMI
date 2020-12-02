package Serveur;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

 
import Serveur.ServeurIntf;



public class Serveur extends UnicastRemoteObject implements ServeurIntf{
	private static final long serialVersionUID = 1L;

	public Serveur() throws RemoteException{
	super(0);
	}
	
	//Creation de la liste mémorisé par le serveur
	
	private List<String> Message = new ArrayList<>();
	
	public List<String> getMessage() throws RemoteException {
		return Message ;  
	}
	
	public void setMessage (List<String> Message) {
		this.Message = Message ;
	}
	
	//Ajout d'un message à la liste  
	public void EnvoieMessage(String message) throws RemoteException{
		this.Message.add(message);
	}
	
	
	//Message d'acceuil
	
	@Override
	public String Accueil() throws RemoteException{
		return "Bienvenue dans le chat! Tapez votre message ci-dessous :";
	}
	
	//Paramétrage du serveur
	 public static void main(String args[]) throws Exception {
	        try { 
	            LocateRegistry.createRegistry(1099); 
	        } catch (RemoteException e) {
	        }
	        Serveur chatServeur = new Serveur();
	        Naming.rebind("//localhost/RmiServer", chatServeur);
	        System.out.println("Serveur pret!");
	    }
	 

}