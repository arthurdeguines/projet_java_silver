package main;

import java.io.Console;
import java.util.Scanner;

import common.Input;
import entity.ClientEntity;
import enumeration.Fruits;

public class Main {
	public static void main(String[] args) {
		ClientEntity clientEntity = new ClientEntity();
		String[] clients = clientEntity.getClients();
		Input input = new Input();
		int choixRefaireCommande;
		
		System.out.println("Outil de création de commande by U'DEV");
		System.out.println("Pour quel client passer une commande?");
		for(int cpt = 0; cpt < clients.length; cpt++) {
			System.out.println(cpt + " : " + clients[cpt]);
		}
		int choixClient = input.saisirNombre();
		System.out.println("Vous avez choisi le client " + clients[choixClient]);
		do{
			System.out.println("De quoi sera composé la commande?");
			for(int cpt = 0; cpt < Fruits.values().length; cpt++) {
				System.out.println(cpt + " : " + Fruits.values()[cpt]);
			}
			int choixCommande = input.saisirNombre();
			System.out.println("Combien de " + Fruits.values()[choixCommande] + "?");
			int nombreFruit = input.saisirNombre();
			System.out.println("Choix enregistré : " + nombreFruit + " " + Fruits.values()[choixCommande].toString().toLowerCase() + "(s)");
			System.out.println("Voulez-vous rajouter une commande? 1 : oui/2 : non");
			choixRefaireCommande = input.saisirNombre();
		}while(choixRefaireCommande == 1);
		
	}
	
}
