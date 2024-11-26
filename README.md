My Hunter Test

MySQL DDL

```sql
CREATE TABLE categories 
(
	id bigint UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	parent_category_id bigint UNSIGNED,

	FOREIGN KEY (parent_category_id) REFERENCES categories(id)
);
```

```sql
CREATE TABLE products 
(
	id bigint UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(300) NOT NULL,	
	available int not null default 0,
	price decimal(10,2) not null,
	category_id bigint unsigned,
	
	FOREIGN KEY (category_id) REFERENCES categories(id)
);
```
