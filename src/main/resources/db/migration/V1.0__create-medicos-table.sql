CREATE TABLE medicos (
   id bigint NOT NULL AUTO_INCREMENT,
   crm varchar(6) NOT NULL,
   email varchar(255) NOT NULL,
   bairro varchar(255) NOT NULL,
   cep varchar(255) NOT NULL,
   cidade varchar(255) NOT NULL,
   complemento varchar(255) DEFAULT NULL,
   logradouro varchar(255) NOT NULL,
   numero varchar(255) DEFAULT NULL,
   uf varchar(255) NOT NULL,
   especialidade enum('CARDIOLOGIA','DERMATOLOGIA','GINECOLOGIA','ORTOPEDIA') NOT NULL,
   nome varchar(255) NOT NULL,
   PRIMARY KEY (id)
);