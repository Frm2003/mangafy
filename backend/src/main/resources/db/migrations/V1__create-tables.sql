-- -- Criação da tabela autor
CREATE TABLE autor (
    id_autor UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL, 
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL, 
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT email_unique UNIQUE (email)
);

-- Criação da tabela livro
CREATE TABLE livro (
    id_livro UUID PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    id_autor UUID NOT NULL,
    qtd_paginas INT NOT NULL,
    FOREIGN KEY (id_autor) REFERENCES autor(id_autor) ON DELETE CASCADE
);

-- Criação da tabela manga
CREATE TABLE manga (
    id_manga UUID PRIMARY KEY,
    titulo VARCHAR(255),
    id_autor UUID NOT NULL,
    qtd_capitulos INT NOT NULL
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