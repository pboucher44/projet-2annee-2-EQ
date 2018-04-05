-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 05 avr. 2018 à 12:59
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `festival`
--
CREATE DATABASE IF NOT EXISTS `festival` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `festival`;

-- --------------------------------------------------------

--
-- Structure de la table `attribution`
--

DROP TABLE IF EXISTS `attribution`;
CREATE TABLE IF NOT EXISTS `attribution` (
  `idEtab` char(8) COLLATE utf8_bin NOT NULL,
  `idTypeChambre` char(2) COLLATE utf8_bin NOT NULL,
  `idGroupe` char(4) COLLATE utf8_bin NOT NULL,
  `nombreChambres` int(11) NOT NULL,
  PRIMARY KEY (`idEtab`,`idTypeChambre`,`idGroupe`),
  KEY `idTypeChambre` (`idTypeChambre`),
  KEY `idGroupe` (`idGroupe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `attribution`
--

INSERT INTO `attribution` (`idEtab`, `idTypeChambre`, `idGroupe`, `nombreChambres`) VALUES
('0350773A', 'C2', 'g004', 2),
('0350773A', 'C3', 'g005', 1),
('0350785N', 'C1', 'g001', 1),
('0350785N', 'C1', 'g002', 2),
('0350785N', 'C1', 'g003', 2),
('0350785N', 'C2', 'g001', 2),
('0350785N', 'C2', 'g002', 1),
('0350785N', 'C3', 'g001', 2),
('0350785N', 'C3', 'g002', 1),
('0352072M', 'C1', 'g006', 1),
('0352072M', 'C2', 'g007', 3),
('0352072M', 'C3', 'g006', 3);

-- --------------------------------------------------------

--
-- Structure de la table `etablissement`
--

DROP TABLE IF EXISTS `etablissement`;
CREATE TABLE IF NOT EXISTS `etablissement` (
  `id` char(8) COLLATE utf8_bin NOT NULL,
  `nom` varchar(45) COLLATE utf8_bin NOT NULL,
  `adresseRue` varchar(45) COLLATE utf8_bin NOT NULL,
  `codePostal` char(5) COLLATE utf8_bin NOT NULL,
  `ville` varchar(35) COLLATE utf8_bin NOT NULL,
  `tel` varchar(13) COLLATE utf8_bin NOT NULL,
  `adresseElectronique` varchar(70) COLLATE utf8_bin DEFAULT NULL,
  `type` tinyint(4) NOT NULL,
  `civiliteResponsable` varchar(12) COLLATE utf8_bin NOT NULL,
  `nomResponsable` varchar(25) COLLATE utf8_bin NOT NULL,
  `prenomResponsable` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `etablissement`
--

INSERT INTO `etablissement` (`id`, `nom`, `adresseRue`, `codePostal`, `ville`, `tel`, `adresseElectronique`, `type`, `civiliteResponsable`, `nomResponsable`, `prenomResponsable`) VALUES
('0350773A', 'Collège Ste Jeanne d\'Arc-Choisy', '3, avenue de la Borderie BP 32', '35404', 'Paramé', '0299560159', '', 1, 'Madame', 'LEFORT', 'Anne'),
('0350773Z', 'ollège Ste Jeanne d\'Arc-Choisyy', '3, avenue de la Borderie BP 326', '44400', 'dqsdqs', '0299560159', 'test@hotmail.fr', 0, 'Monsieur', 'LEFORT', 'qsdsqd'),
('0350785N', 'Collège de Moka', '2 avenue Aristide Briand BP 6', '35401', 'Saint-Malo', '0299206990', '', 1, 'Monsieur', 'DUPONT', 'Alain'),
('0352072M', 'Institution Saint-Malo Providence', '2 rue du collège BP 31863', '35418', 'Saint-Malo', '0299407474', NULL, 1, 'Monsieur', 'Durand', 'Pierre'),
('11111111', 'Centre de rencontres internationales', '37 avenue du R.P. Umbricht BP 108', '35407', 'Saint-Malo', '0299000000', NULL, 0, 'Monsieur', 'Guenroc', 'Guy');

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `id` char(4) COLLATE utf8_bin NOT NULL,
  `nom` varchar(40) COLLATE utf8_bin NOT NULL,
  `identiteResponsable` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `adressePostale` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `nombrePersonnes` int(11) NOT NULL,
  `nomPays` varchar(40) COLLATE utf8_bin NOT NULL,
  `hebergement` char(1) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`id`, `nom`, `identiteResponsable`, `adressePostale`, `nombrePersonnes`, `nomPays`, `hebergement`) VALUES
('g001', 'Groupe folklorique du Bachkortostan', NULL, NULL, 40, 'Bachkirie', 'O'),
('g002', 'Marina Prudencio Chavez', NULL, NULL, 25, 'Bolivie', 'O'),
('g003', 'Nangola Bahia de Salvador', NULL, NULL, 34, 'Brésil', 'O'),
('g004', 'Bizone de Kawarma', NULL, NULL, 38, 'Bulgarie', 'O'),
('g005', 'Groupe folklorique camerounais', NULL, NULL, 22, 'Cameroun', 'O'),
('g006', 'Syoung Yaru Mask Dance Group', NULL, NULL, 29, 'Corée du Sud', 'O'),
('g007', 'Pipe Band', NULL, NULL, 19, 'Ecosse', 'O'),
('g008', 'Aira da Pedra', NULL, NULL, 5, 'Espagne', 'O'),
('g009', 'The Jersey Caledonian Pipe Band', NULL, NULL, 21, 'Jersey', 'O'),
('g010', 'Groupe folklorique des Émirats', NULL, NULL, 30, 'Emirats arabes unis', 'O'),
('g011', 'Groupe folklorique mexicain', NULL, NULL, 38, 'Mexique', 'O'),
('g012', 'Groupe folklorique de Panama', NULL, NULL, 22, 'Panama', 'O'),
('g013', 'Groupe folklorique papou', NULL, NULL, 13, 'Papouasie', 'O'),
('g014', 'Paraguay Ete', NULL, NULL, 26, 'Paraguay', 'O'),
('g015', 'La Tuque Bleue', NULL, NULL, 8, 'Québec', 'O'),
('g016', 'Ensemble Leissen de Oufa', NULL, NULL, 40, 'République de Bachkirie', 'O'),
('g017', 'Groupe folklorique turc', NULL, NULL, 40, 'Turquie', 'O'),
('g018', 'Groupe folklorique russe', NULL, NULL, 43, 'Russie', 'O'),
('g019', 'Ruhunu Ballet du village de Kosgoda', NULL, NULL, 27, 'Sri Lanka', 'O'),
('g020', 'L\'Alen', NULL, NULL, 34, 'France - Provence', 'O'),
('g021', 'L\'escolo Di Tourre', NULL, NULL, 40, 'France - Provence', 'O'),
('g022', 'Deloubes Kévin', NULL, NULL, 1, 'France - Bretagne', 'O'),
('g023', 'Daonie See', NULL, NULL, 5, 'France - Bretagne', 'O'),
('g024', 'Boxty', NULL, NULL, 5, 'France - Bretagne', 'O'),
('g025', 'Soeurs Chauvel', NULL, NULL, 2, 'France - Bretagne', 'O'),
('g026', 'Cercle Gwik Alet', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g027', 'Bagad Quic En Groigne', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g028', 'Penn Treuz', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g029', 'Savidan Launay', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g030', 'Cercle Boked Er Lann', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g031', 'Bagad Montfortais', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g032', 'Vent de Noroise', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g033', 'Cercle Strollad', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g034', 'Bagad An Hanternoz', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g035', 'Cercle Ar Vro Melenig', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g036', 'Cercle An Abadenn Nevez', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g037', 'Kerc\'h Keltiek Roazhon', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g038', 'Bagad Plougastel', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g039', 'Bagad Nozeganed Bro Porh-Loeiz', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g040', 'Bagad Nozeganed Bro Porh-Loeiz', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g041', 'Jackie Molard Quartet', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g042', 'Deomp', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g043', 'Cercle Olivier de Clisson', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g044', 'Kan Tri', NULL, NULL, 0, 'France - Bretagne', 'N');

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
  `id` int(2) NOT NULL,
  `nom` varchar(45) COLLATE utf8_bin NOT NULL,
  `adresse` varchar(82) COLLATE utf8_bin NOT NULL,
  `capaciteAccueil` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `lieu`
--

INSERT INTO `lieu` (`id`, `nom`, `adresse`, `capaciteAccueil`) VALUES
(1, 'Salle du panier fleuri', 'Rue de Bonneville', 450),
(2, 'Le Cabaret', 'Mairie Annexe De Parame,Place Georges Coudray', 250),
(3, 'Le Parc Des Chênes', '14 Rue des Chênes', 2000),
(4, 'Ecole Legatelois, 25 Rue Général de Castelnau', '14 Rue des Chênes', 500);

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

DROP TABLE IF EXISTS `offre`;
CREATE TABLE IF NOT EXISTS `offre` (
  `idEtab` char(8) COLLATE utf8_bin NOT NULL,
  `idTypeChambre` char(2) COLLATE utf8_bin NOT NULL,
  `nombreChambres` int(11) NOT NULL,
  PRIMARY KEY (`idEtab`,`idTypeChambre`),
  KEY `idTypeChambre` (`idTypeChambre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`idEtab`, `idTypeChambre`, `nombreChambres`) VALUES
('0350773A', 'C2', 15),
('0350773A', 'C3', 1),
('0350785N', 'C1', 5),
('0350785N', 'C2', 10),
('0350785N', 'C3', 5),
('0352072M', 'C1', 5),
('0352072M', 'C2', 10),
('0352072M', 'C3', 3);

-- --------------------------------------------------------

--
-- Structure de la table `representation`
--

DROP TABLE IF EXISTS `representation`;
CREATE TABLE IF NOT EXISTS `representation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `Lieu` int(2) NOT NULL,
  `Groupe` char(4) COLLATE utf8_bin NOT NULL,
  `heuredebut` time NOT NULL,
  `heurefin` time NOT NULL,
  `places_dispo` int(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Lieu` (`Lieu`),
  KEY `FK_Groupe` (`Groupe`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `representation`
--

INSERT INTO `representation` (`id`, `date`, `Lieu`, `Groupe`, `heuredebut`, `heurefin`, `places_dispo`) VALUES
(1, '2018-07-11', 1, 'g019', '21:45:00', '23:00:00', 396),
(2, '2018-07-11', 2, 'g006', '20:30:00', '21:00:00', 250),
(3, '2017-07-11', 3, 'g027', '11:00:00', '12:00:00', 2000),
(4, '2017-07-11', 3, 'g030', '12:00:00', '13:00:00', 2000),
(5, '2017-07-12', 1, 'g008', '20:30:00', '22:00:00', 450),
(6, '2017-07-12', 1, 'g009', '22:15:00', '23:30:00', 450),
(7, '2017-07-12', 2, 'g016', '20:00:00', '23:00:00', 250),
(8, '2017-07-13', 1, 'g012', '20:30:00', '22:00:00', 450),
(9, '2017-07-13', 2, 'g018', '20:30:00', '21:45:00', 250),
(10, '2017-07-14', 1, 'g020', '19:30:00', '21:00:00', 450),
(11, '2018-07-14', 1, 'g022', '21:15:00', '23:00:00', 450),
(12, '2017-07-14', 3, 'g010', '14:00:00', '14:30:00', 2000),
(13, '2017-07-14', 3, 'g011', '14:30:00', '15:00:00', 2000),
(14, '2017-07-14', 3, 'g013', '15:30:00', '16:00:00', 2000),
(15, '2017-07-14', 3, 'g017', '16:00:00', '16:30:00', 2000),
(16, '2017-07-14', 4, 'g028', '11:00:00', '12:00:00', 500),
(17, '2017-07-14', 4, 'g014', '15:00:00', '17:00:00', 500),
(18, '2017-07-14', 4, 'g024', '15:00:00', '17:00:00', 500),
(19, '2017-07-15', 4, 'g025', '15:00:00', '16:00:00', 500),
(20, '2017-07-15', 4, 'g029', '16:30:00', '19:00:00', 500);

-- --------------------------------------------------------

--
-- Structure de la table `typechambre`
--

DROP TABLE IF EXISTS `typechambre`;
CREATE TABLE IF NOT EXISTS `typechambre` (
  `id` char(2) COLLATE utf8_bin NOT NULL,
  `libelle` varchar(15) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `typechambre`
--

INSERT INTO `typechambre` (`id`, `libelle`) VALUES
('C1', '1 lit'),
('C2', '2 à 3 lits'),
('C3', '4 à 5 lits'),
('C4', '6 à 8 lits'),
('C5', '8 à 12 lits');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL,
  `login` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `motDePasse` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `prenom` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `login`, `motDePasse`, `nom`, `prenom`) VALUES
(1, 'btssio', '017fe3a523712ceba7cde169653316e9', 'Pierre', 'Boucher'),
(2, 'joliverie', '2d15fa8b5394c2f25a7a8ecd62c9ae2f', 'Theo', 'Berthome');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `attribution`
--
ALTER TABLE `attribution`
  ADD CONSTRAINT `fk1_Attribution` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`id`),
  ADD CONSTRAINT `fk2_Attribution` FOREIGN KEY (`idEtab`,`idTypeChambre`) REFERENCES `offre` (`idEtab`, `idTypeChambre`);

--
-- Contraintes pour la table `offre`
--
ALTER TABLE `offre`
  ADD CONSTRAINT `fk1_Offre` FOREIGN KEY (`idEtab`) REFERENCES `etablissement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2_Offre` FOREIGN KEY (`idTypeChambre`) REFERENCES `typechambre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `representation`
--
ALTER TABLE `representation`
  ADD CONSTRAINT `FK_Groupe` FOREIGN KEY (`Groupe`) REFERENCES `groupe` (`id`),
  ADD CONSTRAINT `FK_Lieu` FOREIGN KEY (`Lieu`) REFERENCES `lieu` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
