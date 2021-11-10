-- Cliente
INSERT INTO clientes (id, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular, direccion, correo_electronico, presupuesto_limite) VALUES ('1', 'Diego', 'Alexander', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', '1000000' );
INSERT INTO clientes (id, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular, direccion, correo_electronico, presupuesto_limite) VALUES ('2', 'Alex', 'Andres', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', '1000000' );
INSERT INTO clientes (id, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular, direccion, correo_electronico, presupuesto_limite) VALUES ('3', 'Diego', 'Andres', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', '1000000' );
INSERT INTO clientes (id, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_documento, numero_documento, numero_celular, direccion, correo_electronico, presupuesto_limite) VALUES ('4', 'Diego', 'Andres', 'Leon', 'Duarte', 'CC', '12345', '12345', 'Cll 1 # 2-3', 'diego@mail.com', '1000000' );

-- Factura
INSERT INTO factura(id, total_factura, )
private Long id;
    private Double totalFactura;


    @ManyToOne
    @JoinColumn(name="cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="mecanico_id", nullable = false)
    private Mecanico mecanico;

    @ManyToOne
    @JoinColumn(name="repuesto_id", nullable = false)
    private Repuesto repuesto;

    @ManyToOne
    @JoinColumn(name="servicio_id", nullable = false)
    private Servicio servicio;

-- Mecanico

-- Repuesto

-- Servicio