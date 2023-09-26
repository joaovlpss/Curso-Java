# Usa o os para listar todos os arquivos em uma pasta
import os
from os.path import isfile, join
curr = os.getcwd()
lista_arquivos = [i for i in os.listdir(curr) if isfile(join(curr, i))]
print(lista_arquivos)