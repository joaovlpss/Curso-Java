nros = input('Insira os numeros, separados por virgula: ')
new = [int(i.strip()) for i in nros.split(',')]
new = sorted(new)

dict = {}

#popula o dicionario com chaves unicas para cada nro em new
for i in new:
    if i in dict.keys():
        continue
    else:
        dict[i] = 0

# aumenta em 1 a contagem para cada vez que a chave aparece em new
for i in range(len(new)):
    dict[new[i]] += 1

print(dict)



    