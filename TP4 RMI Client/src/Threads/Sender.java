package Threads;

import java.rmi.RemoteException;
import java.util.Scanner;

import Client.Client;
import Serveur.ServeurIntf;

public class Sender extends Thread {
	private Client client;
	private ServeurIntf serveur ;
	private Scanner sc ;
	public Sender( Client client, ServeurIntf serveur) {
		this.client = client;
		this.serveur = serveur;
		this.sc = new Scanner(System.in);
	}
//Gestion du renvoie de message à l'autre client
@Override
public void run() {
	while (true) {
		String message = sc.nextLine();
		try {
			client.getListeEntree().add(message);
			serveur.EnvoieMessage(message);
		} catch (RemoteException e) {
			 e.printStackTrace();
		}
	}
	
}



}
