'''
funcao any(): retorna true se qualquer item da lista for verdade.

metodo str.isdigit(): retorna true se alguma caracter da string for um digito.

(idx + 1) % len(string): a divisao modulo e usada para tornar o iterador
ciclico, ja que se idx for o ultimo membro do iterador, a divisao ira retornar o 0.
'''

def contem_nro(string):
    return any(char.isdigit() for char in string)

def strip_nro(string):
    nros = []
    digitos = ''
    proximo = 0

    for idx, elem in enumerate(string):
        digitos = ''
        n = 2
        thiselem = elem
        nextelem = string[(idx + 1) % len(string)]

        '''
        precisa-se checar se o numero inputado tem mais de 1 digito.
        para isso, se thiselem (elemento atual) for um digito, ele e
        adicionado, e entao o loop checara se o proximo tambem e.

        se o proximo tambem for, thiselem vira o proximo, e nextelem
        vira o proximo do proximo, ate que nao se encontrem mais digitos
        juntos.

        n e um int de apoio a esse loop while. o jeito que calcula o prox
        elemento e o mesmo feio acima, so que aumentando n para fazer
        sentido.

        proximo e um valor que diz quantos numeros a frente ja foram 
        contabilizados, para que o loop for nao coloque digitos repetidos.
        ex: 2000 geraria proximo = 3
        entao contabilizaria o 2000 quando chegasse no 2, e entao pularia
        os 3 zeros.
        '''

        if(proximo > 0):
            proximo -= 1
            continue

        if(thiselem.isdigit()):
            digitos += thiselem

            while(nextelem.isdigit()):
                thiselem = nextelem
                nextelem = string[(idx + n) % len(string)]
                digitos += thiselem
                n += 1
                proximo += 1
            
            nros.append(int(digitos))

    return nros

str = input('Insira uma frase com ou sem alguns nros: ')

if (contem_nro(str)):
    nros = strip_nro(str)
    print(f'Os nros da sua string sao: {nros}.')
    print(f'A soma de todos os nros da sua string e: {sum(nros)}.')
else:
    print('Sua string nao tem numeros.')