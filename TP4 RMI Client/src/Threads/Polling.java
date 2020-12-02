 package Threads;
 
 import java.rmi.RemoteException;

import Client.Client;
import Serveur.ServeurIntf;
import java.util.ArrayList;


 

public class Polling extends Thread {
	private Client client;
	private ServeurIntf serveur;
	public Polling( Client client, ServeurIntf serveur)  {
		this.client = client ;
		this.serveur = (ServeurIntf)serveur; 	
	}
	
	
	// Gestion de la récupération du message entrée et modifications des listes  
	@Override
	public void run() {
		try {
			client.setListeEntree((ArrayList<String>) serveur.getMessage()); 
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		while(true) {
			 try {
				  if(serveur.getMessage().size() > client.getListeEntree().size()) {
					  for (int i = client.getListeEntree().size(); i < serveur.getMessage().size(); i++) {
						   System.out.println(serveur.getMessage().get(i));
						   //Cette ligne permet de ne pas avoir qui s'affichent à l'infini 
						   client.getListeEntree().add(serveur.getMessage().get(i));
					  }
				  }
			 } catch (RemoteException e) {
				 e.printStackTrace();
			 }
		}

	}

}
