-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-05-2014 a las 22:25:19
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `estudent`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asiste`
--

CREATE TABLE IF NOT EXISTS `asiste` (
  `codigo` int(10) NOT NULL DEFAULT '0',
  `cedula` int(20) DEFAULT NULL,
  `curso` int(10) DEFAULT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `cedula` (`cedula`),
  KEY `curso` (`curso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE IF NOT EXISTS `curso` (
  `codigo` int(10) NOT NULL DEFAULT '0',
  `curso` varchar(30) DEFAULT NULL,
  `nivel` tinytext,
  `dias` int(3) DEFAULT NULL,
  `dinicio` varchar(10) DEFAULT NULL,
  `dfinal` varchar(10) DEFAULT NULL,
  `instructor` varchar(10) DEFAULT NULL,
  `cupo` int(10) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`codigo`, `curso`, `nivel`, `dias`, `dinicio`, `dfinal`, `instructor`, `cupo`) VALUES
(18116, 'natacion', 'conceptos basicos de natacion', 0, '2014-05-11', '2014-05-24', '987654321', 22),
(35403, 'capoheira', 'conceptos basicos', 0, '2014-05-23', '2014-05-31', '987654321', 23),
(42017, 'dance', 'aprenda a bailar', 0, '2014-05-11', '2014-05-11', '1092352729', 12),
(52599, 'gimnacia', 'conceptos basicos de gimancia', 0, '2014-05-23', '2014-05-31', '987654321', 10),
(54280, 'aerobicos', 'actividad de aerobicos', 0, '2014-05-22', '2014-05-31', '987654321', 23),
(54997, 'spinning', 'aprenda spinning ', 0, '2014-05-11', '2014-05-11', '987654321', 12),
(58785, 'danzas pacificas', 'conceptos basicos ', 0, '2014-05-11', '2014-05-30', '1092352729', 23),
(105286, 'danzas ', 'conceptos avanzados de dabnzas', 0, '2014-05-13', '2014-05-23', '987654321', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formacion`
--

CREATE TABLE IF NOT EXISTS `formacion` (
  `codigo` int(8) NOT NULL DEFAULT '0',
  `curso` int(10) DEFAULT NULL,
  `inicio` varchar(10) DEFAULT NULL,
  `final` varchar(10) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `curso` (`curso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `rol` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`rol`) VALUES
('Estudiante'),
('Instructor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sexo`
--

CREATE TABLE IF NOT EXISTS `sexo` (
  `sexo` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`sexo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sexo`
--

INSERT INTO `sexo` (`sexo`) VALUES
('hombre'),
('mujer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `cedula` int(15) NOT NULL DEFAULT '0',
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `roll` varchar(15) DEFAULT NULL,
  `clave` tinytext,
  PRIMARY KEY (`cedula`),
  KEY `sexo` (`sexo`),
  KEY `roll` (`roll`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`cedula`, `nombre`, `apellido`, `sexo`, `email`, `telefono`, `roll`, `clave`) VALUES
(65498, 'juan', 'silva', 'hombre', 'silvaj@gmail.com', '365451', 'Estudiante', 'oxm2q'),
(123456, 'edgar', 'rodriguez', 'hombre', NULL, '6541346', 'Instructor', '123456'),
(654981, 'cesar ', 'rodriguez', 'hombre', 'cesarr@gmail.com', '6549841', 'Estudiante', 'oxm2q'),
(2852546, 'diana', 'mantilla', 'mujer', 'mantidi@gmail.com', '26516854', 'Estudiante', 'oxm2q'),
(32165132, 'carlos', 'torres', 'hombre', 'torresfa@gmail.com', '65496813', 'Estudiante', 'oxm2q'),
(65498132, 'jeisson', 'lopez', 'hombre', 'jesiion@hotmail.com', '65469843656', 'Estudiante', 'oxm2q'),
(69632032, 'patricia', 'salamanca', 'mujer', 'patty@gmail.com', '3654951', 'Estudiante', 'oxm2q'),
(123456789, 'prueba', 'prueba', 'hombre', 'farvher@yahoo.com', '3246541', 'Estudiante', 'oxm2q'),
(987654321, 'instructor', 'prueba', 'hombre', 'farvher@yahoo.com', '3246541', 'Instructor', 'oxm2q'),
(1019098618, 'yessika', 'real', 'mujer', 'yesik@misena.edu.co', '12345342', 'Estudiante', '123456'),
(1092312312, 'diego', 'lopez', 'hombre', NULL, '123456', 'Estudiante', '123456'),
(1092352729, 'daniel', 'oliveros', 'hombre', 'astarot@gmail.com', '3204332700', 'Estudiante', '123456'),
(1092352730, 'johana', 'lopez', 'mujer', 'joha@gmail.com', '3001231231', 'Instructor', '123456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_curso`
--

CREATE TABLE IF NOT EXISTS `user_curso` (
  `id` int(11) NOT NULL DEFAULT '0',
  `cedula` int(15) DEFAULT NULL,
  `codigo` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `codigo` (`codigo`),
  KEY `cedula` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user_curso`
--

INSERT INTO `user_curso` (`id`, `cedula`, `codigo`) VALUES
(257, 1092352729, 54997),
(359, 123456789, 105286),
(417, 123456789, 54997),
(675, 123456789, 18116),
(2321, 32165132, 52599),
(3423, 32165132, 54997),
(4312, 1092352729, 54997),
(4321, 1092312312, 58785),
(42312, 2852546, 54280),
(54645, 654981, 58785),
(65654, 1019098618, 54280),
(67867, 1092352729, 58785);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asiste`
--
ALTER TABLE `asiste`
  ADD CONSTRAINT `asiste_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `user` (`cedula`),
  ADD CONSTRAINT `asiste_ibfk_3` FOREIGN KEY (`curso`) REFERENCES `curso` (`codigo`);

--
-- Filtros para la tabla `formacion`
--
ALTER TABLE `formacion`
  ADD CONSTRAINT `formacion_ibfk_1` FOREIGN KEY (`curso`) REFERENCES `curso` (`codigo`);

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`sexo`) REFERENCES `sexo` (`sexo`),
  ADD CONSTRAINT `user_ibfk_4` FOREIGN KEY (`roll`) REFERENCES `rol` (`rol`);

--
-- Filtros para la tabla `user_curso`
--
ALTER TABLE `user_curso`
  ADD CONSTRAINT `user_curso_ibfk_1` FOREIGN KEY (`codigo`) REFERENCES `curso` (`codigo`),
  ADD CONSTRAINT `user_curso_ibfk_2` FOREIGN KEY (`cedula`) REFERENCES `user` (`cedula`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
