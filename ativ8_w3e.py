dados = input("De os nros, separados por virgula: ")
dados_lista = dados.split(',')

dados_lista_limpa = [int(i.strip()) for i in dados_lista]

dados_tupla_limpa = tuple(dados_lista_limpa)

print(f'Tupla: {dados_tupla_limpa}\nLista: {dados_lista_limpa}')