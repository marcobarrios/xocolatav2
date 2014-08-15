-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-08-2014 a las 19:02:27
-- Versión del servidor: 5.6.14
-- Versión de PHP: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `xocolata`
--
CREATE DATABASE IF NOT EXISTS `xocolata` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `xocolata`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `cantidadDetalleClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadDetalleClientes`(IN `dato` VARCHAR(45))
begin
select count(tblDetalleTransaccionClientes.idDetalleTransaccionClientes) from tblDetalleTransaccionClientes
inner join tblTransaccionClientes on tblDetalleTransaccionClientes.idTransaccionCliente = tblTransaccionClientes.idTransaccionCliente
where  tblTransaccionClientes.idTransaccionCliente = (select max(tblTransaccionClientes.idTransaccionCliente) from tblTransaccionClientes);
end$$

DROP PROCEDURE IF EXISTS `cantidadDetalleVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadDetalleVendedores`(in dato varchar(45))
begin
select count(tblDetalleTransaccionVendedores.idDetalleTransaccionVendedor) from tblDetalleTransaccionVendedores
inner join tblTransaccionVendedores on tblDetalleTransaccionVendedores.idTransaccionVendedor = tblTransaccionVendedores.idTransaccionVendedor
where  tblTransaccionVendedores.idTransaccionVendedor = (select max(tblTransaccionVendedores.idTransaccionVendedor) from tblTransaccionVendedores);
end$$

DROP PROCEDURE IF EXISTS `cantidadDevolucionProductoVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadDevolucionProductoVendedores`(in dato varchar(45))
begin
select count(tblDetalleTransaccionVendedores.idTransaccionVendedor) from tblDetalleTransaccionVendedores
inner join tblTransaccionVendedores on tblTransaccionVendedores.idTransaccionVendedor = tblDetalleTransaccionVendedores.idTransaccionVendedor
inner join tblProductos on tblProductos.idProducto = tblDetalleTransaccionVendedores.idProducto
where tblProductos.idEstadoProducto = 3 and tblTransaccionVendedores.codigoTransaccion= dato;
end$$

DROP PROCEDURE IF EXISTS `cantidadInventarioGeneral`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadInventarioGeneral`(in dato varchar(45))
begin 
select count(codigoProducto) from tblProductos
where idEstadoProducto = 1;
end$$

DROP PROCEDURE IF EXISTS `cantidadInvetarioMarcas`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadInvetarioMarcas`(in dato varchar(45))
begin 
select count(codigoProducto) from tblProductos
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
where idEstadoProducto = 1 and tblMarcas.Marca = dato;
end$$

DROP PROCEDURE IF EXISTS `cantidadInvetarioTalla`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadInvetarioTalla`(in dato varchar(45))
begin 
select count(codigoProducto) from tblProductos
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
where idEstadoProducto = 1 and tblTallas.Talla = dato;
end$$

DROP PROCEDURE IF EXISTS `cantidadInvetarioTipoProducto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadInvetarioTipoProducto`(IN `dato` VARCHAR(45))
begin 
select count(codigoProducto) from tblProductos
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
where idEstadoProducto = 1 and tblTipoProductos.TipoProducto = dato;
end$$

DROP PROCEDURE IF EXISTS `cantidadProductosSalidaGeneral`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadProductosSalidaGeneral`(in dato varchar(45))
begin
select count(codigoProducto) from tblProductos
where idEstadoProducto = 2;
end$$

DROP PROCEDURE IF EXISTS `cantidadSalidaProductosPorVendedor`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadSalidaProductosPorVendedor`(in dato varchar(45))
begin
select count(codigoProducto) from tblProductos
inner join tblDetalleTransaccionVendedores on tblProductos.idProducto = tblDetalleTransaccionVendedores.idProducto
inner join tblTransaccionVendedores on tblDetalleTransaccionVendedores.idTransaccionVendedor = tblTransaccionVendedores.idTransaccionVendedor
inner join tblVendedores on tblTransaccionVendedores.idVendedor = tblVendedores.idVendedor
where idEstadoProducto = 2 and tblVendedores.nombrevendedor = dato;
end$$

DROP PROCEDURE IF EXISTS `cantidadTotalVentas`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadTotalVentas`(in dato varchar(45))
begin
select count(tblproductos.idProducto) from tblProductos
where idEstadoProducto = 3;
end$$

DROP PROCEDURE IF EXISTS `cantidadVentasClientesGenerales`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadVentasClientesGenerales`(in dato varchar(45))
begin
select count(tblDetalleTransaccionClientes.idProducto) from tblDetalleTransaccionClientes
inner join tblTransaccionClientes on tblDetalleTransaccionClientes.idTransaccionCliente = tblTransaccionClientes.idTransaccionCliente
inner join tblClientes on tblTransaccionClientes.idCliente = tblClientes.idCliente
inner join tblProductos on tblDetalleTransaccionClientes.idProducto = tblProductos.idProducto
where tblProductos.idEstadoProducto = 3 and tblClientes.nombreCliente = dato;
end$$

DROP PROCEDURE IF EXISTS `cantidadventasclientesgeneralesu`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadventasclientesgeneralesu`(in dato varchar(45))
begin
select count(tblDetalleTransaccionClientes.idProducto) from tblDetalleTransaccionClientes
inner join tblTransaccionClientes on tblDetalleTransaccionClientes.idTransaccionCliente = tblTransaccionClientes.idTransaccionCliente
inner join tblClientes on tblTransaccionClientes.idCliente = tblClientes.idCliente
inner join tblProductos on tblDetalleTransaccionClientes.idProducto = tblProductos.idProducto
where tblProductos.idEstadoProducto = 3;
end$$

DROP PROCEDURE IF EXISTS `cantidadVentasVendedoresGenerales`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadVentasVendedoresGenerales`(in dato varchar(45))
begin
select count(tblDetalleTransaccionVendedores.idProducto) from tblDetalleTransaccionVendedores
inner join tblTransaccionVendedores on tblDetalleTransaccionVendedores.idTransaccionVendedor = tblTransaccionVendedores.idTransaccionVendedor
inner join tblVendedores on tblTransaccionVendedores.idVendedor = tblVendedores.idVendedor
inner join tblProductos on tblDetalleTransaccionVendedores.idProducto = tblProductos.idProducto
where (tblProductos.idEstadoProducto = 3 or tblProductos.idEstadoProducto = 2) and (tblVendedores.nombreVendedor = dato);
end$$

DROP PROCEDURE IF EXISTS `cantidadVentasVendedoresGeneralesU`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidadVentasVendedoresGeneralesU`(in dato varchar(45))
begin
select count(tblDetalleTransaccionVendedores.idProducto) from tblDetalleTransaccionVendedores
inner join tblTransaccionVendedores on tblDetalleTransaccionVendedores.idTransaccionVendedor = tblTransaccionVendedores.idTransaccionVendedor
inner join tblVendedores on tblTransaccionVendedores.idVendedor = tblVendedores.idVendedor
inner join tblProductos on tblDetalleTransaccionVendedores.idProducto = tblProductos.idProducto
where (tblProductos.idEstadoProducto = 3 or tblProductos.idEstadoProducto = 2); 
end$$

DROP PROCEDURE IF EXISTS `rptAbonosClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptAbonosClientes`(IN `dato` VARCHAR(45))
begin 
select nombreCliente, DPI, direccionCliente, telefonoCliente, saldoCliente, fechaAbono, AbonoCliente from tblAbonoClientes
inner join tblClientes on tblAbonoClientes.idCliente = tblClientes.idCliente
where tblClientes.nombreCliente = dato and tblAbonoClientes.abonoCliente <> 0;
end$$

DROP PROCEDURE IF EXISTS `rptAbonosVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptAbonosVendedores`(IN `dato` VARCHAR(45))
begin
select codigoVendedor, nombreVendedor, DPI, direccionVendedor,saldoVendedor, fechaAbono, Abono from tblAbonoVendedores 
inner join tblVendedores  on tblAbonoVendedores.idVendedor = tblVendedores.idVendedor
where tblVendedores.nombreVendedor = dato and tblAbonoVendedores.abono <> 0;
end$$

DROP PROCEDURE IF EXISTS `rptDatosClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptDatosClientes`(IN `dato` VARCHAR(45))
begin
select * from tblClientes where nombreCliente = dato;
end$$

DROP PROCEDURE IF EXISTS `rptDatosVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptDatosVendedores`(IN `dato` VARCHAR(45))
begin
select * from tblVendedores 
inner join tblContactoVendedor on tblVendedores.idVendedor= tblContactoVendedor.idVendedor
where nombreVendedor = dato;
end$$

DROP PROCEDURE IF EXISTS `rptDevolucionesTransaccionVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptDevolucionesTransaccionVendedores`(IN `dato` VARCHAR(45))
begin
select tblVendedores.codigoVendedor, tblVendedores.nombreVendedor, tblVendedores.DPI, tblVendedores.direccionVendedor, tblTransaccionVendedores.codigoTransaccion, tblTransaccionVendedores.fechaTransaccionVendedor, tblTransaccionVendedores.fechaDevolucion, tblTransaccionVendedores.totalTransaccion, tblProductos.codigoProducto, tblProductos.colorProducto, tblProductos.gananciaSugerida, tblProductos.PrecioSugerido,tblProductos.precioOfertado, tblMarcas.Marca, tblTipoProductos.TipoProducto, tblTallas.Talla from tblVendedores
inner join tblTransaccionVendedores on tblVendedores.idVendedor = tblTransaccionVendedores.idVendedor
inner join tblDetalleTransaccionVendedores on tblTransaccionVendedores.idTransaccionVendedor = tblDetalleTransaccionVendedores.idTransaccionVendedor
inner join tblProductos on tblDetalleTransaccionVendedores.idProducto = tblProductos.idProducto
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
where tblTransaccionVendedores.codigoTransaccion = dato and tblProductos.idEstadoProducto = 3;
end$$

DROP PROCEDURE IF EXISTS `rptGastosGenerales`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptGastosGenerales`(IN `dato` VARCHAR(20))
begin
select TipoGasto, Gasto, FechaGasto from tblGastos
inner join tblTipoGasto on tblGastos.idTipoGasto = tblTipoGasto.idTipoGasto;
end$$

DROP PROCEDURE IF EXISTS `rptGastosTipo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptGastosTipo`(IN `dato` VARCHAR(45))
begin
select TipoGasto, Gasto, FechaGasto from tblGastos
inner join tblTipoGasto on tblGastos.idTipoGasto = tblTipoGasto.idTipoGasto
where tblTipoGasto.TipoGasto = dato;
end$$

DROP PROCEDURE IF EXISTS `rptInventarioCodigoPedido`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptInventarioCodigoPedido`(IN `dato` VARCHAR(45))
begin
select * from tblProductos
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblPedidos on tblProductos.idPedido = tblPedidos.idPedido
inner join tblEstadoProductos on tblProductos.idEstadoProducto = tblEstadoProductos.idEstadoProducto
where tblPedidos.codigoPedido = dato order by tblProductos.CodigoProducto asc ;
end$$

DROP PROCEDURE IF EXISTS `rptInventarioCodigoProducto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptInventarioCodigoProducto`(IN `dato` VARCHAR(45))
begin
select * from tblProductos
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblPedidos on tblProductos.idPedido = tblPedidos.idPedido
where tblProductos.idEstadoProducto = 1 and tblProductos.codigoProducto = dato order by tblProductos.CodigoProducto asc;
end$$

DROP PROCEDURE IF EXISTS `rptInventarioGeneral`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptInventarioGeneral`(IN `dato` VARCHAR(45))
begin
select * from tblProductos
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblPedidos on tblProductos.idPedido = tblPedidos.idPedido
where tblProductos.idEstadoProducto = 1 order by tblProductos.CodigoProducto asc;
end$$

DROP PROCEDURE IF EXISTS `rptInventarioMarcas`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptInventarioMarcas`(IN `dato` VARCHAR(45))
begin
select * from tblProductos
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblPedidos on tblProductos.idPedido = tblPedidos.idPedido
where tblProductos.idEstadoProducto = 1 and tblMarcas.Marca = dato order by tblProductos.CodigoProducto asc;
end$$

DROP PROCEDURE IF EXISTS `rptInventarioTallas`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptInventarioTallas`(IN `dato` VARCHAR(45))
select * from tblProductos
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblPedidos on tblProductos.idPedido = tblPedidos.idPedido
where tblProductos.idEstadoProducto = 1 and tblTallas.Talla = dato order by tblProductos.CodigoProducto asc$$

DROP PROCEDURE IF EXISTS `rptInventarioTipoProductos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptInventarioTipoProductos`(IN `dato` VARCHAR(45))
begin
select * from tblProductos
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblPedidos on tblProductos.idPedido = tblPedidos.idPedido
where tblProductos.idEstadoProducto = 1 and tblTipoProductos.TipoProducto = dato order by tblProductos.CodigoProducto asc;
end$$

DROP PROCEDURE IF EXISTS `rptProductosEnSalidaPorPedido`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptProductosEnSalidaPorPedido`(IN `dato` VARCHAR(45))
begin
Select tblVendedores.nombreVendedor,tblProductos.codigoProducto,tblTipoProductos.tipoProducto,tblMarcas.marca, tblTallas.talla, tblProductos.colorProducto, tblPedidos.codigoPedido,tblProductos.precioOfertado,tblTransaccionVendedores.fechaDevolucion,tblTransaccionVendedores.fechaTransaccionVendedor, tblTransaccionVendedores.codigoTransaccion  from tblVendedores
inner join tblTransaccionVendedores on tblVendedores.idVendedor = tblTransaccionVendedores.idVendedor
inner join tblDetalleTransaccionVendedores on tblTransaccionVendedores.idTransaccionVendedor = tblDetalleTransaccionVendedores.idTransaccionVendedor
inner join tblProductos on tblDetalleTransaccionVendedores.idProducto = tblProductos.idProducto
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblPedidos on tblProductos.idPedido = tblPedidos.idPedido
where tblProductos.idEstadoProducto = 2 and tblTransaccionVendedores.codigoTransaccion = dato;
end$$

DROP PROCEDURE IF EXISTS `rptProductosEnSalidaVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptProductosEnSalidaVendedores`(IN `dato` VARCHAR(45))
begin
Select tblVendedores.nombreVendedor,tblProductos.codigoProducto,tblTipoProductos.tipoProducto,tblMarcas.marca, tblTallas.talla, tblProductos.colorProducto, tblPedidos.codigoPedido,tblProductos.precioOfertado,tblTransaccionVendedores.fechaDevolucion,tblTransaccionVendedores.fechaTransaccionVendedor  from tblVendedores
inner join tblTransaccionVendedores on tblVendedores.idVendedor = tblTransaccionVendedores.idVendedor
inner join tblDetalleTransaccionVendedores on tblTransaccionVendedores.idTransaccionVendedor = tblDetalleTransaccionVendedores.idTransaccionVendedor
inner join tblProductos on tblDetalleTransaccionVendedores.idProducto = tblProductos.idProducto
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblPedidos on tblProductos.idPedido = tblPedidos.idPedido
where tblProductos.idEstadoProducto = 2;
end$$

DROP PROCEDURE IF EXISTS `rptProductosEnSalidaVendedorEspecifico`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptProductosEnSalidaVendedorEspecifico`(IN `dato` VARCHAR(45))
begin
Select tblVendedores.nombreVendedor,tblProductos.codigoProducto,tblTipoProductos.tipoProducto,tblMarcas.marca, tblTallas.talla, tblProductos.colorProducto, tblPedidos.codigoPedido,tblProductos.precioOfertado, tblTransaccionVendedores.fechaDevolucion , tblVendedores.codigoVendedor,tblTransaccionVendedores.fechaTransaccionVendedor from tblVendedores
inner join tblTransaccionVendedores on tblVendedores.idVendedor = tblTransaccionVendedores.idVendedor
inner join tblDetalleTransaccionVendedores on tblTransaccionVendedores.idTransaccionVendedor = tblDetalleTransaccionVendedores.idTransaccionVendedor
inner join tblProductos on tblDetalleTransaccionVendedores.idProducto = tblProductos.idProducto
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblPedidos on tblProductos.idPedido = tblPedidos.idPedido
where tblProductos.idEstadoProducto = 2 and tblVendedores.nombreVendedor = dato;
end$$

DROP PROCEDURE IF EXISTS `rptReciboAbonoClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptReciboAbonoClientes`(in dato varchar(45))
begin
select max(tblAbonoClientes.abonoCliente), max(tblAbonoClientes.FechaAbono), max(tblClientes.nombreCliente), max(tblClientes.DPI),max(tblClientes.DireccionCliente),max(tblClientes.telefonoCliente),max(tblClientes.saldoCliente) from tblAbonoClientes inner join tblClientes on tblAbonoClientes.idCliente = tblClientes.idCliente 
where idAbonoCliente = (select max(idAbonoCliente) from tblAbonoClientes);
end$$

DROP PROCEDURE IF EXISTS `rptReciboAbonoVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptReciboAbonoVendedores`(IN `dato` VARCHAR(45))
begin
select max(tblAbonoVendedores.abono), max(tblAbonoVendedores.FechaAbono), max(tblVendedores.codigoVendedor), max(tblVendedores.nombreVendedor), max(tblVendedores.DPI),max(tblVendedores.DireccionVendedor),max(tblVendedores.saldoVendedor), max(tblContactoVendedor.contacto) from tblAbonoVendedores inner join tblVendedores on tblAbonoVendedores.idVendedor = tblVendedores.idVendedor 
inner join tblContactoVendedor on tblVendedores.idVendedor = tblContactoVendedor.idVendedor
where idAbonoVendedor = (select max(idAbonoVendedor) from tblAbonoVendedores);
end$$

DROP PROCEDURE IF EXISTS `rptTransaccionClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptTransaccionClientes`(IN `dato` VARCHAR(45))
begin
select tblClientes.nombreCliente, tblClientes.DPI, tblClientes.direccionCliente, tblClientes.telefonoCliente,  tblTransaccionClientes.fechaTransaccionCliente, tblTransaccionClientes.totalTransaccion, tblProductos.codigoProducto, tblProductos.colorProducto, tblProductos.gananciaSugerida, tblProductos.PrecioSugerido,tblProductos.precioOfertado, tblMarcas.Marca, tblTipoProductos.TipoProducto, tblTallas.Talla from tblClientes
inner join tblTransaccionClientes on tblClientes.idCliente = tblTransaccionClientes.idCliente
inner join tblDetalleTransaccionClientes on tblTransaccionClientes.idTransaccionCliente = tblDetalleTransaccionClientes.idTransaccionCliente
inner join tblProductos on tblDetalleTransaccionClientes.idProducto = tblProductos.idProducto
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
where tblTransaccionClientes.idTransaccionCliente = (select max(idTransaccionCliente) from tblTransaccionClientes) order by tblProductos.CodigoProducto asc;
end$$

DROP PROCEDURE IF EXISTS `rptTransaccionVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptTransaccionVendedores`(IN `dato` VARCHAR(45))
select tblVendedores.codigoVendedor, tblVendedores.nombreVendedor, tblVendedores.DPI, tblVendedores.direccionVendedor, tblTransaccionVendedores.codigoTransaccion, tblTransaccionVendedores.fechaTransaccionVendedor, tblTransaccionVendedores.fechaDevolucion, tblTransaccionVendedores.totalTransaccion, tblProductos.codigoProducto, tblProductos.colorProducto, tblProductos.gananciaSugerida, tblProductos.PrecioSugerido,tblProductos.precioOfertado, tblMarcas.Marca, tblTipoProductos.TipoProducto, tblTallas.Talla from tblVendedores
inner join tblTransaccionVendedores on tblVendedores.idVendedor = tblTransaccionVendedores.idVendedor
inner join tblDetalleTransaccionVendedores on tblTransaccionVendedores.idTransaccionVendedor = tblDetalleTransaccionVendedores.idTransaccionVendedor
inner join tblProductos on tblDetalleTransaccionVendedores.idProducto = tblProductos.idProducto
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
where tblTransaccionVendedores.idTransaccionVendedor = (select max(tblTransaccionVendedores.idTransaccionVendedor) from tblTransaccionVendedores) order by tblProductos.CodigoProducto asc$$

DROP PROCEDURE IF EXISTS `rptVentasClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptVentasClientes`(IN `dato` VARCHAR(45))
begin
select tblProductos.codigoProducto, tblMarcas.Marca, tblTallas.Talla, tblTipoProductos.TipoProducto, tblProductos.preciosugerido, tblClientes.nombreCliente, tblProductos.colorProducto, tblClientes.telefonoCliente from tblProductos
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tblDetalleTransaccionClientes on tblProductos.idProducto = tblDetalleTransaccionClientes.idProducto
inner join tblTransaccionClientes on tblDetalleTransaccionClientes.idTransaccionCliente = tblTransaccionClientes.idTransaccionCliente
inner join tblClientes on tblTransaccionClientes.idCliente = tblClientes.idCliente
where tblProductos.idEstadoProducto = 3 and tblClientes.nombreCliente = dato order by tblProductos.codigoProducto asc;
end$$

DROP PROCEDURE IF EXISTS `rptVentasGeneralesClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptVentasGeneralesClientes`(IN `dato` VARCHAR(45))
begin
select * from tblProductos
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tbldetalletransaccionclientes on tblproductos.idproducto = tbldetalletransaccionclientes.idProducto
where tblProductos.idEstadoProducto = 3 order by tblProductos.codigoProducto asc;
end$$

DROP PROCEDURE IF EXISTS `rptVentasGeneralesVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptVentasGeneralesVendedores`(IN `dato` VARCHAR(45))
begin
select * from tblProductos
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla
inner join tbldetalletransaccionvendedores on tblproductos.idproducto = tbldetalletransaccionvendedores.idProducto
where (tblProductos.idEstadoProducto = 3 or tblProductos.idEstadoProducto = 2) order by tblProductos.codigoProducto asc;
end$$

DROP PROCEDURE IF EXISTS `rptVentasVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `rptVentasVendedores`(IN `dato` VARCHAR(45))
begin
select tblVendedores.nombreVendedor, tblProductos.codigoProducto,tblProductos.colorProducto, tblMarcas.Marca, tblTallas.Talla, tblTipoProductos.TipoProducto, tblProductos.precioOfertado from tblVendedores
inner join tblTransaccionVendedores on tblVendedores.idVendedor = tblTransaccionVendedores.idVendedor
inner join tblDetalleTransaccionVendedores on tblTransaccionVendedores.idTransaccionVendedor = tblDetalleTransaccionVendedores.idTransaccionVendedor
inner join tblProductos on tblDetalleTransaccionVendedores.idProducto = tblProductos.idProducto
inner join tblMarcas on tblProductos.idMarca = tblMarcas.idMarca
inner join tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto
inner join tblTallas on tblProductos.idTalla = tblTallas.idTalla where (tblProductos.idEstadoProducto = 3 or tblProductos.idEstadoProducto = 2) and tblVendedores.nombreVendedor = dato order by tblProductos.codigoProducto asc;
end$$

