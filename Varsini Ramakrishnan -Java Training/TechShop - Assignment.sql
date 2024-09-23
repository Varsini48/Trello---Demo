create database TechShop;
use TechShop;
show tables;
create Table Customers(
CustomerID int auto_increment Primary key,
FirstName varchar(50),
LastName varchar(50),
email varchar(50),
phone bigint,
address varchar(250)
);

create table Product(
 ProductID varchar(5) primary key,
 ProductName varchar(50),
 ProdDesc varchar(50),
 Price Decimal(10,2)
 );

 
 
 create table Orders(
 OrderId int primary key,
 CustomerID int, 
 foreign key (CustomerID) references Customers(CustomerID) on delete cascade ,
 Orderdate date,
 TotalAmount decimal(10,2)
 );
 
create table OrderDetails(
OrderDetailID varchar(10) primary key,
OrderID int ,
foreign key (OrderID) references Orders(OrderID) on delete cascade,
ProductID varchar(5),
foreign key (ProductID) references Product(ProductID) on delete cascade,
Quantity int
);

create table Inventory(
InventoryID varchar(20) primary key,
ProductID varchar(5),
foreign key(ProductID) references Product(ProductID) on delete cascade,
QuantityStock int,
LastStockUpdate int
);


insert into Customers values (1,'Ram','kumar','ram@gmail.com','12345678','Delhi');
insert into Customers values (2,'Arun','kumar','arun@gmail.com','12367678','Pune');
insert into Customers values (3,'Shyam','Singh','shyam@gmail.com','45345678','Chennai');
insert into Customers values (4,'Deepthi','singh','deepthi@gmail.com','364745678','Delhi');
insert into Customers values (5,'Anil','Tiwari','anil@gmail.com','57845678','Coimbatore');
insert into Customers values (6,'Manoj','kumar','manoj@gmail.com','17845678','Gujarat');
insert into Customers values (7,'Devi','Priya','devi@gmail.com','29845678','Mumbai');
insert into Customers values (8,'Siva','Ranjani','siva@gmail.com','12345600','Chennai');
insert into Customers values (9,'Varsini','Ramakrishnan','varsini@gmail.com','56745678','Coimbatore');
insert into Customers values (10,'Kishor','Saravanan','kishor@gmail.com','12398078','abc');
select * from Customers;

insert into Product values (101,'Mobile','Samsung s20',1000);
insert into Product values (102,'Mobile','Moto G(5)',1500);
insert into Product values (103,'Headphones','Boat wireless',200);
insert into Product values (104,'Headphones','MI headphones ',150);
insert into Product values (105,'Datacable','B-type',100);
insert into Product values (106,'Datacable','C-Type',100);
insert into Product values (107,'Pendrive','Sandisk',1000);
insert into Product values (108,'Hardisk','Seagate',1000);
insert into Product values (109,'Charger','B-type',1000);
insert into Product values (110,'Charger','C-Type',1000); 

insert into Orders values (1001,1,'2024-09-18',130);
insert into Orders values (1002,2,'2024-09-24',240);
insert into Orders values (1003,8,'2024-08-07',150);
insert into Orders values (1004,3,'2024-07-17',180);
insert into Orders values (1005,5,'2024-05-06',140);
insert into Orders values (1006,7,'2024-07-18',200);
insert into Orders values (1007,4,'2024-04-20',260);
insert into Orders values (1008,6,'2024-02-15',180);
insert into Orders values (1009,9,'2024-07-15',300);
insert into Orders values (1010,10,'2024-09-25',190);

insert into OrderDetails values ('OD1',1001,101,100);
insert into OrderDetails values ('OD2',1002,107,500);
insert into OrderDetails values ('OD3',1003,104,2000);
insert into OrderDetails values ('OD4',1004,103,1500);
insert into OrderDetails values ('OD5',1005,109,1000);
insert into OrderDetails values ('OD6',1006,102,3000);
insert into OrderDetails values ('OD7',1007,105,500);
insert into OrderDetails values ('OD8',1008,106,700);
insert into OrderDetails values ('OD9',1009,108,600);
insert into OrderDetails values ('OD10',1010,110,800);


insert into Inventory values ('ID1', 101 , 200, 210); 
insert into Inventory values ('ID2', 102 , 300, 350);
insert into Inventory values ('ID3', 103 , 350, 400);
insert into Inventory values ('ID4', 104 , 500, 550); 
insert into Inventory values ('ID5', 105 , 100, 150);
insert into Inventory values ('ID6', 106 , 250, 300);
insert into Inventory values ('ID7', 107 , 150, 200);
insert into Inventory values ('ID8', 108 , 400, 450);
insert into Inventory values ('ID9', 109 , 700, 750);
insert into Inventory values ('ID10', 110 , 800, 810); 
 
 -- TASK 2

