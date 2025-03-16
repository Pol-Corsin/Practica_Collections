# Sistema de Gestió de Supermercat

## Descripció

Aquesta pràctica és un sistema de gestió de supermercat que permet als usuaris gestionar un magatzem(carro), afegir productes, processar compres i veure el carro de la compra.

## Funcionalitats

- **Gestió de Magatzem**: Veure productes per data de caducitat, tiquets de compra i composició tèxtil.
- **Entrada de Productes**: Afegir nous productes al magatzem, incloent alimentació, tèxtil i electrònica.
- **Caixa**: Processar compres i generar tiquets de compra.
- **Carro de la Compra**: Veure el contingut del carro de la compra.

## Classes

### Classes Principals

- `Main`: Classe principal que gestiona la interfície d'usuari i les interaccions.
- `Vista`: Classe per mostrar missatges i obtenir l'entrada de l'usuari.

### Classes del Model

- `Producte`: Classe abstracta que representa un producte.
- `Alimentacio`: Productes d'alimentació.
- `Textil`: Productes tèxtils.
- `Electronica`: Productes electrònics.
