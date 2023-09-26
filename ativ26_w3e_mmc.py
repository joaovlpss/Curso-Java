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

def fazer_mdc(k1, k2):
    n = 2
    mmc = 1

    while (k1 != 1 and k2 != 1):


        if (k1 % n == 0 and k2 % n == 0):
            while (k1 % n == 0 and k2 % n == 0):
                mmc *= n
                k1 = k1 // n
                k2 = k2 // n
        elif (k1 % n == 0):
            while (k1 % n == 0):
                k1 = k1 // n           
        elif (k2 % n == 0):
            while(k2 % n == 0):
                k2 = k2 // n

        n = proximo_primo(n)
        

    return mdc

nros = [int(i) for i in input('Insira os nros separados por virgula: ').strip().split(',')]

n1 = nros[0]
n2 = nros[1]

mdc = fazer_mdc(n1,n2)

print(f'O mmc entre os dois e igual a {mdc}')