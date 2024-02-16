import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClientPersonne {
public static void main(String argv[]) {
int port = 0;
String host = "";
Scanner keyb = new Scanner(System.in);
int age;
String nom;
// .............................................................
System.out.print("Nom du serveur : ");
host = keyb.next();
System.out.print("Port du serveur : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le second paramètre n'est pas un entier.");
System.exit(-1);
}
// .............................................................
try {
// .............................................................
InetAddress adr = InetAddress.getByName(host);
// .............................................................
Socket socket = new Socket(adr, port);
// .............................................................
ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());
// .............................................................
System.out.print("Saisir l'age : ");
age = keyb.nextInt();
System.out.print("Saisir le nom : ");
nom = keyb.next();

output.writeObject(new personne(age, nom));
// .............................................................
String chaine = (String) input.readObject();
System.out.println(" recu du serveur : " + chaine);
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
}
}