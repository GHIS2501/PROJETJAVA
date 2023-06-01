SET search_path TO projet;


-- Supprime toutes les données
--DELETE FROM categorie;
--DELETE FROM auteur;
--DELETE FROM editeur;
--DELETE FROM auteur;
--DELETE FROM emprunt;
--DELETE FROM demande;
--DELETE FROM document;
DELETE FROM role;
DELETE FROM compte;


-- Insère les données

-- Compte

INSERT INTO compte (idcompte, pseudo, motdepasse, email ) VALUES 
( 1, 'geek', 'geek', 'geek@jfox.fr' ),
( 2, 'chef', 'chef', 'chef@jfox.fr' ),
( 3, 'job', 'job', 'job@jfox.fr' );

ALTER TABLE compte ALTER COLUMN idcompte RESTART WITH 4;


-- Role

INSERT INTO role (idcompte, role) VALUES 
( 1, 'ADMINISTRATEUR' ),
( 1, 'UTILISATEUR' ),
( 2, 'UTILISATEUR' ),
( 3, 'UTILISATEUR' );
 

--Document 
--INSERT INTO auteur VALUES 
--( 1,'TOTO','toto');

--INSERT INTO editeur VALUES 
--( 1,'Laforet','A' );

--INSERT INTO categorie(IdCategorie,NomCat) VALUES 
--( 1,'Romance');

--INSERT INTO document VALUES 
--( 1, 1, 1, 1,1,'Livre1','Y' );

