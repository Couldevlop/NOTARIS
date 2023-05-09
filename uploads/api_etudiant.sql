-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 09 mars 2023 à 22:50
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `resapi1`
--

-- --------------------------------------------------------

--
-- Structure de la table `api_etudiant`
--

CREATE TABLE `api_etudiant` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `lieu_naiss` varchar(255) DEFAULT NULL,
  `naiss` date DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nom_mere` varchar(255) DEFAULT NULL,
  `nom_pere` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `quartier` varchar(255) DEFAULT NULL,
  `tel_parent` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `api_etudiant`
--

INSERT INTO `api_etudiant` (`id`, `email`, `lieu_naiss`, `naiss`, `nom`, `nom_mere`, `nom_pere`, `prenom`, `quartier`, `tel_parent`, `telephone`, `ville`) VALUES
(1, 'coulwao@gmail.com', 'KATIOLA', '1987-05-01', 'COULIBALY', 'OUATTARA YERAYEWA ROSALIE', 'COULIBALY PELIBIN JOSEPH', 'WAOPRON THOMAS', 'Niemonkaha', '0408524512', '0709320594', 'KATIOLA'),
(2, 'jchrist@gmail.com', 'KATIOLA', '2009-09-01', 'COULIBALY', 'HILI POTAGNOU LOUISE', 'COULIBALY WAOPRON', 'JEAN-CHRIST', 'Niemonkaha', '0478451202', '0709320594', 'KATIOLA'),
(3, 'kone@gmail.com', 'NIAKARA', '1879-09-01', 'KONE', 'COULIBALY SITA', 'KONE SOUNAN', 'OBONAN', 'Gnagbo', '020145784', '0909320594', 'NIAKARA'),
(4, 'enock@gmail.com', 'BOUAKE', '2020-09-01', 'OUATTARA', 'ZADI GILIETTE', 'OUATTARA YVES', 'ENOCK', 'Broukro', '045478451', '0700320094', 'BOUAKE'),
(5, 'yanick@gmail.com', 'FRANCE', '2003-09-01', 'IRIE BI', 'ELISA DU POND', 'IRIE-BI GAUTHIER', 'YANICK', 'Toulouse', '070784512', '0619245329', 'FRANCE'),
(7, 'marcelin@gmail.com', 'DIMBOKRO', '1893-05-12', 'KOFFI', 'KOUAME AKISSI BERNADETTE', 'KOFFI KOUADIO ARMAND', 'MARCELIN', 'Koffikro', '089854541', '047845120', 'DIMBOKRO');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `api_etudiant`
--
ALTER TABLE `api_etudiant`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
