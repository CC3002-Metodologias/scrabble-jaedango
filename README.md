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

Now the classes mentioned above had a Constant method, that makes easy use of this. And 
to use less memory, we use a factory method that store data and value.  
Class ConstantFactory initializes a constant factory, that we will detail next.  
Constant factory has 3 method types:  
	- CNum -> Initializes integer, float and binary.  
	- CLog -> Initializes boolean values.  
	- CStr -> Initializes string value.

Example :
ConstantFactory c = new Constant factory(); // use this to initialize factory  
ConstantNum num = c.cNum(1) // initialize a ConstantNum, with a value of ScInt(1)  
ConstantNum fl = c.cNum(3.5f) // initialize a ConstantNum, with a values of ScFloat(3.5)  
ConstantNum bin = c.cNum("0101") // initialize a ConstantNum, with a value of ScBinary(0101)  
ConstantLog t = c.cLog(true) // initialize a ConstantLogical, with a value of ScBool(true)  
ConstantStr str = c.cStr("hola") // initialize a ConstantString, with a value of ScStr(hola)


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

<<<<<<< HEAD
Added variables to the project, now you can define and modify variables.  
Variables can be: int, float, bin, boolean or strings.
=======
To use this, use one of the operations mentioned above, make this:  
	- new Operation(operator1, operator2)  

Example:  
new Add(c.cNum(1), c.cNum(2));  

If we use eval() method, this returns a new Constant with a value of ScInt(3).  

Added a CompareTo class, that receives two ConstantNums.
Example of use:
CompareTo compareTo = new CompareTo(num1, num2);  

This returns 1 if num1 > num2, 0 if their values are equals, and
-1 if num2 > num1. If their values are equals, return 0 even if the 
numbers aren't of the same type:
CompareTo(c.cNum("0101"), c.cNum(5f)) == 0


Added an If class that can receive a boolean or a 
ConstantLogical value, and two Operations, if logical
value is true, return 1st Operation, else return the 
second one.  

Example of use:  
new If(boolean, op1, op2);  
If boolean is true, return op1, else return op2.  

Also tried to implement While, but failed greatly.  
I tried to make a Visitor implementation but I have a lot 
of errors, so I prefer to send this without that, this code is 
more clean and functional that the other one, so this is my final 
release (at the moment) of this project, I enjoyed a lot this, 
and spend a lot of time, but I learn a lot with this. Thanks to read
until here, see u another time, maybe with a finished functional project.
>>>>>>> entregaFinal
