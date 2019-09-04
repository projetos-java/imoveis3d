-- USUARIO
INSERT INTO `imoveisweb`.`tb_usuario` (`cpf`, `email`, `nome`, `senha`) VALUES ('000.000.000-00', 'admin', 'admin', 'admin');

-- ESTADOS
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Acre');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Alagoas');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Amapa');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Amazonas');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Bahia');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Ceará');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Distrito Federal');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Espirito Santo');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Goias');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Maranhao');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Mato Grosso');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Mato Grosso do Sul');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Minas Gerais');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Para');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Paraiba');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Parana');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Pernanbuco');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Piaui');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Rio de Janeiro');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Rio Grande do Norte');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Rio Grande do Sul');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Rondonia');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Roraina');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Santa Catarina');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Sao Paulo');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Sergipe');
INSERT INTO `imoveisweb`.`tb_uf` (`nome`) VALUES ('Tocantins');

-- CIDADES
INSERT INTO `imoveisweb`.`tb_cidade` (`nome`, `id_tb_uf`) VALUES ('Araguaina', '27');
INSERT INTO `imoveisweb`.`tb_cidade` (`nome`, `id_tb_uf`) VALUES ('Palmas', '27');
INSERT INTO `imoveisweb`.`tb_cidade` (`nome`, `id_tb_uf`) VALUES ('Colinas', '27');
INSERT INTO `imoveisweb`.`tb_cidade` (`nome`, `id_tb_uf`) VALUES ('Porto Nacional', '27');
INSERT INTO `imoveisweb`.`tb_cidade` (`nome`, `id_tb_uf`) VALUES ('Lajeado', '27');
INSERT INTO `imoveisweb`.`tb_cidade` (`nome`, `id_tb_uf`) VALUES ('Gurupi', '27');

-- CATEGORIA
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Casa');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Apartamento');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Flat');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Kitnet');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Sobrado');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Duplex');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Triplex');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Cobertura');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Mansao');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Fazenda');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Sitio');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Casa na Praia');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Casa em Condominio');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Ponto Comercial');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Galpao');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Sala Comercial');
INSERT INTO `imoveisweb`.`tb_categoria` (`nome`) VALUES ('Deposito / Armazem');