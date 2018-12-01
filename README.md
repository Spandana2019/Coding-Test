# Coding-Test
Coding Test

Assumption:
  1. Assuming Z contains the minimum length of the sub sequence palindrom in the Random Number
  2. Assuming X contains the number that will be used for division when random number is even
  3. Assuming Y contains the number that will be added to the random number if random number is odd
  4. Assuming positive random numbers are generated
                     
  Flow of the program:
 
   Initial Setup: create a StringBuffer buf for storing the generated sequence numbers.
 
    1. Generate positive random number, lets say randomNum.
    2. Check for the largest palindromic sub sequence in randomNum.
    3. If the length of the largest sub sequence in randomNum is greater than or equal to Z goto step (a).
            a. Check if randomNum is even, if true then divide randomNum by X and append the result to StringBuffer buf
                     otherwise (if odd) add Y to randomNum and append the result to StringBuffer buf
                         maintain a counter count1 to keep track of sequence numbers generated using the above process in step 3.
    4.  If the randomNum does not contain the palindromic sub sequence then append the randomNum to StringBuffer buf  
                      maintain a counter count2 to keep track of sequence numbers generated using the above process in step 4.  
    5. If the string length in the StringBuffer buf is greater than or equal to 40 characters long, stop the random number generation.
    6. Check the length of the final string in BufferSting buf.
    7. If length is under 30 characters long then it is padded with 0's.
    8. If length is over 40 characters long then it is truncated to 40 characters.
    9. The resulting length is returned.
    
    This project contain both UuidGeneratorApplication and the Junit test cases.
    
    The url is localhost:<portnumber>/generateUUID?x=2&y=1&z=5
