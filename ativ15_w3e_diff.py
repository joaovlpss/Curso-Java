n = input('Insira o nro: ')
num = int(n.strip())

diff = (num - 17) if num > 17 else (2 * abs(num - 17))

print(f'Diferenca: {diff}')
