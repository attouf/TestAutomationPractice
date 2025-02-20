Feature: S'inscrire aux NewsLettre 
@NewsLettre
     Scenario: S'inscrire à la new lettre avec un email valide 
        Given la page dacceuil est visible2
        When je défile la page en bas 
        And  le titre NewsLettre doit être visible
        And je tape un email valide "atef"
        And je clique sur le bouton "s'inscrire"
        Then le message "Newsletter : You have successfully subscribed to this newsletter." doit être visible

    @NewsLettreError
     Scenario: S'inscrire à la new lettre avec un email invalide 
        Given la page dacceuil est visible
        When je défile la page en bas 
        And  le titre NewsLettre doit être visible
        And je tape un email valide "atef"
        And je clique sur le bouton "s'inscrire"
        Then le message "Newsletter : Invalid email address." doit être visible


