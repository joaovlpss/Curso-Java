'''
Write a Python program that returns a string that is n (non-negative integer) copies of a given string. 
'''
stri = input('Insira a string: ')
n = int(input('Insira o nro de vezes para repetir: ').strip())
striinit = stri

for i in range(0, n-1):
    stri += striinit

print(f'String nova: {stri}')
