import sys
import pathlib
from pympler import asizeof

'''
Algumas funcs que foram pedidas nos exercicios 79,82,83,85,86 e 87
'''

# Soma todos os itens de um container
def sumitems(cont):
    final = 0
    for i in cont:
        final += i
    return final

# Verifica se todos os itens do container X sao maiores que o nro Y
def allgreaterthan(x, y):
    for i in x:
        if (i < y):
            return False
    return True

# Determina se o caminho e para um arquivo ou um diretorio
def fileordir(a):
    p = pathlib.Path(a)
    if (p.is_file()):
        print(f'{a} e um arquivo.')
        return 0
    elif (p.is_dir()):
        print(f'{a} e um diretorio.')
        return 1
    else:
        print('O item fornecido nao e um caminho.')
        return 2

# Determina o valor ASCII de um CHAR
def asciival(a):
    if (isinstance(a, str) and len(a) == 1):
        print(f'Valor ascii de {a} = {ord(a)}')
        return True
    else:
        print(f'{a} nao e um caracter')
        return False

# Determina o tamanho de um arquivo
def filesize(a):
    p = pathlib.Path(a)
    if p.is_file():
        print(f'O tamanho do arquivo {a} e: {p.stat().st_size}')
        return True
    else:
        return False