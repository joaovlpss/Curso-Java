inter = input('Fale um inteiro: ')
n = int(inter.strip())
kekw = []

for i in range(0, 3):
    if i == 0:
        kekw.append(n)
    else:
        kekw.append(n * 10**i + kekw[i - 1])

result = sum(kekw)

print(result)
