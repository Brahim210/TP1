import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
 public static void main(String argv[]) {
 int port = 0;
 String host = "";
 Scanner keyb = new Scanner(System.in);
 // Donner le nom et le port du serveur avec lequel le client veut établir une connexion
 System.out.print("Nom du serveur : ");
 host = keyb.next();
 System.out.print("Port du serveur : ");

 try {
 port = keyb.nextInt();
 } catch (NumberFormatException e) {
 System.err.println("Le second paramètre n'est pas un entier.");
 System.exit(-1);
 }
 // Créer d'une demande de connexion avec un serveur spécifique
 try {
 // Chercher d'adresse IP du serveur "host"
 InetAddress adr = InetAddress.getByName(host);
 // Créer un socket client en spécifiant l'adresse IP et le port du serveur en question pour établir une connexion
 Socket socket = new Socket(adr, port);
 // Créer un buffer d'envoie et de réception
 ObjectOutputStream output =
 new ObjectOutputStream(socket.getOutputStream());
 ObjectInputStream input =
 new ObjectInputStream(socket.getInputStream());
 // Ecrire sur le buffer d'envoie (sortie)
 output.writeObject(new String("ma première socket"));
 // Lire le message reçu par le client sur le buffer de reception à partir du buffer d'envoie du serveur
 String chaine = (String) input.readObject();
 System.out.println(" recu du serveur : " + chaine);
 } catch (Exception e) {
 System.err.println("Erreur : " + e);
 }
 }
}