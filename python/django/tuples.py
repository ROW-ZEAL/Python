Tuples
Tuples are like lists except they are immutable like strings. They are useful when a statement or a function can safely assume that collection of values will not change.



t = 12345, 54321, 'hello!'
t[0]
12345----->output


# Tuples may be nested:
u = t, (1, 2, 3, 4, 5)
u

output
((12345, 54321, 'hello!'), (1, 2, 3, 4, 5))



# Tuples are immutable:
t[0] = 88888

output
---------------------------------------------------------------------------

TypeError                                 Traceback (most recent call last)

<ipython-input-52-9e19cce22619> in <module>
      1 # Tuples are immutable:
----> 2 t[0] = 88888


TypeError: 'tuple' object does not support item assignment


# but they can contain mutable objects:
v = ([1, 2, 3], [3, 2, 1])
v
 output
([1, 2, 3], [3, 2, 1])

#Variable value can be changed
v[0][0] = 'Changed'
v

output
(['Changed', 2, 3], [3, 2, 1])
