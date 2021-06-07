FROM postgres:latest

COPY database/db.dev.sql /docker-entrypoint-initdb.d/