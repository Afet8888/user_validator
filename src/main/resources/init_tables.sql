CREATE TABLE todo (
  id SERIAL PRIMARY KEY,
  title VARCHAR(300),
  text TEXT,
  is_done BOOLEAN,
  creation_date TIMESTAMP
)