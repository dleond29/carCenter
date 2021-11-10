-- Cliente
INSERT INTO clientes (id, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular, direccion, correo_electronico, presupuesto_limite) VALUES ('1', 'Diego', 'Alexander', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', '1000000' );
INSERT INTO clientes (id, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular, direccion, correo_electronico, presupuesto_limite) VALUES ('2', 'Alex', 'Andres', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', '1000000' );
INSERT INTO clientes (id, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular, direccion, correo_electronico, presupuesto_limite) VALUES ('3', 'Diego', 'Andres', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', '1000000' );
INSERT INTO clientes (id, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular, direccion, correo_electronico, presupuesto_limite) VALUES ('4', 'Diego', 'Andres', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', '1000000' );

-- Mecanico
INSERT INTO mecanicos(id,primer_nombre,segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular,direccion,correo_electronico,estado) VALUES ('1', 'Jose', 'Alexander', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', 'terminado' );
INSERT INTO mecanicos(id,primer_nombre,segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular,direccion,correo_electronico,estado) VALUES ('2', 'Diego', 'Alexander', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', 'pendiente' );
INSERT INTO mecanicos(id,primer_nombre,segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular,direccion,correo_electronico,estado) VALUES ('3', 'Diego', 'Alexander', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', 'terminado' );
INSERT INTO mecanicos(id,primer_nombre,segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular,direccion,correo_electronico,estado) VALUES ('4', 'Diego', 'Alexander', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', 'pendiente' );

-- Repuesto
INSERT INTO repuestos(id, nombre_repuesto, precio_por_unidad, numero_de_unidades) VALUES ('1','Retenedor', '12000', '2');
INSERT INTO repuestos(id, nombre_repuesto, precio_por_unidad, numero_de_unidades) VALUES ('2','Empaque', '2000', '1');
INSERT INTO repuestos(id, nombre_repuesto, precio_por_unidad, numero_de_unidades) VALUES ('3','Filtro aceite', '15000', '3');
INSERT INTO repuestos(id, nombre_repuesto, precio_por_unidad, numero_de_unidades) VALUES ('4','Aceite', '20000', '2');

-- Servicio
INSERT INTO servicios(id, nombre_servicio, mano_de_obra, descuento, id_repuesto) VALUES ('1', 'Cambio de aceite', '35000', '0', '1');
INSERT INTO servicios(id, nombre_servicio, mano_de_obra, descuento, id_repuesto) VALUES ('2', 'Cambio filtro de aceite', '35000', '0','2');
INSERT INTO servicios(id, nombre_servicio, mano_de_obra, descuento, id_repuesto) VALUES ('3', 'Cambio de llantas', '35000', '0','3');
INSERT INTO servicios(id, nombre_servicio, mano_de_obra, descuento, id_repuesto) VALUES ('4', 'Alineacion', '35000', '0','4');

-- Factura
INSERT INTO facturas(id, total_factura, cliente_id, mecanico_id, servicio_id) VALUES ('1','100000','1','1','1');
INSERT INTO facturas(id, total_factura, cliente_id, mecanico_id, servicio_id) VALUES ('2','100000','2','1','2');
INSERT INTO facturas(id, total_factura, cliente_id, mecanico_id, servicio_id) VALUES ('3','100000','2','1','3');
INSERT INTO facturas(id, total_factura, cliente_id, mecanico_id, servicio_id) VALUES ('4','100000','3','2','1');