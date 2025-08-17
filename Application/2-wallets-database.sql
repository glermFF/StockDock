CREATE USER "pg-stockDock-wallets" WITH PASSWORD 'stockwallets';

CREATE DATABASE "stockDock-wallets";
ALTER DATABASE "stockDock-wallets" OWNER TO "pg-stockDock-wallets";