DROP PROCEDURE IF EXISTS `saldoCliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `saldoCliente`(in dato varchar(45))
begin
select ((select sum(tblProductos.preciosugerido) from tblClientes
inner join tblTransaccionClientes on tblTransaccionClientes.idCliente = tblClientes.idCliente
inner join tblDetalleTransaccionClientes on tblTransaccionClientes.idTransaccionCliente = tblDetalleTransaccionClientes.idTransaccionCliente
inner join tblProductos on tblProductos.idPRoducto = tblDetalleTransaccionClientes.idProducto
where tblClientes.nombreCliente = dato and tblProductos.idEstadoProducto = 3) -(select sum(tblAbonoClientes.abonoCliente) from tblAbonoClientes inner join tblClientes on tblAbonoClientes.idCliente = tblClientes.idCliente where tblClientes.nombreCliente= dato)) as 'Saldo';
end$$

DROP PROCEDURE IF EXISTS `saldoVendedor`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `saldoVendedor`(in dato varchar(45))
begin
select ((select sum(tblProductos.precioOfertado) from tblVendedores
inner join tblTransaccionVendedores on tblTransaccionVendedores.idVendedor = tblVendedores.idVendedor
inner join tblDetalleTransaccionVendedores on tblTransaccionVendedores.idTransaccionVendedor = tblDetalleTransaccionVendedores.idTransaccionVendedor
inner join tblProductos on tblProductos.idPRoducto = tblDetalleTransaccionVendedores.idProducto
where tblVendedores.nombreVendedor = dato and tblProductos.idEstadoProducto = 3) -(select sum(tblAbonoVendedores.abono) from tblAbonoVendedores inner join tblVendedores on tblAbonoVendedores.idVendedor = tblVendedores.idVendedor where tblVendedores.nombreVendedor= dato)) as 'Saldo';
end$$

DROP PROCEDURE IF EXISTS `sumaAbonoClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sumaAbonoClientes`(in dato varchar(45))
begin
select sum(tblAbonoClientes.abonoCliente) from tblAbonoClientes
inner join tblClientes on tblAbonoClientes.idCliente = tblClientes.idCliente
where tblClientes.nombreCliente = dato;
end$$

DROP PROCEDURE IF EXISTS `sumaAbonoVendedor`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sumaAbonoVendedor`(in dato varchar(45))
begin
select sum(tblAbonoVendedores.abono) from tblAbonoVendedores
inner join tblVendedores on tblAbonoVendedores.idVendedor = tblVendedores.idVendedor
where tblVendedores.nombreVendedor = dato;
end$$

DROP PROCEDURE IF EXISTS `SumaSaldoAnteriorClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SumaSaldoAnteriorClientes`(in dato varchar(45))
begin
select max(tblAbonoClientes.AbonoCliente + tblClientes.saldoCliente) from tblAbonoClientes
inner join tblClientes on tblAbonoClientes.idCliente = tblClientes.idCliente
where tblAbonoClientes.idAbonoCliente = (select max(tblAbonoClientes.idAbonoCliente) from tblAbonoClientes);
end$$

DROP PROCEDURE IF EXISTS `SumaSaldoAnteriorVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SumaSaldoAnteriorVendedores`(in dato varchar(45))
begin
select max(tblAbonoVendedores.Abono + tblVendedores.saldoVendedor) from tblAbonoVendedores
inner join tblVendedores on tblAbonoVendedores.idVendedor = tblVendedores.idVendedor
where tblAbonoVendedores.idAbonoVendedor = (select max(tblAbonoVendedores.idAbonoVendedor) from tblAbonoVendedores);
end$$

DROP PROCEDURE IF EXISTS `telefonoVendedor`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `telefonoVendedor`(in dato varchar(45))
begin
select max(tblContactoVendedor.contacto) from tblContactoVendedor
inner join tblVendedores on tblContactoVendedor.idVendedor = tblVendedores.idVendedor
where tblVendedores.nombreVendedor = dato;
end$$

DROP PROCEDURE IF EXISTS `totalAbonoClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `totalAbonoClientes`(in dato varchar(45))
begin
select sum(tblAbonoClientes.abonoCliente) from tblClientes
inner join tblAbonoClientes on tblClientes.idCliente = tblAbonoClientes.idCliente;
end$$

DROP PROCEDURE IF EXISTS `totalAbonoVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `totalAbonoVendedores`(IN `dato` VARCHAR(45))
begin
select sum(abono) from tblVendedores
inner join tblAbonoVendedores on tblVendedores.idVendedor = tblAbonoVendedores.idVendedor;
end$$

DROP PROCEDURE IF EXISTS `totalVendidoClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `totalVendidoClientes`(in dato Varchar(45))
begin
select ((select saldoCliente from tblClientes where nombreCliente = dato) + (select sum(tblAbonoClientes.abonoCliente) from tblAbonoClientes inner join tblClientes on tblAbonoClientes.idCliente = tblClientes.idCliente where tblClientes.nombreCliente = dato))as 'TOTAL';
end$$

DROP PROCEDURE IF EXISTS `totalVendidoVendedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `totalVendidoVendedores`(in dato Varchar(45))
begin
select ((select saldoVendedor from tblVendedores where nombreVendedor = dato) + (select sum(tblAbonoVendedores.abono) from tblAbonoVendedores inner join tblVendedores on tblAbonoVendedores.idVendedor = tblVendedores.idVendedor where tblVendedores.nombreVendedor = dato))as 'TOTAL';
end$$

