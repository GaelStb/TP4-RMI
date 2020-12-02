package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Serveur.ServeurIntf;
import Threads.Polling;
import Threads.Sender;


public class Client {
	static ServeurIntf Serveur;
	
	public Client() throws MalformedURLException, RemoteException, NotBoundException {
	}
	
	//Connexion Serveur
	
	public static void main(String args[]) throws Exception {
        Client chatClient=new Client();       
        Serveur = (ServeurIntf)Naming.lookup("//localhost/RmiServer");
        System.out.println(chatClient.Serveur.Accueil());
        new Polling(chatClient, Serveur).start();
        new Sender(chatClient, Serveur).start();
    }
	
	//Creation de la liste entrée par le client
	
	private ArrayList<String> ListeEntree = new ArrayList<String>() ;
	
	public ArrayList<String> getListeEntree () {
		return ListeEntree ;
	}
	
	public void setListeEntree (ArrayList<String> ListeEntree) {
		this.ListeEntree = ListeEntree ;
	}		
	
}