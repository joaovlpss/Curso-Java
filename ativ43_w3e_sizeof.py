import sys
from pympler import asizeof

obj = 'Hello, World!'
byte_size = sys.getsizeof(obj)
byte_size_2 = asizeof.asizeof(obj)

obj2 = ['Hello, world!', {'key' : 'val'}]
byte_size_3 = asizeof.asizeof(obj2)
byte_size_4 = sys.getsizeof(obj2)

print(f'Tamanho 1 (sys string): {byte_size}')
print(f'Tamanho 2 (asizeof string): {byte_size_2}')
print(f'Tamanho 3 (asizeof list/dict): {byte_size_3}')
print(f'Tamanho 4 (sys list/dict): {byte_size_4}')