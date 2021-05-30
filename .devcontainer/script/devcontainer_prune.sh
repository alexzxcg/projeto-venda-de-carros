#!/usr/bin/env sh

printf "removing containers...\n"
docker container stop java-APSOO-Venda-Carros postgres-dev-APSOO-Venda-Carros postgres-test-APSOO-Venda-Carros
docker container rm java-APSOO-Venda-Carros postgres-dev-APSOO-Venda-Carros postgres-test-APSOO-Venda-Carros

printf "\nremoving volumes...\n"
docker volume prune -f

printf "\nremoving images...\n"
docker image rm ufms-apsoo-venda-carros_devcontainer_app