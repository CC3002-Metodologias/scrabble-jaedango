# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

----------------------
At this moment, this don't do anything :(  
We are working to merge everything, but we have functional classes :D  
Actual classes:  
	- ScBinary 	: Scrabble type binary, receive an String with only 0's and 1's.  
	- ScInt 	: Scrabble type Int, receives an Integer.  
	- ScFloat 	: Scrabble type Float, receives a floating point number.  
	- ScBoolean : Scrabble type Boolean, receives only 'true' and 'false' values.  
	- ScString 	: Scrabble type String, receives any String.

Now added a Factory method for the classes showed above (Expecting use less memory to store data).  
Added new ways to use the next Operations  :  
	- Add (+)  
	- Sub (-)  
	- Mul (*)  
	- Div (/)  
And boolean Operations:  
	- And (&&)  
	- Or  (||)  

Now we use prefix notation, example:  
(+ 3 5) = 8  
(- 6 3) = 3

Added variables to the project, now you can define and modify variables.  
Variables can be: int, float, bin, boolean or strings.