-- -- Criação da tabela autor
CREATE TABLE usuarios (
    id_user UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL, 
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL, 
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT email_unique UNIQUE (email)
);

-- Criação da tabela livro
CREATE TABLE livros (
    id_livro UUID PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    id_autor UUID NOT NULL,
    qtd_paginas INT NOT NULL,
    FOREIGN KEY (id_autor) REFERENCES autor(id_autor) ON DELETE CASCADE
);

-- Criação da tabela manga
CREATE TABLE mangas (
    id_manga UUID PRIMARY KEY,
    titulo VARCHAR(255),
    id_autor UUID NOT NULL,
    qtd_capitulos INT NOT NULL
);

-- Criação da tabela capitulo_manga
CREATE TABLE capitulos_manga (
    id_livro UUID PRIMARY KEY,
    num_capitulo INT NOT NULL,
    qtd_paginas INT NOT NULL,
    path VARCHAR(255) NOT NULL,
    id_manga UUID NOT NULL,
    FOREIGN KEY (id_manga) REFERENCES manga(id_manga) ON DELETE CASCADE
);