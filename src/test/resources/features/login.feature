 Feature: log in
@Login
     Scenario: login success
        Given la page dacceuil est visible
        When je clic sur le bouton signIn
        When je tape un email "sarra.bellila@gmail.com" et un password "omar1234" valides
        When je clique sur le bouton SignIn
        Then la page UserAccount est visible


@LogError
 Scenario: login error avec mail invalide
 Given la page dacceuil est visible5
        When je clic sur le bouton signIn2
        When je tape un email invalide "sarra.bellila@gmail.com"
        When je tape un password "mmmmmm"
        When je clique sur le bouton SignIn3
        Then le message erreur "Authentication failed." doit etre visible

 
 