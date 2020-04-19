class GeekforGeeks: 
	geek = "" 

	# default constructor 
	def __init__(self): 
		self.geek = "GeekforGeeks"

	# a method for printing data members 
	def print_Geek(self): 
		print(self.geek) 


# creating object of the class 
obj = GeekforGeeks() 

# calling the instance method using the object obj 
obj.print_Geek() 




class Addition: 
	first = 0
	second = 0
	answer = 0
	
	# parameterized constructor 
	def __init__(self, f, s): 
		self.first = f 
		self.second = s 
	
	def display(self): 
		print("First number = " + str(self.first)) 
		print("Second number = " + str(self.second)) 
		print("Addition of two numbers = " + str(self.answer)) 

	def calculate(self): 
		self.answer = self.first + self.second 

# creating object of the class 
# this will invoke parameterized constructor 
obj = Addition(1000, 2000) 

# perform Addition 
obj.calculate() 

# display result 
obj.display() 
