
# APP-RANK-LIST-MEILI-SEARCH-KOTLIN

<p>Serviço responsavel por buscar dados no MeiliSearch</p>

### :hammer: Pré-requisitos

Antes de começar será necessario iniciar o serviço principal [APP-MENUS-RESTAURANTS-JAVA] e iniciar o arquivo docker compose do mesmo (https://github.com/leonardodantas/app-menus-restaurants-java)

### 🎲 Iniciando projeto pela primeira vez

```bash
# Clone este repositório
git clone https://github.com/leonardodantas/app-rank-list-meili-search-kotlin.git

# Inicie a aplicação com uma IDE de sua preferência

#Acesse o seguinte endereço no navegador
http://localhost:8082/swagger-ui/index.html

```

### 🛠 Detalhes Tecnicos

- Java 17
- Records
- Eventos assincronos.
- Cache com Redis
- MongoDB
- Arquitetura baseada em Clean Arch
- Criação de Annotations para validação de dados

## Documentação da API

## Restaurantes

- ### Criar um novo restaurante

```
POST /restaurant
```
A requisição precisa de um body com os seguintes parâmetros:
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `address` | `AddressRequestJson` | **Obrigatório**. Objeto contendo as informaçẽos de endereço |
| `cnpj` | `string` | **Obrigatório**. CNPJ |
| `name` | `string` | **Obrigatório**. Nome do restaurante |
| `operatingHours` | `OperatingHoursRequesJson` | **Obrigatório**. Objeto contendo as informações referentes ao horario de funcionamento |

CURL de exemplo:

```
curl -X POST "http://localhost:8080/restaurant" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"address\": { \"city\": \"Tarumã\", \"complement\": \"Avenida principal\", \"number\": \"31\", \"state\": \"SP\", \"street\": \"Arvores\", \"village\": \"Araruama\" }, \"cnpj\": \"16.682.460/0001-87\", \"name\": \"Lanches dos Lagos\", \"operatingHours\": { \"endTime\": \"22:00\", \"startTime\": \"18:00\" }}"
```


### Atualizar restaurante

```
PUT /restaurant?id={id do restaurante}
```
A requisição precisa de um body com os seguintes parâmetros:
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `address` | `AddressRequestJson` | **Obrigatório**. Objeto contendo as informaçẽos de endereço |
| `operatingHours` | `OperatingHoursRequesJson` | **Obrigatório**. Objeto contendo as informações referentes ao horario de funcionamento |

CURL de exemplo:

```
curl -X PUT "http://localhost:8080/restaurant?id=628b7437a7e01b3b50f2399a" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"address\": { \"city\": \"Assis\", \"complement\": \"Avenida secundaria\", \"number\": \"89\", \"state\": \"SP\", \"street\": \"Rua barbosa\", \"village\": \"Avenida Rui Barbosa\" }, \"operatingHours\": { \"endTime\": \"18:00\", \"startTime\": \"23:00\" }}"
```

### Abrir restaurante

```
PUT /restaurant/open?id={id do restaurante}
```

CURL de exemplo:

```
curl -X PUT "http://localhost:8080/restaurant/open?id=628b7437a7e01b3b50f2399a" -H "accept: */*"
```

### Fechar restaurante

```
PUT /restaurant/close?id={id do restaurante}
```

CURL de exemplo:

```
curl -X PUT "http://localhost:8080/restaurant/close?id=628b7437a7e01b3b50f2399a" -H "accept: */*"
```

### Recuperar detalhes do restaurante (CNPJ)

```
GET /restaurant/cnpj/{CNPJ}/details
```

CURL de exemplo:

```
curl -X GET "http://localhost:8080/restaurant/cnpj/16682460000187/details" -H "accept: */*"
```

### Recuperar detalhes do restaurante (ID)

```
GET /restaurant/id/{id do restaurante}/details
```

CURL de exemplo:

```
curl -X GET "http://localhost:8080/restaurant/id/628b7437a7e01b3b50f2399a/details" -H "accept: */*"
```

### Recuperar detalhes do restaurante (CODE)

```
GET /restaurant/code/{codigo do restaurante}/details
```

CURL de exemplo:

```
curl -X GET "http://localhost:8080/restaurant/code/LANCHES-BDB2D/details" -H "accept: */*"
```

### Recuperar restaurantes paginados

```
GET /restaurants?page={numero da pagina}&size={tamanho da pagina}
```

CURL de exemplo:

```
curl -X GET "http://localhost:8080/restaurants?page=0&size=20" -H "accept: */*"
```

### Remover restaurante

```
DELETE /restaurant/id/{id do restaurante}
```

CURL de exemplo:

```
curl -X DELETE "http://localhost:8080/restaurant/id/628b7437a7e01b3b50f2399a" -H "accept: */*"
```
## Produtos

- ### Criar um novo produto

```
POST /product
```
A requisição precisa de um body com os seguintes parâmetros:
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `categories` | `CategoriesRequestJson` | **Obrigatório**. Objeto contendo as categorias do produto |
| `code` | `string` | **Obrigatório**. Codigo do restaurante |
| `name` | `string` | **Obrigatório**. Nome do produto |
| `price` | `BigDecimal` | **Obrigatório**. Valor do produto |

CURL de exemplo:

```
curl -X POST "http://localhost:8080/product" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"categories\": { \"values\": [ \"SALSICHA\", \"BACON\", \"MOSTARDA\", \"PRESUNTO\", \"PURE\" ] }, \"code\": \"LANCHES-BDB2D\", \"name\": \"Cachorro Quente Especial\", \"price\": 18}"
```

- ### Atualizar um novo produto

```
PUT /product?id={id do produto}
```
A requisição precisa de um body com os seguintes parâmetros:
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `categories` | `CategoriesRequestJson` | **Obrigatório**. Objeto contendo as categorias do produto |
| `code` | `string` | **Obrigatório**. Codigo do restaurante |
| `name` | `string` | **Obrigatório**. Nome do produto |
| `price` | `BigDecimal` | **Obrigatório**. Valor do produto |

CURL de exemplo:

```
curl -X PUT "http://localhost:8080/product?id=628b7d956db36a02c824593f" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"categories\": { \"values\": [ \"BATATA\",\"MOLHO\",\"HAMBURGUER\",\"CALABRESA\" ] }, \"code\": \"LANCHES-BDB2D\", \"name\": \"Cachorro da Casa\", \"price\": 20}"
```

- ### Buscar produtos paginados por code

```
GET /products/restaurant/{codigo do restaurante}?page={numero da pagina}&size={tamanho da pagina}
```

CURL de exemplo:

```
curl -X GET "http://localhost:8080/products/restaurant/LANCHES-BDB2D?page=0&size=20" -H "accept: */*"
```

- ### Remover produto

```
DELETE /products?code={codigo do restaurante}&id={id do produto}
```

CURL de exemplo:

```
curl -X DELETE "http://localhost:8080/products?code=LANCHES-BDB2D&id=628b7d956db36a02c824593f" -H "accept: */*"
```
## Delivery

- ### Ativar delivery

```
POST /restaurant/delivery/activate?code={codigo do restaurante}
```
A requisição precisa de um body com os seguintes parâmetros:
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `maximumDeliveryTime` | `int` | **Obrigatório**. Tempo maximo para entrega |
| `minimumDeliveryTime` | `int` | **Obrigatório**. Tempo minimo para entrega |
| `rate` | `BigDecimal` | **Obrigatório**. Taxa da entrega |

CURL de exemplo:

```
curl -X POST "http://localhost:8080/restaurant/delivery/activate?code=LANCHES-BDB2D" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"maximumDeliveryTime\": 50, \"minimumDeliveryTime\":40, \"rate\": 2}"
```

- ### Desativar delivery

```
PUT /restaurant/delivery/deactivate?code={codigo do restaurante}
```

CURL de exemplo:

```
curl -X PUT "http://localhost:8080/restaurant/delivery/deactivate?code=LANCHES-BDB2D" -H "accept: */*"
```

## Promoções

- ### Criar nova promoção

```
POST /promotion?productId={id do produto}
```
A requisição precisa de um body com os seguintes parâmetros:
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `daysAndHours` | `List<DaysAndHoursRequestJson>` | **Obrigatório**. Objeto que contem as informações sobre os dias e a hora da promoção |
| `description` | `String` | **Obrigatório**. Descrição da promoção |
| `promotionalPrice` | `BigDecimal` | **Obrigatório**. Valor promocional |

CURL de exemplo:

```
curl -X POST "http://localhost:8080/promotion?productId=62877e6a8b60245329674de7" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"daysAndHours\": [ { \"day\": \"MONDAY\", \"endTime\": \"18:00\", \"startTime\": \"17:00\" } ], \"description\": \"Leve dois pelo preço de 1\", \"promotionalPrice\": 15}"
```

- ### Recuperar todas as promoções de um restaurante

```
GET /promotions?code={codigo do restaurante}
```

CURL de exemplo:

```
curl -X GET "http://localhost:8080/promotions?code=RESTAUR-725AE" -H "accept: */*"
```

- ### Recuperar promoções de um restaurante que estão validas no momento atual

```
GET /promotions/now?code={codigo do restaurante}
```

CURL de exemplo:

```
curl -X GET "http://localhost:8080/promotions/now?code=RESTAUR-725AE" -H "accept: */*"
```

- ### Remover todas as promoções de um produto

```
DELETE /promotion/product/{id do produto}
```

CURL de exemplo:

```
curl -X DELETE "http://localhost:8080/promotion/product/62877e6a8b60245329674de7" -H "accept: */*"
```

- ### Remover promoções de um unico dia

```
DELETE /promotion/product/{id do produto}/day/{dia da semana seguindo a seguinte convenção: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
```

CURL de exemplo:

```
curl -X DELETE "http://localhost:8080/promotion/product/62877e6a8b60245329674de7/day/MONDAY" -H "accept: */*"
```

## Categorias

- ### Buscar todas as categorias cadastradas para um restaurante

```
GET /categories/restaurant/code/{codigo do restaurante}
```

CURL de exemplo:

```
curl -X GET "http://localhost:8080/categories/restaurant/RESTAUR-725AE" -H "accept: */*"
```

- ### Buscar produtos utilizando uma lista de categorias

```
POST /categories/restaurants/code/{codigo do restaurante}
```
A requisição precisa de um body com os seguintes parâmetros:
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `values` | `List<String>` | **Obrigatório**. Objeto que contem uma lista de categorias |

CURL de exemplo:

```
curl -X POST "http://localhost:8080/categories/restaurants/RESTAUR-725AE" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"values\": [ \"QUEIJO\", \"BACON\" ]}"
```

## Tecnologias

<div style="display: inline_block">

  <img align="center" alt="mongo" src="https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white" />
  <img align="center" alt="java" src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" />
  <img align="center" alt="spring" src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" />
  <img align="center" alt="swagger" src="https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white" />
  <img align="center" alt="redis" src="https://img.shields.io/badge/redis-%23DD0031.svg?style=for-the-badge&logo=redis&logoColor=white" />
	
</div>

## Apêndice

O projeto foi construido a partir do seguinte desafio https://github.com/ZXVentures/ze-code-challenges/blob/master/backend_pt.md encontrado no repositório https://github.com/CollabCodeTech/backend-challenges


### :sunglasses: Autor
Criado por Leonardo Rodrigues Dantas.

[![Linkedin Badge](https://img.shields.io/badge/-Leonardo-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/leonardo-rodrigues-dantas/)](https://www.linkedin.com/in/leonardo-rodrigues-dantas/) 
[![Gmail Badge](https://img.shields.io/badge/-leonardordnt1317@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:leonardordnt1317@gmail.com)](mailto:leonardordnt1317@gmail.com)

## Licença
Este projeto esta sobe a licença MIT.
