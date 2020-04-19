
# A Python program to demonstrate inheritance 

# Base or Super class. Note object in bracket. 
# (Generally, object is made ancestor of all classes) 
# In Python 3.x "class Person" is 
# equivalent to "class Person(object)" 
class Person(object): 
	
	# Constructor 
	def __init__(self, name): 
		self.name = name 

	# To get name 
	def getName(self): 
		return self.name 

	# To check if this person is employee 
	def isEmployee(self): 
		return False


# Inherited or Sub class (Note Person in bracket) 
class Employee(Person): 

	# Here we return true 
	def isEmployee(self): 
		return True

# Driver code 
emp = Person("Geek1") # An Object of Person 
print(emp.getName(), emp.isEmployee()) 

emp = Employee("Geek2") # An Object of Employee 
print(emp.getName(), emp.isEmployee()) 






# Python example to check if a class is 
# subclass of another 

class Base(object): 
	pass # Empty Class 

class Derived(Base): 
	pass # Empty Class 

# Driver Code 
print(issubclass(Derived, Base)) 
print(issubclass(Base, Derived)) 

d = Derived() 
b = Base() 

# b is not an instance of Derived 
print(isinstance(b, Derived)) 

# But d is an instance of Base 
print(isinstance(d, Base)) 


# object is root of all classes.



# Python example to show working of multiple 
# inheritance 
class Base1(object): 
	def __init__(self): 
		self.str1 = "Geek1"
		print "Base1"

class Base2(object): 
	def __init__(self): 
		self.str2 = "Geek2"		
		print "Base2"

class Derived(Base1, Base2): 
	def __init__(self): 
		
		# Calling constructors of Base1 
		# and Base2 classes 
		Base1.__init__(self) 
		Base2.__init__(self) 
		print "Derived"
		
	def printStrs(self): 
		print(self.str1, self.str2) 
		

ob = Derived() 
ob.printStrs() 



# Python example to show that base 
# class members can be accessed in 
# derived class using base class name 
class Base(object): 

	# Constructor 
	def __init__(self, x): 
		self.x = x	 

class Derived(Base): 

	# Constructor 
	def __init__(self, x, y): 
		Base.x = x 
		self.y = y 

	def printXY(self): 
	
	# print(self.x, self.y) will also work 
	print(Base.x, self.y) 


# Driver Code 
d = Derived(10, 20) 
d.printXY() 




# Python example to show that base 
# class members can be accessed in 
# derived class using super() 
class Base(object): 

	# Constructor 
	def __init__(self, x): 
		self.x = x	 

class Derived(Base): 

	# Constructor 
	def __init__(self, x, y): 
		
		''' In Python 3.x, "super().__init__(name)" 
			also works'''
		super(Derived, self).__init__(x) 
		self.y = y 

	def printXY(self): 

	# Note that Base.x won't work here 
	# because super() is used in constructor 
	print(self.x, self.y) 


# Driver Code 
d = Derived(10, 20) 
d.printXY() 


#excercise 
#1

class X(object): 
	def __init__(self, a): 
		self.num = a 
	def doubleup(self): 
		self.num *= 2

class Y(X): 
	def __init__(self, a): 
		X.__init__(self, a) 
	def tripleup(self): 
		self.num *= 3

obj = Y(4) 
print(obj.num) 

obj.doubleup() 
print(obj.num) 

obj.tripleup() 
print(obj.num) 


# 2
class Person(object): 
	def __init__(self, name): 
		self.name = name 
		
	def getName(self): 
		return self.name 
	
	def isEmployee(self): 
		return False

# Inherited or Subclass (Note Person in bracket) 
class Employee(Person): 
	def __init__(self, name, eid): 

		''' In Python 3.0+, "super().__init__(name)" 
			also works'''
		super(Employee, self).__init__(name) 
		self.empID = eid 
		
	def isEmployee(self): 
		return True
		
	def getID(self): 
		return self.empID 

# Driver code 
emp = Employee("Geek1", "E101") 
print(emp.getName(), emp.isEmployee(), emp.getID()) 
