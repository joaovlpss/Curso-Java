'''
Algoritmo de 'hashing' de palavras. Implementa o algoritmo soundex para transformar
uma palavra em sua versao soundex.

algoritmo soundex:
1 - segure a primeira letra da palavra
2 - remova todas as vogais nao iniciais (a,e,i,o,u,y,h,w)
3 - assinale numeros as letras restantes:
b, f, p, v -> 1
c, g, j, k, q, s, x, z -> 2
d, t -> 3
l -> 4
m, n -> 5
r -> 6
4 - se duas letras adjacentes tivere mo mesmo numero, considerar apenas a primeira
5 - colocar zeros se o resultado for menos de 4 caracteres, se nao for,
trucar para 4 caracteres.
'''

def soundex(word):
    #converter a palavra para uppercase e reter a primeira letra
    word = word.upper()
    coded = word[0]

    #dicionario de conversoes de digitos soundex
    soundex_dict = {
        'A': '0', 'E': '0', 'I': '0', 'O': '0', 'U': '0', 'H': '0', 'W': '0', 'Y': '0',
        'B': '1', 'F': '1', 'P': '1', 'V': '1',
        'C': '2', 'G': '2', 'J': '2', 'K': '2', 'Q': '2', 'S': '2', 'X': '2', 'Z': '2',
        'D': '3', 'T': '3',
        'L': '4',
        'M': '5', 'N': '5',
        'R': '6'     
    }

    #converter letras para digitos soundex, e entao agrupar digitos iguais
    digits = ''.join(soundex_dict[letter] for letter in word)[1:]

    #remover duplicatas de digitos
    last_digit = ''
    coded_digits = ''
    for digit in digits:
        if digit != last_digit:
            coded_digits += digit
        last_digit = digit
    
    #remover as vogais
    coded_digits = coded_digits.replace('0', '')

    #limpar todos os digitos depois do quarto. caso haja menos que 4, completar com 0s
    coded += coded_digits
    coded = (coded + '0000')[:4]

    return coded

word = input('Inputar a palavra a ser hasheada: ')
print(f'A palavra soundex para {word} e: {soundex(word)}')