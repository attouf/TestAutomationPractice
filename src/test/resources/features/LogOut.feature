Feature: log Out
@LogOut
     Scenario: logOut success
        Given la page dacceuil est visible1
        When je clic sur le bouton signIn1
        And je tape un email "sarra.bellila@gmail.com" et un password "omar1234" valides1
        And je clique sur le bouton SignIn1
        And la page UserAccount est visible1
        And je clique sur le bouton SignOut
        Then verifier la page Authentification est visible
