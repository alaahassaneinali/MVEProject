 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (id,username, authority) VALUES (1,'guest', 'ROLE_USER');
INSERT INTO authority (id,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO authority (id,username, authority) VALUES (3,'admin', 'ROLE_USER');

INSERT INTO  `USER` (id,firstname, lastname,age,title,userNumber, USER_id) VALUES (1,'Curious','George',12,'Boy Monkey', 8754,'admin');
INSERT INTO `USER` (id,firstname, lastname,age,title,userNumber,USER_id) VALUES (2,'Allen','Rench',123,'Torque Master', 8733,'guest');

INSERT INTO `ADDRESS` (id,city,state,street,USER_id) VALUES (1,'Fairfield','Iowa','Main','1');
INSERT INTO `ADDRESS` (id,city,state,street,USER_id) VALUES (2,'Batavia','Iowa','Maple','2');
INSERT INTO `ADDRESS` (id,city,state,street,USER_id) VALUES (3,'Ottumwa','Iowa','Maple','2');

INSERT INTO product(id,name,price, description,quantity) VALUES (1,"Sail Boat",22.0, "Sails",0);
INSERT INTO product(id,name,price, description,quantity) VALUES (2,"Toy Boat",22.0, "floats",0);


INSERT INTO store(id,name,address_id) VALUES (1,"Mongolia Store",1);
INSERT INTO store(id,name,address_id) VALUES (2,"Vitneam Store",2);
 
					