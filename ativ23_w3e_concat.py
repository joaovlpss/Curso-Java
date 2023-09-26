ls = [i.strip() for i in input('Insira os elementos da lista, sep por virgula: ').split(',')]

str = ''
for i in ls:
    str += f' {i}'

print(str)