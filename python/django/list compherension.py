Tradition method

squares=[]
forxinrange(10):
    squares.append(x**2)
squares

	[0, 1, 4, 9, 16, 25, 36, 49, 64, 81]-----> resutls
	
List Comprehensions
Range = from a num to a num
squares = [x**2 for x in range(10)] 
squares
	[0, 1, 4, 9, 16, 25, 36, 49, 64, 81]-----> resutls
	
	
	Example 
	[python for python in 'python']
	Output------> ['p', 'y', 't', 'h', 'o', 'n']
	
	
	[number for number in range(10) if number % 2 == 0]
	Output -----> [0, 2, 4, 6, 8]
	
	
	['Even' if number%2==0 else "Odd" for number in range(10)]
	Output -------> ['Even', 'Odd', 'Even', 'Odd', 'Even', 'Odd', 'Even', 'Odd', 'Even', 'Odd']


