
* docker run -d --name sqlserver --network mynetwork \
-e 'ACCEPT_EULA=Y' \
-e 'SA_PASSWORD=Perusalen123$' \
-e 'MSSQL_PID=Developer' \
-p 1433:1433 mcr.microsoft.com/mssql/server:2022-CU13-ubuntu-22.04


* CREATE DATABASE football COLLATE Latin1_General_100_CI_AS_SC;

* docker run --rm --network mynetwork demopacificogradle:0.0.1-SNAPSHOT