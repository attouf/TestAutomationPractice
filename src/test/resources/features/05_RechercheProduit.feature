
Feature: Recherche Produit
@Search
    Scenario Outline: Rechercher un produit a partir de la page d'acceuil
      Given la page accueil est visible3
      When je tape le nom de produit "<nom_produit>" dans la barre de recherche
      And Je clic sur le bouton de recherche 
      Then Verifier que tous les produits relatifs à la recherche sont visibles "<nom_produit>"
      Examples:
      | nom_produit |
      | printed dress |
      | blouse |


     