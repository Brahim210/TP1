# TP1
Exercice 1:
  question 3:
    1. Le serveur reste à l'écoute sur un port déjà précisé
    2. Le client envoie une demande de connexion
    3. En cas d'acceptation, une connexion est établie entre le client et le serveur en utilisant des sockets.
    4. Le client envoie des données au serveur via cette connexion (via un buffer d'envoie).
    5. Le serveur reçoit les données envoyées par le client (dans le buffer de reception).
    6. Après réception des données, le serveur traite ces informations.
    7. En réponse au traitement, le serveur peut envoyer des données ou une confirmation au client.
    8. Le client reçoit la réponse du serveur.
    9. La connexion entre le client et le serveur est fermée, terminant ainsi l'échange de données.
