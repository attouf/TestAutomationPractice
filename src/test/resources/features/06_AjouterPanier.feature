
Feature: Ajout d'un produit au panier avec changement de couleur
@Panier
    Scenario Outline: Rechercher un produit a partir de la page d'acceuil et l'ajouter au panier
      Given la page accueil est visible4
      When je tape le nom de produit  "Blouse" dans la barre de recherche
      And Je clic sur le bouton de recherche1 
      And Verifier que tous les produits relatifs à la recherche sont visibles2 "Blouse"
      And je survole le premier produit verifier letat du bouton Add To Cart est Enabled or Disabled
      And Si le bouton Add et Enabled je clic dessus
      And Sinon je verifie si le produit existe avec autre couleur 
      And Je clic sur le bouton More
      And je change la couleur du produit dispo en stock
      And je clic sur le bouton Add to cart
      Then Verifier que le message "Product successfully added to your shopping cart"est visible1
      And  je clic sur le bouton continue shopping
      And verifier que le quantite du panier est égale à "1"

    




     