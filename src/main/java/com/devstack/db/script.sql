CREATE DATABASE IF NOT EXISTS hotel_api;
       SHOW DATABASES;
        USE hotel_api;
#==========================
CREATE TABLE IF NOT EXISTS user (
    id VARCHAR(80) PRIMARY KEY,
    full_name VARCHAR(45),
    email VARCHAR(100) UNIQUE,
    password TEXT
);
#==========================
# TEXT (name)
#TXT
#txtName
#==========================
# table
#tbl
#button
#btn