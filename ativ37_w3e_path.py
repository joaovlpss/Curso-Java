import os

def absolute_path(path_fname):
    return os.path.abspath('path_fname')

print('Caminho absoluto: ', absolute_path('teste.txt'))