#Destructors are called when an object gets destroyed. In Python, destructors are not needed as much 
# needed in C++ because Python has a garbage collector that handles memory management automatically.

#It is called when all references to the object have been deleted i.e when an object is garbage collected.


# Python program to illustrate destructor 

class Employee: 

	# Initializing 
	def __init__(self): 
		print('Employee created') 

	# Calling destructor 
	def __del__(self): 
		print("Destructor called") 

def Create_obj(): 
	print('Making Object...') 
	obj = Employee() 
	print('function end...') 
	return obj 

print('Calling Create_obj() function...') 
obj = Create_obj() 
print('Program End...') 



#if your instances are involved in circular references they will live in memory for as long as the application run.

# Python program to illustrate destructor 

class A: 
	def __init__(self, bb): 
		self.b = bb 

class B: 
	def __init__(self): 
		self.a = A(self) 
	def __del__(self): 
		print("die") 

def fun(): 
	b = B() 

fun() 

