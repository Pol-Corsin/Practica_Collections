# Sistema de Gestió de Supermercat

## Descripció

Aquest projecte és un sistema de gestió de supermercat en Java. Permet als usuaris gestionar un magatzem, afegir productes, processar compres i veure el carro de la compra.

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

### Excepcions
- `DataCaducitatException`: Excepció per a la data de caducitat.
- `EnumFailedException`: Excepció per a l'enumeració.
- `LimitCaracterException`: Excepció per al límit de caràcters.
- `LimitProductesException`: Excepció per al límit de productes.
- `NegatiuException`: Excepció per a valors negatius.

## Ús

1. **Executar l'Aplicació**: Executa la classe Main per iniciar l'aplicació.
2. **Navegar pel Menú**: Per gestionar el magatzem, afegir productes, processar compres i veure el carro de la compra.