ints = [int(i) for i in input('Entre com os numeros, separados por virgula: ').strip().split(',')]

a1 = min(ints[0], ints[1], ints[2])
a2 = max(ints[0], ints[1], ints[2])
a3 = ints[0] + ints[1] + ints[2] - a1 - a2

print(f'A ordem e: {a1}, {a3}, {a2}.')

