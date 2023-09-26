# Printa para STDERR ao inves de STDOUT

import sys

'''
args, nesse contexto, sao argumentos posicionais.
argumentos posicionais sao argumentos passados para a func baseado
em suas posicoes ou ordens. a func espera que sejam passados na ordem
em que serao utilizados.

kwargs, nesse contexto, sao argumentos-chave.
argumentos chave sao passados para a func usando a chave (nome do parametro)
associada ao argumento. o nome do parametro deve ser acompanhado do valor por um =.
a funcao deixa vc passar argumentos chave em qualquer ordem
'''

#Nesse exemplo, a func eprint puxa os args a serem printados como *args,
# e puxa os args para servirem como parametros do print por **kwargs.
def eprint(*args, **kwargs):
    print(*args, file=sys.stderr, **kwargs)

eprint("abc", "efg", "xyz", sep="--")