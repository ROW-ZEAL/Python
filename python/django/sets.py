Set
 it is an unordered collection with no duplicate elements and  
it supports mathematical operations like union, interaction, difference.


example
shopping_basket = {'apple', 'orange', 'pineapple', 'apple', 'pear'}
shopping_basket

Output
{'apple', 'orange', 'pear', 'pineapple'}

Eg-2
shopping_basket = set()
type(shopping_basket)

Output 
set

We can also check the variable is present in our set or not

shopping_basket = {'apple', 'orange', 'pineapple', 'apple', 'pear'}
'apple' in shopping_basket

Output 
True #if present the true 

'strawberry' in shopping_basket
Output 
False #is not then false


Eg-3
a = set('abracadabra')
b = set('alacazam')


a - b # letters in a but not in b
Output
{'b', 'd', 'r'}



a | b # letters in a or b or both
Output
{'a', 'b', 'c', 'd', 'l', 'm', 'r', 'z'}

a & b # letters in both a and b
Output
{'a', 'c'}

a ^ b # letters in a or b but not bot
Output
{'b', 'd', 'l', 'm', 'r', 'z'}



