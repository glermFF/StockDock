CREATE USER "pg-stockDock-investments" WITH PASSWORD 'stockinvestments';

CREATE DATABASE "stockdock-investments";
ALTER DATABASE "stockdock-investments" OWNER TO "pg-stockDock-investments";