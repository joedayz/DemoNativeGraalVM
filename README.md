1. 
docker run -d \
--name sqlserver \
-e 'ACCEPT_EULA=Y' \
-e 'SA_PASSWORD=Perusalen123$' \
-e 'MSSQL_PID=Developer' \
-p 1433:1433 \
mcr.microsoft.com/mssql/server:2022-latest


2. create database football;