-- 1

select Firstname, lastname, email from customers;

-- 2

select o.OrderDate , c.FirstName 
from Orders o
inner join Customers c
on c.CustomerID = o.CustomerID ;

-- 3

insert into Customers (firstname,lastname,email,address) values ('diya', 'dinesh', 'diya@gmail.com', 'coimbatore');
select * from customers;

-- 4

update product set price=price+(Price*0.1);

-- 5

delete from Orders where OrderID=1001;
select * from orders;
select * from OrderDetails;

-- 6

insert into orders(CustomerId, orderID, orderdate, Totalamount) values (3, '1011', '2024-09-20', 2000);

-- 7

update customers set email='ranjnai@gmail.com' where CustomerId=8;

-- 8

update Orders set totalamount = (select sum(orderdetails.Quantity * product.Price)
from orderDetails 
join product on orderDetails.ProductID = product.ProductID
where orderDetails.OrderID = orders.OrderID
);
select * from orders;

-- 9
 delete from Orders
where OrderID in (select OrderID from Orders where CustomerID = 7);
 
 
-- 10
insert into product (productID, productName,  price) values (111, 'lenovo laptpo', 20000);

--  11
update orders set orderdate='2024-04-24' where orderid=1007;

-- 12

alter table Customers 
add orders_placed int;
update Customers set Orders_placed = 0 where orders_placed is NULL;
update customers set orders_placed= (select count(*) from orders where c.customerId = o.customerID)
where orders_placed=0; 

-- TASK 3

-- 1
use Techshop;
select o.orderid,c.firstname from orders o 
inner join customers c
where o.customerid=c.customerid;

-- 2 
use Techshop;
select distinct ProductName, Price * Quantity as totalrevenue 
from Product
inner join  OrderDetails 
on Product.ProductID = OrderDetails.ProductID;
 
 
-- 3
select c.CustomerID, c.Firstname,c.email, c.Address
from customers c
inner join orders o
on c.customerId=o.Customerid;

-- 4 

select p.productname 
from product p
inner join orderdetails o group by productname having max(quantity);

-- 5

select productid, productname, proddesc from product ;

-- 6

select c.firstname, avg(o.totalamount) as avg 
from Orders o
join customers c on c.customerid=o.customerid
group by c.customerid;

-- 7

select o.orderid, c.firstname, o.totalamount from orders o 
join customers c on c.customerid=o.customerid
order by o.totalamount desc;

-- 8
select p.productid, p.productname, count(*)
from product p
join orderdetails o on p.productid=o.productid
group by p.productid;

-- 9
select c.firstname,o.orderid, p.Productname 
from customers c
join orders o on c.customerid=o.customerid
join orderdetails od on o.orderid=od.orderid
join product p on p.productid=od.productid
where productname='mobile';

 -- 10 

select sum(o.TotalAmount) as totalrevenue
from Orders o
where o.OrderDate between '2024-09-10' and '2024-09-15';


-- TASK 4
use techshop;

-- 1

select customers.firstname, customers.lastname
from customers
left join orders 
on customers.customerid=orders.customerid
where orders.orderid is NULL;

 -- 2 
 
 select sum(quantitystock)as products_available from inventory;
 
 -- 3 
 
 select sum(totalamount) as revenue_generated from orders;
 
 -- 4 
 
select p.productname, avg(od.quantity) 
from product p
join orderdetails od on p.productid=od.productid
where p.productname='mobile';

-- 5 

select customers.customerid, customers.firstname, sum(orders.totalamount) as total_revenue
from customers 
join orders  
on customers.customerid=orders.customerid
where customers.customerid = '7';

-- 6 

select c.firstname, count(o.orderid) as ordersplaced
from customers c 
join orders o 
on c.customerid=o.customerid
group by c.customerid
order by ordersplaced desc;

-- 7 

select p.productname, sum(od.quantity) as tot_quan
from product p
join orderdetails od 
on p.productid=od.productid
group by p.productid
order by tot_quan desc
limit 1;

-- 8 

select c.firstname, sum(o.totalamount) as high_tot_rev
from customers c
join orders o
on c.customerid=o.customerid
group by c.customerid
order by high_tot_rev desc
limit 1;

-- 9 

select c.firstname, sum(o.totalamount)/count(o.orderid) as avg_order_value
from customers c
join orders o 
on c.customerid = o.customerid
group by c.customerid;

-- 10 

select c.firstname, count(o.orderid)
from customers c
join orders o 
on c.customerid=o.customerid
group by c.customerid;

