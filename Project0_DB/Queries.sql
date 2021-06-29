
DROP TABLE IF EXISTS orders;

CREATE TABLE orders(
   order_id serial PRIMARY KEY NOT NULL,
   quantity INT,
   unit_price DECIMAL(4,2),
   total_price DECIMAL(4,2),
   order_date DATE,
   teddy_id INT REFERENCES teddies (teddy_id)
 );
  



DROP TABLE IF EXISTS teddies;


CREATE TABLE teddies( 
    teddy_id serial PRIMARY KEY, 
	teddy_name TEXT,
	teddy_colors TEXT,
	teddy_description TEXT 
);

INSERT INTO Teddies (teddy_name, teddy_colors, teddy_description)
			VALUES ('Charlotte ', 'Tan,', 'Bear with uniqe softness' ),
			('Bibi', 'Pale brown', 'Cutest cream teddy bear '),
			('Bella', 'Pale brown', ' tenderness to your little one.'),
			('Pipo', 'Brown', 'life long friend'),
			('Sese', 'Beige',  ' He really has it all'),
			('Chati', ' Chocolate', ' Endless cuddles in your arms');
			
		
INSERT INTO orders (quantity, unit_price, total_price, order_date , teddy_id)
			VALUES ( 1, 55.99, 55.99, '2020-12-10', 1),
			( 1, 69.99, 69.99, '2020-12-15', 2), 
			(1, 75.99, 75.99, '2020-12-18', 3),
			( 1, 80.99, 80.99, '2020-12-20', 4), 
		    ( 1, 85.99, 85.99, '2020-12-20', 5), 
		    ( 1, 79.9, 79.99, '2020-12-23', 6);

		   
SELECT * FROM teddies;		
		
SELECT * FROM orders;
	
CREATE TRIGGER teddies_removed AFTER DELETE ON teddies 
FOR EACH ROW EXECUTE PROCEDURE teddy_removed();
		
SELECT * FROM teddies WHERE teddy_name = 'Charlotte and Charles';		

SELECT * FROM teddies WHERE teddy_colors = 'Brown, Blue, Pink';		
		
		
DELETE FROM teddies WHERE teddy_id = 7;		
				
SELECT * FROM orders WHERE teddy_id	> 1;	
	
SELECT * FROM orders  ORDER BY unit_price desc;	

SELECT 
		


select * from teddies JOIN orders on teddies.teddy_id = orders.order_Id;
--UPDATE teddies SET teddies_order = 1 WHERE order_Id = 4;

--UPDATE teddies_orders SET teddy_id = 1 WHERE order_Id = 7;

--UPDATE teddies_orders SET teddy_id = 3 WHERE order_Id = 4;	

--UPDATE teddies_orders SET teddy_id = 3 WHERE order_Id = 5;		
		
--UPDATE teddies_orders SET teddy_id = 5 WHERE order_Id =6;		
				
--UPDATE teddies_orders SET teddy_id = 6 WHERE teddy_Id =1;		
						
	--DELETE teddies_orders 	
		--INSERT INTO Teddies (teddy_name, teddy_colors, teddy_description)
			--VALUES ('Charlotte and Charles', 'Tan, Chocolate, Black, White', 'Formidable Pink teddy bear with uniqe softness' ),
			--('Ours polaire', 'Pale brown, Dark Brown, White', 'Cutest cream teddy bear that twists in all directions'),
			--('Rose attrape rêve', 'Pale brown, Dark Brown, White', 'Original plush that brings peace and tenderness to your little one.'),
			--('Ours beige', 'Brown, Blue, Pink', 'This beautiful white bear soft toy holds a big red heart in its hands to reveal the tenderness that we can feel.'),
			--('Miel Titours', 'Beige, Tan, Chocolate',  'Soft, with dense, thick and silky fur, with an intelligent and warm look, he really has it all'),
			--('Chat thaytou', 'Beige, Tan, Chocolate', 'This tenderly colored kitten standing on all fours is the best confidant for endless cuddles in your arms');

		
		
ALTER TABLE "orders"
DROP CONSTRAINT "orders_teddy_id_fkey",
ADD CONSTRAINT "orders_teddy_id_fkey"
  FOREIGN KEY ("teddy_id")
  REFERENCES teddies(teddy_id)
  ON DELETE CASCADE;
 

 ALTER TABLE "Teddy".orders ADD CONSTRAINT orders_teddy_id_fkey FOREIGN KEY (teddy_id) REFERENCES "Teddy".teddies(teddy_id)
 
