INSERT INTO usuario (nombre, clave, rol, activo)
VALUES ('admin', '$2a$10$UYKzeg61RYWuvIuN8rOY5uk0ciOAfms0Ea8Exv/nS2WGcpVOrWmMi', 'ADMIN', true);
INSERT INTO usuario (nombre, clave, rol, activo)
VALUES ('user', '$2a$10$ZIvvH0rTLYqKnI10y/SMWukQ7DjRnyDY1c4sqKIOjd2wz84hL3Kre', 'USER', true);

INSERT INTO categoria (nombre) VALUES ('Celular');
INSERT INTO categoria (nombre) VALUES ('Automóvil');

INSERT INTO marca (nombre) VALUES ('Samsung');
INSERT INTO marca (nombre) VALUES ('Apple');
INSERT INTO marca (nombre) VALUES ('Huawei');
INSERT INTO marca (nombre) VALUES ('Xiaomi');
INSERT INTO marca (nombre) VALUES ('Toyota');
INSERT INTO marca (nombre) VALUES ('Nissan');
INSERT INTO marca (nombre) VALUES ('Suzuki');