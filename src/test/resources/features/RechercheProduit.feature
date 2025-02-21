Feature: 
@Search
    Scenario Outline: Rechercher un produit a partir de la page d'acceuil
      Given la page accueil est visible3
      When je tape le nom de produit "printed dress" dans la barre de recherche
      And Je clic sur le bouton de recherche 
      Then Verifier que tous les produits relatifs à la recherche sont visibles "printed dress"
     