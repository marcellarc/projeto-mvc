CREATE TABLE IF NOT EXISTS filme (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255),
    diretor VARCHAR(255),
    anoLancamento INT,
    genero VARCHAR(100),
    duracao INT,
    status VARCHAR(50)
);