''' 
O que aprendi nessa ativ:

1 - str.split(sep = none, maxsplit = -1)
retorna uma lista de palavras na string, utilizando sep como a string
delimitadora. se maxsplit for dado, no maximo (maxsplit) strings
serao feitas. (entao a lista tera maxsplit + 1 elementos no max).

se maxstring nao for especificado ou for -1, algoritmos diferentes de
split sao usados: whitespace consecutivo, 

'''

filename = input("Fale o nome do arquivo: ")
f_ext = filename.split('.')
print("A extensao do arquivo e: " + repr(f_ext[-1]))