#!/usr/bin/env sh

echo -e "removing containers...\n"
docker container stop java-APSOO-Venda-Carros postgres-dev-APSOO-Venda-Carros postgres-test-APSOO-Venda-Carros
docker container rm java-APSOO-Venda-Carros postgres-dev-APSOO-Venda-Carros postgres-test-APSOO-Venda-Carros

echo -e "\nremoving volumes...\n"
docker volume prune -f