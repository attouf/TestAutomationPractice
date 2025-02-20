 Feature: log in
@Login
     Scenario: login success
        Given la page dacceuil est visible
        When je clic sur le bouton signIn
        When je tape un email "sarra.bellila@gmail.com" et un password "omar1234" valides
        When je clique sur le bouton SignIn
        Then la page UserAccount est visible



 Scenario: login error avec mail invalide
 Given la page dacceuil est visible
        When je clic sur le bouton signIn
        When je tape un email invalide "bekri.ateff@gmail.com"
        When je tape un password "a123"
        When je clique sur le bouton SignIn
        Then le message d'erreur "Invalid email address." doit etre visible

 
 Scenario: login error avec password invalide
 Given la page dacceuil est visible
        When je clic sur le bouton signIn
        When je tape un email valide "sarra.bellila@gmail.com"
         When je tape un password invalide "a123"
        When je clique sur le bouton SignIn
        Then le message d'erreur "Authentication failed." doit etre visible