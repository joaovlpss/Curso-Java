# checar se um arquivo existe

arq = input('Insira o nome do arquivo, com extensao: ')

try:
    file = open(arq, 'r')
except:
    print('O arquivo nao existe.')
finally:
    print('O arquivo existe.')    
