-- Criação da tabela manga
CREATE TABLE manga (
    id_manga UUID PRIMARY KEY,
    titulo VARCHAR(255),
    autor VARCHAR(255),
    qtd_capitulos INT
);

-- Criação da tabela livro
CREATE TABLE livro (
    id_livro UUID PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255),
    qtd_paginas INT NOT NULL
);

-- Criação da tabela capitulo_manga
CREATE TABLE capitulo_manga (
    id_livro UUID PRIMARY KEY,
    num_capitulo INT NOT NULL,
    qtd_paginas INT NOT NULL,
    path VARCHAR(255) NOT NULL,
    id_manga UUID NOT NULL,
    FOREIGN KEY (id_manga) REFERENCES manga(id_manga) ON DELETE CASCADE
);