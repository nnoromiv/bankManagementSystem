# Java Bank Management System

The Bank Management System is a Java application that enables users to perform various banking operations. It includes features like user authentication, account creation, and transaction management.

## Table of Contents

- [Java Bank Management System](#java-bank-management-system)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Screenshots](#screenshots)
  - [Getting Started](#getting-started)
  - [Dependencies](#dependencies)
  - [Usage](#usage)
  - [Contributions](#contributions)
  - [License](#license)

## Features

1. **User Authentication:**
   - Secure login functionality for authorized access.

![Login Preview](lib/images/login.png)

1. **Account Creation:**
   - Three-step sign-up process for personal details, additional details, and account details.

![Sign Up Preview](lib/images/SignUpCover.png)

1. **Transaction Management:**
   - Withdrawal
   - Deposit
   - FastCash
   - Balance Enquiry
   - Pin Change
   - Mini Statement
  
![Transaction Preview](lib/images/TransactionsCover.png)

## Screenshots

![Transaction Preview](lib/images/MoreTransactionCover.png)

**[More Images](https://github.com/nnoromiv/bankManagementSystem/tree/master/lib/images)**

## Getting Started

1. **Clone the repository:**

    ```bash
    git clone https://github.com/nnoromiv/bankManagementSystem.git
    ```

2. **Database Setup:**

    Create a MySQL database and import the provided SQL schema file.
    - All SQL Queries at [SQL File](https://github.com/nnoromiv/bankManagementSystem/blob/master/src/index.sql)

    ```sql
        CREATE DATABASE bank_management_system;
    ```

3. **Dependencies:**

    Ensure all dependencies are installed (Java, MySQL Connector, etc.).
    Go to [Dependencies](#dependencies)

4. **Run the Application:**

## Dependencies

-Java
-MySQL Connector
-JCalender

## Usage

1. Sign Up:

   - Click the Sign up button.
   - Provide dummy details to fill in personal details, additional details, and account details during the sign-up process.
   - Copy out the Card Number and Pin that is generated.

2. Login:

    - Use the Card Number and Pin to log in securely.
  
3. Perform Transactions:

    - Explore various transaction options from the menu.

## Contributions

Contributions are welcome! Feel free to submit issues or pull requests.
    - Bug Fixes
    - Feature Enhancements
    - Documentation Improvements

## License

This project is licensed under the MIT License - see the LICENSE file for details.
