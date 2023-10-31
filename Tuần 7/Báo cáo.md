# Demo Project
Một website sử dụng springboot cấu trúc MVC áp dụng JDBC và Oracle database để demo các thao tác CRUD cơ bản

## Tools
IDE: Intelij Community 2023  
Database: Oracle SQL Developer + Oracle database 21c 
Java Springboot  

## Demo
Connect database, applications.properties:  
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=sa
spring.datasource.password=123


MongoDB database: DemoNoSQL.User (Model User)
![Screenshot 2023-10-24 142240](https://github.com/ducvg/Ki6/assets/117010800/12201c47-163e-4fe8-96ef-c91cc16ea9ba)
(*) DemoNoSQL.dbSequence có chức năng auto-increment id cho User mỗi lần insert

Login page
![image](https://github.com/ducvg/Ki6/assets/117010800/017af623-2f27-43f9-9266-3422b171ab78)

Register Page
![image](https://github.com/ducvg/Ki6/assets/117010800/261fa318-879e-49d4-a207-a0f49a77029c)

Home Page với các chức năng Xóa và chỉnh sửa User
![image](https://github.com/ducvg/Ki6/assets/117010800/0c0b5bba-dfb3-4a58-951f-7a9956503761)
