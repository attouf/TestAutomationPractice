Feature: historique

  @historique
  Scenario: historiqueCommande
    Given la page dacceuil est visible6
    When je clique sur le bouton SignIn6
    And je tape un email "sarra.bellila@gmail.com" et un password "omar1234" valides6
    And je clique sur le bouton submit6
    And la page UserAccount est visible6
    And je clique sur le bouton historique de historiqueCommande
    And je vérifie que la référence de commande "ZEQWDLAMM" est visible
    And je clique sur la référence
    Then le message "Order Reference ZEQWDLAMM - placed on 02/24/2025" est visible
