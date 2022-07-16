
# APP-RANK-LIST-MEILI-SEARCH-KOTLIN

<p>Serviço responsavel por buscar dados no MeiliSearch</p>


### :pushpin: Features

- [x] Busca de produtos com MeiliSearch.
- [x] Busca de produtos com MeiliSearch paginado.

### :hammer: Pré-requisitos

Antes de começar será necessario iniciar o serviço principal [APP-MENUS-RESTAURANTS-JAVA](https://github.com/leonardodantas/app-menus-restaurants-java) e iniciar o arquivo docker compose do mesmo. 

### 🎲 Iniciando projeto pela primeira vez

```bash
# Clone este repositório
git clone https://github.com/leonardodantas/app-rank-list-meili-search-kotlin.git

# Inicie a aplicação com uma IDE de sua preferência

#Acesse o seguinte endereço no navegador
http://localhost:8082/swagger-ui/index.html

```

### 🛠 Detalhes Tecnicos

- Kotlin
- Kafka
- Arquitetura baseada em Clean Arch
- MeiliSearch

## Documentação da API

## Produtos

### Recuperar produtos

```
GET /search
```

CURL de exemplo:

```
curl -X GET "http://localhost:8082/search?q=Lanche" -H "accept: */*"
```

### Recuperar produtos páginados

```
GET /search/page/{Número da página}/size/{Tamanho da página}?q={Termo para busca}
```

CURL de exemplo:
```
curl -X GET "http://localhost:8082/search/page/0/size/20?q=Lanche" -H "accept: */*"
```


## Tecnologias

<div style="display: inline_block">

  <img align="center" alt="kotlin" src="https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white" />
  <img align="center" alt="spring" src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" />
  <img align="center" alt="kafka" src="https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka" />
	
</div>

### :sunglasses: Autor
Criado por Leonardo Rodrigues Dantas.

[![Linkedin Badge](https://img.shields.io/badge/-Leonardo-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/leonardo-rodrigues-dantas/)](https://www.linkedin.com/in/leonardo-rodrigues-dantas/) 
[![Gmail Badge](https://img.shields.io/badge/-leonardordnt1317@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:leonardordnt1317@gmail.com)](mailto:leonardordnt1317@gmail.com)

## Licença
Este projeto esta sobe a licença MIT.
