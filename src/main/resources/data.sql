insert into brand(name) values('Chevrolet');
insert into brand(name) values('Volkswagens');
insert into brand(name) values('Yamaha');
insert into brand(name) values('Honda');

insert into type(name) values('Carro');
insert into type(name) values('Moto');

insert into model(name, brand_id, type_id) values('Fazer 150', 3, 2);
insert into model(name, brand_id, type_id) values('Lander 250', 3, 2);
insert into model(name, brand_id, type_id) values('Biz 100', 4, 2);
insert into model(name, brand_id, type_id) values('CB 650f', 4, 2);
insert into model(name, brand_id, type_id) values('Gol', 2, 1);
insert into model(name, brand_id, type_id) values('Virtus', 2, 1);
insert into model(name, brand_id, type_id) values('Onix', 1, 1);
insert into model(name, brand_id, type_id) values('Camaro', 1, 1);

insert into address(zipcode, public_place, number, city, state, neighborhood, complement) values('115488', 'Rua Joaquim Manoel', '151', 'sao paulo', 'sp', 'jardins', '');

insert into parking(name, cnpj, email, password, address_id, is_active) values('Estacionamento Teste', '7584856680011', 'teste@email.com', '$2y$12$Gw9SqJ0P8Wu0v7cBfmCCleRdmtVvjh3IMKUM3VPWIeDDveTa7v9ma',1, true);

insert into role(name) values('ROLE_USER');
insert into parking_role(parking_id, role_id) values ('teste@email.com', 'ROLE_USER');

insert into vehicle(plate, parking_id, model_id, is_active) values('ytd215e', 1, 1, true);
insert into vehicle(plate, parking_id, model_id, is_active) values('gege54', 1, 6, true);
