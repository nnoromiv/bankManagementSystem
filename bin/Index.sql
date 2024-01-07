CREATE DATABASE bank_management_system;

CREATE TABLE SIGNUP (
    _formNumber VARCHAR(20) PRIMARY NOT NULL,
    _fullName VARCHAR(50),
    _motherMadianName VARCHAR(20),
    _emailAddress VARCHAR(50) UNIQUE,
    _address VARCHAR(50),
    _city VARCHAR(50),
    _state VARCHAR(50),
    _postalCode VARCHAR(20),
    _dob VARCHAR(20),
    _gender VARCHAR(10),
    _maritalStatus VARCHAR(10) DEFAULT NULL
);

CREATE TABLE SIGNUP_ACCOUNT_DETAILS (
    _formNumber VARCHAR(20) PRIMARY,
    _accountType VARCHAR(50),
    _cardNumber VARCHAR(50)UNIQUE NOT NULL,
    _pin VARCHAR(4),
    _servicesRequired VARCHAR(250),
    FOREIGN KEY (_formNumber) REFERENCES SIGNUP(_formNumber)
);

CREATE TABLE SIGNUP_ADDITIONAL_DETAILS (
    _formNumber VARCHAR(20) PRIMARY UNIQUE,
    _religion VARCHAR(50),
    _category VARCHAR(50),
    _income VARCHAR(50),
    _qualification VARCHAR(50),
    _occupation VARCHAR(50),
    _panNumber VARCHAR(50) NOT NULL
    FOREIGN KEY (_formNumber) REFERENCES SIGNUP(_formNumber)
);

CREATE TABLE LOGIN (
    _formNumber VARCHAR(20) UNIQUE,
    _cardNumber VARCHAR(50) PRIMARY UNIQUE,
    _pin VARCHAR(4) NOT NUll,
    FOREIGN KEY (_formNumber) REFERENCES SIGNUP(_formNumber)
    FOREIGN KEY (_cardNumber) REFERENCES SIGNUP_ACCOUNT_DETAILS(_cardNumber)
);

CREATE TABLE BANK (
    _date VARCHAR(100),
    _amount VARCHAR(200),
    _type VARCHAR(20),
    _pin VARCHAR(4),
    _cardNumber VARCHAR(50),
    FOREIGN KEY (_pin) REFERENCES LOGIN(_pin),
    FOREIGN KEY (_cardNumber) REFERENCES LOGIN(_cardNumber)
);




