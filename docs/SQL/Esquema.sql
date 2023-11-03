
CREATE TABLE alojamientos (
    activa                    VARCHAR2(2) NOT NULL,
    usuarios_iduser           NUMBER NOT NULL,
    checkin                   DATE NOT NULL,
    checkout                  DATE NOT NULL,
    acompanantes              NUMBER NOT NULL,
    planes_idplan             NUMBER NOT NULL,
    cuentas_idcuenta          NUMBER NOT NULL,
    idalojamiento             NUMBER NOT NULL,
    habitaciones_idhabitacion NUMBER NOT NULL
);

ALTER TABLE alojamientos
    ADD CHECK ( activa IN ( 'NO', 'SI' ) );

ALTER TABLE alojamientos ADD CONSTRAINT alojamientos_pk PRIMARY KEY ( idalojamiento );

CREATE TABLE bares (
    estilo     VARCHAR2(50) NOT NULL,
    idservicio NUMBER NOT NULL
);

ALTER TABLE bares
    ADD CHECK ( estilo IN ( 'Frances', 'Italiano', 'Mediterraneo', 'Mexicano', 'Oriental' ) );

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( idservicio );

CREATE TABLE conferencias (
    capacidad  NUMBER NOT NULL,
    fecha      DATE,
    hora       DATE NOT NULL,
    duracion   NUMBER NOT NULL,
    idservicio NUMBER NOT NULL
);

ALTER TABLE conferencias ADD CONSTRAINT conferencias_pk PRIMARY KEY ( idservicio );

CREATE TABLE cuentas (
    netocuenta                 NUMBER NOT NULL,
    idcuenta                   NUMBER NOT NULL,
    alojamientos_idalojamiento NUMBER NOT NULL
);

ALTER TABLE cuentas ADD CONSTRAINT cuentas_pk PRIMARY KEY ( idcuenta );

