CREATE DATABASE IF NOT EXISTS reinos_perdidos;
USE reinos_perdidos;

CREATE TABLE IF NOT EXISTS raca (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    bonus_vida INT NOT NULL,
    bonus_escudo INT NOT NULL,
    bonus_poder_fisico INT NOT NULL,
    bonus_poder_habilidade INT NOT NULL
);

CREATE TABLE IF NOT EXISTS arquetipos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    bonus_poder_fisico INT NOT NULL,
    bonus_poder_habilidade INT NOT NULL,
    bonus_vida INT NOT NULL,
    bonus_escudo INT NOT NULL,
    atributos INT NOT NULL
);

CREATE TABLE IF NOT EXISTS personagem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    vida INT NOT NULL,
    escudo INT NOT NULL,
    poder_fisico INT NOT NULL,
    poder_habilidade INT NOT NULL,
    raca_id INT,
    arquetipos_id INT,
    FOREIGN KEY (raca_id) REFERENCES raca(id),
    FOREIGN KEY (arquetipos_id) REFERENCES arquetipos(id)
);

CREATE TABLE IF NOT EXISTS batalha (
    id INT AUTO_INCREMENT PRIMARY KEY,
    lutador1_id INT NOT NULL,
    lutador2_id INT NOT NULL,
    vencedor_id INT,
    FOREIGN KEY (lutador1_id) REFERENCES personagem(id),
    FOREIGN KEY (lutador2_id) REFERENCES personagem(id),
    FOREIGN KEY (vencedor_id) REFERENCES personagem(id)
);