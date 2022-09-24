Count
It will count the value inside list
fruits = ['orange', 'apple', 'pear', 'banana', 'kiwi', 'apple', 'banana']
fruits.count('apple') ------- > outuput = 2


Index 
Gives the postion of the value
fruits = ['orange', 'apple', 'pear', 'banana', 'kiwi', 'apple', 'banana']
fruits.index('banana', 4) ---------------> output = 6 {it start from  the 4 th postion }


Reverse
It will reverse the whole list
fruits.reverse()
Fruits  ------> output = ['banana', 'apple', 'kiwi', 'banana', 'pear', 'apple', 'orange']


Append
It will add a value in last position
fruits.append('grape')
fruits
--------> output = ['banana', 'apple', 'kiwi', 'banana', 'pear', 'apple', 'orange', 'grape']


Sort 
It will sort value by alphabetical order
fruits.sort()
fruits
----------->output = ['apple', 'apple', 'banana', 'banana', 'grape', 'kiwi', 'orange', 'pear']


Pop
It will delete the last value of list
fruits.pop()
--------------> output = 'pear'

Del
It can delet entire list and it can delete a select values also

a = [-1, 1, 66.25, 333, 333, 1234.5]
del a[0]
a


[1, 66.25, 333, 333, 1234.5]-----> output




del a # del can also be used to delete entire variables
a

Outuput
---------------------------------------------------------------------------

NameError                                 Traceback (most recent call last)

<ipython-input-49-91b8cc03fd62> in <module>
----> 1 del a # del can also be used to delete entire variables
      2 a


NameError: name 'a' is not defined






