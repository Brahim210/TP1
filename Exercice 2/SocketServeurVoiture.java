import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketServeurVoiture {
public static void main(String argv[]) {
int port = 0;
Scanner keyb = new Scanner(System.in);
// .............................................................
System.out.print("Port d'écoute : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le paramètre n'est pas un entier.");
System.err.println("Usage : java ServeurUDP port-serveur");
System.exit(-1);
}
try {
// .............................................................
ServerSocket serverSocket = new ServerSocket(port);
// ..........................................................
Socket socket = serverSocket.accept();
// ..........................................................
ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());
// ..........................................................
voiture voiture1 = (voiture) input.readObject();
System.out.println(" recu de la voiture: ");
// ..........................................................
System.out.println(" ca vient de : " + socket.getInetAddress() +
":" + socket.getPort());
// ..........................................................
int carb;
System.out.println("Donner le volume de carburant à ajouter: ");
carb = keyb.nextInt();

voiture1.setCarburant(carb);
output.writeObject(new String("bien recu"));
System.out.println("le volume de carburant de la voiture est " + voiture1.getCarburant()); 

} catch (Exception e) {
System.err.println("Erreur : " + e);
}
}
}