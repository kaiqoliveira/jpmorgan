INSERT INTO trader (tradercode, tradername) VALUES ('JDO', 'John Doe'),('JSM', 'John Smith');
INSERT INTO ordert (orderid, ticker, traderid) VALUES (123456,'PETR4', 'JDO'), (123457,'ITUB4', 'JSM');
INSERT INTO trade (price, quantity, tradetime, orderid) VALUES (25.123456, 1000, current_timestamp, 123456), (40.000000, 2000, current_timestamp, 123457);