CREATE USER "pg-stockDock-users" WITH PASSWORD 'stockusers';

CREATE DATABASE "stockDock-users";
ALTER DATABASE "stockDock-users" OWNER TO "pg-stockDock-users";