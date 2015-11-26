CREATE TABLE Person (
	Person_Id INT Primary KEY,
	First_Name VARCHAR(512),
	Middle_name VARCHAR(512),
	Last_name VARCHAR(512),
	Primary_Phone_Number VARCHAR(512),
	Other_Phone_Number VARCHAR(512),
	Email_Address VARCHAR(512)
);

CREATE TABLE Member (
	Member_Id INT Primary Key,
	Person_Id INT,
	Join_Date DATE
);

ALTER TABLE Member
ADD FOREIGN KEY (Person_Id)
REFERENCES PUBLIC.Person(Person_Id);

CREATE TABLE Asset (
	Asset_Id INT Primary Key,
	Barcode VARCHAR(512),
	Asset_Type VARCHAR(512)
);

CREATE TABLE Book (
	Asset_Id INT PRIMARY Key,
	Title VARCHAR(512),
	Author_Name VARCHAR(512),
	ISBN VARCHAR(512)
);

ALTER TABLE Book
ADD FOREIGN KEY (Asset_Id)
REFERENCES PUBLIC.Asset(Asset_Id);

CREATE TABLE Loan (
	Loan_Id INT PRIMARY KEY,
	Asset_Id INT,
	Member_Id INT,
	Checked_Out_On DATE,
	Checked_In_On DATE,
	Due_Date DATE
);

ALTER TABLE Loan
ADD FOREIGN KEY (Asset_Id)
REFERENCES PUBLIC.Asset(Asset_Id);

ALTER TABLE Loan
ADD FOREIGN KEY (Member_Id)
REFERENCES PUBLIC.Member(Member_Id);



INSERT INTO PUBLIC.Person (Person_Id, First_Name, Last_Name, Primary_Phone_Number, Email_Address)
	VALUES (1, 'Jill', 'Jordan', '0262548754', 'j.jordan@fakedomain.com.au');
INSERT INTO Member (Member_Id, Person_Id, Join_Date) VALUES (1, 1, parsedatetime('17-09-2015', 'dd-MM-yyyy'));
INSERT INTO PUBLIC.Person (Person_Id, First_Name, Middle_Name, Last_Name, Primary_Phone_Number, Email_Address)
	VALUES (2, 'Adam', 'E', 'Apples', '0454215487', 'adam.a@anotherfakedomain.com.au');
INSERT INTO Member (Member_Id, Person_Id, Join_Date) VALUES (2, 2, parsedatetime('10-01-2010', 'dd-MM-yyyy'));

INSERT INTO PUBLIC.Asset (Asset_Id, Barcode, Asset_Type) VALUES (1, '123456789', 'Book');
INSERT INTO PUBLIC.Book (Asset_Id, Title, Author_Name, ISBN) VALUES (1, 'Animal Farm', 'George Orwell', '9780451526342');
INSERT INTO PUBLIC.Asset (Asset_Id, Barcode, Asset_Type) VALUES (2, '456987212', 'Book');
INSERT INTO PUBLIC.Book (Asset_Id, Title, Author_Name, ISBN) VALUES (2, 'Nineteen Eighty-Four', 'George Orwell', '9780547249643');
INSERT INTO PUBLIC.Asset (Asset_Id, Barcode, Asset_Type) VALUES (3, '514784596', 'Book');
INSERT INTO PUBLIC.Book (Asset_Id, Title, Author_Name, ISBN) VALUES (3, 'Lord of the Flies', 'William Golding', '0571056865');
INSERT INTO PUBLIC.Asset (Asset_Id, Barcode, Asset_Type) VALUES (4, '325845651', 'Book');
INSERT INTO PUBLIC.Book (Asset_Id, Title, Author_Name, ISBN) VALUES (4, 'Catch-22', 'Joseph Heller', '0684833395');

INSERT INTO PUBLIC.Loan (Loan_Id, Asset_Id, Member_Id, Checked_Out_On, Due_Date) 
	VALUES (1, 1, 1, parsedatetime('20-11-2015', 'dd-MM-yyyy'), parsedatetime('19-5-2016', 'dd-MM-yyyy'));
INSERT INTO PUBLIC.Loan (Loan_Id, Asset_Id, Member_Id, Checked_Out_On, Due_Date) 
	VALUES (2, 2, 2, parsedatetime('20-10-2015', 'dd-MM-yyyy'), parsedatetime('01-01-2016', 'dd-MM-yyyy'));
INSERT INTO PUBLIC.Loan (Loan_Id, Asset_Id, Member_Id, Checked_Out_On, Due_Date) 
	VALUES (3, 3, 1, parsedatetime('01-06-2015', 'dd-MM-yyyy'), parsedatetime('01-12-2015', 'dd-MM-yyyy'));

COMMIT;
	
