DELIMITER $$
CREATE PROCEDURE DELETAR_CRIPTO (ID varchar(100))
BEGIN
DELETE FROM tab_extremos WHERE ID_Cripto = ID;
DELETE FROM tab_valor_hist WHERE ID_Cripto = ID;
DELETE FROM tab_valor WHERE ID_Cripto = ID;
DELETE FROM TAB_CRIPTO WHERE ID_Cripto = ID;
END $$
DELIMITER ;