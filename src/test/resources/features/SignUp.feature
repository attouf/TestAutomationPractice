Feature: User SignUp
@SignUp
  Scenario: SignUp avec des données valides
    Given La page accueil est visible 
    When je clic sur le bouton SignIn
    And La page createAccount est visible
    And Taper une adresse email valide "atef"
    And Je clic sur le bouton Create Account
    And Verifiez que la page Personal information est visible
    And Je remplis le formulaire  "atef" "mohamed" "atef1234"
    And Je clic sur le bouton Register
    Then Verifiez que le message "Your account has been created." est visible
    
  Scenario: SignUp avec un email existant
    Given La page accueil est visible 
    When je clic sur le bouton SignIn
    And La page createAccount est visible
    And Taper une adresse email existante "atef00@gmailcom"
    And Je clic sur le bouton Create Account
    Then Verifiez que le message "An account using this email address has already been registered. Please enter a valid password or request a new one." est visible