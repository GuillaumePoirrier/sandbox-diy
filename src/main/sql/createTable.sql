CREATE TABLE `article` (
  `idarticle` int(11) NOT NULL,
  `nomarticle` varchar(45) DEFAULT NULL,
  `contenu` varchar(10000) DEFAULT NULL,
  `dateajout` timestamp NULL DEFAULT NULL,
  `idcategorie` int(11) DEFAULT NULL,
  `idauthor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idarticle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `article_has_tag` (
  `idarticle_has_tag` int(11) NOT NULL,
  `idarticle` int(11) DEFAULT NULL,
  `idtag` int(11) DEFAULT NULL,
  PRIMARY KEY (`idarticle_has_tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `author` (
  `idauthor` int(11) NOT NULL,
  `authorname` varchar(45) DEFAULT NULL,
  `authorbio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idauthor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `categorie` (
  `idcategorie` int(11) NOT NULL,
  `nomcategorie` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tag` (
  `idtag` int(11) NOT NULL,
  `tagname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
