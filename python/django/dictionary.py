Dictionary
It must contains key value and which can be any immutable types (string or numbers) and must be unique.

Eg
contact = {
    'aba': 12345678,
    'dba Pau': 87654321,
    'cbd': 1122334
}

contact['aba']

Output 
12345678


del contact['cdb']
contact

Output
{'aba': 12345678, 'dba ': 87654321}


contact['efg'] = 987665322 
# we can add in dictionary but we need key :values
Contact

Output
{'aba': 12345678, 'dba ': 87654321, 'efg': 987665322}


sorted(contact) -->it will sort by alphabetical order
Output
['aba', 'dba ', 'efg']

We can check on dictrionar also is it present or not
'abc' in contact
Output
False ----> not present
'aba' in contact
Output
True---> present



