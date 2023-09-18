# planejamento-orcamentario-api

# Docker

## Criando arquivo de variáveis locais
```
$ cp default.env .env
```

## Subir container
```
$ docker compose --env-file=.env up
```

## Conectar ao banco
```
$ docker exec -it postgres_db psql -U ${DB_USER} ${DB_DATABASE} 
```

## Porta do banco em seu computador
- localhost:${DB_PORT}

## Porta do banco em outros containers
- db:5432