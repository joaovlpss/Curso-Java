n = input('Insira o nro: ')
if (abs(1000 - int(n)) <= 100 or abs(2000-int(n)) <= 100):
    print('Esta a 100 de 1000 ou 2000.')
else: 
    print('Nao esta a 100 de 1000 ou 2000.')