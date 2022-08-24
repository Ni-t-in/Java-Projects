# ATM  
## Automatic Teller Machine
### Description
This is terminal based project built on Java language.  
This project perform various function such as :
 - Create Account
   - Generate unique ID numbers
   - Generate hash of PIN
 - Authenticate User
 - Withdraw funds
 - Deposit funds
 - Transfer funds
 - Transaction history
### Working

#### Create Account  
User have to enter his information such as first name, last name, pin and select type of account.
##### Unique ID generation
**User ID** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : Random 6 digit number will be created which will not match with any User ID in database.  
**Account ID** : Random 10 digit number will be created which will not match with any Account ID in database.  
##### PIN Hash generation
PIN is stored in database in form of hash for security purpose.  
To generate hash of PIN **MD5 Hashing** technique is used.  
  
User ID and Account ID will be provided to user.  
#### Authenticate User
User has to enter his User ID and PIN for login.  
The User's PIN is compared with entered PIN using **MD5** technique.
User ID and PIN will be checked until User ID and PIN matches.  
After successful authentication user will login and summary of User's account will be displayed.  

#### Withdraw funds  
Account ID of User's account to be entered.  
**Minimum withdrawl limit** is set to Rs 100.  
**Wrong Trials limit** is set to 3.  

#### Deposit funds  
Account ID of User's account to be entered.  
**Minimum deposit limit** is set to Rs 100.  
**Wrong Trials limit** is set to 3.

#### Transfer funds
Account ID of User's account to be entered.
**Minimum transfer limit** is set to Rs 100.  
**Wrong Trials limit** is set to 3.  
Account ID of Reciever's account to be entered.

#### Transaction history
Account ID of User's account to be entered.
It will print all transactions in form of  
Amount : Memo : Date/Time stamp
