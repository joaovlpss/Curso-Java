prog = [1, 1]

for i in range(2, 23):
    num = prog[i-1] + prog[i-2]
    prog.append(num)

inp = int(input('Insira o nro a ser testado: ').strip())

if inp in prog:
    print(f'{inp} esta na progressao.')
else:
    print(f'{inp} nao esta na progessao.')

print(f'Progressao: {prog}')


