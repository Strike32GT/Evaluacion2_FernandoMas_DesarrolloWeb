-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-10-2025 a las 23:14:05
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `HospitalDB`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `AntecedenteMedico`
--

CREATE TABLE `AntecedenteMedico` (
  `idAntecedente` bigint(20) NOT NULL,
  `idHistoria` bigint(20) NOT NULL,
  `tipo` enum('alergias','enfermedades previas','cirugias') NOT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Bitacora`
--

CREATE TABLE `Bitacora` (
  `idBitacora` bigint(20) NOT NULL,
  `idUsuario` bigint(20) NOT NULL,
  `accion` text DEFAULT NULL,
  `fechaHora` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cita`
--

CREATE TABLE `Cita` (
  `idCita` bigint(20) NOT NULL,
  `idPaciente` bigint(20) NOT NULL,
  `idMedico` bigint(20) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `motivo` varchar(200) DEFAULT NULL,
  `estado` enum('programada','atendida','cancelada') DEFAULT 'programada'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Consulta`
--

CREATE TABLE `Consulta` (
  `idConsulta` bigint(20) NOT NULL,
  `idCita` bigint(20) NOT NULL,
  `idMedico` bigint(20) NOT NULL,
  `idPaciente` bigint(20) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `motivoConsulta` varchar(200) DEFAULT NULL,
  `observaciones` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DetalleFactura`
--

CREATE TABLE `DetalleFactura` (
  `idDetalleFactura` bigint(20) NOT NULL,
  `idFactura` bigint(20) NOT NULL,
  `concepto` varchar(100) DEFAULT NULL,
  `monto` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DetalleReceta`
--

CREATE TABLE `DetalleReceta` (
  `idDetalleReceta` bigint(20) NOT NULL,
  `idReceta` bigint(20) NOT NULL,
  `medicamento` varchar(100) NOT NULL,
  `dosis` varchar(50) DEFAULT NULL,
  `frecuencia` varchar(50) DEFAULT NULL,
  `duracion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Diagnostico`
--

CREATE TABLE `Diagnostico` (
  `idDiagnostico` bigint(20) NOT NULL,
  `idConsulta` bigint(20) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `tipo` enum('presuntivo','definitivo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Especialidad`
--

CREATE TABLE `Especialidad` (
  `idEspecialidad` bigint(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Especialidad`
--

INSERT INTO `Especialidad` (`idEspecialidad`, `nombre`, `descripcion`) VALUES
(1, 'Cardiología', 'Diagnóstico y tratamiento de enfermedades del corazón y del sistema circulatorio.'),
(2, 'Pediatría', 'Atención médica a bebés, niños y adolescentes.'),
(3, 'Dermatología', 'Tratamiento de enfermedades de la piel, cabello y uñas.'),
(4, 'Neurología', 'Diagnóstico y tratamiento de trastornos del sistema nervioso.'),
(5, 'Ginecología', 'Atención médica del sistema reproductor femenino.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Factura`
--

CREATE TABLE `Factura` (
  `idFactura` bigint(20) NOT NULL,
  `idPaciente` bigint(20) NOT NULL,
  `fechaEmision` date NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `estado` enum('pendiente','pagado') DEFAULT 'pendiente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Habitacion`
--

CREATE TABLE `Habitacion` (
  `idHabitacion` bigint(20) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `tipo` enum('UCI','general','emergencia') NOT NULL,
  `estado` enum('disponible','ocupada','mantenimiento') DEFAULT 'disponible'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Habitacion`
--

INSERT INTO `Habitacion` (`idHabitacion`, `numero`, `tipo`, `estado`) VALUES
(1, '101', 'UCI', 'disponible'),
(2, '102', 'general', 'disponible'),
(3, '103', 'emergencia', 'mantenimiento'),
(4, '104', 'general', 'ocupada'),
(5, '105', 'UCI', 'disponible'),
(7, '109', 'UCI', 'mantenimiento');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `HistoriaClinica`
--

CREATE TABLE `HistoriaClinica` (
  `idHistoria` bigint(20) NOT NULL,
  `idPaciente` bigint(20) NOT NULL,
  `fechaApertura` date NOT NULL,
  `observaciones` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Hospitalizacion`
--

CREATE TABLE `Hospitalizacion` (
  `idHosp` bigint(20) NOT NULL,
  `idPaciente` bigint(20) NOT NULL,
  `idHabitacion` bigint(20) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `fechaAlta` date DEFAULT NULL,
  `diagnosticoIngreso` text DEFAULT NULL,
  `estado` enum('activo','dado de alta') DEFAULT 'activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Medico`
--

CREATE TABLE `Medico` (
  `idMedico` bigint(20) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `colegiatura` varchar(20) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `estado` enum('activo','inactivo') DEFAULT 'activo',
  `idUsuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Medico`
--

INSERT INTO `Medico` (`idMedico`, `nombres`, `apellidos`, `colegiatura`, `telefono`, `correo`, `estado`, `idUsuario`) VALUES
(1, 'Carlos', 'Ramírez Torres', 'CMP12345', '987654321', 'carlos.ramirez@hospital.com', 'activo', 2),
(2, 'Lucía', 'Mendoza Pérez', 'CMP67890', '956741258', 'lucia.mendoza@hospital.com', 'activo', 5),
(3, 'José', 'Huamán Díaz', 'CMP54321', '912345678', 'jose.huaman@hospital.com', 'inactivo', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `MedicoEspecialidad`
--

CREATE TABLE `MedicoEspecialidad` (
  `idMedicoEsp` bigint(20) NOT NULL,
  `idMedico` bigint(20) NOT NULL,
  `idEspecialidad` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Paciente`
--

CREATE TABLE `Paciente` (
  `idPaciente` bigint(20) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `estado` enum('activo','inactivo') DEFAULT 'activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Paciente`
--

INSERT INTO `Paciente` (`idPaciente`, `dni`, `nombres`, `apellidos`, `fechaNacimiento`, `sexo`, `direccion`, `telefono`, `correo`, `estado`) VALUES
(1, '12345678', 'Juan', 'Peres', '1989-05-10', 'M', 'Av. Siempre Viva 123', '987654321', 'juan.perez@example.com', 'activo'),
(2, '87654321', 'Maria', 'Lopez', '1985-12-01', 'F', 'Calle Falsa 456', '912345678', 'maria.lopez@example.com', 'activo'),
(11, '71738450', 'Piero', 'Capcha', '2001-03-15', 'M', 'Av.Cascanueces', '987543210', 'piero_capcha@gmail.com', 'inactivo'),
(12, '74789440', 'Isabella', 'Ramirez Suniga', '2006-05-04', 'F', 'Jr.Lince 42', '999888777', 'isabella_sun@gmail.com', 'inactivo'),
(13, '75735541', 'Allison', 'Malma ', '2006-09-21', 'F', 'Jr.Miraflores 84', '111222333', 'alli_mal@gmail.com', 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `RecetaMedica`
--

CREATE TABLE `RecetaMedica` (
  `idReceta` bigint(20) NOT NULL,
  `idConsulta` bigint(20) NOT NULL,
  `indicaciones` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE `Usuario` (
  `idUsuario` bigint(20) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` enum('admin','medico','recepcionista','enfermera') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Usuario`
--

INSERT INTO `Usuario` (`idUsuario`, `nombreUsuario`, `password`, `rol`) VALUES
(1, 'admin_oficial', 'admin123', 'admin'),
(2, 'Medico-Carlos', 'medCarlos123', 'medico'),
(3, 'recep1', 'recep123', 'recepcionista'),
(4, 'enfermera1', 'enfer123', 'enfermera'),
(5, 'Medico-Lucia', 'medLucia123', 'medico'),
(6, 'Medico-Jose', 'medJose123', 'medico');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `AntecedenteMedico`
--
ALTER TABLE `AntecedenteMedico`
  ADD PRIMARY KEY (`idAntecedente`),
  ADD KEY `idHistoria` (`idHistoria`);

--
-- Indices de la tabla `Bitacora`
--
ALTER TABLE `Bitacora`
  ADD PRIMARY KEY (`idBitacora`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `Cita`
--
ALTER TABLE `Cita`
  ADD PRIMARY KEY (`idCita`),
  ADD KEY `idPaciente` (`idPaciente`),
  ADD KEY `idMedico` (`idMedico`);

--
-- Indices de la tabla `Consulta`
--
ALTER TABLE `Consulta`
  ADD PRIMARY KEY (`idConsulta`),
  ADD KEY `idCita` (`idCita`),
  ADD KEY `idMedico` (`idMedico`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `DetalleFactura`
--
ALTER TABLE `DetalleFactura`
  ADD PRIMARY KEY (`idDetalleFactura`),
  ADD KEY `idFactura` (`idFactura`);

--
-- Indices de la tabla `DetalleReceta`
--
ALTER TABLE `DetalleReceta`
  ADD PRIMARY KEY (`idDetalleReceta`),
  ADD KEY `idReceta` (`idReceta`);

--
-- Indices de la tabla `Diagnostico`
--
ALTER TABLE `Diagnostico`
  ADD PRIMARY KEY (`idDiagnostico`),
  ADD KEY `idConsulta` (`idConsulta`);

--
-- Indices de la tabla `Especialidad`
--
ALTER TABLE `Especialidad`
  ADD PRIMARY KEY (`idEspecialidad`);

--
-- Indices de la tabla `Factura`
--
ALTER TABLE `Factura`
  ADD PRIMARY KEY (`idFactura`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `Habitacion`
--
ALTER TABLE `Habitacion`
  ADD PRIMARY KEY (`idHabitacion`),
  ADD UNIQUE KEY `numero` (`numero`);

--
-- Indices de la tabla `HistoriaClinica`
--
ALTER TABLE `HistoriaClinica`
  ADD PRIMARY KEY (`idHistoria`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `Hospitalizacion`
--
ALTER TABLE `Hospitalizacion`
  ADD PRIMARY KEY (`idHosp`),
  ADD KEY `idPaciente` (`idPaciente`),
  ADD KEY `idHabitacion` (`idHabitacion`);

--
-- Indices de la tabla `Medico`
--
ALTER TABLE `Medico`
  ADD PRIMARY KEY (`idMedico`),
  ADD UNIQUE KEY `colegiatura` (`colegiatura`),
  ADD UNIQUE KEY `uq_medico_usuario` (`idUsuario`);

--
-- Indices de la tabla `MedicoEspecialidad`
--
ALTER TABLE `MedicoEspecialidad`
  ADD PRIMARY KEY (`idMedicoEsp`),
  ADD KEY `idMedico` (`idMedico`),
  ADD KEY `idEspecialidad` (`idEspecialidad`);

--
-- Indices de la tabla `Paciente`
--
ALTER TABLE `Paciente`
  ADD PRIMARY KEY (`idPaciente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `RecetaMedica`
--
ALTER TABLE `RecetaMedica`
  ADD PRIMARY KEY (`idReceta`),
  ADD KEY `idConsulta` (`idConsulta`);

--
-- Indices de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `nombreUsuario` (`nombreUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `AntecedenteMedico`
--
ALTER TABLE `AntecedenteMedico`
  MODIFY `idAntecedente` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Bitacora`
--
ALTER TABLE `Bitacora`
  MODIFY `idBitacora` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Cita`
--
ALTER TABLE `Cita`
  MODIFY `idCita` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Consulta`
--
ALTER TABLE `Consulta`
  MODIFY `idConsulta` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `DetalleFactura`
--
ALTER TABLE `DetalleFactura`
  MODIFY `idDetalleFactura` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `DetalleReceta`
--
ALTER TABLE `DetalleReceta`
  MODIFY `idDetalleReceta` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Diagnostico`
--
ALTER TABLE `Diagnostico`
  MODIFY `idDiagnostico` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Especialidad`
--
ALTER TABLE `Especialidad`
  MODIFY `idEspecialidad` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `Factura`
--
ALTER TABLE `Factura`
  MODIFY `idFactura` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Habitacion`
--
ALTER TABLE `Habitacion`
  MODIFY `idHabitacion` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `HistoriaClinica`
--
ALTER TABLE `HistoriaClinica`
  MODIFY `idHistoria` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Hospitalizacion`
--
ALTER TABLE `Hospitalizacion`
  MODIFY `idHosp` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Medico`
--
ALTER TABLE `Medico`
  MODIFY `idMedico` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `MedicoEspecialidad`
--
ALTER TABLE `MedicoEspecialidad`
  MODIFY `idMedicoEsp` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Paciente`
--
ALTER TABLE `Paciente`
  MODIFY `idPaciente` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `RecetaMedica`
--
ALTER TABLE `RecetaMedica`
  MODIFY `idReceta` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `idUsuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `AntecedenteMedico`
--
ALTER TABLE `AntecedenteMedico`
  ADD CONSTRAINT `AntecedenteMedico_ibfk_1` FOREIGN KEY (`idHistoria`) REFERENCES `HistoriaClinica` (`idHistoria`);

--
-- Filtros para la tabla `Bitacora`
--
ALTER TABLE `Bitacora`
  ADD CONSTRAINT `Bitacora_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`);

--
-- Filtros para la tabla `Cita`
--
ALTER TABLE `Cita`
  ADD CONSTRAINT `Cita_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`idPaciente`),
  ADD CONSTRAINT `Cita_ibfk_2` FOREIGN KEY (`idMedico`) REFERENCES `Medico` (`idMedico`);

--
-- Filtros para la tabla `Consulta`
--
ALTER TABLE `Consulta`
  ADD CONSTRAINT `Consulta_ibfk_1` FOREIGN KEY (`idCita`) REFERENCES `Cita` (`idCita`),
  ADD CONSTRAINT `Consulta_ibfk_2` FOREIGN KEY (`idMedico`) REFERENCES `Medico` (`idMedico`),
  ADD CONSTRAINT `Consulta_ibfk_3` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`idPaciente`);

--
-- Filtros para la tabla `DetalleFactura`
--
ALTER TABLE `DetalleFactura`
  ADD CONSTRAINT `DetalleFactura_ibfk_1` FOREIGN KEY (`idFactura`) REFERENCES `Factura` (`idFactura`);

--
-- Filtros para la tabla `DetalleReceta`
--
ALTER TABLE `DetalleReceta`
  ADD CONSTRAINT `DetalleReceta_ibfk_1` FOREIGN KEY (`idReceta`) REFERENCES `RecetaMedica` (`idReceta`);

--
-- Filtros para la tabla `Diagnostico`
--
ALTER TABLE `Diagnostico`
  ADD CONSTRAINT `Diagnostico_ibfk_1` FOREIGN KEY (`idConsulta`) REFERENCES `Consulta` (`idConsulta`);

--
-- Filtros para la tabla `Factura`
--
ALTER TABLE `Factura`
  ADD CONSTRAINT `Factura_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`idPaciente`);

--
-- Filtros para la tabla `HistoriaClinica`
--
ALTER TABLE `HistoriaClinica`
  ADD CONSTRAINT `HistoriaClinica_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`idPaciente`);

--
-- Filtros para la tabla `Hospitalizacion`
--
ALTER TABLE `Hospitalizacion`
  ADD CONSTRAINT `Hospitalizacion_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`idPaciente`),
  ADD CONSTRAINT `Hospitalizacion_ibfk_2` FOREIGN KEY (`idHabitacion`) REFERENCES `Habitacion` (`idHabitacion`);

--
-- Filtros para la tabla `Medico`
--
ALTER TABLE `Medico`
  ADD CONSTRAINT `fk_medico_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `MedicoEspecialidad`
--
ALTER TABLE `MedicoEspecialidad`
  ADD CONSTRAINT `MedicoEspecialidad_ibfk_1` FOREIGN KEY (`idMedico`) REFERENCES `Medico` (`idMedico`),
  ADD CONSTRAINT `MedicoEspecialidad_ibfk_2` FOREIGN KEY (`idEspecialidad`) REFERENCES `Especialidad` (`idEspecialidad`);

--
-- Filtros para la tabla `RecetaMedica`
--
ALTER TABLE `RecetaMedica`
  ADD CONSTRAINT `RecetaMedica_ibfk_1` FOREIGN KEY (`idConsulta`) REFERENCES `Consulta` (`idConsulta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
