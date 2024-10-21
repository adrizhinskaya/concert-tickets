   drop table IF EXISTS "Ticket";
   drop table IF EXISTS "User";

   create TABLE IF NOT EXISTS "User" (
       id SERIAL PRIMARY KEY,
       name VARCHAR(255),
       creation_date DATE
   );

   create TABLE IF NOT EXISTS "Ticket" (
       id SERIAL PRIMARY KEY,
       user_id BIGINT,
       ticket_type VARCHAR(10) CHECK (ticket_type IN ('DAY', 'WEEK', 'MONTH', 'YEAR')),
       creation_date DATE,
       FOREIGN KEY (user_id) REFERENCES "User"(id) ON delete RESTRICT
   );
   