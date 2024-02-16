import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketServeur {
 public static void main(String argv[]) {
 int port = 0;
 Scanner keyb = new Scanner(System.in);
 //Choisir un port d'écoute
 System.out.print("Port d'écoute : ");
 try {
 port = keyb.nextInt();
 } catch (NumberFormatException e) {
 System.err.println("Le paramètre n'est pas un entier.");
 System.err.println("Usage : java ServeurUDP port-serveur");
 System.exit(-1);
 }
 try {
 // Créer un Socket serveur TCP sur le port "port = 10000"
 ServerSocket serverSocket = new ServerSocket(port);
 // Accepter les clients qui veulent établir une connexion d'entré sur le socket serveur

Socket socket = serverSocket.accept();
 // Créer des buffer d'envoie et de réception
 ObjectOutputStream output =
 new ObjectOutputStream(socket.getOutputStream());
 ObjectInputStream input =
 new ObjectInputStream(socket.getInputStream());
 // Lire une chaine à partir du flux d'entrée du client
 String chaine = (String) input.readObject();
 System.out.println(" recu : " + chaine);
 // Donner l'adresse et le port du client 
 System.out.println(" ca vient de : " + socket.getInetAddress() +
":" + socket.getPort());
 // Ecrire un message sur le buffer d'envoie
 output.writeObject(new String("bien recu"));
 } catch (Exception e) {
 System.err.println("Erreur : " + e);
 }
 }
}