DROP PROCEDURE IF EXISTS `ultimoAbonoCliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ultimoAbonoCliente`(IN `dato` VARCHAR(45))
begin
select abonoCliente from tblAbonoClientes where idAbonoCliente = (Select max(idAbonoCliente) from tblAbonoClientes);
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblabonoclientes`
--

DROP TABLE IF EXISTS `tblabonoclientes`;
CREATE TABLE IF NOT EXISTS `tblabonoclientes` (
  `idAbonoCliente` int(11) NOT NULL AUTO_INCREMENT,
  `fechaAbono` date NOT NULL,
  `AbonoCliente` double NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idAbonoCliente`),
  KEY `fk_tblAbonoCliente_tblCliente1_idx` (`idCliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Volcado de datos para la tabla `tblabonoclientes`
--

INSERT INTO `tblabonoclientes` (`idAbonoCliente`, `fechaAbono`, `AbonoCliente`, `idCliente`) VALUES
(1, '2014-04-05', 0, 1),
(2, '2014-04-07', 0, 1),
(3, '2014-04-07', 0, 1),
(4, '2014-04-11', 0, 2),
(5, '2014-04-11', 0, 3),
(6, '2014-04-11', 0, 2),
(7, '2014-04-11', 480, 2),
(8, '2014-04-12', 730, 1),
(9, '2014-04-13', 0, 4),
(10, '2014-04-13', 0, 4),
(11, '2014-04-13', 0, 4),
(12, '2014-04-13', 0, 2),
(13, '2014-04-13', 200, 4),
(14, '2014-05-31', 420, 1),
(15, '2014-05-31', 140, 1),
(16, '2014-06-06', 300, 4),
(17, '2014-06-06', 425, 2),
(18, '2014-07-05', 15, 1),
(19, '2014-08-02', 70, 1);

--
-- Disparadores `tblabonoclientes`
--
DROP TRIGGER IF EXISTS `descuentosaldocliente`;
DELIMITER //
CREATE TRIGGER `descuentosaldocliente` AFTER INSERT ON `tblabonoclientes`
 FOR EACH ROW BEGIN
DECLARE vidCliente int;
DECLARE vsaldoCliente  double;
DECLARE vidAbonoCliente int;
DECLARE vAbono double;

SELECT max(idAbonoCliente) INTO vidAbonoCliente from tblAbonoClientes;
Select AbonoCliente into vAbono from tblAbonoClientes where idAbonoCliente = vidAbonoCliente;
Select idCliente into vidCliente from tblAbonoClientes where idAbonoCliente = vidAbonoCliente;
update tblClientes set saldoCliente = saldoCliente-vAbono where idCliente = vidCliente;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblabonovendedores`
--

DROP TABLE IF EXISTS `tblabonovendedores`;
CREATE TABLE IF NOT EXISTS `tblabonovendedores` (
  `idAbonoVendedor` int(11) NOT NULL AUTO_INCREMENT,
  `fechaAbono` date NOT NULL,
  `Abono` double NOT NULL,
  `idVendedor` int(11) NOT NULL,
  PRIMARY KEY (`idAbonoVendedor`),
  KEY `fk_tblAbonoVendedor_tblVendedor_idx` (`idVendedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `tblabonovendedores`
--

INSERT INTO `tblabonovendedores` (`idAbonoVendedor`, `fechaAbono`, `Abono`, `idVendedor`) VALUES
(1, '2014-05-31', 3000, 2),
(2, '2014-06-20', 815, 4),
(3, '2014-07-05', 4700, 2),
(4, '2014-07-05', 1160, 5),
(5, '2014-07-10', 400, 4),
(6, '2014-08-02', 5, 6),
(7, '2014-08-04', 4125, 1);

--
-- Disparadores `tblabonovendedores`
--
DROP TRIGGER IF EXISTS `descuentosaldovendedor`;
DELIMITER //
CREATE TRIGGER `descuentosaldovendedor` AFTER INSERT ON `tblabonovendedores`
 FOR EACH ROW BEGIN
DECLARE vidVendedor int;
DECLARE vsaldoVendedor  double;
DECLARE vidAbonoVendedor int;
DECLARE vAbono double;

SELECT max(idAbonoVendedor) INTO vidAbonoVendedor from tblAbonoVendedores;
Select Abono into vAbono from tblAbonoVendedores where idAbonoVendedor = vidAbonoVendedor;
Select idVendedor into vidVendedor from tblAbonoVendedores where idAbonoVendedor = vidAbonoVendedor;
update tblVendedores set saldoVendedor = saldoVendedor-vAbono where idVendedor = vidVendedor;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblclientes`
--

DROP TABLE IF EXISTS `tblclientes`;
CREATE TABLE IF NOT EXISTS `tblclientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCliente` varchar(45) NOT NULL,
  `DPI` varchar(45) NOT NULL,
  `direccionCliente` varchar(45) NOT NULL,
  `telefonoCliente` varchar(45) NOT NULL,
  `saldoCliente` double DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `tblclientes`
--

INSERT INTO `tblclientes` (`idCliente`, `nombreCliente`, `DPI`, `direccionCliente`, `telefonoCliente`, `saldoCliente`) VALUES
(1, 'Familia Ochoa Bautista', '1811 87396 0901', '12 avenida 1-90 zona 3', '77654289', 0),
(2, 'Familia Girón Reyes', '', '', '40455444', 0),
(3, 'Sergio Santiago', '', '', '55108137', 700),
(4, 'Beronica Boj', '', '20av 0-28 zona 7', '51464524', 160);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcontactovendedor`
--

DROP TABLE IF EXISTS `tblcontactovendedor`;
CREATE TABLE IF NOT EXISTS `tblcontactovendedor` (
  `idContacto` int(11) NOT NULL AUTO_INCREMENT,
  `Contacto` varchar(45) NOT NULL,
  `idVendedor` int(11) NOT NULL,
  PRIMARY KEY (`idContacto`),
  KEY `fk_tblContactoVendedor_tblVendedores1_idx` (`idVendedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `tblcontactovendedor`
--

INSERT INTO `tblcontactovendedor` (`idContacto`, `Contacto`, `idVendedor`) VALUES
(1, '55108137', 1),
(2, '34097701', 2),
(3, '55341332', 3),
(4, '56975091', 4),
(7, '54148998', 5),
(8, '40455444', 6),
(9, '50162833', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbldetalletransaccionclientes`
--

DROP TABLE IF EXISTS `tbldetalletransaccionclientes`;
CREATE TABLE IF NOT EXISTS `tbldetalletransaccionclientes` (
  `idDetalleTransaccionClientes` int(11) NOT NULL AUTO_INCREMENT,
  `idTransaccionCliente` int(11) NOT NULL,
  `idProducto` bigint(20) NOT NULL,
  PRIMARY KEY (`idDetalleTransaccionClientes`),
  KEY `fk_tblDetalleTransaccionClientes_tblTransaccionClientes1_idx` (`idTransaccionCliente`),
  KEY `fk_tblDetalleTransaccionClientes_tblProductos1_idx` (`idProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

--
-- Volcado de datos para la tabla `tbldetalletransaccionclientes`
--

INSERT INTO `tbldetalletransaccionclientes` (`idDetalleTransaccionClientes`, `idTransaccionCliente`, `idProducto`) VALUES
(1, 1, 155),
(2, 1, 369),
(3, 1, 367),
(4, 2, 182),
(5, 2, 79),
(6, 3, 195),
(7, 4, 205),
(8, 4, 203),
(9, 5, 44),
(10, 5, 176),
(11, 5, 55),
(12, 5, 48),
(13, 6, 239),
(14, 14, 41),
(15, 14, 42),
(16, 15, 237),
(17, 15, 185),
(18, 15, 232),
(19, 16, 27),
(20, 16, 397),
(21, 17, 390);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbldetalletransaccionvendedores`
--

DROP TABLE IF EXISTS `tbldetalletransaccionvendedores`;
CREATE TABLE IF NOT EXISTS `tbldetalletransaccionvendedores` (
  `idDetalleTransaccionVendedor` int(11) NOT NULL AUTO_INCREMENT,
  `idTransaccionVendedor` int(11) NOT NULL,
  `idProducto` bigint(20) NOT NULL,
  PRIMARY KEY (`idDetalleTransaccionVendedor`),
  KEY `fk_tblDetalleTransaccionVendedores_tblTransaccionVendedores_idx` (`idTransaccionVendedor`),
  KEY `fk_tblDetalleTransaccionVendedores_tblProductos1_idx` (`idProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=513 ;

--
-- Volcado de datos para la tabla `tbldetalletransaccionvendedores`
--

INSERT INTO `tbldetalletransaccionvendedores` (`idDetalleTransaccionVendedor`, `idTransaccionVendedor`, `idProducto`) VALUES
(2, 1, 202),
(3, 1, 50),
(4, 1, 156),
(5, 1, 132),
(6, 1, 38),
(7, 1, 35),
(8, 1, 204),
(10, 1, 206),
(14, 1, 37),
(17, 1, 166),
(20, 1, 184),
(22, 1, 212),
(25, 1, 188),
(26, 1, 189),
(28, 1, 80),
(31, 1, 33),
(38, 1, 93),
(41, 1, 133),
(45, 1, 247),
(46, 1, 118),
(56, 1, 153),
(59, 1, 196),
(60, 1, 198),
(64, 1, 353),
(72, 2, 307),
(73, 2, 336),
(74, 2, 320),
(75, 2, 318),
(76, 2, 324),
(77, 2, 278),
(78, 2, 423),
(79, 2, 363),
(80, 2, 386),
(81, 2, 257),
(82, 2, 150),
(83, 2, 173),
(84, 2, 221),
(85, 2, 213),
(86, 2, 143),
(87, 2, 154),
(88, 2, 30),
(89, 2, 53),
(90, 2, 167),
(91, 2, 165),
(92, 2, 3),
(93, 2, 109),
(94, 2, 259),
(95, 2, 23),
(96, 2, 229),
(97, 2, 179),
(98, 2, 225),
(99, 2, 6),
(100, 2, 12),
(101, 3, 5),
(102, 3, 190),
(103, 3, 219),
(104, 3, 105),
(105, 3, 124),
(106, 3, 216),
(107, 3, 215),
(108, 3, 83),
(109, 3, 151),
(110, 3, 31),
(111, 3, 160),
(112, 3, 22),
(113, 3, 321),
(114, 3, 339),
(115, 3, 326),
(116, 3, 335),
(117, 3, 322),
(118, 3, 328),
(119, 3, 337),
(120, 3, 340),
(122, 4, 102),
(124, 4, 20),
(125, 4, 158),
(126, 4, 157),
(127, 4, 16),
(128, 4, 228),
(129, 4, 7),
(132, 4, 238),
(134, 4, 125),
(135, 4, 129),
(136, 4, 123),
(139, 4, 104),
(140, 4, 274),
(144, 4, 36),
(145, 4, 263),
(146, 4, 224),
(149, 4, 245),
(150, 4, 241),
(151, 4, 248),
(152, 4, 250),
(153, 4, 310),
(154, 4, 312),
(155, 4, 299),
(156, 4, 300),
(157, 4, 296),
(158, 4, 294),
(159, 4, 303),
(160, 4, 290),
(161, 4, 283),
(162, 4, 291),
(163, 4, 286),
(164, 4, 293),
(165, 4, 306),
(166, 4, 308),
(167, 4, 311),
(168, 4, 432),
(170, 4, 388),
(171, 4, 418),
(172, 4, 396),
(175, 4, 410),
(176, 4, 364),
(178, 4, 409),
(179, 4, 275),
(180, 4, 356),
(181, 4, 334),
(183, 4, 381),
(184, 4, 378),
(185, 4, 376),
(186, 4, 304),
(187, 4, 354),
(188, 4, 359),
(189, 4, 361),
(190, 5, 256),
(197, 6, 67),
(200, 6, 110),
(208, 6, 115),
(209, 6, 15),
(212, 6, 111),
(213, 6, 145),
(215, 6, 242),
(218, 6, 197),
(223, 6, 77),
(226, 6, 191),
(227, 6, 227),
(244, 6, 343),
(246, 7, 64),
(248, 7, 60),
(250, 7, 243),
(251, 7, 235),
(252, 7, 69),
(253, 7, 1),
(255, 7, 26),
(256, 7, 171),
(259, 7, 287),
(260, 8, 309),
(261, 8, 305),
(262, 8, 63),
(263, 9, 86),
(264, 9, 94),
(265, 9, 88),
(266, 9, 84),
(267, 9, 101),
(268, 9, 89),
(269, 9, 78),
(270, 9, 99),
(271, 9, 223),
(272, 9, 187),
(273, 9, 147),
(274, 9, 217),
(275, 9, 240),
(276, 9, 130),
(277, 9, 253),
(278, 9, 231),
(279, 9, 251),
(280, 9, 9),
(281, 9, 159),
(282, 9, 106),
(283, 9, 13),
(284, 9, 11),
(285, 9, 261),
(286, 9, 75),
(287, 9, 92),
(288, 9, 97),
(289, 9, 108),
(290, 9, 100),
(291, 9, 117),
(292, 9, 246),
(293, 9, 128),
(294, 9, 218),
(295, 9, 29),
(296, 9, 58),
(297, 9, 174),
(298, 9, 301),
(299, 9, 297),
(300, 9, 295),
(301, 9, 298),
(302, 9, 302),
(303, 9, 285),
(304, 9, 284),
(305, 9, 292),
(306, 9, 331),
(307, 9, 342),
(308, 9, 375),
(309, 9, 351),
(310, 9, 344),
(311, 9, 355),
(312, 9, 330),
(313, 9, 332),
(314, 9, 314),
(315, 10, 329),
(316, 10, 382),
(317, 10, 357),
(318, 10, 348),
(319, 10, 424),
(320, 10, 280),
(321, 10, 431),
(322, 10, 434),
(323, 10, 404),
(324, 10, 164),
(325, 10, 161),
(326, 10, 168),
(327, 10, 163),
(328, 11, 200),
(329, 11, 441),
(330, 11, 52),
(331, 11, 518),
(332, 11, 519),
(333, 11, 517),
(334, 11, 513),
(335, 11, 512),
(336, 11, 520),
(337, 11, 350),
(338, 11, 522),
(339, 11, 521),
(340, 12, 127),
(341, 12, 62),
(342, 12, 277),
(343, 12, 433),
(344, 12, 403),
(345, 12, 426),
(346, 12, 391),
(347, 12, 422),
(348, 12, 288),
(349, 12, 407),
(350, 12, 358),
(351, 12, 317),
(352, 12, 360),
(353, 12, 370),
(354, 12, 377),
(355, 12, 362),
(356, 13, 144),
(357, 13, 265),
(358, 13, 2),
(359, 13, 485),
(360, 13, 483),
(361, 13, 65),
(362, 13, 254),
(363, 13, 71),
(364, 13, 10),
(365, 13, 14),
(366, 13, 258),
(367, 13, 61),
(368, 13, 72),
(369, 13, 73),
(370, 13, 39),
(371, 13, 255),
(372, 13, 220),
(373, 13, 137),
(374, 13, 266),
(375, 13, 249),
(376, 13, 273),
(377, 13, 54),
(378, 13, 112),
(379, 13, 131),
(380, 13, 267),
(381, 13, 119),
(382, 13, 120),
(383, 13, 18),
(384, 13, 114),
(385, 13, 264),
(386, 13, 45),
(387, 13, 172),
(388, 13, 177),
(389, 13, 56),
(390, 13, 40),
(391, 13, 139),
(392, 13, 252),
(393, 13, 268),
(394, 13, 19),
(395, 13, 49),
(396, 13, 504),
(397, 13, 269),
(398, 13, 122),
(399, 13, 503),
(400, 13, 486),
(401, 13, 484),
(402, 13, 272),
(403, 13, 207),
(404, 13, 21),
(405, 13, 4),
(406, 13, 271),
(407, 13, 439),
(408, 13, 17),
(409, 13, 505),
(410, 13, 260),
(411, 13, 234),
(412, 13, 445),
(413, 13, 446),
(414, 13, 458),
(415, 13, 460),
(416, 13, 508),
(417, 13, 507),
(418, 13, 461),
(419, 13, 146),
(420, 13, 169),
(421, 13, 480),
(422, 13, 466),
(423, 13, 473),
(424, 13, 469),
(425, 13, 463),
(426, 13, 481),
(427, 13, 471),
(428, 13, 470),
(429, 13, 479),
(430, 13, 462),
(431, 13, 467),
(432, 13, 472),
(433, 13, 474),
(434, 13, 475),
(435, 13, 477),
(436, 13, 476),
(437, 13, 510),
(438, 13, 59),
(439, 13, 138),
(440, 13, 149),
(441, 13, 152),
(442, 14, 447),
(443, 14, 450),
(444, 14, 448),
(445, 14, 451),
(446, 14, 28),
(447, 14, 442),
(448, 14, 211),
(449, 14, 209),
(450, 14, 210),
(451, 14, 443),
(452, 14, 194),
(453, 14, 230),
(454, 14, 516),
(455, 14, 347),
(456, 14, 346),
(457, 14, 333),
(458, 14, 380),
(459, 15, 531),
(460, 15, 528),
(461, 15, 525),
(462, 15, 90),
(463, 15, 457),
(464, 15, 453),
(465, 15, 452),
(466, 15, 449),
(467, 16, 534),
(468, 16, 533),
(469, 16, 532),
(470, 17, 379),
(471, 17, 515),
(472, 17, 349),
(473, 17, 338),
(475, 17, 374),
(476, 17, 523),
(477, 17, 524),
(478, 17, 401),
(479, 17, 368),
(480, 17, 400),
(481, 17, 373),
(482, 17, 429),
(483, 17, 420),
(484, 17, 419),
(485, 17, 436),
(486, 17, 427),
(487, 17, 395),
(488, 17, 365),
(489, 17, 366),
(490, 17, 417),
(491, 17, 279),
(492, 17, 408),
(493, 17, 393),
(494, 17, 276),
(495, 17, 399),
(496, 17, 425),
(497, 17, 411),
(498, 17, 289),
(499, 17, 428),
(500, 17, 394),
(501, 17, 281),
(502, 17, 385),
(503, 19, 352),
(504, 19, 383),
(505, 19, 316),
(506, 19, 325),
(507, 19, 323),
(508, 19, 315),
(509, 19, 319),
(510, 19, 384),
(511, 19, 313),
(512, 19, 103);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblestadoproductos`
--

DROP TABLE IF EXISTS `tblestadoproductos`;
CREATE TABLE IF NOT EXISTS `tblestadoproductos` (
  `idEstadoProducto` int(11) NOT NULL AUTO_INCREMENT,
  `EstadoProducto` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstadoProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tblestadoproductos`
--

INSERT INTO `tblestadoproductos` (`idEstadoProducto`, `EstadoProducto`) VALUES
(1, 'Bodega'),
(2, 'Pendiente'),
(3, 'Vendido');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblgastos`
--

DROP TABLE IF EXISTS `tblgastos`;
CREATE TABLE IF NOT EXISTS `tblgastos` (
  `idGasto` int(11) NOT NULL AUTO_INCREMENT,
  `Gasto` double NOT NULL,
  `FechaGasto` date NOT NULL,
  `idTipoGasto` int(11) NOT NULL,
  PRIMARY KEY (`idGasto`),
  KEY `fk_tblGastos_tblTipoGasto1_idx` (`idTipoGasto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblmarcas`
--

DROP TABLE IF EXISTS `tblmarcas`;
CREATE TABLE IF NOT EXISTS `tblmarcas` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `Marca` varchar(45) NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `tblmarcas`
--

INSERT INTO `tblmarcas` (`idMarca`, `Marca`) VALUES
(1, 'Hollister'),
(2, 'Abercrombie'),
(3, 'Aeropostale'),
(4, 'American Eagle'),
(5, 'Nautica'),
(6, 'Victorias Secret'),
(7, 'Forever 21'),
(8, 'Old Navy'),
(9, 'Charlotte Russe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpedidos`
--

DROP TABLE IF EXISTS `tblpedidos`;
CREATE TABLE IF NOT EXISTS `tblpedidos` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `codigoPedido` varchar(45) NOT NULL,
  `subtotalPedido` double NOT NULL,
  `impuestoPedido` double NOT NULL,
  `envioPedido` double NOT NULL,
  `cantidadProductos` int(11) NOT NULL,
  `impuestoUnitario` double NOT NULL,
  `envioUnitario` double NOT NULL,
  `fechaIngreso` date NOT NULL,
  `tipoCambio` double DEFAULT NULL,
  `envioGuate` double DEFAULT NULL,
  PRIMARY KEY (`idPedido`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `tblpedidos`
--

INSERT INTO `tblpedidos` (`idPedido`, `codigoPedido`, `subtotalPedido`, `impuestoPedido`, `envioPedido`, `cantidadProductos`, `impuestoUnitario`, `envioUnitario`, `fechaIngreso`, `tipoCambio`, `envioGuate`) VALUES
(1, 'AG73', 1557.08, 128.46, 0, 84, 8.25005780049837, 0, '2014-03-29', 7.75, 12.76),
(2, '42345161', 250.76, 21.25, 0, 29, 8.47423831552082, 0, '2014-03-30', 7.75, 12.76),
(3, '723004A', 93.74, 7.73, 0, 16, 8.24621292937913, 0, '2014-03-30', 7.75, 12.76),
(4, '724004B', 317.39, 26.18, 0, 23, 8.2485270487413, 0, '2014-03-30', 7.75, 12.76),
(5, '725003A', 307.16, 25.34, 0, 19, 8.24977210574293, 0, '2014-03-30', 7.75, 12.76),
(6, '5200132207', 284.89, 25.65, 0, 11, 9.00347502544842, 0, '2014-03-30', 7.75, 12.76),
(7, '3191051705', 227.75, 20.5, 0, 14, 9.00109769484083, 0, '2014-03-30', 7.75, 12.76),
(8, '3137719876', 389.25, 35.03, 0, 30, 8.99935773924213, 0, '2014-03-30', 7.75, 12.76),
(9, '3060249185', 315.44, 28.39, 0, 26, 9.00012680699975, 0, '2014-03-30', 7.75, 12.76),
(10, '3060339905', 540.45, 48.64, 0, 47, 8.99990748450365, 0, '2014-03-30', 7.75, 12.76),
(11, '545565163', 175, 16.58, 19.99, 28, 9.47428571428571, 0.713928571428571, '2014-04-05', 7.75, 12.76),
(12, '545631426', 179, 16.92, 19.99, 37, 9.45251396648045, 0.54027027027027, '2014-04-05', 7.75, 12.76),
(13, '545705211', 14, 1.33, 1.6, 2, 9.5, 0.8, '2014-04-05', 7.75, 12.76),
(14, '545873537', 177, 16.75, 19.99, 44, 9.46327683615819, 0.454318181818182, '2014-04-05', 7.75, 12.76),
(15, '545995189', 180, 17, 19.99, 39, 9.44444444444444, 0.512564102564103, '2014-04-05', 7.75, 12.76),
(16, '4581039', 83.49, 7.17, 0, 6, 8.58785483291412, 0, '2014-04-05', 7.75, 12.76),
(17, '23654AB', 1000, 80, 0, 40, 8, 0, '2014-05-31', 7.7, 6),
(18, '68437RZ', 1000, 80, 0, 45, 8, 0, '2014-05-31', 7.7, 5),
(19, '253390CA', 300, 24, 0, 15, 8, 0, '2014-07-05', 7.7, 10),
(20, '1', 10, 10, 0, 5, 100, 0, '2014-08-02', 7.65, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproductos`
--

DROP TABLE IF EXISTS `tblproductos`;
CREATE TABLE IF NOT EXISTS `tblproductos` (
  `idProducto` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigoProducto` varchar(45) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `idTipoProducto` int(11) NOT NULL,
  `idTalla` int(11) DEFAULT NULL,
  `colorProducto` varchar(45) DEFAULT NULL,
  `descripcionProducto` varchar(45) DEFAULT NULL,
  `costoDolares` double NOT NULL,
  `impuestoProducto` double NOT NULL,
  `envioProducto` double NOT NULL,
  `totalDolares` double NOT NULL,
  `tipoCambio` double NOT NULL,
  `costoQuetzaltes` double NOT NULL,
  `envioGuate` double NOT NULL,
  `totalQuetzales` double NOT NULL,
  `porcentajeGanacia` double NOT NULL,
  `gananciaEstimada` double NOT NULL,
  `precioVenta` double NOT NULL,
  `gananciaSugerida` double DEFAULT NULL,
  `precioSugerido` double DEFAULT NULL,
  `idEstadoProducto` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `porcentajeOferta` double DEFAULT '0',
  `precioOfertado` double DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_tblProductos_tblMarca1_idx` (`idMarca`),
  KEY `fk_tblProductos_tblTipoProducto1_idx` (`idTipoProducto`),
  KEY `fk_tblProductos_tblEstadoProducto1_idx` (`idEstadoProducto`),
  KEY `fk_tblProductos_tblPedidos1_idx` (`idPedido`),
  KEY `fk_tblProductos_tblTalla1_idx` (`idTalla`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=539 ;

--
-- Volcado de datos para la tabla `tblproductos`
--

INSERT INTO `tblproductos` (`idProducto`, `codigoProducto`, `idMarca`, `idTipoProducto`, `idTalla`, `colorProducto`, `descripcionProducto`, `costoDolares`, `impuestoProducto`, `envioProducto`, `totalDolares`, `tipoCambio`, `costoQuetzaltes`, `envioGuate`, `totalQuetzales`, `porcentajeGanacia`, `gananciaEstimada`, `precioVenta`, `gananciaSugerida`, `precioSugerido`, `idEstadoProducto`, `idPedido`, `porcentajeOferta`, `precioOfertado`) VALUES
(1, 'P3001', 4, 11, 2, 'Corinto', 'manga 3/4', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 49.868793722112, 56.567446245537, 170, 14.7058823529412, 195, 3, 1, 0, 170),
(2, 'P3002', 4, 7, 2, 'Crema', 'Manga 3/4, espalda destapada', 8, 0.66000462403987, 0, 8.66000462403987, 7.75, 67.115035836309, 12.76, 79.875035836309, 37.7151181821405, 30.124964163691, 110, 13.6363636363636, 125, 2, 1, 0, 110),
(3, 'P3003', 4, 12, 4, 'Azul', 'Mujer', 8, 0.66000462403987, 0, 8.66000462403987, 7.75, 67.115035836309, 12.76, 79.875035836309, 50.2346743805169, 40.124964163691, 120, 16.6666666666667, 140, 2, 1, 0, 120),
(4, 'P3004', 4, 12, 2, 'Rosado/blanco', 'Mujer. Rayas', 8, 0.66000462403987, 0, 8.66000462403987, 7.75, 67.115035836309, 12.76, 79.875035836309, 50.2346743805169, 40.124964163691, 120, 16.6666666666667, 140, 2, 1, 0, 120),
(5, 'P3005', 4, 3, 2, 'Beige', 'Mujer. cerrado', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(6, 'P3006', 4, 3, 1, 'Beige', 'Mujer. cerrado', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(7, 'P3007', 4, 3, 1, 'Beige', 'Mujer. cerrado', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 3, 1, 0, 300),
(8, 'P3008', 4, 3, 4, 'Zapote', 'Mujer. cerrado. 0994', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 1, 1, 0, 300),
(9, 'P3009', 4, 3, 4, 'Zapote.', 'Mujer. cerrado. 0994', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(10, 'P3010', 4, 3, 3, 'Negro', 'Mujer. cerrado. 0531', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(11, 'P3011', 4, 3, 4, 'Azul', 'Mujer. Cerrado. 0648', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(12, 'P3012', 4, 3, 2, 'Azul', 'Mujer. Cerrado. 0622', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(13, 'P3013', 4, 3, 4, 'Negro', 'Mujer. Cerrado. 0549', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(14, 'P3014', 4, 3, 3, 'Morado', 'Mujer. Cerrado. 0887', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(15, 'P3015', 4, 3, 2, 'Morado', 'Mujer. Cerrado. 0879', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 3, 1, 0, 300),
(16, 'P3016', 4, 3, 2, 'Blanco', 'Mujer. Cerrado. 0671', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 3, 1, 0, 300),
(17, 'P3017', 4, 7, 2, 'Gris', 'Manga larga. 5936', 18.71, 1.54358581447325, 0, 20.2535858144732, 7.75, 156.965290062167, 12.76, 169.725290062167, -2.78408130010338, -4.72529006216701, 165, 12.1212121212121, 185, 2, 1, 0, 165),
(18, 'P3018', 4, 7, 3, 'Gris', 'Manga larga. 5944', 18.71, 1.54358581447325, 0, 20.2535858144732, 7.75, 156.965290062167, 12.76, 169.725290062167, -2.78408130010338, -4.72529006216701, 165, 12.1212121212121, 185, 2, 1, 0, 165),
(19, 'P3019', 4, 7, 1, 'Rosado/gris', 'Manga larga. 5993', 18.71, 1.54358581447325, 0, 20.2535858144732, 7.75, 156.965290062167, 12.76, 169.725290062167, -2.78408130010338, -4.72529006216701, 165, 12.1212121212121, 185, 2, 1, 0, 165),
(20, 'P3020', 4, 1, 3, 'Blanco', 'Manga larga. 6923', 11.99, 0.989181930279755, 0, 12.9791819302798, 7.75, 100.588659959668, 12.76, 113.348659959668, 41.1573811785085, 46.651340040332, 160, 12.5, 180, 3, 1, 0, 160),
(21, 'P3021', 4, 1, 4, 'Blanco', 'Manga larga. 6931', 11.99, 0.989181930279755, 0, 12.9791819302798, 7.75, 100.588659959668, 12.76, 113.348659959668, 41.1573811785085, 46.651340040332, 160, 12.5, 180, 2, 1, 0, 160),
(22, 'P3022', 4, 3, 4, 'Negro', 'Cerrado. Hombre. 2775', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(23, 'P3023', 4, 3, 3, 'Negro', 'Cerrado. Hombre. 2767', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, -88.3333333333333, 35, 2, 1, 0, 300),
(24, 'P3024', 4, 3, 4, 'Blanco', 'Hombre. Cerrado', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 1, 1, 0, 300),
(25, 'P3025', 4, 3, 4, 'Blanco', 'Hombre. Cerrado. 2890', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 1, 1, 0, 300),
(26, 'P3026', 4, 3, 3, 'Rojo', 'Hombre. Cerrado. 3187', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 3, 1, 0, 300),
(27, 'P3027', 4, 3, 3, 'Azul', 'Hombre. Cerrado. 3005', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 3, 1, 0, 300),
(28, 'P3028', 4, 3, 4, 'Azul', 'Hombre. Cerrado. 3013', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(29, 'P3029', 4, 3, 1, 'Azul', 'Hombre. Cerrado. 2981', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(30, 'P3030', 4, 6, 4, 'Blanco/azul', 'Hombre. Cuadros. 2480', 11.98, 0.988356924499705, 0, 12.9683569244997, 7.75, 100.504766164873, 12.76, 113.264766164873, 76.5774183552116, 86.735233835127, 200, 12.5, 225, 2, 1, 0, 200),
(31, 'P3031', 4, 6, 1, 'Corinto/azul', 'Hombre. Cuadros. 2654', 11.98, 0.988356924499705, 0, 12.9683569244997, 7.75, 100.504766164873, 12.76, 113.264766164873, 76.5774183552116, 86.735233835127, 200, 12.5, 225, 2, 1, 0, 200),
(32, 'P3032', 4, 6, 3, 'Corinto/azul', 'Hombre. Cuadros. 2670', 11.99, 0.989181930279755, 0, 12.9791819302798, 7.75, 100.588659959668, 12.76, 113.348659959668, 76.4467264731356, 86.651340040332, 200, 12.5, 225, 1, 1, 0, 200),
(33, 'P3033', 4, 11, 2, 'Fuscia', 'Mujer. Manga 3/4', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 49.868793722112, 56.567446245537, 170, 11.7647058823529, 190, 3, 1, 0, 170),
(34, 'P3034', 4, 12, 5, 'Rosado', 'Mujer. 1022', 8, 0.66000462403987, 0, 8.66000462403987, 7.75, 67.115035836309, 12.76, 79.875035836309, 50.2346743805169, 40.124964163691, 120, 16.6666666666667, 140, 1, 1, 0, 120),
(35, 'P3035', 4, 6, 2, 'Azul/amarillo', 'Hombre. Cuadros. 3066', 11.98, 0.988356924499705, 0, 12.9683569244997, 7.75, 100.504766164873, 12.76, 113.264766164873, 76.5774183552116, 86.735233835127, 200, 12.5, 225, 3, 1, 0, 200),
(36, 'P3036', 4, 7, 2, 'Gris', 'Manga larga. 0893', 8, 0.66000462403987, 0, 8.66000462403987, 7.75, 67.115035836309, 12.76, 79.875035836309, 50.2346743805169, 40.124964163691, 120, 16.6666666666667, 140, 3, 1, 0, 120),
(37, 'P3037', 4, 6, 1, 'Azul/rojo', 'Hombre. Cuadros. 1630', 18, 1.48501040408971, 0, 19.4850104040897, 7.75, 151.008830631695, 12.76, 163.768830631695, 40.4418649829981, 66.231169368305, 230, 10.8695652173913, 255, 3, 1, 0, 230),
(38, 'P3038', 4, 6, 2, 'Celeste', 'Hombre. Cuadros. 1705', 18, 1.48501040408971, 0, 19.4850104040897, 7.75, 151.008830631695, 12.76, 163.768830631695, 40.4418649829981, 66.231169368305, 230, 10.8695652173913, 255, 3, 1, 0, 230),
(39, 'P3039', 4, 11, 1, 'Gris/blanco', 'Mujer. ziper. 1294', 16, 1.32000924807974, 0, 17.3200092480797, 7.75, 134.230071672618, 12.76, 146.990071672618, 36.0636114563219, 53.009928327382, 200, 12.5, 225, 2, 1, 0, 200),
(40, 'P3040', 4, 11, 1, 'Corinto', 'Mujer. Manga 3/4. 3185', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 49.868793722112, 56.567446245537, 170, 11.7647058823529, 190, 2, 1, 0, 170),
(41, 'P3041', 4, 6, 3, 'Blanco/azul', 'Hombre. Cuadros. 2472', 11.98, 0.988356924499705, 0, 12.9683569244997, 7.75, 100.504766164873, 12.76, 113.264766164873, 76.5774183552116, 86.735233835127, 200, 12.5, 225, 3, 1, 0, 200),
(42, 'P3042', 4, 6, 3, 'Verde', 'Hombre. Cuadros. 4050', 18, 1.48501040408971, 0, 19.4850104040897, 7.75, 151.008830631695, 12.76, 163.768830631695, 37.3887809616286, 61.231169368305, 225, 11.1111111111111, 250, 3, 1, 0, 225),
(43, 'P3043', 4, 12, 2, 'Rosado', 'Mujer. 0990', 8, 0.66000462403987, 0, 8.66000462403987, 7.75, 67.115035836309, 12.76, 79.875035836309, 50.2346743805169, 40.124964163691, 120, 16.6666666666667, 140, 1, 1, 0, 120),
(44, 'P3044', 4, 6, 2, 'Blanco/azul', 'Hombre. Cuadros. 2464', 11.98, 0.988356924499705, 0, 12.9683569244997, 7.75, 100.504766164873, 12.76, 113.264766164873, 76.5774183552116, 86.735233835127, 200, 12.5, 225, 3, 1, 0, 200),
(45, 'P3045', 4, 11, 3, 'Corinto', 'Mujer. Manga 3/4. 3201', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 49.868793722112, 56.567446245537, 170, 11.7647058823529, 190, 2, 1, 0, 170),
(46, 'P3046', 4, 12, 2, 'Azul/amarillo', 'Hombre. Rayas. 6462', 8, 0.66000462403987, 0, 8.66000462403987, 7.75, 67.115035836309, 12.76, 79.875035836309, 50.2346743805169, 40.124964163691, 120, 16.6666666666667, 140, 1, 1, 0, 120),
(47, 'P3047', 4, 12, 2, 'Azul/blanco', 'Hombre. Rayas. 2166', 29.95, 2.47089231124926, 0, 32.4208923112493, 7.75, 251.261915412182, 12.76, 264.021915412182, -54.5492275470163, -144.021915412182, 120, 16.6666666666667, 140, 1, 1, 0, 120),
(48, 'P3048', 4, 12, 1, 'Azul/blanco', 'Hombre. Rayas. 2158', 29.95, 2.47089231124926, 0, 32.4208923112493, 7.75, 251.261915412182, 12.76, 264.021915412182, -54.5492275470163, -144.021915412182, 120, 16.6666666666667, 140, 3, 1, 0, 120),
(49, 'P3049', 4, 7, 1, 'Azul', 'Manga 3/4. Espalda destapada. 2980', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, -3.0260746503981, -3.432553754463, 110, 13.6363636363636, 125, 2, 1, 0, 110),
(50, 'P3050', 4, 12, 3, 'Blanco/celeste', 'Hombre. Rayas. 1994', 8, 0.66000462403987, 0, 8.66000462403987, 7.75, 67.115035836309, 12.76, 79.875035836309, 50.2346743805169, 40.124964163691, 120, 16.6666666666667, 140, 3, 1, 0, 120),
(51, 'P3051', 4, 12, 2, 'Blanco/celeste', 'Hombre. Rayas. 1986', 8, 0.66000462403987, 0, 8.66000462403987, 7.75, 67.115035836309, 12.76, 79.875035836309, 50.2346743805169, 40.124964163691, 120, 16.6666666666667, 140, 1, 1, 0, 120),
(52, 'P3052', 4, 12, 2, 'Azul', 'Hombre. 1861', 19.99, 1.64918655431962, 0, 21.6391865543196, 7.75, 167.703695795977, 12.76, 180.463695795977, -33.5046312385923, -60.463695795977, 120, 16.6666666666667, 140, 2, 1, 0, 120),
(53, 'P3053', 4, 12, 3, 'Azul/amarillo', 'Hombre. Rayas. 6479', 8, 0.66000462403987, 0, 8.66000462403987, 7.75, 67.115035836309, 12.76, 79.875035836309, 50.2346743805169, 40.124964163691, 120, 16.6666666666667, 140, 2, 1, 0, 120),
(54, 'P3054', 4, 11, 3, 'Crema', 'Mujer. Manga 3/4. 3151', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 49.868793722112, 56.567446245537, 170, 11.7647058823529, 190, 2, 1, 0, 170),
(55, 'P3055', 4, 12, 2, 'Gris', 'Hombre. 1564', 19.99, 1.64918655431962, 0, 21.6391865543196, 7.75, 167.703695795977, 12.76, 180.463695795977, -33.5046312385923, -60.463695795977, 120, 16.6666666666667, 140, 3, 1, 0, 120),
(56, 'P3056', 4, 3, 3, 'Azul', 'Hombre. 8183', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(57, 'P3057', 4, 3, 4, 'Azul', 'Hombre. 8191', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 1, 1, 0, 300),
(58, 'P3058', 4, 3, 2, 'Blanco', 'Hombre. Cerrado. 2874', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(59, 'P3059', 4, 3, 3, 'Blanco', 'Hombre. Cerrado. 8480', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(60, 'P3060', 4, 3, 2, 'Blanco', 'Hombre. Cerrado. 8472', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 3, 1, 0, 300),
(61, 'P3061', 4, 3, 3, 'Fuscia', 'Mujer. Cerrado. 2815', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(62, 'P3062', 4, 3, 3, 'Azul', 'Mujer. Abierto. 4760', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 164.474341862551, 186.567446245537, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(63, 'P3063', 4, 3, 5, 'Fuscia', 'Mujer. Cerrado. 2831', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 3, 1, 0, 300),
(64, 'P3064', 4, 3, 2, 'Aqua', 'Mujer. Cerrado. 4347', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 3, 1, 0, 300),
(65, 'P3065', 4, 3, 2, 'Azul', 'Mujer. Abierto. 4752', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 164.474341862551, 186.567446245537, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(66, 'P3066', 4, 3, 2, 'Azul', 'Mujer. Cerrado. 2856', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 1, 1, 0, 300),
(67, 'P3067', 4, 3, 1, 'Azul', 'Mujer. Cerrado. 2849', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 3, 1, 0, 300),
(68, 'P3068', 4, 3, 4, 'Fuscia', 'Mujer. Cerrado. 4570', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 302, 1, 1, 10, 270),
(69, 'P3069', 4, 3, 4, 'Azul', 'Mujer. Cerrado. 2872', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 3, 1, 0, 300),
(70, 'P3070', 4, 3, 1, 'Celeste', 'Mujer. Cerrado. 4497', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 164.474341862551, 186.567446245537, 300, 11.6666666666667, 335, 1, 1, 0, 300),
(71, 'P3071', 4, 3, 2, 'Celeste', 'Mujer. Cerrad. 4505', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 164.474341862551, 186.567446245537, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(72, 'P3072', 4, 3, 3, 'Celeste', 'Mujer. Cerrado. Sin etiqueta', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 164.474341862551, 186.567446245537, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(73, 'P3073', 4, 3, 3, 'Fuscia', 'Mujer. Cerrado. Sin etiqueta', 24.99, 2.06168944434454, 0, 27.0516894443445, 7.75, 209.65059319367, 12.76, 222.41059319367, 34.8856615560424, 77.58940680633, 300, 11.6666666666667, 335, 2, 1, 0, 300),
(74, 'P3074', 4, 3, 1, 'Gris', 'Mujer. Cerrado. Sin etiqueta', 12, 0.990006936059804, 0, 12.9900069360598, 7.75, 100.672553754463, 12.76, 113.432553754463, 164.474341862551, 186.567446245537, 300, 11.6666666666667, 335, 1, 1, 0, 300),
(75, 'P3075', 7, 13, 3, 'Gris', '50425', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(76, 'P3076', 7, 13, 2, 'Azul', '50425312', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 1, 2, 0, 50),
(77, 'P3077', 7, 13, 3, 'Café', '72597153', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 3, 2, 0, 50),
(78, 'P3078', 7, 13, 3, 'Café', '72597153', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(79, 'P3079', 7, 14, 2, 'Azul', 'Mujer. 54470052', 15, 1.27113574732812, 0, 16.2711357473281, 7.75, 126.101302041793, 12.76, 138.861302041793, 51.2300381115514, 71.138697958207, 210, 11.9047619047619, 235, 3, 2, 0, 210),
(80, 'P3080', 7, 14, 2, 'Azul', 'Mujer. 54470052', 15, 1.27113574732812, 0, 16.2711357473281, 7.75, 126.101302041793, 12.76, 138.861302041793, 51.2300381115514, 71.138697958207, 210, 11.9047619047619, 235, 3, 2, 0, 210),
(81, 'P3081', 7, 13, 3, 'Fuscia', '50425323', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 1, 2, 0, 50),
(82, 'P3082', 7, 13, 4, 'Blanco', '50425124', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 1, 2, 0, 50),
(83, 'P3083', 7, 14, 3, 'Gris', 'Mujer. 111758063', 15.8, 1.33892965385229, 0, 17.1389296538523, 7.75, 132.826704817355, 12.76, 145.586704817355, 44.2439405874694, 64.413295182645, 210, 11.9047619047619, 235, 2, 2, 0, 210),
(84, 'P3084', 7, 13, 4, 'Azul', '50425114', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(85, 'P3085', 7, 13, 4, 'Fuscia', '50425324', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 1, 2, 0, 50),
(86, 'P3086', 7, 13, 4, 'Café', '72597154', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(87, 'P3087', 7, 13, 2, 'Fuscia', '50425322', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 1, 2, 0, 50),
(88, 'P3088', 7, 13, 4, 'gris', '50425144', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(89, 'P3089', 7, 13, 3, 'Blanco', '50425123', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(90, 'P3090', 7, 15, 4, 'Negro', '4631034', 28.99, 2.45668168766949, 0, 31.4466816876695, 7.75, 243.711783079439, 12.76, 256.471783079439, 40.366318539024, 103.528216920561, 360, 8.33333333333333, 390, 2, 2, 0, 360),
(91, 'P3091', 7, 15, 4, 'Negro', '4631034', 28.99, 2.45668168766949, 0, 31.4466816876695, 7.75, 243.711783079439, 12.76, 256.471783079439, 40.366318539024, 103.528216920561, 360, 8.33333333333333, 390, 1, 2, 0, 360),
(92, 'P3092', 7, 13, 3, 'Anaranjado', '72597183', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(93, 'P3093', 7, 13, 2, 'Anaranjado', '72597182', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 3, 2, 0, 50),
(94, 'P3094', 7, 13, 4, 'Azul', '50425314', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(95, 'P3095', 7, 13, 4, 'Verde', '50425334', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 1, 2, 0, 50),
(96, 'P3096', 7, 13, 2, 'Blanco', '50425122', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 1, 2, 0, 50),
(97, 'P3097', 7, 13, 2, 'Gris', '50425142', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(98, 'P3098', 7, 13, 2, 'Verde', '50425332', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 1, 2, 0, 50),
(99, 'P3099', 7, 13, 2, 'Café', '72597152', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(100, 'P3100', 7, 13, 2, 'Azul marino', '50425112', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(101, 'P3101', 7, 13, 3, 'Azul marino', '50425113', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(102, 'P3102', 7, 13, 3, 'Verde', '50425333', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 3, 2, 0, 50),
(103, 'P3103', 7, 14, 2, 'Gris', '111658072', 15.8, 1.33892965385229, 0, 17.1389296538523, 7.75, 132.826704817355, 12.76, 145.586704817355, 44.2439405874694, 64.413295182645, 210, 11.9047619047619, 235, 2, 2, 0, 210),
(104, 'P3104', 7, 15, 4, 'Negro', '50478024', 28.99, 2.45668168766949, 0, 31.4466816876695, 7.75, 243.711783079439, 12.76, 256.471783079439, 40.366318539024, 103.528216920561, 360, 8.33333333333333, 390, 3, 2, 0, 360),
(105, 'P3105', 7, 15, 4, 'Negro', '50478024', 28.99, 2.45668168766949, 0, 31.4466816876695, 7.75, 243.711783079439, 12.76, 256.471783079439, 40.366318539024, 103.528216920561, 360, 8.33333333333333, 390, 2, 2, 0, 360),
(106, 'P3106', 7, 14, 3, 'Azul', '4470053', 15, 1.27113574732812, 0, 16.2711357473281, 7.75, 126.101302041793, 12.76, 138.861302041793, 51.2300381115514, 71.138697958207, 210, 11.9047619047619, 235, 2, 2, 0, 210),
(107, 'P3107', 7, 14, 3, 'Azul', '4470053', 15, 1.27113574732812, 0, 16.2711357473281, 7.75, 126.101302041793, 12.76, 138.861302041793, 51.2300381115514, 71.138697958207, 210, 11.9047619047619, 235, 1, 2, 0, 210),
(108, 'P3108', 7, 13, 3, 'Azul', '50425313', 1.8, 0.152536289679375, 0, 1.95253628967937, 7.75, 15.1321562450151, 12.76, 27.8921562450151, 79.2618668875269, 22.1078437549849, 50, 30, 65, 2, 2, 0, 50),
(109, 'P3109', 3, 12, 4, 'Negro', 'Mujer. 58959', 9, 0.742159163644122, 0, 9.74215916364412, 7.75, 75.5017335182419, 12.76, 88.2617335182419, 24.629321921561, 21.7382664817581, 110, 18.1818181818182, 130, 2, 3, 0, 110),
(110, 'P3110', 3, 6, 1, 'Verde/gris', 'Mujer. Cuadros. 90027', 6.99, 0.576410283763601, 0, 7.5664102837636, 7.75, 58.6396796991679, 12.76, 71.3996796991679, 110.084976055919, 78.6003203008321, 150, 16.6666666666667, 175, 3, 3, 0, 150),
(111, 'P3111', 3, 7, 3, 'Azul', 'Manga larga. Botones. 13138', 8, 0.65969703435033, 0, 8.65969703435033, 7.75, 67.1126520162151, 12.76, 79.8726520162151, 37.7192283256961, 30.1273479837849, 110, 18.1818181818182, 130, 3, 3, 0, 110),
(112, 'P3112', 3, 12, 3, 'Azul', 'Mujer. 76399', 5, 0.412310646468957, 0, 5.41231064646896, 7.75, 41.9454075101344, 12.76, 54.7054075101344, 101.077014150058, 55.2945924898656, 110, 18.1818181818182, 130, 2, 3, 0, 110),
(113, 'P3113', 3, 12, 4, 'Azul', 'Mujer. 76402', 5, 0.412310646468957, 0, 5.41231064646896, 7.75, 41.9454075101344, 12.76, 54.7054075101344, 101.077014150058, 55.2945924898656, 110, 18.1818181818182, 130, 1, 3, 0, 110),
(114, 'P3114', 3, 7, 3, 'Gris', 'Manga larga. 400767', 2.79, 0.230069340729678, 0, 3.02006934072968, 7.75, 23.405537390655, 12.76, 36.165537390655, 204.156962502162, 73.834462609345, 110, 18.1818181818182, 130, 2, 3, 0, 110),
(115, 'P3115', 3, 7, 4, 'Gris', 'Manga larga. 12638', 2.79, 0.230069340729678, 0, 3.02006934072968, 7.75, 23.405537390655, 12.76, 36.165537390655, 204.156962502162, 73.834462609345, 110, 18.1818181818182, 130, 3, 3, 0, 110),
(116, 'P3116', 3, 13, 2, 'Morado', 'Zipper. 74965', 6, 0.494772775762748, 0, 6.49477277576275, 7.75, 50.3344890121613, 12.76, 63.0944890121613, 50.5678253162316, 31.9055109878387, 95, 15.7894736842105, 110, 1, 3, 0, 95),
(117, 'P3117', 3, 13, 4, 'Morado', 'Zipper. 74981', 6, 0.494772775762748, 0, 6.49477277576275, 7.75, 50.3344890121613, 12.76, 63.0944890121613, 50.5678253162316, 31.9055109878387, 95, 15.7894736842105, 110, 2, 3, 0, 95),
(118, 'P3118', 3, 13, 2, 'Rosado', 'Zipper. 75031', 6, 0.494772775762748, 0, 6.49477277576275, 7.75, 50.3344890121613, 12.76, 63.0944890121613, 50.5678253162316, 31.9055109878387, 95, 15.7894736842105, 110, 3, 3, 0, 95),
(119, 'P3119', 3, 13, 3, 'Negro', 'Zipper. 74906', 6, 0.494772775762748, 0, 6.49477277576275, 7.75, 50.3344890121613, 12.76, 63.0944890121613, 50.5678253162316, 31.9055109878387, 95, 15.7894736842105, 110, 2, 3, 0, 95),
(120, 'P3120', 3, 13, 3, 'Rosado', 'Zipper. 75058', 6, 0.494772775762748, 0, 6.49477277576275, 7.75, 50.3344890121613, 12.76, 63.0944890121613, 50.5678253162316, 31.9055109878387, 95, 15.7894736842105, 110, 2, 3, 0, 95),
(121, 'P3121', 3, 6, 1, 'Azul/verde', 'Mujer, Cuadros. 90094', 6.99, 0.576410283763601, 0, 7.5664102837636, 7.75, 58.6396796991679, 12.76, 71.3996796991679, 110.084976055919, 78.6003203008321, 150, 16.6666666666667, 175, 1, 3, 0, 150),
(122, 'P3122', 3, 13, 1, 'Negro', 'Zipper. 74884', 6, 0.494772775762748, 0, 6.49477277576275, 7.75, 50.3344890121613, 12.76, 63.0944890121613, 50.5678253162316, 31.9055109878387, 95, 15.7894736842105, 110, 2, 3, 0, 95),
(123, 'P3123', 3, 16, 5, 'Negro', 'Mujer. Zipper. 7577', 22, 1.81467595072309, 0, 23.8146759507231, 7.75, 184.563738618104, 12.76, 197.323738618104, 44.4326982632245, 87.676261381896, 285, 10.5263157894737, 315, 3, 4, 0, 285),
(124, 'P3124', 3, 16, 3, 'Beige', 'Mujer. Zipper. 7666', 22, 1.81467595072309, 0, 23.8146759507231, 7.75, 184.563738618104, 12.76, 197.323738618104, 44.4326982632245, 87.676261381896, 285, 10.5263157894737, 315, 2, 4, 0, 285),
(125, 'P3125', 3, 16, 3, 'Gris', 'Mujer. Zipper. 7607', 22, 1.81467595072309, 0, 23.8146759507231, 7.75, 184.563738618104, 12.76, 197.323738618104, 44.4326982632245, 87.676261381896, 285, 10.5263157894737, 315, 3, 4, 0, 285),
(126, 'P3126', 3, 16, 2, 'Beige', 'Mujer. Zipper. 7658', 22, 1.81467595072309, 0, 23.8146759507231, 7.75, 184.563738618104, 12.76, 197.323738618104, 44.4326982632245, 87.676261381896, 285, 10.5263157894737, 315, 1, 4, 0, 285),
(127, 'P3127', 3, 16, 4, 'Gris', 'Mujer. Zipper. 7615', 22, 1.81467595072309, 0, 23.8146759507231, 7.75, 184.563738618104, 12.76, 197.323738618104, 44.4326982632245, 87.676261381896, 285, 8.7719298245614, 310, 2, 4, 0, 285),
(128, 'P3128', 3, 16, 2, 'Gris', 'Mujer. Zipper. 7593', 22, 1.81467595072309, 0, 23.8146759507231, 7.75, 184.563738618104, 12.76, 197.323738618104, 44.4326982632245, 87.676261381896, 285, 10.5263157894737, 315, 2, 4, 0, 285),
(129, 'P3129', 3, 16, 2, 'Negro', 'Mujer. Zipper. 7534', 22, 1.81467595072309, 0, 23.8146759507231, 7.75, 184.563738618104, 12.76, 197.323738618104, 44.4326982632245, 87.676261381896, 285, 10.5263157894737, 315, 3, 4, 0, 285),
(130, 'P3130', 3, 16, 4, 'Negro', 'Mujer. Zipper. 7569', 22, 1.81467595072309, 0, 23.8146759507231, 7.75, 184.563738618104, 12.76, 197.323738618104, 44.4326982632245, 87.676261381896, 285, 10.5263157894737, 315, 2, 4, 0, 285),
(131, 'P3131', 3, 7, 3, 'Verde limón', 'Manga larga. Botones. 1492', 5.59, 0.461092662024639, 0, 6.05109266202464, 7.75, 46.895968130691, 12.76, 59.655968130691, 76.0092129759286, 45.344031869309, 105, 19.0476190476191, 125, 2, 4, 0, 105),
(132, 'P3132', 3, 17, 3, 'Corinto/azul', 'Hombre. 8143', 9.09, 0.749791108730584, 0, 9.83979110873059, 7.75, 76.2583810926621, 12.76, 89.0183810926621, 96.5886122078954, 85.9816189073379, 175, 14.2857142857143, 200, 3, 4, 0, 175),
(133, 'P3133', 3, 7, 2, 'Gris', 'Manga larga. Encaje. 0759', 2.79, 0.230133904659882, 0, 3.02013390465988, 7.75, 23.4060377611141, 12.76, 36.1660377611141, 204.152754378509, 73.8339622388859, 110, 18.1818181818182, 130, 3, 4, 0, 110),
(134, 'P3134', 3, 12, 2, 'Azul', 'Mujer. 6372', 5, 0.412426352437065, 0, 5.41242635243707, 7.75, 41.9463042313873, 12.76, 54.7063042313873, 101.073718185643, 55.2936957686127, 110, 18.1818181818182, 130, 1, 4, 0, 110),
(135, 'P3135', 3, 12, 2, 'Gris', 'Mujer. 6232', 5, 0.412426352437065, 0, 5.41242635243707, 7.75, 41.9463042313873, 12.76, 54.7063042313873, 101.073718185643, 55.2936957686127, 110, 18.1818181818182, 130, 1, 4, 0, 110),
(136, 'P3136', 3, 12, 2, 'Rosado', 'Mujer. 6453', 5, 0.412426352437065, 0, 5.41242635243707, 7.75, 41.9463042313873, 12.76, 54.7063042313873, 101.073718185643, 55.2936957686127, 110, 18.1818181818182, 130, 1, 4, 0, 110),
(137, 'P3137', 3, 12, 3, 'Rosado', 'Mujer. 6461', 5, 0.412426352437065, 0, 5.41242635243707, 7.75, 41.9463042313873, 12.76, 54.7063042313873, 101.073718185643, 55.2936957686127, 110, 18.1818181818182, 130, 2, 4, 0, 110),
(138, 'P3138', 3, 16, 4, 'Azul', 'Hombre. Botones. 9276', 11.19, 0.923010176754151, 0, 12.1130101767542, 7.75, 93.8758288698451, 12.76, 106.635828869845, 110.99850058335, 118.364171130155, 225, 11.1111111111111, 250, 2, 4, 0, 225),
(139, 'P3139', 3, 12, 1, 'Gris', 'Mujer. 6224', 5, 0.412426352437065, 0, 5.41242635243707, 7.75, 41.9463042313873, 12.76, 54.7063042313873, 101.073718185643, 55.2936957686127, 110, 18.1818181818182, 130, 2, 4, 0, 110),
(140, 'P3140', 3, 7, 2, 'Celeste', 'Manga larga. Botones. 3197', 8, 0.659882163899304, 0, 8.6598821638993, 7.75, 67.1140867702196, 12.76, 79.8740867702196, 37.7167545169513, 30.1259132297804, 110, 18.1818181818182, 130, 1, 4, 0, 110),
(141, 'P3141', 3, 7, 4, 'Celeste', 'Manga larga. Botones. 3227', 8, 0.659882163899304, 0, 8.6598821638993, 7.75, 67.1140867702196, 12.76, 79.8740867702196, 37.7167545169513, 30.1259132297804, 110, 18.1818181818182, 130, 1, 4, 0, 110),
(142, 'P3142', 3, 7, 4, 'Azul', 'Manga larga. Botones. 3146', 8, 0.659882163899304, 0, 8.6598821638993, 7.75, 67.1140867702196, 12.76, 79.8740867702196, 37.7167545169513, 30.1259132297804, 110, 18.1818181818182, 130, 1, 4, 0, 110),
(143, 'P3143', 3, 7, 4, 'Azul', 'Manga larga. Botones. 3146', 8, 0.659882163899304, 0, 8.6598821638993, 7.75, 67.1140867702196, 12.76, 79.8740867702196, 37.7167545169513, 30.1259132297804, 110, 18.1818181818182, 130, 2, 4, 0, 110),
(144, 'P3144', 3, 6, 2, 'Verde/gris', 'Mujer. Cuadros. 0035', 6.99, 0.576659070191431, 0, 7.56665907019143, 7.75, 58.6416077939836, 12.76, 71.4016077939836, 110.079303021856, 78.5983922060164, 150, 16.6666666666667, 175, 2, 5, 0, 150),
(145, 'P3145', 3, 6, 1, 'Azul', 'Mujer. Cuadros. 0094', 6.99, 0.576659070191431, 0, 7.56665907019143, 7.75, 58.6416077939836, 12.76, 71.4016077939836, 110.079303021856, 78.5983922060164, 150, 16.6666666666667, 175, 3, 5, 0, 150),
(146, 'P3146', 3, 16, 3, 'Negro', 'Hombre. Zipper. 4078', 24.75, 2.04181859617138, 0, 26.7918185961714, 7.75, 207.636594120328, 12.76, 220.396594120328, 45.1928063032101, 99.603405879672, 320, 9.375, 350, 2, 5, 0, 320),
(147, 'P3147', 3, 16, 3, 'Negro', 'Hombre. Zipper. 4159', 24.75, 2.04181859617138, 0, 26.7918185961714, 7.75, 207.636594120328, 12.76, 220.396594120328, 45.1928063032101, 99.603405879672, 320, 9.375, 350, 2, 5, 0, 320),
(148, 'P3148', 3, 16, 2, 'Negro', 'Hombre. Zipper. 4132', 24.75, 2.04181859617138, 0, 26.7918185961714, 7.75, 207.636594120328, 12.76, 220.396594120328, 45.1928063032101, 99.603405879672, 320, 9.375, 350, 1, 5, 0, 320),
(149, 'P3149', 3, 16, 4, 'Negro', 'Hombre. Zipper. 4086', 24.75, 2.04181859617138, 0, 26.7918185961714, 7.75, 207.636594120328, 12.76, 220.396594120328, 45.1928063032101, 99.603405879672, 320, 9.375, 350, 2, 5, 0, 320),
(150, 'P3150', 3, 16, 3, 'Gris', 'Hombre. Zipper. 5451', 13.99, 1.15414311759344, 0, 15.1441431175934, 7.75, 117.367109161349, 12.76, 130.127109161349, 53.6958757394766, 69.872890838651, 200, 12.5, 225, 2, 5, 0, 200),
(151, 'P3151', 3, 16, 4, 'Gris', 'Hombre. Zipper. 5478', 13.99, 1.15414311759344, 0, 15.1441431175934, 7.75, 117.367109161349, 12.76, 130.127109161349, 53.6958757394766, 69.872890838651, 200, 12.5, 225, 2, 5, 0, 200),
(152, 'P3152', 3, 16, 4, 'Negro', 'Hombre. Zipper. 4167', 24.75, 2.04181859617138, 0, 26.7918185961714, 7.75, 207.636594120328, 12.76, 220.396594120328, 45.1928063032101, 99.603405879672, 320, 9.375, 350, 2, 5, 0, 320),
(153, 'P3153', 3, 16, 3, 'Gris', 'Hombre. Zipper. 5451', 13.99, 1.15414311759344, 0, 15.1441431175934, 7.75, 117.367109161349, 12.76, 130.127109161349, 53.6958757394766, 69.872890838651, 200, 12.5, 225, 3, 5, 0, 200),
(154, 'P3154', 3, 3, 3, 'Gris', 'Hombre. Cerrado. 1047', 17.8, 1.46845943482224, 0, 19.2684594348222, 7.75, 149.330560619872, 12.76, 162.090560619872, 54.2347679247588, 87.909439380128, 250, 10, 275, 2, 5, 0, 250),
(155, 'P3155', 3, 3, 2, 'Gris', 'Hombre. Cerrado. 1039', 17.8, 1.46845943482224, 0, 19.2684594348222, 7.75, 149.330560619872, 12.76, 162.090560619872, 54.2347679247588, 87.909439380128, 250, 10, 275, 3, 5, 0, 250),
(156, 'P3156', 3, 17, 3, 'Azul/gris', 'Hombre. 8054', 9.09, 0.749904284412032, 0, 9.83990428441203, 7.75, 76.2592582041932, 12.76, 89.0192582041932, 96.5866752097432, 85.9807417958068, 175, 14.2857142857143, 200, 3, 5, 0, 175),
(157, 'P3157', 3, 17, 3, 'Azul/gris', 'Hombre. 8054', 9.09, 0.749904284412032, 0, 9.83990428441203, 7.75, 76.2592582041932, 12.76, 89.0192582041932, 96.5866752097432, 85.9807417958068, 175, 14.2857142857143, 200, 3, 5, 0, 175),
(158, 'P3158', 3, 17, 3, 'Azul/corinto', 'Hombre. 8143', 9.09, 0.749904284412032, 0, 9.83990428441203, 7.75, 76.2592582041932, 12.76, 89.0192582041932, 96.5866752097432, 85.9807417958068, 175, 14.2857142857143, 200, 3, 5, 0, 175),
(159, 'P3159', 3, 3, 4, 'Azul pavo', 'Hombre. Cerrado. 1225', 17.8, 1.46845943482224, 0, 19.2684594348222, 7.75, 149.330560619872, 12.76, 162.090560619872, 54.2347679247588, 87.909439380128, 250, 10, 275, 2, 5, 0, 250),
(160, 'P3160', 3, 3, 3, 'Azul pavo', 'Hombre. Cerrado. 1217', 17.8, 1.46845943482224, 0, 19.2684594348222, 7.75, 149.330560619872, 12.76, 162.090560619872, 54.2347679247588, 87.909439380128, 250, 10, 275, 2, 5, 0, 250),
(161, 'P3161', 5, 16, 2, 'Blanco', 'Hombre. Cuello Alto. 3251', 20.99, 1.88982940784162, 0, 22.8798294078416, 7.75, 177.318677910772, 12.76, 190.078677910772, 49.9379115703796, 94.921322089228, 285, 8.7719298245614, 310, 2, 6, 0, 285),
(162, 'P3162', 5, 16, 2, 'Azul', 'Hombre. Cuello Alto. 3288', 20.99, 1.88982940784162, 0, 22.8798294078416, 7.75, 177.318677910772, 12.76, 190.078677910772, 49.9379115703796, 94.921322089228, 285, 8.7719298245614, 310, 1, 6, 0, 285),
(163, 'P3163', 5, 3, 2, 'Gris', 'Hombre. Abierto. 6398', 29.99, 2.70014216013198, 0, 32.690142160132, 7.75, 253.348601741023, 12.76, 266.108601741023, 31.525248605312, 83.891398258977, 350, 8.57142857142857, 380, 2, 6, 0, 350),
(164, 'P3164', 5, 16, 2, 'Negro', 'Hombre. Cuello Alto. 3244', 20.99, 1.88982940784162, 0, 22.8798294078416, 7.75, 177.318677910772, 12.76, 190.078677910772, 49.9379115703796, 94.921322089228, 285, 8.7719298245614, 310, 2, 6, 0, 285),
(165, 'P3165', 5, 11, 2, 'Gris', 'Hombre. Rayas. Cuello V. 3418', 23.99, 2.15993365860508, 0, 26.1499336586051, 7.75, 202.66198585419, 12.76, 215.42198585419, 50.8666809059957, 109.57801414581, 325, 7.69230769230769, 350, 2, 6, 0, 325),
(166, 'P3166', 5, 11, 2, 'Negro', 'Hombre. Cuello V. Rayas. 3408', 23.99, 2.15993365860508, 0, 26.1499336586051, 7.75, 202.66198585419, 12.76, 215.42198585419, 50.8666809059957, 109.57801414581, 325, 7.69230769230769, 350, 3, 6, 0, 325),
(167, 'P3167', 5, 11, 2, 'Negro', 'Hombre. Cuello V. Rayas. 3408', 23.99, 2.15993365860508, 0, 26.1499336586051, 7.75, 202.66198585419, 12.76, 215.42198585419, 50.8666809059957, 109.57801414581, 325, 7.69230769230769, 350, 2, 6, 0, 325),
(168, 'P3168', 5, 3, 2, 'Negro', 'Hombre. Abierto. 4052', 29.99, 2.70014216013198, 0, 32.690142160132, 7.75, 253.348601741023, 12.76, 266.108601741023, 31.525248605312, 83.891398258977, 350, 8.57142857142857, 380, 2, 6, 0, 350),
(169, 'P3169', 5, 3, 2, 'Negro', 'Hombre. Abierto. 6405', 29.99, 2.70014216013198, 0, 32.690142160132, 7.75, 253.348601741023, 12.76, 266.108601741023, 31.525248605312, 83.891398258977, 350, 8.57142857142857, 380, 2, 6, 0, 350),
(170, 'P3170', 5, 3, 2, 'Azul', 'Hombre. Abierto. 6412', 29.99, 2.70014216013198, 0, 32.690142160132, 7.75, 253.348601741023, 12.76, 266.108601741023, 31.525248605312, 83.891398258977, 350, 8.57142857142857, 380, 1, 6, 0, 350),
(171, 'P3171', 5, 3, 2, 'Azul', 'Hombre. Abierto. 6412', 29.99, 2.70014216013198, 0, 32.690142160132, 7.75, 253.348601741023, 12.76, 266.108601741023, 31.525248605312, 83.891398258977, 350, 8.57142857142857, 380, 3, 6, 0, 350),
(172, 'P3172', 3, 3, 3, 'Gris', 'Hombre. Cerrado. 2486', 19.75, 1.77771679473106, 0, 21.5277167947311, 7.75, 166.839805159166, 12.76, 179.599805159166, 44.7663040444733, 80.400194840834, 260, 11.5384615384615, 290, 2, 7, 0, 260),
(173, 'P3173', 3, 3, 2, 'Azul', 'Mujer. Cerrado. 5553', 22.25, 2.00274423710208, 0, 24.2527442371021, 7.75, 187.958767837541, 12.76, 200.718767837541, 24.5523787802178, 49.281232162459, 250, 10, 275, 2, 7, 0, 250),
(174, 'P3174', 3, 3, 2, 'Negro', 'Hombre. Cerrado. 2389', 19.75, 1.77771679473106, 0, 21.5277167947311, 7.75, 166.839805159166, 12.76, 179.599805159166, 44.7663040444733, 80.400194840834, 260, 11.5384615384615, 290, 2, 7, 0, 260),
(175, 'P3175', 3, 3, 2, 'Rosado', 'Mujer. Cerrado. 5707', 22.25, 2.00274423710208, 0, 24.2527442371021, 7.75, 187.958767837541, 12.76, 200.718767837541, 24.5523787802178, 49.281232162459, 250, 10, 275, 1, 7, 0, 250),
(176, 'P3176', 3, 3, 2, 'Gris', 'Hombre. Cerrado. 2478', 19.75, 1.77771679473106, 0, 21.5277167947311, 7.75, 166.839805159166, 12.76, 179.599805159166, 44.7663040444733, 80.400194840834, 260, 11.5384615384615, 290, 3, 7, 0, 260),
(177, 'P3177', 3, 3, 3, 'Negro', 'Hombre. Cerrado. 2397', 19.75, 1.77771679473106, 0, 21.5277167947311, 7.75, 166.839805159166, 12.76, 179.599805159166, 44.7663040444733, 80.400194840834, 260, 11.5384615384615, 290, 2, 7, 0, 260),
(178, 'P3178', 3, 3, 3, 'Azul', 'Mujer. Cerrado. 5561', 22.25, 2.00274423710208, 0, 24.2527442371021, 7.75, 187.958767837541, 12.76, 200.718767837541, 24.5523787802178, 49.281232162459, 250, 10, 275, 1, 7, 0, 250),
(179, 'P3179', 3, 3, 3, 'Rosado', 'Mujer. Cerrado. 5715', 22.25, 2.00274423710208, 0, 24.2527442371021, 7.75, 187.958767837541, 12.76, 200.718767837541, 24.5523787802178, 49.281232162459, 250, 10, 275, 2, 7, 0, 250),
(180, 'P3180', 3, 18, 6, 'Rojo', 'Mujer. 9103', 8, 0.720087815587266, 0, 8.72008781558727, 7.75, 67.5806805708013, 12.76, 80.3406805708014, 49.3639326271928, 39.6593194291986, 120, 16.6666666666667, 140, 1, 7, 0, 120),
(181, 'P3181', 3, 18, 6, 'Aqua', 'Mujer. 3061', 8, 0.720087815587266, 0, 8.72008781558727, 7.75, 67.5806805708013, 12.76, 80.3406805708014, 49.3639326271928, 39.6593194291986, 120, 16.6666666666667, 140, 1, 7, 0, 120),
(182, 'P3182', 3, 18, 6, 'Azul', 'Mujer. 9081', 8, 0.720087815587266, 0, 8.72008781558727, 7.75, 67.5806805708013, 12.76, 80.3406805708014, 49.3639326271928, 39.6593194291986, 120, 16.6666666666667, 140, 3, 7, 0, 120),
(183, 'P3183', 3, 3, 3, 'Gris', 'Hombre. Abierto. 6926', 17.2, 1.54788953114965, 0, 18.7478895311496, 7.75, 145.296143866409, 12.76, 158.056143866409, 64.4985089727073, 101.943856133591, 260, 11.5384615384615, 290, 1, 8, 0, 260),
(184, 'P3184', 3, 3, 2, 'Azul', 'Hombre. Abierto. 7167', 17.2, 1.54788953114965, 0, 18.7478895311496, 7.75, 145.296143866409, 12.76, 158.056143866409, 1.22985167551219, 1.943856133591, 160, 18.75, 190, 3, 8, 0, 160),
(185, 'P3185', 3, 3, 4, 'Azul', 'Hombre. Abierto. 7183', 17.2, 1.54788953114965, 0, 18.7478895311496, 7.75, 145.296143866409, 12.76, 158.056143866409, 64.4985089727073, 101.943856133591, 260, 11.5384615384615, 290, 3, 8, 0, 260),
(186, 'P3186', 3, 3, 3, 'Azul', 'Hombre. Abierto. 7175', 17.2, 1.54788953114965, 0, 18.7478895311496, 7.75, 145.296143866409, 12.76, 158.056143866409, 64.4985089727073, 101.943856133591, 260, 11.5384615384615, 290, 1, 8, 0, 260),
(187, 'P3187', 3, 3, 4, 'Gris', 'Hombre. Abierto. 3232', 17.2, 1.54788953114965, 0, 18.7478895311496, 7.75, 145.296143866409, 12.76, 158.056143866409, 64.4985089727073, 101.943856133591, 260, 11.5384615384615, 290, 2, 8, 0, 260),
(188, 'P3188', 3, 16, 3, 'Gris/negro', 'Mujer. Cuero. 8079', 15.35, 1.38140141297367, 0, 16.7314014129737, 7.75, 129.668360950546, 12.76, 142.428360950546, 57.9741552162666, 82.571639049454, 225, 11.1111111111111, 250, 3, 8, 0, 225),
(189, 'P3189', 3, 16, 2, 'Negro/gris', 'Mujer. Cuero. 8052', 15.35, 1.38140141297367, 0, 16.7314014129737, 7.75, 129.668360950546, 12.76, 142.428360950546, 57.9741552162666, 82.571639049454, 225, 11.1111111111111, 250, 3, 8, 0, 225),
(190, 'P3190', 3, 11, 2, 'Azul', 'Mujer. Largo. 8557', 13.76, 1.23831162491972, 0, 14.9983116249197, 7.75, 116.236915093128, 12.76, 128.996915093128, 55.0424673765354, 71.003084906872, 200, 12.5, 225, 2, 8, 0, 200),
(191, 'P3191', 3, 11, 2, 'Azul', 'Mujer. Largo. 8557', 13.76, 1.23831162491972, 0, 14.9983116249197, 7.75, 116.236915093128, 12.76, 128.996915093128, 55.0424673765354, 71.003084906872, 200, 12.5, 225, 3, 8, 0, 200),
(192, 'P3192', 3, 11, 4, 'Azul', 'Mujer. Largo. 8565', 13.76, 1.23831162491972, 0, 14.9983116249197, 7.75, 116.236915093128, 12.76, 128.996915093128, 55.0424673765354, 71.003084906872, 200, 12.5, 225, 1, 8, 0, 200),
(193, 'P3193', 3, 19, 6, 'Blanco', '9073', 13.76, 1.23831162491972, 0, 14.9983116249197, 7.75, 116.236915093128, 12.76, 128.996915093128, 16.2818505324015, 21.003084906872, 150, 13.3333333333333, 170, 1, 8, 0, 150),
(194, 'P3194', 3, 19, 6, 'Blanco', '9073', 13.76, 1.23831162491972, 0, 14.9983116249197, 7.75, 116.236915093128, 12.76, 128.996915093128, 16.2818505324015, 21.003084906872, 150, 13.3333333333333, 170, 2, 8, 0, 150),
(195, 'P3195', 3, 19, 6, 'Rojo', '9065', 13.76, 1.23831162491972, 0, 14.9983116249197, 7.75, 116.236915093128, 12.76, 128.996915093128, 16.2818505324015, 21.003084906872, 150, 13.3333333333333, 170, 3, 8, 0, 150),
(196, 'P3196', 3, 19, 6, 'Rojo', '9065', 13.76, 1.23831162491972, 0, 14.9983116249197, 7.75, 116.236915093128, 12.76, 128.996915093128, 16.2818505324015, 21.003084906872, 150, 13.3333333333333, 170, 3, 8, 0, 150),
(197, 'P3197', 3, 19, 6, 'Azul', '9057', 13.76, 1.23831162491972, 0, 14.9983116249197, 7.75, 116.236915093128, 12.76, 128.996915093128, 16.2818505324015, 21.003084906872, 150, 13.3333333333333, 170, 3, 8, 0, 150),
(198, 'P3198', 3, 19, 6, 'Azul', '9057', 13.76, 1.23831162491972, 0, 14.9983116249197, 7.75, 116.236915093128, 12.76, 128.996915093128, 16.2818505324015, 21.003084906872, 150, 13.3333333333333, 170, 3, 8, 0, 150),
(199, 'P3199', 3, 19, 6, 'Aqua', '9049', 13.76, 1.23831162491972, 0, 14.9983116249197, 7.75, 116.236915093128, 12.76, 128.996915093128, 16.2818505324015, 21.003084906872, 150, 13.3333333333333, 170, 1, 8, 0, 150),
(200, 'P3200', 3, 1, 4, 'Blanco', '6044', 10.32, 0.928733718689788, 0, 11.2487337186898, 7.75, 87.177686319846, 12.76, 99.937686319846, 40.0872935480379, 40.062313680154, 140, 14.2857142857143, 160, 2, 8, 0, 140),
(201, 'P3201', 3, 1, 3, 'Blanco', '6036', 10.32, 0.928733718689788, 0, 11.2487337186898, 7.75, 87.177686319846, 12.76, 99.937686319846, 40.0872935480379, 40.062313680154, 140, 14.2857142857143, 160, 1, 8, 0, 140),
(202, 'P3202', 3, 1, 3, 'Azul', '6192', 10.32, 0.928733718689788, 0, 11.2487337186898, 7.75, 87.177686319846, 12.76, 99.937686319846, 40.0872935480379, 40.062313680154, 140, 14.2857142857143, 160, 3, 8, 0, 140),
(203, 'P3203', 3, 1, 3, 'Gris', '5943', 10.32, 0.928733718689788, 0, 11.2487337186898, 7.75, 87.177686319846, 12.76, 99.937686319846, 40.0872935480379, 40.062313680154, 140, 14.2857142857143, 160, 3, 8, 0, 140),
(204, 'P3204', 3, 1, 2, 'Gris', '5935', 10.32, 0.928733718689788, 0, 11.2487337186898, 7.75, 87.177686319846, 12.76, 99.937686319846, 40.0872935480379, 40.062313680154, 140, 14.2857142857143, 160, 3, 8, 0, 140),
(205, 'P3205', 3, 1, 3, 'Azul', '1866', 10.32, 0.928733718689788, 0, 11.2487337186898, 7.75, 87.177686319846, 12.76, 99.937686319846, 40.0872935480379, 40.062313680154, 140, 14.2857142857143, 160, 3, 8, 0, 140),
(206, 'P3206', 3, 1, 2, 'Blanco', '1777', 10.32, 0.928733718689788, 0, 11.2487337186898, 7.75, 87.177686319846, 12.76, 99.937686319846, 40.0872935480379, 40.062313680154, 140, 14.2857142857143, 160, 3, 8, 0, 140),
(207, 'P3207', 3, 1, 4, 'Blanco', '6478', 10.06, 0.905335388567758, 0, 10.9653353885678, 7.75, 84.9813492614005, 12.76, 97.7413492614005, 43.2351825076432, 42.2586507385995, 140, 14.2857142857143, 160, 2, 8, 0, 140),
(208, 'P3208', 3, 1, 2, 'Azul', '6354', 11.7, 1.05292485549133, 0, 12.7529248554913, 7.75, 98.8351676300576, 12.76, 111.595167630058, 25.4534609097995, 28.404832369942, 140, 14.2857142857143, 160, 1, 8, 0, 140),
(209, 'P3209', 3, 19, 6, 'Beige', '', 9.75, 0.877437379576108, 0, 10.6274373795761, 7.75, 82.3626396917148, 12.76, 95.1226396917148, 5.1274442383983, 4.8773603082852, 100, 20, 120, 2, 8, 0, 100),
(210, 'P3210', 3, 19, 6, 'Beige', '8058', 9.75, 0.877437379576108, 0, 10.6274373795761, 7.75, 82.3626396917148, 12.76, 95.1226396917148, 5.1274442383983, 4.8773603082852, 100, 20, 120, 2, 8, 0, 100),
(211, 'P3211', 3, 19, 6, 'Beige', '8058', 9.75, 0.877437379576108, 0, 10.6274373795761, 7.75, 82.3626396917148, 12.76, 95.1226396917148, 5.1274442383983, 4.8773603082852, 100, 20, 120, 2, 8, 0, 100),
(212, 'P3212', 3, 15, 2, 'Azul', '4859', 15.39, 1.38511951559726, 0, 16.7751195155973, 7.75, 130.007176245879, 12.76, 142.767176245879, 57.5992506936584, 82.232823754121, 225, 11.1111111111111, 250, 3, 9, 0, 225),
(213, 'P3213', 3, 15, 2, 'Azul', '4859', 15.39, 1.38511951559726, 0, 16.7751195155973, 7.75, 130.007176245879, 12.76, 142.767176245879, 57.5992506936584, 82.232823754121, 225, 11.1111111111111, 250, 2, 9, 0, 225),
(214, 'P3214', 3, 15, 3, 'Azul', '4867', 15.39, 1.38511951559726, 0, 16.7751195155973, 7.75, 130.007176245879, 12.76, 142.767176245879, 57.5992506936584, 82.232823754121, 225, 11.1111111111111, 250, 1, 9, 0, 225),
(215, 'P3215', 3, 15, 4, 'Azul', '4875', 15.39, 1.38511951559726, 0, 16.7751195155973, 7.75, 130.007176245879, 12.76, 142.767176245879, 57.5992506936584, 82.232823754121, 225, 11.1111111111111, 250, 2, 9, 0, 225),
(216, 'P3216', 3, 15, 4, 'Gris', '4808', 15.39, 1.38511951559726, 0, 16.7751195155973, 7.75, 130.007176245879, 12.76, 142.767176245879, 57.5992506936584, 82.232823754121, 225, 11.1111111111111, 250, 2, 9, 0, 225),
(217, 'P3217', 3, 11, 2, 'Gris', 'Mujer. Largo. 9937', 13.99, 1.25911774029927, 0, 15.2491177402993, 7.75, 118.18066248732, 12.76, 130.94066248732, 52.7409409734486, 69.05933751268, 200, 12.5, 225, 2, 9, 0, 200),
(218, 'P3218', 3, 11, 2, 'Gris', 'Mujer. Largo. 9937', 13.99, 1.25911774029927, 0, 15.2491177402993, 7.75, 118.18066248732, 12.76, 130.94066248732, 52.7409409734486, 69.05933751268, 200, 12.5, 225, 2, 9, 0, 200),
(219, 'P3219', 3, 11, 4, 'Gris', 'Mujer. Largo. 9945', 13.99, 1.25911774029927, 0, 15.2491177402993, 7.75, 118.18066248732, 12.76, 130.94066248732, 52.7409409734486, 69.05933751268, 200, 12.5, 225, 2, 9, 0, 200),
(220, 'P3220', 3, 11, 2, 'Azul', 'Mujer. Largo. 9988', 13.99, 1.25911774029927, 0, 15.2491177402993, 7.75, 118.18066248732, 12.76, 130.94066248732, 52.7409409734486, 69.05933751268, 200, 12.5, 225, 2, 9, 0, 200),
(221, 'P3221', 3, 6, 1, 'Azul/verde', 'Mujer. Cuadros. 0094', 9.09, 0.818111526756277, 0, 9.90811152675628, 7.75, 76.7878643323612, 12.76, 89.5478643323612, 67.5081824880466, 60.4521356676388, 150, 16.6666666666667, 175, 2, 9, 0, 150),
(222, 'P3222', 3, 6, 2, 'Verde/gris', 'Mujer. Cuadros. 0035', 9.09, 0.818111526756277, 0, 9.90811152675628, 7.75, 76.7878643323612, 12.76, 89.5478643323612, 67.5081824880466, 60.4521356676388, 150, 16.6666666666667, 175, 1, 9, 0, 150),
(223, 'P3223', 3, 6, 2, 'Verde/gris', 'Mujer. Cuadros. 0035', 9.09, 0.818111526756277, 0, 9.90811152675628, 7.75, 76.7878643323612, 12.76, 89.5478643323612, 67.5081824880466, 60.4521356676388, 150, 16.6666666666667, 175, 2, 9, 0, 150),
(224, 'P3224', 3, 6, 3, 'Verde/gris', 'Mujer. Cuadros. 0043', 9.09, 0.818111526756277, 0, 9.90811152675628, 7.75, 76.7878643323612, 12.76, 89.5478643323612, 67.5081824880466, 60.4521356676388, 150, 16.6666666666667, 175, 3, 9, 0, 150),
(225, 'P3225', 3, 6, 3, 'Verde/gris', 'Mujer. Cuadros. 0043', 9.09, 0.818111526756277, 0, 9.90811152675628, 7.75, 76.7878643323612, 12.76, 89.5478643323612, 67.5081824880466, 60.4521356676388, 150, 16.6666666666667, 175, 2, 9, 0, 150);
INSERT INTO `tblproductos` (`idProducto`, `codigoProducto`, `idMarca`, `idTipoProducto`, `idTalla`, `colorProducto`, `descripcionProducto`, `costoDolares`, `impuestoProducto`, `envioProducto`, `totalDolares`, `tipoCambio`, `costoQuetzaltes`, `envioGuate`, `totalQuetzales`, `porcentajeGanacia`, `gananciaEstimada`, `precioVenta`, `gananciaSugerida`, `precioSugerido`, `idEstadoProducto`, `idPedido`, `porcentajeOferta`, `precioOfertado`) VALUES
(226, 'P3226', 3, 3, 4, 'Morado', 'Mujer. Sin capuchon. 8919', 6.99, 0.629108863809283, 0, 7.61910886380928, 7.75, 59.0480936945219, 12.76, 71.8080936945219, 108.890101773365, 78.1919063054781, 150, 16.6666666666667, 175, 1, 9, 0, 150),
(227, 'P3227', 3, 3, 4, 'Morado', 'Mujer. Sin capuchón. 8919', 6.99, 0.629108863809283, 0, 7.61910886380928, 7.75, 59.0480936945219, 12.76, 71.8080936945219, 108.890101773365, 78.1919063054781, 150, 16.6666666666667, 175, 3, 9, 0, 150),
(228, 'P3228', 3, 3, 3, 'Beige', 'Mujer. Sin capuchón. 8838', 6.99, 0.629108863809283, 0, 7.61910886380928, 7.75, 59.0480936945219, 12.76, 71.8080936945219, 108.890101773365, 78.1919063054781, 150, 16.6666666666667, 175, 3, 9, 0, 150),
(229, 'P3229', 3, 3, 3, 'Beige', 'Mujer. Sin capuchón. 8838', 6.99, 0.629108863809283, 0, 7.61910886380928, 7.75, 59.0480936945219, 12.76, 71.8080936945219, 108.890101773365, 78.1919063054781, 150, 16.6666666666667, 175, 2, 9, 0, 150),
(230, 'P3230', 3, 3, 4, 'Gris', 'Mujer. Sin capuchón. 7874', 6.99, 0.629108863809283, 0, 7.61910886380928, 7.75, 59.0480936945219, 12.76, 71.8080936945219, 108.890101773365, 78.1919063054781, 150, 16.6666666666667, 175, 2, 9, 0, 150),
(231, 'P3231', 3, 2, 3, 'Blanco/rojo', 'Rayas. 8731', 15.8, 1.42198538255158, 0, 17.2219853825516, 7.75, 133.470386714775, 12.76, 146.230386714775, 36.7704787583607, 53.769613285225, 200, 12.5, 225, 2, 10, 0, 200),
(232, 'P3232', 3, 2, 4, 'Blanco/rojo', 'Mujer. Rayas. 8758', 15.8, 1.42198538255158, 0, 17.2219853825516, 7.75, 133.470386714775, 12.76, 146.230386714775, 36.7704787583607, 53.769613285225, 200, 12.5, 225, 3, 10, 0, 200),
(233, 'P3233', 3, 2, 2, 'Gris/azul', 'Mujer. Rayas. 8804', 15.8, 1.42198538255158, 0, 17.2219853825516, 7.75, 133.470386714775, 12.76, 146.230386714775, 36.7704787583607, 53.769613285225, 200, 12.5, 225, 1, 10, 0, 200),
(234, 'P3234', 3, 2, 5, 'Gris/azul', 'Mujer. Rayas. 8847', 15.8, 1.42198538255158, 0, 17.2219853825516, 7.75, 133.470386714775, 12.76, 146.230386714775, 36.7704787583607, 53.769613285225, 200, 12.5, 225, 2, 10, 0, 200),
(235, 'P3235', 3, 2, 3, 'Gris', 'Mujer. Floreado. 8898', 15.8, 1.42198538255158, 0, 17.2219853825516, 7.75, 133.470386714775, 12.76, 146.230386714775, 36.7704787583607, 53.769613285225, 200, 12.5, 225, 3, 10, 0, 200),
(236, 'P3236', 3, 2, 4, 'Gris', 'Mujer. Floreado. 8901', 15.8, 1.42198538255158, 0, 17.2219853825516, 7.75, 133.470386714775, 12.76, 146.230386714775, 36.7704787583607, 53.769613285225, 200, 12.5, 225, 1, 10, 0, 200),
(237, 'P3237', 3, 2, 4, 'Blanco', 'Mujer. Encaje. 4347', 15, 1.34998612267555, 0, 16.3499861226755, 7.75, 126.712392450735, 12.76, 139.472392450735, 43.3975545164932, 60.527607549265, 200, 12.5, 225, 3, 10, 0, 200),
(238, 'P3238', 3, 2, 5, 'Blanco', 'Mujer. Encaje. 4355', 15, 1.34998612267555, 0, 16.3499861226755, 7.75, 126.712392450735, 12.76, 139.472392450735, 43.3975545164932, 60.527607549265, 200, 12.5, 225, 3, 10, 0, 200),
(239, 'P3239', 3, 2, 3, 'Turquesa', 'Mujer. Lana. 4614', 14.85, 1.33648626144879, 0, 16.1864862614488, 7.75, 125.445268526228, 12.76, 138.205268526228, 44.7122834988341, 61.794731473772, 200, 12.5, 225, 3, 10, 0, 200),
(240, 'P3240', 3, 2, 3, 'Turquesa', 'Mujer. Lana. 4614', 14.85, 1.33648626144879, 0, 16.1864862614488, 7.75, 125.445268526228, 12.76, 138.205268526228, 44.7122834988341, 61.794731473772, 200, 12.5, 225, 2, 10, 0, 200),
(241, 'P3241', 3, 2, 4, 'Turquesa', 'Mujer. Lana. 4622', 14.85, 1.33648626144879, 0, 16.1864862614488, 7.75, 125.445268526228, 12.76, 138.205268526228, 44.7122834988341, 61.794731473772, 200, 12.5, 225, 3, 10, 0, 200),
(242, 'P3242', 3, 2, 4, 'Turquesa', 'Mujer. Lana. 4622', 14.85, 1.33648626144879, 0, 16.1864862614488, 7.75, 125.445268526228, 12.76, 138.205268526228, 44.7122834988341, 61.794731473772, 200, 12.5, 225, 3, 10, 0, 200),
(243, 'P3243', 3, 2, 2, 'Morado', 'Mujer. Lana. 4673', 14.85, 1.33648626144879, 0, 16.1864862614488, 7.75, 125.445268526228, 12.76, 138.205268526228, 44.7122834988341, 61.794731473772, 200, 12.5, 225, 3, 10, 0, 200),
(244, 'P3244', 3, 2, 2, 'Gris', 'Mujer. Lana. 4533', 14.85, 1.33648626144879, 0, 16.1864862614488, 7.75, 125.445268526228, 12.76, 138.205268526228, 44.7122834988341, 61.794731473772, 200, 12.5, 225, 1, 10, 0, 200),
(245, 'P3245', 3, 2, 3, 'Gris oscuro', 'Mujer. Lana. 4487', 14.85, 1.33648626144879, 0, 16.1864862614488, 7.75, 125.445268526228, 12.76, 138.205268526228, 44.7122834988341, 61.794731473772, 200, 12.5, 225, 3, 10, 0, 200),
(246, 'P3246', 3, 2, 1, 'Gris oscuro', 'Mujer. Lana. 4452', 14.85, 1.33648626144879, 0, 16.1864862614488, 7.75, 125.445268526228, 12.76, 138.205268526228, 44.7122834988341, 61.794731473772, 200, 12.5, 225, 2, 10, 0, 200),
(247, 'P3247', 3, 2, 2, 'Gris oscuro', 'Mujer. Lana. 4479', 14.85, 1.33648626144879, 0, 16.1864862614488, 7.75, 125.445268526228, 12.76, 138.205268526228, 44.7122834988341, 61.794731473772, 200, 12.5, 225, 3, 10, 0, 200),
(248, 'P3248', 3, 7, 3, 'Azul', 'Botones. 0189', 13, 1.16998797298547, 0, 14.1699879729855, 7.75, 109.817406790638, 12.76, 122.577406790638, 6.05543338181381, 7.42259320936201, 130, 15.3846153846154, 150, 3, 10, 0, 130),
(249, 'P3249', 3, 7, 3, 'Azul', 'Botones. Lana. 0189', 13, 1.16998797298547, 0, 14.1699879729855, 7.75, 109.817406790638, 12.76, 122.577406790638, 6.05543338181381, 7.42259320936201, 130, 15.3846153846154, 150, 2, 10, 0, 130),
(250, 'P3250', 3, 7, 4, 'Azul', 'Botones. Lana. 0197', 13, 1.16998797298547, 0, 14.1699879729855, 7.75, 109.817406790638, 12.76, 122.577406790638, 6.05543338181381, 7.42259320936201, 130, 15.3846153846154, 150, 3, 10, 0, 130),
(251, 'P3251', 3, 7, 2, 'Corinto', 'Botones. Lana. 0243', 13, 1.16998797298547, 0, 14.1699879729855, 7.75, 109.817406790638, 12.76, 122.577406790638, 6.05543338181381, 7.42259320936201, 130, 15.3846153846154, 150, 2, 10, 0, 130),
(252, 'P3252', 3, 7, 1, 'Corinto', 'Botones. Lana. 0235', 13, 1.16998797298547, 0, 14.1699879729855, 7.75, 109.817406790638, 12.76, 122.577406790638, 6.05543338181381, 7.42259320936201, 130, 15.3846153846154, 150, 2, 10, 0, 130),
(253, 'P3253', 3, 7, 2, 'Verde musgo', 'Botones. Lana. 0081', 13, 1.16998797298547, 0, 14.1699879729855, 7.75, 109.817406790638, 12.76, 122.577406790638, 6.05543338181381, 7.42259320936201, 130, 15.3846153846154, 150, 2, 10, 0, 130),
(254, 'P3254', 3, 3, 2, 'Gris', 'Mujer. Cerrado. 3337', 12, 1.07998889814044, 0, 13.0799888981404, 7.75, 101.369913960588, 12.76, 114.129913960588, 75.2388949220317, 85.870086039412, 200, 12.5, 225, 2, 10, 0, 200),
(255, 'P3255', 3, 3, 1, 'Gris', 'Mujer. Cerrado. 3329', 12, 1.07998889814044, 0, 13.0799888981404, 7.75, 101.369913960588, 12.76, 114.129913960588, 75.2388949220317, 85.870086039412, 200, 12.5, 225, 2, 10, 0, 200),
(256, 'P3256', 3, 3, 3, 'Turquesa', 'Mujer. Cerrado. 3566', 12, 1.07998889814044, 0, 13.0799888981404, 7.75, 101.369913960588, 12.76, 114.129913960588, 75.2388949220317, 85.870086039412, 200, 12.5, 225, 3, 10, 0, 200),
(257, 'P3257', 3, 3, 4, 'Turquesa', 'Mujer. Cerrado. 3574', 12, 1.07998889814044, 0, 13.0799888981404, 7.75, 101.369913960588, 12.76, 114.129913960588, 75.2388949220317, 85.870086039412, 200, 12.5, 225, 2, 10, 0, 200),
(258, 'P3258', 3, 3, 3, 'Rosado', 'Mujer. Cerrado. 3647', 12, 1.07998889814044, 0, 13.0799888981404, 7.75, 101.369913960588, 12.76, 114.129913960588, 75.2388949220317, 85.870086039412, 200, 12.5, 225, 2, 10, 0, 200),
(259, 'P3259', 3, 3, 2, 'Rosado', 'Mujer. Cerrado. 3639', 12, 1.07998889814044, 0, 13.0799888981404, 7.75, 101.369913960588, 12.76, 114.129913960588, 75.2388949220317, 85.870086039412, 200, 12.5, 225, 2, 10, 0, 200),
(260, 'P3260', 3, 3, 5, 'Rosado', 'Mujer. Cerrado. 3663', 12, 1.07998889814044, 0, 13.0799888981404, 7.75, 101.369913960588, 12.76, 114.129913960588, 75.2388949220317, 85.870086039412, 200, 12.5, 225, 2, 10, 0, 200),
(261, 'P3261', 3, 7, 3, 'Negro', 'Transparente. Manga larga. 0089', 10, 0.899990748450365, 0, 10.8999907484504, 7.75, 84.4749283004906, 12.76, 97.2349283004906, 54.2655531523061, 52.7650716995094, 150, 13.3333333333333, 170, 2, 10, 0, 150),
(262, 'P3262', 3, 7, 4, 'Negro', 'Transparente. Manga larga. 0097', 10, 0.899990748450365, 0, 10.8999907484504, 7.75, 84.4749283004906, 12.76, 97.2349283004906, 54.2655531523061, 52.7650716995094, 150, 13.3333333333333, 170, 1, 10, 0, 150),
(263, 'P3263', 3, 7, 2, 'Morado', '3976', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 3, 10, 0, 95),
(264, 'P3264', 3, 7, 3, 'Morado', '3984', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 2, 10, 0, 95),
(265, 'P3265', 3, 7, 2, 'Aqua', '4042', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 2, 10, 0, 95),
(266, 'P3266', 3, 7, 3, 'Aqua', '4069', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 2, 10, 0, 95),
(267, 'P3267', 3, 7, 3, 'Azul', '4123', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 2, 10, 0, 95),
(268, 'P3268', 3, 7, 1, 'Azul', '4107', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 2, 10, 0, 95),
(269, 'P3269', 3, 7, 1, 'Azul', '4107', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 2, 10, 0, 95),
(270, 'P3270', 3, 7, 4, 'Azul', '4131', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 1, 10, 0, 95),
(271, 'P3271', 3, 7, 2, 'Gris', '4417', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 2, 10, 0, 95),
(272, 'P3272', 3, 7, 1, 'Gris', '4409', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 2, 10, 0, 95),
(273, 'P3273', 3, 7, 4, 'Blanco', '3925', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 2, 10, 0, 95),
(274, 'P3274', 3, 7, 4, 'Blanco', '3925', 5, 0.449995374225182, 0, 5.44999537422518, 7.75, 42.2374641502451, 12.76, 54.9974641502451, 72.7352369201492, 40.0025358497549, 95, 15.7894736842105, 110, 3, 10, 0, 95),
(275, 'P3275', 6, 9, 6, 'Cocoa', 'Beauty Rush', 3.5, 0.3316, 0.713928571428571, 4.54552857142857, 7.75, 35.2278464285714, 12.76, 47.9878464285714, 45.8702675982618, 22.0121535714286, 70, 21.4285714285714, 85, 3, 11, 0, 70),
(276, 'P3276', 6, 9, 6, 'Cocoa', 'Beauty Rush', 3.5, 0.3316, 0.713928571428571, 4.54552857142857, 7.75, 35.2278464285714, 12.76, 47.9878464285714, 45.8702675982618, 22.0121535714286, 70, 21.4285714285714, 85, 2, 11, 0, 70),
(277, 'P3277', 6, 9, 6, 'Citrus Kissed', 'Beauty Rush', 3.5, 0.3316, 0.713928571428571, 4.54552857142857, 7.75, 35.2278464285714, 12.76, 47.9878464285714, 45.8702675982618, 22.0121535714286, 70, 21.4285714285714, 85, 2, 11, 0, 70),
(278, 'P3278', 6, 9, 6, 'Citrus Kissed', 'Beauty Rush', 3.5, 0.3316, 0.713928571428571, 4.54552857142857, 7.75, 35.2278464285714, 12.76, 47.9878464285714, 45.8702675982618, 22.0121535714286, 70, 21.4285714285714, 85, 2, 11, 0, 70),
(279, 'P3279', 6, 9, 6, 'Taffy Go Lucky', 'Beauty Rush', 3.5, 0.3316, 0.713928571428571, 4.54552857142857, 7.75, 35.2278464285714, 12.76, 47.9878464285714, 45.8702675982618, 22.0121535714286, 70, 21.4285714285714, 85, 2, 11, 0, 70),
(280, 'P3280', 6, 9, 6, 'Shine Berry', 'Beauty Rush', 3.5, 0.3316, 0.713928571428571, 4.54552857142857, 7.75, 35.2278464285714, 12.76, 47.9878464285714, 45.8702675982618, 22.0121535714286, 70, 22.8571428571429, 86, 2, 11, 0, 70),
(281, 'P3281', 6, 9, 6, 'Shine Berry', 'Beauty Rush', 3.5, 0.3316, 0.713928571428571, 4.54552857142857, 7.75, 35.2278464285714, 12.76, 47.9878464285714, 45.8702675982618, 22.0121535714286, 70, 21.4285714285714, 85, 2, 11, 0, 70),
(282, 'P3282', 6, 9, 6, 'Yummy Berry', 'Beauty Rush', 3.5, 0.3316, 0.713928571428571, 4.54552857142857, 7.75, 35.2278464285714, 12.76, 47.9878464285714, 45.8702675982618, 22.0121535714286, 70, 21.4285714285714, 85, 1, 11, 0, 70),
(283, 'P3283', 6, 10, 6, 'Ready to Party', 'Pink', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(284, 'P3284', 6, 10, 6, 'Ready to Party', 'Pink', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 2, 11, 0, 120),
(285, 'P3285', 6, 10, 6, 'Sun Kissed', 'Pink', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 2, 11, 0, 120),
(286, 'P3286', 6, 10, 6, 'Sweet and Flirty', '', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(287, 'P3287', 6, 10, 6, 'Sweet and Flirty', 'Pink', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(288, 'P3288', 6, 9, 6, 'Taffy go Lucky', '', 3.5, 0.3316, 0.713928571428571, 4.54552857142857, 7.75, 35.2278464285714, 12.76, 47.9878464285714, 45.8702675982618, 22.0121535714286, 70, 21.4285714285714, 85, 2, 11, 0, 70),
(289, 'P3289', 6, 9, 6, 'Yummy Berry', 'Beauty Rush', 3.5, 0.3316, 0.713928571428571, 4.54552857142857, 7.75, 35.2278464285714, 12.76, 47.9878464285714, 45.8702675982618, 22.0121535714286, 70, 21.4285714285714, 85, 2, 11, 0, 70),
(290, 'P3290', 6, 10, 6, 'Sun Kissed', 'Pink', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(291, 'P3291', 6, 10, 6, 'Fresh and Clean', 'Pink', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(292, 'P3292', 6, 10, 6, 'Wild at Heart', 'Pink', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 2, 11, 0, 120),
(293, 'P3293', 6, 10, 6, 'Wild at Heart', 'Pink', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(294, 'P3294', 6, 8, 6, 'Ready to Party', 'Manos y Cuerpo', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(295, 'P3295', 6, 8, 6, 'Ready to Party', 'Manos y Cuerpo', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 2, 11, 0, 120),
(296, 'P3296', 6, 8, 6, 'Sun Kissed', 'Manos y Cuerpo', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(297, 'P3297', 6, 8, 6, 'Sun Kissed', 'Manos y Cuerpo', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 2, 11, 0, 120),
(298, 'P3298', 6, 8, 6, 'Sweet and Flirty', 'Manos y Cuerpo', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 2, 11, 0, 120),
(299, 'P3299', 6, 8, 6, 'Sweet and Flirty', 'Manos y cuerpo', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(300, 'P3300', 6, 8, 6, 'Fresh and Clean', 'Manos y Cuerpo', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(301, 'P3301', 6, 8, 6, 'Fresh and Clean', 'Manos y cuerpo', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 2, 11, 0, 120),
(302, 'P3302', 6, 8, 6, 'Wild at Heart', 'Manos y Cuerpo', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 2, 11, 0, 120),
(303, 'P3303', 6, 8, 6, 'Wild at Heart', 'Manos y Cuerpo', 7, 0.6632, 0.713928571428571, 8.37712857142857, 7.75, 64.9227464285714, 12.76, 77.6827464285714, 54.4744560625685, 42.3172535714286, 120, 16.6666666666667, 140, 3, 11, 0, 120),
(304, 'P3304', 6, 8, 6, 'Aqua Kiss', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 3, 12, 0, 80),
(305, 'P3305', 6, 8, 6, 'Total Flirt', 'Pink. Body Lotion', 7.04, 0.665456983240224, 0.54027027027027, 8.24572725351049, 7.75, 63.9043862147063, 12.76, 76.6643862147063, 56.5263950120568, 43.3356137852937, 120, 16.6666666666667, 140, 3, 12, 0, 120),
(306, 'P3306', 6, 8, 6, 'Sun Kissed', 'Pink. Body Lotion', 7.04, 0.665456983240224, 0.54027027027027, 8.24572725351049, 7.75, 63.9043862147063, 12.76, 76.6643862147063, 56.5263950120568, 43.3356137852937, 120, 16.6666666666667, 140, 3, 12, 0, 120),
(307, 'P3307', 6, 8, 6, 'Warm and Cozy', 'Pink. Body Lotion', 7.04, 0.665456983240224, 0.54027027027027, 8.24572725351049, 7.75, 63.9043862147063, 12.76, 76.6643862147063, 56.5263950120568, 43.3356137852937, 120, 16.6666666666667, 140, 2, 12, 0, 120),
(308, 'P3308', 6, 8, 6, 'Sweet and Flirty', 'Pink. Body Lotion', 7.04, 0.665456983240224, 0.54027027027027, 8.24572725351049, 7.75, 63.9043862147063, 12.76, 76.6643862147063, 56.5263950120568, 43.3356137852937, 120, 16.6666666666667, 140, 3, 12, 0, 120),
(309, 'P3309', 6, 8, 6, 'Wild and Breezy', '', 7.04, 0.665456983240224, 0.54027027027027, 8.24572725351049, 7.75, 63.9043862147063, 12.76, 76.6643862147063, 56.5263950120568, 43.3356137852937, 120, 16.6666666666667, 140, 3, 12, 0, 120),
(310, 'P3310', 6, 8, 6, 'Fresh and Clean', 'Pink. Body Lotion', 7.04, 0.665456983240224, 0.54027027027027, 8.24572725351049, 7.75, 63.9043862147063, 12.76, 76.6643862147063, 56.5263950120568, 43.3356137852937, 120, 16.6666666666667, 140, 3, 12, 0, 120),
(311, 'P3311', 6, 8, 6, 'Wild at Heart', 'Pink. Body Lotion', 7.04, 0.665456983240224, 0.54027027027027, 8.24572725351049, 7.75, 63.9043862147063, 12.76, 76.6643862147063, 56.5263950120568, 43.3356137852937, 120, 16.6666666666667, 140, 3, 12, 0, 120),
(312, 'P3312', 6, 8, 6, 'Ready to Party', 'Pink. Body Lotion', 7.05, 0.666402234636872, 0.54027027027027, 8.25667250490714, 7.75, 63.9892119130303, 12.76, 76.7492119130303, 56.3533970042326, 43.2507880869697, 120, 16.6666666666667, 140, 3, 12, 0, 120),
(313, 'P3313', 6, 8, 6, 'Strawberries & Champagne', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(314, 'P3314', 6, 8, 6, 'Strawberries & Champagne', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(315, 'P3315', 6, 10, 6, 'Strawberries & Champagne', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(316, 'P3316', 6, 10, 6, 'Vainilla', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(317, 'P3317', 6, 10, 6, 'Vainilla', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(318, 'P3318', 6, 10, 6, 'Vainilla', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(319, 'P3319', 6, 10, 6, 'Vainilla', '', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(320, 'P3320', 6, 8, 6, 'Sheer love', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(321, 'P3321', 6, 8, 6, 'Sheer Love', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(322, 'P3322', 6, 10, 6, 'Sheer Love', '', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(323, 'P3323', 6, 8, 6, 'Mango', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(324, 'P3324', 6, 8, 6, 'Mango', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(325, 'P3325', 6, 10, 6, 'Mango', '', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(326, 'P3326', 6, 8, 6, 'Secret Charm', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(327, 'P3327', 6, 8, 6, 'Secret Charm', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(328, 'P3328', 6, 10, 6, 'Secret Charm', '', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(329, 'P3329', 6, 8, 6, 'Endless Love', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(330, 'P3330', 6, 8, 6, 'Endless Love', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(331, 'P3331', 6, 10, 6, 'Endless Love', '', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(332, 'P3332', 6, 8, 6, 'Pera', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(333, 'P3333', 6, 8, 6, 'Pera', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(334, 'P3334', 6, 10, 6, 'Aqua Kiss', '', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 3, 12, 0, 80),
(335, 'P3335', 6, 8, 6, 'Coco', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(336, 'P3336', 6, 8, 6, 'Coco', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(337, 'P3337', 6, 10, 6, 'Coco', '', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(338, 'P3338', 6, 8, 6, 'Amber Romance', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(339, 'P3339', 6, 8, 6, 'Amber Romance', 'Manos y cuerpo', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(340, 'P3340', 6, 10, 6, 'Amber Romance', '', 4.23, 0.399841340782123, 0.54027027027027, 5.17011161105239, 7.75, 40.068364985656, 12.76, 52.828364985656, 51.4337989103423, 27.171635014344, 80, 25, 100, 2, 12, 0, 80),
(341, 'P3341', 6, 19, 6, 'Dorada', 'Cosmetiquera', 0, 0, 0.454318181818182, 0.454318181818182, 7.75, 3.52096590909091, 12.76, 16.2809659090909, 514.214172294055, 83.7190340909091, 100, 20, 120, 1, 14, 0, 100),
(342, 'P3342', 6, 10, 6, 'Deep Berry', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 2, 14, 0, 80),
(343, 'P3343', 6, 8, 6, 'Deep Berry', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 3, 14, 0, 80),
(344, 'P3344', 6, 8, 6, 'Deep Berry', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 2, 14, 0, 80),
(345, 'P3345', 6, 8, 6, 'Luscious Crush', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 1, 14, 0, 80),
(346, 'P3346', 6, 8, 6, 'Luscious Crush', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 2, 14, 0, 80),
(347, 'P3347', 6, 8, 6, 'Citrus Dream', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 2, 14, 0, 80),
(348, 'P3348', 6, 8, 6, 'Citrus Dream', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 2, 14, 0, 80),
(349, 'P3349', 6, 8, 6, 'Lemon Escape', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 2, 14, 0, 80),
(350, 'P3350', 6, 8, 6, 'Lemon Escape', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 2, 14, 0, 80),
(351, 'P3351', 6, 8, 6, 'Pure Seduction', 'Manos y cuerpo', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 2, 14, 0, 80),
(352, 'P3352', 6, 8, 6, 'Pure Seduction', 'Manos y cuerpo', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 2, 14, 0, 80),
(353, 'P3353', 6, 10, 6, 'Pure Seduction', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 3, 14, 0, 80),
(354, 'P3354', 6, 8, 6, 'Secret Craving', 'Manos y cuerpo', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 3, 14, 0, 80),
(355, 'P3355', 6, 8, 6, 'Secret Craving', 'Manos y cuerpo', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 2, 14, 0, 80),
(356, 'P3356', 6, 10, 6, 'Secret Craving', '', 4.22, 0.399350282485876, 0.454318181818182, 5.07366846430406, 7.75, 39.3209305983565, 12.76, 52.0809305983565, 53.6070862806828, 27.9190694016435, 80, 25, 100, 3, 14, 0, 80),
(357, 'P3357', 6, 8, 6, 'Pure Daydream', 'Manos y cuerpo', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(358, 'P3358', 6, 8, 6, 'Pure Daydream', 'Manos y cuerpo', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(359, 'P3359', 6, 8, 6, 'Such a Flirt', 'Manos y cuerpo', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 3, 14, 0, 80),
(360, 'P3360', 6, 8, 6, 'Such a Flirt', 'Manos y cuerpo', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(361, 'P3361', 6, 10, 6, 'Such a Flirt', '', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 3, 14, 0, 80),
(362, 'P3362', 6, 9, 6, 'Cherry Bomb', '', 3.5, 0.331214689265537, 0.454318181818182, 4.28553287108372, 7.75, 33.2128797508988, 12.76, 45.9728797508988, 52.2636832395331, 24.0271202491012, 70, 21.4285714285714, 85, 2, 14, 0, 70),
(363, 'P3363', 6, 9, 6, 'Cherry Bomb', '', 3.5, 0.331214689265537, 0.454318181818182, 4.28553287108372, 7.75, 33.2128797508988, 12.76, 45.9728797508988, 52.2636832395331, 24.0271202491012, 70, 21.4285714285714, 85, 2, 14, 0, 70),
(364, 'P3364', 6, 9, 6, 'Love Berry', '', 3.5, 0.331214689265537, 0.454318181818182, 4.28553287108372, 7.75, 33.2128797508988, 12.76, 45.9728797508988, 52.2636832395331, 24.0271202491012, 70, 21.4285714285714, 85, 3, 14, 0, 70),
(365, 'P3365', 6, 9, 6, 'Love Berry', '', 3.5, 0.331214689265537, 0.454318181818182, 4.28553287108372, 7.75, 33.2128797508988, 12.76, 45.9728797508988, 52.2636832395331, 24.0271202491012, 70, 21.4285714285714, 85, 2, 14, 0, 70),
(366, 'P3366', 6, 9, 6, 'Indulgence', '', 3.51, 0.332161016949152, 0.454318181818182, 4.29647919876733, 7.75, 33.2977137904468, 12.76, 46.0577137904468, 51.9832276488706, 23.9422862095532, 70, 21.4285714285714, 85, 2, 14, 0, 70),
(367, 'P3367', 6, 9, 6, 'Indulgence', '', 3.51, 0.332161016949152, 0.454318181818182, 4.29647919876733, 7.75, 33.2977137904468, 12.76, 46.0577137904468, 51.9832276488706, 23.9422862095532, 70, 21.4285714285714, 85, 3, 14, 0, 70),
(368, 'P3368', 6, 9, 6, 'Punchy', '', 3.51, 0.332161016949152, 0.454318181818182, 4.29647919876733, 7.75, 33.2977137904468, 12.76, 46.0577137904468, 51.9832276488706, 23.9422862095532, 70, 21.4285714285714, 85, 2, 14, 0, 70),
(369, 'P3369', 6, 9, 6, 'Punchy', '', 3.51, 0.332161016949152, 0.454318181818182, 4.29647919876733, 7.75, 33.2977137904468, 12.76, 46.0577137904468, 51.9832276488706, 23.9422862095532, 70, 21.4285714285714, 85, 3, 14, 0, 70),
(370, 'P3370', 6, 9, 6, 'Candy Baby', '', 3.51, 0.332161016949152, 0.454318181818182, 4.29647919876733, 7.75, 33.2977137904468, 12.76, 46.0577137904468, 51.9832276488706, 23.9422862095532, 70, 21.4285714285714, 85, 2, 14, 0, 70),
(371, 'P3371', 6, 9, 6, 'Candy Baby', '', 3.51, 0.332161016949152, 0.454318181818182, 4.29647919876733, 7.75, 33.2977137904468, 12.76, 46.0577137904468, 51.9832276488706, 23.9422862095532, 70, 21.4285714285714, 85, 1, 14, 0, 70),
(372, 'P3372', 6, 9, 6, 'Pink Goes Pop', '', 3.51, 0.332161016949152, 0.454318181818182, 4.29647919876733, 7.75, 33.2977137904468, 12.76, 46.0577137904468, 51.9832276488706, 23.9422862095532, 70, 21.4285714285714, 85, 1, 14, 0, 70),
(373, 'P3373', 6, 9, 6, 'Pink Goes Pop', '', 3.51, 0.332161016949152, 0.454318181818182, 4.29647919876733, 7.75, 33.2977137904468, 12.76, 46.0577137904468, 51.9832276488706, 23.9422862095532, 70, 21.4285714285714, 85, 2, 14, 0, 70),
(374, 'P3374', 6, 9, 6, 'Forbidden Vanilla', 'Manos y cuerpo', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(375, 'P3375', 6, 9, 6, 'Forbidden Vanilla', 'Manos y cuerpo', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(376, 'P3376', 6, 8, 6, 'Love Spell', 'Manos y cuerpo', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 3, 14, 0, 80),
(377, 'P3377', 6, 8, 6, 'Love Spell', 'Manos y cuerpo', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(378, 'P3378', 6, 10, 6, 'Love Spell', '', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 3, 14, 0, 80),
(379, 'P3379', 6, 8, 6, 'Passion Struck', 'Manos y cuerpo', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(380, 'P3380', 6, 8, 6, 'Passion Struck', 'Manos y cuerpo', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(381, 'P3381', 6, 10, 6, 'Passion Struck', '', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 3, 14, 0, 80),
(382, 'P3382', 6, 8, 6, 'Moonlight Dream', '', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(383, 'P3383', 6, 8, 6, 'Moonlight Dream', '', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(384, 'P3384', 6, 10, 6, 'Moonlight Dream', '', 4.21, 0.39840395480226, 0.454318181818182, 5.06272213662044, 7.75, 39.2360965588084, 12.76, 51.9960965588084, 53.8577033557101, 28.0039034411916, 80, 25, 100, 2, 14, 0, 80),
(385, 'P3385', 6, 9, 6, 'Sugar', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(386, 'P3386', 6, 9, 6, 'Paradise Punch', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(387, 'P3387', 6, 9, 6, 'Raspberry Cool', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(388, 'P3388', 6, 9, 6, 'Vainilla', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 3, 15, 0, 70),
(389, 'P3389', 6, 9, 6, 'Cady Baby', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(390, 'P3390', 6, 9, 6, 'Strawberry Fizz', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 3, 15, 0, 70),
(391, 'P3391', 6, 9, 6, 'Melonragous', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(392, 'P3392', 6, 9, 6, 'Melonragous', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(393, 'P3393', 6, 9, 6, 'Melonragous', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(394, 'P3394', 6, 9, 6, 'Sugar', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(395, 'P3395', 6, 9, 6, 'Sugar', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(396, 'P3396', 6, 9, 6, 'Paradise Punch', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 3, 15, 0, 70),
(397, 'P3397', 6, 9, 6, 'Paradise Punch', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 3, 15, 0, 70),
(398, 'P3398', 6, 9, 6, 'Raspberry Cool', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(399, 'P3399', 6, 9, 6, 'Raspberry Cool', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(400, 'P3400', 6, 9, 6, 'Vainilla', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(401, 'P3401', 6, 9, 6, 'Vainilla', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(402, 'P3402', 6, 9, 6, 'Candy Baby', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(403, 'P3403', 6, 9, 6, 'Candy Baby', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(404, 'P3404', 6, 9, 6, 'Strawberry Fizz', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(405, 'P3405', 6, 9, 6, 'Strawberry Fizz', '', 2.94, 0.277666666666667, 0.512564102564103, 3.73023076923077, 7.75, 28.9092884615385, 12.76, 41.6692884615385, 67.9894295881996, 28.3307115384615, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(406, 'P3406', 6, 9, 6, 'Cocoa', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(407, 'P3407', 6, 9, 6, 'Vainilla', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(408, 'P3408', 6, 9, 6, 'Indulgence', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(409, 'P3409', 6, 9, 6, 'Punchy', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 3, 15, 0, 70),
(410, 'P3410', 6, 9, 6, 'Citrus Kissed', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 3, 15, 0, 70),
(411, 'P3411', 6, 9, 6, 'Candy Baby', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(412, 'P3412', 6, 9, 6, 'Shine Berry', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(413, 'P3413', 6, 9, 6, 'Yummy Berry', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(414, 'P3414', 6, 9, 6, 'Pink goes Pop', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(415, 'P3415', 6, 9, 6, 'Love Berry', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(416, 'P3416', 6, 9, 6, 'Love Berry', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(417, 'P3417', 6, 9, 6, 'Super Juicy', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(418, 'P3418', 6, 9, 6, 'Super Juicy', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 3, 15, 0, 70),
(419, 'P3419', 6, 9, 6, 'Super Juicy', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(420, 'P3420', 6, 9, 6, 'Candied', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(421, 'P3421', 6, 9, 6, 'Candied', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(422, 'P3422', 6, 9, 6, 'Candied', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(423, 'P3423', 6, 9, 6, 'Slice of Heaven', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(424, 'P3424', 6, 9, 6, 'Slice of Heaven', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(425, 'P3425', 6, 9, 6, 'Juiced Berry', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(426, 'P3426', 6, 9, 6, 'Juiced Berry', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(427, 'P3427', 6, 9, 6, 'Juiced Berry', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(428, 'P3428', 6, 9, 6, 'Sugar High', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(429, 'P3429', 6, 9, 6, 'Sugar High', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(430, 'P3430', 6, 9, 6, 'Sugar High', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(431, 'P3431', 6, 9, 6, 'Grapefruit Blast', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(432, 'P3432', 6, 9, 6, 'Grapefruit Blast', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 3, 15, 0, 70),
(433, 'P3433', 6, 9, 6, 'Grapefruit Blast', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(434, 'P3434', 6, 9, 6, 'Strawberry Fizz', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(435, 'P3435', 6, 9, 6, 'Decadent Berry', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(436, 'P3436', 6, 9, 6, 'Decadent Berry', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 2, 15, 0, 70),
(437, 'P3437', 6, 9, 6, 'Decadent Berry', '', 3.53, 0.333388888888889, 0.512564102564103, 4.37595299145299, 7.75, 33.9136356837607, 12.76, 46.6736356837607, 49.9776029326023, 23.3263643162393, 70, 21.4285714285714, 85, 1, 15, 0, 70),
(438, 'P3438', 4, 7, 4, 'Gris', 'Manga larga. 5951', 18.71, 1.60678763923823, 0, 20.3167876392382, 7.75, 157.455104204096, 12.76, 170.215104204096, -3.06383163144139, -5.21510420409601, 165, 12.1212121212121, 185, 1, 16, 0, 165),
(439, 'P3439', 4, 7, 2, 'Rosado', 'Manga larga. 6009', 18.71, 1.60678763923823, 0, 20.3167876392382, 7.75, 157.455104204096, 12.76, 170.215104204096, -3.06383163144139, -5.21510420409601, 165, 12.1212121212121, 185, 2, 16, 0, 165),
(440, 'P3440', 4, 12, 1, 'Azul', 'Mujer. 5399', 8, 0.68702838663313, 0, 8.68702838663313, 7.75, 67.3244699964068, 12.76, 80.0844699964068, 49.8417858111368, 39.9155300035932, 120, 16.6666666666667, 140, 1, 16, 0, 120),
(441, 'P3441', 3, 1, 3, 'Blanco', '1785', 10.32, 0.886266618756737, 0, 11.2062666187567, 7.75, 86.8485662953644, 12.76, 99.6085662953644, 40.5501607009028, 40.3914337046356, 140, 14.2857142857143, 160, 2, 16, 0, 140),
(442, 'P3442', 3, 18, 6, 'Rosado', 'Mujer. 9103', 8, 0.68702838663313, 0, 8.68702838663313, 7.75, 67.3244699964068, 12.76, 80.0844699964068, 49.8417858111368, 39.9155300035932, 120, 16.6666666666667, 140, 2, 16, 0, 120),
(443, 'P3443', 3, 18, 6, 'Azul', 'Mujer. 9081', 8, 0.68702838663313, 0, 8.68702838663313, 7.75, 67.3244699964068, 12.76, 80.0844699964068, 49.8417858111368, 39.9155300035932, 120, 16.6666666666667, 140, 2, 16, 0, 120),
(444, 'P3444', 3, 3, 2, 'Negro', 'Hombre. Cerrado. 2389', 19.75, 1.69610132950054, 0, 21.4461013295005, 7.75, 166.207285303629, 12.76, 178.967285303629, 45.2779481785702, 81.032714696371, 260, 11.5384615384615, 290, 1, 16, 0, 260),
(445, 'P3445', 3, 1, 3, 'Gris', 'Manga larga', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 40, 140, 2, 17, 0, 100);
INSERT INTO `tblproductos` (`idProducto`, `codigoProducto`, `idMarca`, `idTipoProducto`, `idTalla`, `colorProducto`, `descripcionProducto`, `costoDolares`, `impuestoProducto`, `envioProducto`, `totalDolares`, `tipoCambio`, `costoQuetzaltes`, `envioGuate`, `totalQuetzales`, `porcentajeGanacia`, `gananciaEstimada`, `precioVenta`, `gananciaSugerida`, `precioSugerido`, `idEstadoProducto`, `idPedido`, `porcentajeOferta`, `precioOfertado`) VALUES
(446, 'P3446', 3, 12, 5, 'Negro', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(447, 'P3447', 1, 1, 4, 'Anaranjado', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(448, 'P3448', 1, 1, 4, 'Amarillo', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(449, 'P3449', 1, 12, 3, 'Verde', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(450, 'P3450', 1, 1, 5, 'Celeste', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(451, 'P3451', 1, 1, 4, 'Verde', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(452, 'P3452', 1, 1, 3, 'Amarillo', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(453, 'P3453', 1, 1, 4, 'Anaranjado', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(454, 'P3454', 1, 6, 2, 'Azul', 'Mujer', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 1, 17, 0, 100),
(455, 'P3455', 1, 6, 1, 'Turquesa', 'Mujer', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 1, 17, 0, 100),
(456, 'P3456', 1, 6, 2, 'Azul marino', 'Mujer', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 1, 17, 0, 100),
(457, 'P3457', 1, 6, 4, 'Verde', 'Hombre', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(458, 'P3458', 1, 12, 4, 'Blanco', 'Hombre', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(459, 'P3459', 1, 3, 4, 'Turquesa', 'Hombre', 15, 1.2, 0, 16.2, 7.7, 124.74, 6, 130.74, 14.7315282239559, 19.26, 150, 0.666666666666671, 151, 1, 17, 0, 150),
(460, 'P3460', 3, 12, 4, 'Blanco', 'Hombre', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(461, 'P3461', 5, 11, 3, 'Blanco', 'Hombre', 15, 1.2, 0, 16.2, 7.7, 124.74, 6, 130.74, -4.39039314670339, -5.74000000000001, 125, 0.799999999999997, 126, 2, 17, 0, 125),
(462, 'P3462', 1, 7, 4, 'Azul', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(463, 'P3463', 1, 7, 2, 'Gris', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 2, 17, 0, 100),
(464, 'P3464', 1, 7, 1, 'Gris', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, 12.1579183490354, 10.84, 100, 1, 101, 1, 17, 0, 100),
(465, 'P3465', 6, 7, 3, 'Gris', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 1, 17, 0, 75),
(466, 'P3466', 6, 7, 2, 'Azul/negro', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(467, 'P3467', 6, 7, 2, 'Verde', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(468, 'P3468', 6, 7, 2, 'Gris', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 1, 17, 0, 75),
(469, 'P3469', 6, 7, 3, 'Rosado', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(470, 'P3470', 6, 7, 2, 'Crema', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(471, 'P3471', 6, 7, 2, 'Verde', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(472, 'P3472', 6, 7, 2, 'Negro', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(473, 'P3473', 6, 7, 2, 'Negro', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(474, 'P3474', 6, 7, 2, 'Amarillo', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(475, 'P3475', 6, 7, 2, 'Morado', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(476, 'P3476', 6, 7, 2, 'Celeste', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(477, 'P3477', 6, 7, 2, 'Anaranjado', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(478, 'P3478', 6, 7, 1, 'Rosado', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 1, 17, 0, 75),
(479, 'P3479', 6, 7, 2, 'Amarillo', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(480, 'P3480', 6, 7, 1, 'Azul', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(481, 'P3481', 6, 7, 4, 'Gris', '', 10, 0.8, 0, 10.8, 7.7, 83.16, 6, 89.16, -15.8815612382234, -14.16, 75, 1.33333333333333, 76, 2, 17, 0, 75),
(482, 'P3482', 9, 7, 4, 'Verde/blanco', '', 5, 0.4, 0, 5.4, 7.7, 41.58, 5, 46.58, 136.152855302705, 63.42, 110, 22.7272727272727, 135, 1, 18, 0, 110),
(483, 'P3483', 9, 7, 2, 'Verde/blanco', '', 5, 0.4, 0, 5.4, 7.7, 41.58, 5, 46.58, 136.152855302705, 63.42, 110, 22.7272727272727, 135, 2, 18, 0, 110),
(484, 'P3484', 9, 7, 1, 'Verde/gris', '', 5, 0.4, 0, 5.4, 7.7, 41.58, 5, 46.58, 136.152855302705, 63.42, 110, 22.7272727272727, 135, 2, 18, 0, 110),
(485, 'P3485', 9, 7, 2, 'Amarillo', '', 5, 0.4, 0, 5.4, 7.7, 41.58, 5, 46.58, 136.152855302705, 63.42, 110, 22.7272727272727, 135, 2, 18, 0, 110),
(486, 'P3486', 9, 7, 1, 'Azul', '', 5, 0.4, 0, 5.4, 7.7, 41.58, 5, 46.58, 136.152855302705, 63.42, 110, 22.7272727272727, 135, 2, 18, 0, 110),
(487, 'P3487', 7, 13, 2, 'Gris', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(488, 'P3488', 7, 13, 2, 'Azul', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(489, 'P3489', 7, 13, 1, 'Blanco', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(490, 'P3490', 7, 13, 2, 'Gris', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(491, 'P3491', 7, 13, 1, 'Gris', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(492, 'P3492', 7, 13, 3, 'Azul', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(493, 'P3493', 7, 13, 4, 'Morado', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(494, 'P3494', 7, 13, 3, 'Beige', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(495, 'P3495', 7, 13, 5, 'Azul', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(496, 'P3496', 7, 13, 2, 'Crema', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(497, 'P3497', 7, 13, 1, 'Crema', '', 2, 0.16, 0, 2.16, 7.7, 16.632, 5, 21.632, 131.139053254438, 28.368, 50, 40, 70, 1, 18, 0, 50),
(498, 'P3498', 3, 13, 3, 'Azul', '', 3, 0.24, 0, 3.24, 7.7, 24.948, 5, 29.948, 183.825297181782, 55.052, 85, 23.5294117647059, 105, 1, 18, 0, 85),
(499, 'P3499', 3, 13, 3, 'Azul', 'Con encaje', 3, 0.24, 0, 3.24, 7.7, 24.948, 5, 29.948, 183.825297181782, 55.052, 85, 23.5294117647059, 105, 1, 18, 0, 85),
(500, 'P3500', 3, 13, 2, 'Verde Menta', '', 3, 0.24, 0, 3.24, 7.7, 24.948, 5, 29.948, 183.825297181782, 55.052, 85, 23.5294117647059, 105, 1, 18, 0, 85),
(501, 'P3501', 3, 13, 3, 'Verde', '', 3, 0.24, 0, 3.24, 7.7, 24.948, 5, 29.948, 183.825297181782, 55.052, 85, 23.5294117647059, 105, 1, 18, 0, 85),
(502, 'P3502', 3, 13, 2, 'Celeste', '', 3, 0.24, 0, 3.24, 7.7, 24.948, 5, 29.948, 183.825297181782, 55.052, 85, 23.5294117647059, 105, 1, 18, 0, 85),
(503, 'P3503', 3, 7, 1, 'Turquesa', '', 8, 0.64, 0, 8.64, 7.7, 66.528, 5, 71.528, 95.7275472542221, 68.472, 140, 14.2857142857143, 160, 2, 18, 0, 140),
(504, 'P3504', 3, 12, 1, 'Morado', 'Mujer', 9, 0.72, 0, 9.72, 7.7, 74.844, 5, 79.844, 56.5552828014629, 45.156, 125, 20, 150, 2, 18, 0, 125),
(505, 'P3505', 3, 7, 2, 'Azul', 'Manga larga', 10, 0.8, 0, 10.8, 7.7, 83.16, 5, 88.16, 58.8021778584392, 51.84, 140, 14.2857142857143, 160, 2, 18, 0, 140),
(506, 'P3506', 3, 12, 4, 'Verde', 'Mujer', 8, 0.64, 0, 8.64, 7.7, 66.528, 5, 71.528, 74.7567386198412, 53.472, 125, 20, 150, 1, 18, 0, 125),
(507, 'P3507', 4, 3, 3, 'Azul', 'Hombre', 25, 2, 0, 27, 7.7, 207.9, 5, 212.9, -29.5443870361672, -62.9, 150, 0.666666666666671, 151, 2, 18, 0, 150),
(508, 'P3508', 4, 3, 3, 'Negro', 'Hombre', 25, 2, 0, 27, 7.7, 207.9, 5, 212.9, -29.5443870361672, -62.9, 150, 0.666666666666671, 151, 2, 18, 0, 150),
(509, 'P3509', 4, 3, 4, 'Crema', 'Hombre', 25, 2, 0, 27, 7.7, 207.9, 5, 212.9, 40.9112259276656, 87.1, 300, 11.6666666666667, 335, 1, 18, 0, 300),
(510, 'P3510', 4, 3, 3, 'Crema', 'Hombre', 25, 2, 0, 27, 7.7, 207.9, 5, 212.9, 40.9112259276656, 87.1, 300, 11.6666666666667, 335, 2, 18, 0, 300),
(511, 'P3511', 2, 3, 3, 'Blanco/gris', 'Hombre', 25, 2, 0, 27, 7.7, 207.9, 5, 212.9, 17.426021606388, 37.1, 250, 14, 285, 1, 18, 0, 250),
(512, 'P3512', 6, 8, 6, 'Sweet & Flirty', 'Pink', 7, 0.56, 0, 7.56, 7.7, 58.212, 5, 63.212, 89.8373726507625, 56.788, 120, 16.6666666666667, 140, 2, 18, 0, 120),
(513, 'P3513', 6, 8, 6, 'Sunny & Happy', 'Pink', 7, 0.56, 0, 7.56, 7.7, 58.212, 5, 63.212, 89.8373726507625, 56.788, 120, 16.6666666666667, 140, 2, 18, 0, 120),
(514, 'P3514', 6, 8, 6, 'Sunny & Happy', '', 7, 0.56, 0, 7.56, 7.7, 58.212, 5, 63.212, 89.8373726507625, 56.788, 120, 16.6666666666667, 140, 1, 18, 0, 120),
(515, 'P3515', 6, 8, 6, 'True Escape', '', 4.23, 0.3384, 0, 4.5684, 7.7, 35.17668, 5, 40.17668, 99.1204848185564, 39.82332, 80, 25, 100, 2, 18, 0, 80),
(516, 'P3516', 6, 8, 6, 'Secret Charm', '', 4.23, 0.3384, 0, 4.5684, 7.7, 35.17668, 5, 40.17668, 99.1204848185564, 39.82332, 80, 25, 100, 2, 18, 0, 80),
(517, 'P3517', 6, 8, 6, 'Jasmine', '', 4.23, 0.3384, 0, 4.5684, 7.7, 35.17668, 5, 40.17668, 99.1204848185564, 39.82332, 80, 25, 100, 2, 18, 0, 80),
(518, 'P3518', 6, 8, 6, 'Shea Butter', '', 4.23, 0.3384, 0, 4.5684, 7.7, 35.17668, 5, 40.17668, 99.1204848185564, 39.82332, 80, 25, 100, 2, 18, 0, 80),
(519, 'P3519', 6, 8, 6, 'Shea Butter', '', 4.23, 0.3384, 0, 4.5684, 7.7, 35.17668, 5, 40.17668, 99.1204848185564, 39.82332, 80, 25, 100, 2, 18, 0, 80),
(520, 'P3520', 6, 8, 6, 'Shea Butter', '', 4.23, 0.3384, 0, 4.5684, 7.7, 35.17668, 5, 40.17668, 99.1204848185564, 39.82332, 80, 25, 100, 2, 18, 0, 80),
(521, 'P3521', 6, 8, 6, 'Shea Butter', '', 4.23, 0.3384, 0, 4.5684, 7.7, 35.17668, 5, 40.17668, 99.1204848185564, 39.82332, 80, 25, 100, 2, 18, 0, 80),
(522, 'P3522', 6, 8, 6, 'Shea Butter', '', 4.23, 0.3384, 0, 4.5684, 7.7, 35.17668, 5, 40.17668, 99.1204848185564, 39.82332, 80, 25, 100, 2, 18, 0, 80),
(523, 'P3523', 6, 8, 6, 'Shea Butter', '', 4.23, 0.3384, 0, 4.5684, 7.7, 35.17668, 5, 40.17668, 99.1204848185564, 39.82332, 80, 25, 100, 2, 18, 0, 80),
(524, 'P3524', 6, 8, 6, 'Shea Butter', '', 4.23, 0.3384, 0, 4.5684, 7.7, 35.17668, 5, 40.17668, 99.1204848185564, 39.82332, 80, 25, 100, 2, 18, 0, 80),
(525, 'P3525', 7, 15, 4, 'Negro', '', 27, 2.16, 0, 29.16, 7.7, 224.532, 10, 234.532, 53.4971773574608, 125.468, 360, 8.33333333333333, 390, 2, 19, 0, 360),
(526, 'P3526', 7, 15, 4, 'Negro', '', 27, 2.16, 0, 29.16, 7.7, 224.532, 10, 234.532, 53.4971773574608, 125.468, 360, 8.33333333333333, 390, 1, 19, 0, 360),
(527, 'P3527', 7, 15, 4, 'Negro', '', 27, 2.16, 0, 29.16, 7.7, 224.532, 10, 234.532, 53.4971773574608, 125.468, 360, 8.33333333333333, 390, 1, 19, 0, 360),
(528, 'P3528', 7, 15, 4, 'Azul', '', 27, 2.16, 0, 29.16, 7.7, 224.532, 10, 234.532, 53.4971773574608, 125.468, 360, 8.33333333333333, 390, 2, 19, 0, 360),
(529, 'P3529', 7, 15, 4, 'Azul', '', 27, 2.16, 0, 29.16, 7.7, 224.532, 10, 234.532, 53.4971773574608, 125.468, 360, 8.33333333333333, 390, 1, 19, 0, 360),
(530, 'P3530', 7, 15, 4, 'Azul', '', 27, 2.16, 0, 29.16, 7.7, 224.532, 10, 234.532, 53.4971773574608, 125.468, 360, 8.33333333333333, 390, 1, 19, 0, 360),
(531, 'P3531', 6, 10, 6, 'Forbidden Vanilla', '', 4.22, 0.3376, 0, 4.5576, 7.7, 35.09352, 10, 45.09352, 77.4090822805583, 34.90648, 80, 25, 100, 2, 19, 0, 80),
(532, 'P3532', 1, 3, 1, 'Celeste', 'Abierto. Mujer', 25, 2, 0, 27, 7.7, 207.9, 10, 217.9, 51.4456172556218, 112.1, 330, 9.09090909090909, 360, 2, 19, 0, 330),
(533, 'P3533', 1, 3, 3, 'Celeste', 'Abierto. Mujer', 25, 2, 0, 27, 7.7, 207.9, 10, 217.9, 51.4456172556218, 112.1, 330, 9.09090909090909, 360, 2, 19, 0, 330),
(534, 'P3534', 1, 3, 4, 'Azul', 'Abierto. Mujer', 25, 2, 0, 27, 7.7, 207.9, 10, 217.9, 51.4456172556218, 112.1, 330, 9.09090909090909, 360, 2, 19, 0, 330),
(535, 'P3535', 4, 3, 2, 'Morado', 'Abierto. Mujer', 25, 2, 0, 27, 7.7, 207.9, 10, 217.9, 37.6778338687471, 82.1, 300, 11.6666666666667, 335, 1, 19, 0, 300),
(536, 'P3536', 4, 3, 4, 'Rosado', 'Cerrado. Mujer', 24.99, 1.9992, 0, 26.9892, 7.7, 207.81684, 10, 217.81684, 37.7303977047872, 82.18316, 300, 11.6666666666667, 335, 1, 19, 0, 300),
(537, 'P3537', 3, 3, 4, 'Azul', 'Cerrado. Mujer', 12, 0.96, 0, 12.96, 7.7, 99.792, 10, 109.792, 82.1626348003497, 90.208, 200, 12.5, 225, 1, 19, 0, 200),
(538, 'P3538', 3, 3, 4, 'Gris', 'Cerrado. Mujer', 15, 1.2, 0, 16.2, 7.7, 124.74, 10, 134.74, 70.6991242392756, 95.26, 230, 13.0434782608696, 260, 1, 19, 0, 230);

--
-- Disparadores `tblproductos`
--
DROP TRIGGER IF EXISTS `codigoproducto`;
DELIMITER //
CREATE TRIGGER `codigoproducto` BEFORE INSERT ON `tblproductos`
 FOR EACH ROW BEGIN
DECLARE var int;

SELECT COUNT(idProducto)+1 into @var FROM tblProductos;

SET NEW.codigoProducto = CONCAT('P', @var+3000);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltallas`
--

DROP TABLE IF EXISTS `tbltallas`;
CREATE TABLE IF NOT EXISTS `tbltallas` (
  `idTalla` int(11) NOT NULL AUTO_INCREMENT,
  `Talla` varchar(45) NOT NULL,
  PRIMARY KEY (`idTalla`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `tbltallas`
--

INSERT INTO `tbltallas` (`idTalla`, `Talla`) VALUES
(1, 'XS'),
(2, 'S'),
(3, 'M'),
(4, 'L'),
(5, 'XL'),
(6, 'OS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltipogasto`
--

DROP TABLE IF EXISTS `tbltipogasto`;
CREATE TABLE IF NOT EXISTS `tbltipogasto` (
  `idTipoGasto` int(11) NOT NULL AUTO_INCREMENT,
  `TipoGasto` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoGasto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltipoproductos`
--

DROP TABLE IF EXISTS `tbltipoproductos`;
CREATE TABLE IF NOT EXISTS `tbltipoproductos` (
  `idTipoProducto` int(11) NOT NULL AUTO_INCREMENT,
  `TipoProducto` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Volcado de datos para la tabla `tbltipoproductos`
--

INSERT INTO `tbltipoproductos` (`idTipoProducto`, `TipoProducto`) VALUES
(1, 'Playera'),
(2, 'Sueter'),
(3, 'Sudadero'),
(4, 'Pantalon'),
(5, 'Pantaloneta'),
(6, 'Camisa'),
(7, 'Blusa'),
(8, 'Crema'),
(9, 'Brillo'),
(10, 'Splash'),
(11, 'Suéter'),
(12, 'Polo'),
(13, 'Top'),
(14, 'Chaqueta'),
(15, 'Abrigo'),
(16, 'Chumpa'),
(17, 'Chaleco'),
(18, 'Billetera'),
(19, 'Bolsa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltransaccionclientes`
--

DROP TABLE IF EXISTS `tbltransaccionclientes`;
CREATE TABLE IF NOT EXISTS `tbltransaccionclientes` (
  `idTransaccionCliente` int(11) NOT NULL AUTO_INCREMENT,
  `fechaTransaccionCliente` varchar(45) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `totalTransaccion` double DEFAULT NULL,
  PRIMARY KEY (`idTransaccionCliente`),
  KEY `fk_tblTransaccionCliente_tblCliente1_idx` (`idCliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

--
-- Volcado de datos para la tabla `tbltransaccionclientes`
--

INSERT INTO `tbltransaccionclientes` (`idTransaccionCliente`, `fechaTransaccionCliente`, `idCliente`, `totalTransaccion`) VALUES
(1, '2014-04-05', 1, 390),
(2, '2014-04-07', 1, 330),
(3, '2014-04-07', 1, 150),
(4, '2014-04-11', 2, 280),
(5, '2014-04-11', 3, 700),
(6, '2014-04-11', 2, 200),
(7, '2014-04-13', 4, 0),
(8, '2014-04-13', 4, 0),
(9, '2014-04-13', 4, 0),
(10, '2014-04-13', 4, 0),
(11, '2014-04-13', 4, 0),
(12, '2014-04-13', 4, 0),
(14, '2014-04-13', 2, 425),
(15, '2014-04-13', 4, 660),
(16, '2014-05-31', 1, 420),
(17, '2014-07-05', 1, 85),
(18, '2014-08-02', 1, 302);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltransaccionvendedores`
--

DROP TABLE IF EXISTS `tbltransaccionvendedores`;
CREATE TABLE IF NOT EXISTS `tbltransaccionvendedores` (
  `idTransaccionVendedor` int(11) NOT NULL AUTO_INCREMENT,
  `codigoTransaccion` varchar(45) NOT NULL,
  `fechaTransaccionVendedor` date NOT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `idVendedor` int(11) NOT NULL,
  `totalTransaccion` double DEFAULT NULL,
  PRIMARY KEY (`idTransaccionVendedor`),
  KEY `fk_tblTransaccion_tblVendedor1_idx` (`idVendedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Volcado de datos para la tabla `tbltransaccionvendedores`
--

INSERT INTO `tbltransaccionvendedores` (`idTransaccionVendedor`, `codigoTransaccion`, `fechaTransaccionVendedor`, `fechaDevolucion`, `idVendedor`, `totalTransaccion`) VALUES
(1, 'T501', '2014-04-12', '2014-05-31', 1, 4125),
(2, 'T502', '2014-04-27', '2014-05-31', 2, 4955),
(3, 'T503', '2014-05-01', '2014-05-01', 2, 3595),
(4, 'T504', '2014-05-01', '2014-06-07', 3, 6925),
(5, 'T505', '2014-05-01', '2014-06-07', 3, 200),
(6, 'T506', '2014-05-01', '2014-06-07', 4, 1950),
(7, 'T507', '2014-05-02', '2014-06-07', 3, 2240),
(8, 'T508', '2014-05-02', '2014-06-07', 3, 540),
(9, 'T509', '2014-05-04', '2014-06-07', 2, 7355),
(10, 'T510', '2014-06-06', '2014-06-14', 5, 1940),
(11, 'T511', '2014-06-08', '2014-07-08', 2, 1200),
(12, 'T512', '2014-06-20', '2014-06-20', 6, 1605),
(13, 'T513', '2014-06-21', '2014-08-24', 2, 13280),
(14, 'T514', '2014-06-21', '2014-08-23', 2, 1940),
(15, 'T515', '2014-07-05', '2014-08-23', 2, 1560),
(16, 'T516', '2014-07-05', '2014-07-31', 2, 990),
(17, 'T517', '2014-07-10', '2014-07-14', 7, 2390),
(18, 'T518', '2014-08-02', NULL, 2, 270),
(19, 'T519', '2014-08-04', '2014-09-04', 1, 930);

--
-- Disparadores `tbltransaccionvendedores`
--
DROP TRIGGER IF EXISTS `codigotransaccion`;
DELIMITER //
CREATE TRIGGER `codigotransaccion` BEFORE INSERT ON `tbltransaccionvendedores`
 FOR EACH ROW BEGIN
DECLARE var int;

SELECT COUNT(idTransaccionVendedor)+1 into @var FROM tblTransaccionVendedores;

SET NEW.codigoTransaccion = CONCAT('T', @var+500);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuarios`
--

DROP TABLE IF EXISTS `tblusuarios`;
CREATE TABLE IF NOT EXISTS `tblusuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(45) NOT NULL,
  `Contrasenia` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tblusuarios`
--

INSERT INTO `tblusuarios` (`idUsuario`, `Usuario`, `Contrasenia`) VALUES
(1, 'root', 'masterkey'),
(2, 'xocolata', 'ldrndlp');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblvendedores`
--

DROP TABLE IF EXISTS `tblvendedores`;
CREATE TABLE IF NOT EXISTS `tblvendedores` (
  `idVendedor` int(11) NOT NULL AUTO_INCREMENT,
  `codigoVendedor` varchar(45) NOT NULL,
  `nombreVendedor` varchar(45) NOT NULL,
  `DPI` varchar(45) NOT NULL,
  `direccionVendedor` varchar(45) NOT NULL,
  `saldoVendedor` double DEFAULT NULL,
  PRIMARY KEY (`idVendedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `tblvendedores`
--

INSERT INTO `tblvendedores` (`idVendedor`, `codigoVendedor`, `nombreVendedor`, `DPI`, `direccionVendedor`, `saldoVendedor`) VALUES
(1, 'V301', 'Sergio Santiago', '', '', 930),
(2, 'V302', 'Allan Sac', '', '', 27175),
(3, 'V303', 'Andrea Fleischhaker', '', '7ma av 1-81 zona 1 la esperanza', 9905),
(4, 'V304', 'Silvana Girón Reyes', '', '', 735),
(5, 'V305', 'Boris Nufio', '', '', 780),
(6, 'V306', 'Ethel Katherine Girón', '', '', 1600),
(7, 'V307', 'Claudia Tirado', '', '0 calle 4-39 zona 9 Condominio Villa Andrea c', 2390);

--
-- Disparadores `tblvendedores`
--
DROP TRIGGER IF EXISTS `codigovendedor`;
DELIMITER //
CREATE TRIGGER `codigovendedor` BEFORE INSERT ON `tblvendedores`
 FOR EACH ROW BEGIN
DECLARE var int;

SELECT COUNT(idVendedor)+1 into @var FROM tblVendedores;

SET NEW.codigoVendedor = CONCAT('V', @var+300);
END
//
DELIMITER ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tblcontactovendedor`
--
ALTER TABLE `tblcontactovendedor`
  ADD CONSTRAINT `fk_tblContactoVendedor_tblVendedores1` FOREIGN KEY (`idVendedor`) REFERENCES `tblvendedores` (`idVendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbldetalletransaccionclientes`
--
ALTER TABLE `tbldetalletransaccionclientes`
  ADD CONSTRAINT `fk_tblDetalleTransaccionClientes_tblProductos1` FOREIGN KEY (`idProducto`) REFERENCES `tblproductos` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tblDetalleTransaccionClientes_tblTransaccionClientes1` FOREIGN KEY (`idTransaccionCliente`) REFERENCES `tbltransaccionclientes` (`idTransaccionCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbldetalletransaccionvendedores`
--
ALTER TABLE `tbldetalletransaccionvendedores`
  ADD CONSTRAINT `fk_tblDetalleTransaccionVendedores_tblProductos1` FOREIGN KEY (`idProducto`) REFERENCES `tblproductos` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tblDetalleTransaccionVendedores_tblTransaccionVendedores1` FOREIGN KEY (`idTransaccionVendedor`) REFERENCES `tbltransaccionvendedores` (`idTransaccionVendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblgastos`
--
ALTER TABLE `tblgastos`
  ADD CONSTRAINT `fk_tblGastos_tblTipoGasto1` FOREIGN KEY (`idTipoGasto`) REFERENCES `tbltipogasto` (`idTipoGasto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblproductos`
--
ALTER TABLE `tblproductos`
  ADD CONSTRAINT `fk_tblProductos_tblEstadoProducto1` FOREIGN KEY (`idEstadoProducto`) REFERENCES `tblestadoproductos` (`idEstadoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tblProductos_tblMarca1` FOREIGN KEY (`idMarca`) REFERENCES `tblmarcas` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tblProductos_tblPedidos1` FOREIGN KEY (`idPedido`) REFERENCES `tblpedidos` (`idPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tblProductos_tblTalla1` FOREIGN KEY (`idTalla`) REFERENCES `tbltallas` (`idTalla`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tblProductos_tblTipoProducto1` FOREIGN KEY (`idTipoProducto`) REFERENCES `tbltipoproductos` (`idTipoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbltransaccionclientes`
--
ALTER TABLE `tbltransaccionclientes`
  ADD CONSTRAINT `fk_tblTransaccionCliente_tblCliente1` FOREIGN KEY (`idCliente`) REFERENCES `tblclientes` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbltransaccionvendedores`
--
ALTER TABLE `tbltransaccionvendedores`
  ADD CONSTRAINT `fk_tblTransaccion_tblVendedor1` FOREIGN KEY (`idVendedor`) REFERENCES `tblvendedores` (`idVendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
