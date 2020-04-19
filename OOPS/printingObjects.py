#this can be achieved by using __repr__ or __str__ methods.

class Test: 
	def __init__(self, a, b): 
		self.a = a 
		self.b = b 

	def __repr__(self): 
		return "Test a:%s b:%s" % (self.a, self.b) 

	def __str__(self): 
		return "From str method of Test: a is %s," \ 
			"b is %s" % (self.a, self.b) 

# Driver Code		 
t = Test(1234, 5678) 
print(t) # This calls __str__() 
print([t]) # This calls __repr__() 





#If no __str__ method is defined, print t (or print str(t)) uses __repr__
class Test2: 
	def __init__(self, a, b): 
		self.a = a 
		self.b = b 

	def __repr__(self): 
		return "Test a:%s b:%s" % (self.a, self.b) 

# Driver Code		 
t = Test2(1234, 5678) 
print(t) 






#If no __repr__ method is defined then the default is used.
class Test: 
	def __init__(self, a, b): 
		self.a = a 
		self.b = b 

# Driver Code		 
t = Test(1234, 5678) 
print(t) 
