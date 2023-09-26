def primo(n):
    if n > 1:
        for i in range(2, int(n/2)+1):
            if (n % i) == 0:
                return False
        return True
    else:
        return False


def proximo_primo(n):
    if primo(n) == True:
        n += 1
    
    while (primo(n) == False):
        n += 1

    return n

def fazer_mmc(n1, n2):
    mmc = 1
    #iniciamos com primo igual a 2
    n = 2

    while (n1 != 1 and n2 != 1):
    #analise de casos:
    #caso 1: o primo atual divide ambos
        if (n1 % n == 0 and n2 % n == 0):
            while(n1 % n == 0 and n2 % n == 0):
                mmc = mmc * n
                n1 = n1 // n
                n2 = n2 // n
    #caso 2: o primo atual divide apenas n1
        elif (n1 % n == 0):
            while(n1 % n == 0):
                mmc = mmc * n
                n1 = n1 // n
    #caso 3: o primo atual divide n1 e n2
        elif (n2 % n == 0):
            while (n2 % n == 0):
                mmc = mmc * n
                n2 = n2 // n
    #caso 4: o primo atual nao divide nenhum dos dois
        else:
            n = proximo_primo(n)

    return mmc
    
entries = [int(i) for i in input('Insira os nros, separados por virgula: ').strip().split(',')]

n1 = entries[0]
n2 = entries[1]

mmc = fazer_mmc(n1, n2)

print(f'O mmc e igual a {mmc}')
            
        
