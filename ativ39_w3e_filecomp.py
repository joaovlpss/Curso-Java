import time as tm
import os

f1 = input('Digite o nome do primeiro arquivo: ')
f2 = input('Digite o nome do segundo arquivo: ')

timef1 = os.stat(f1).st_mtime
timef2 = os.stat(f2).st_mtime

timef1f = tm.localtime(timef1).tm_min
timef2f = tm.localtime(timef2).tm_min

print(f'Tempo do arquivo 1 em minutos: {timef1f}')
print(f'Tempo do arquivo 2 em minutos: {timef2f}')

if (timef2 > timef1): # se o ultimo mod foi a mais segundos, entao o arquivo mais velho e o com menos
    maisvelho = f1
else:
    maisvelho = f2

print(f'O arquivo mais velho e o {maisvelho}')