CREATE TABLE gimnasios (
    capacidad  NUMBER NOT NULL,
    maquinas   VARCHAR2(255) NOT NULL,
    idservicio NUMBER NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( idservicio );

CREATE TABLE habitaciones (
    numhabitacion              NUMBER NOT NULL,
    disponible                 VARCHAR2(2) NOT NULL,
    precionoche                NUMBER NOT NULL,
    hoteles_idhotel            NUMBER NOT NULL,
    tipos_idtipo               NUMBER NOT NULL,
    alojamientos_idalojamiento NUMBER NOT NULL,
    idhabitacion               NUMBER NOT NULL
);

ALTER TABLE habitaciones
    ADD CHECK ( disponible IN ( 'NO', 'SI' ) );

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( idhabitacion );

CREATE TABLE hoteles (
    nombrehotel VARCHAR2(64) NOT NULL,
    nithotel    NUMBER NOT NULL,
    idhotel     NUMBER NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( idhotel );

CREATE TABLE internet (
    anchobanda FLOAT NOT NULL,
    idservicio NUMBER NOT NULL
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( idservicio );

CREATE TABLE piscinas (
    capacidad   NUMBER NOT NULL,
    profundidad FLOAT NOT NULL,
    idservicio  NUMBER NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( idservicio );

CREATE TABLE planes (
    tipoplan  VARCHAR2(64) NOT NULL,
    descuento FLOAT NOT NULL,
    idplan    NUMBER NOT NULL
);

ALTER TABLE planes
    ADD CHECK ( tipoplan IN ( 'Larga_Estadia', 'Promo_Particular', 'Tiempo_Compartido', 'Todo_Incluido' ) );

ALTER TABLE planes ADD CONSTRAINT planes_pk PRIMARY KEY ( idplan );

CREATE TABLE productos (
    nombre                  VARCHAR2(100) NOT NULL,
    precio                  NUMBER NOT NULL,
    restaurantes_idservicio NUMBER NOT NULL,
    bares_idservicio        NUMBER NOT NULL,
    tiendas_idservicio      NUMBER NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( nombre );

CREATE TABLE reservas (
    horareserva      DATE,
    idreserva        NUMBER NOT NULL,
    cuentas_idcuenta NUMBER NOT NULL
);

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( idreserva );

CREATE TABLE restaurantes (
    estilo     VARCHAR2(50) NOT NULL,
    idservicio NUMBER NOT NULL
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurantes_pk PRIMARY KEY ( idservicio );

CREATE TABLE reuniones (
    capacidad      NUMBER NOT NULL,
    costoadicional NUMBER NOT NULL,
    fecha          DATE,
    hora           DATE NOT NULL,
    duracion       NUMBER NOT NULL,
    idservicio     NUMBER NOT NULL
);

ALTER TABLE reuniones ADD CONSTRAINT reuniones_pk PRIMARY KEY ( idservicio );

CREATE TABLE servicios (
    horarioinicial     DATE,
    horariofinal       DATE,
    nombre             VARCHAR2(64) NOT NULL,
    costo              NUMBER NOT NULL,
    cargado            VARCHAR2(2) NOT NULL,
    existe             VARCHAR2(2) NOT NULL,
    idservicio         NUMBER NOT NULL,
    reservas_idreserva NUMBER NOT NULL
);

ALTER TABLE servicios
    ADD CHECK ( cargado IN ( 'NO', 'SI' ) );

ALTER TABLE servicios
    ADD CHECK ( existe IN ( 'NO', 'SI' ) );

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( idservicio );

CREATE TABLE servicios_spas (
    duracion        NUMBER NOT NULL,
    costo           NUMBER NOT NULL,
    fecha           DATE NOT NULL,
    spas_idservicio NUMBER NOT NULL
);

CREATE TABLE spas (
    capacidad  NUMBER NOT NULL,
    idservicio NUMBER NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( idservicio );

CREATE TABLE tiendas (
    tipo       VARCHAR2(40) NOT NULL,
    idservicio NUMBER NOT NULL
);

ALTER TABLE tiendas
    ADD CHECK ( tipo IN ( 'Joyeria', 'Moda', 'Souvenirs', 'Supermercado' ) );

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( idservicio );

CREATE TABLE tipos (
    tipo      VARCHAR2(64) NOT NULL,
    capacidad NUMBER NOT NULL,
    dotacion  VARCHAR2(512) NOT NULL,
    idtipo    NUMBER NOT NULL
);

ALTER TABLE tipos
    ADD CHECK ( tipo IN ( 'Doble', 'Familiar', 'Sencilla', 'Suite', 'Suite Presidencial' ) );

ALTER TABLE tipos ADD CONSTRAINT tipos_pk PRIMARY KEY ( idtipo );

CREATE TABLE usuarios (
    nombreuser                 VARCHAR2(64) NOT NULL,
    tipodocuser                VARCHAR2(32) NOT NULL,
    numdocuser                 NUMBER NOT NULL,
    correouser                 VARCHAR2(64) NOT NULL,
    iduser                     NUMBER NOT NULL,
    alojamientos_idalojamiento NUMBER NOT NULL
);

ALTER TABLE usuarios
    ADD CHECK ( tipodocuser IN ( 'CC', 'CE', 'NIT', 'PASAPORTE', 'TI' ) );

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( iduser );

CREATE TABLE utensilios (
    devuelto   VARCHAR2(2) NOT NULL,
    estado     VARCHAR2(255) NOT NULL,
    idservicio NUMBER NOT NULL
);

ALTER TABLE utensilios
    ADD CHECK ( devuelto IN ( 'NO', 'SI' ) );

ALTER TABLE utensilios ADD CONSTRAINT utensilios_pk PRIMARY KEY ( idservicio );

ALTER TABLE alojamientos
    ADD CONSTRAINT alojamientos_cuentas_fk FOREIGN KEY ( cuentas_idcuenta )
        REFERENCES cuentas ( idcuenta )
            ON DELETE CASCADE;

ALTER TABLE alojamientos
    ADD CONSTRAINT alojamientos_habitaciones_fk FOREIGN KEY ( habitaciones_idhabitacion )
        REFERENCES habitaciones ( idhabitacion )
            ON DELETE CASCADE;

ALTER TABLE alojamientos
    ADD CONSTRAINT alojamientos_planes_fk FOREIGN KEY ( planes_idplan )
        REFERENCES planes ( idplan );

ALTER TABLE alojamientos
    ADD CONSTRAINT alojamientos_usuarios_fk FOREIGN KEY ( usuarios_iduser )
        REFERENCES usuarios ( iduser )
            ON DELETE CASCADE;

ALTER TABLE bares
    ADD CONSTRAINT bares_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE conferencias
    ADD CONSTRAINT conferencias_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE cuentas
    ADD CONSTRAINT cuentas_alojamientos_fk FOREIGN KEY ( alojamientos_idalojamiento )
        REFERENCES alojamientos ( idalojamiento )
            ON DELETE CASCADE;

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_alojamientos_fk FOREIGN KEY ( alojamientos_idalojamiento )
        REFERENCES alojamientos ( idalojamiento )
            ON DELETE CASCADE;

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_hoteles_fk FOREIGN KEY ( hoteles_idhotel )
        REFERENCES hoteles ( idhotel )
            ON DELETE CASCADE;

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_tipos_fk FOREIGN KEY ( tipos_idtipo )
        REFERENCES tipos ( idtipo )
            ON DELETE CASCADE;

ALTER TABLE internet
    ADD CONSTRAINT internet_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_bares_fk FOREIGN KEY ( bares_idservicio )
        REFERENCES bares ( idservicio )
            ON DELETE CASCADE;

ALTER TABLE productos
    ADD CONSTRAINT productos_restaurantes_fk FOREIGN KEY ( restaurantes_idservicio )
        REFERENCES restaurantes ( idservicio )
            ON DELETE CASCADE;

ALTER TABLE productos
    ADD CONSTRAINT productos_tiendas_fk FOREIGN KEY ( tiendas_idservicio )
        REFERENCES tiendas ( idservicio )
            ON DELETE CASCADE;

ALTER TABLE reservas
    ADD CONSTRAINT reservas_cuentas_fk FOREIGN KEY ( cuentas_idcuenta )
        REFERENCES cuentas ( idcuenta )
            ON DELETE CASCADE;

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE reuniones
    ADD CONSTRAINT reuniones_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_reservas_fk FOREIGN KEY ( reservas_idreserva )
        REFERENCES reservas ( idreserva )
            ON DELETE CASCADE;

ALTER TABLE servicios_spas
    ADD CONSTRAINT servicios_spas_spas_fk FOREIGN KEY ( spas_idservicio )
        REFERENCES spas ( idservicio )
            ON DELETE CASCADE;

ALTER TABLE spas
    ADD CONSTRAINT spas_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_alojamientos_fk FOREIGN KEY ( alojamientos_idalojamiento )
        REFERENCES alojamientos ( idalojamiento )
            ON DELETE CASCADE;

ALTER TABLE utensilios
    ADD CONSTRAINT utensilios_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );