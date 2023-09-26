import datetime

date1 = input('Fale a data menor (dia, mes, ano): ')
date2 = input('Fale a data maior (dia, mes, ano): ')

# Limpar os inputs
d1 = [int(i.strip()) for i in date1.split(',')]
d2 = [int(i.strip()) for i in date2.split(',')]

# Assinalar as datas (CRIAR COM CONSTRUTOR)
dat1 = datetime.date(d1[2], d1[1], d1[0])  # Year, Month, Day
dat2 = datetime.date(d2[2], d2[1], d2[0])  # Year, Month, Day

# Calcular a diferença entre as datas
difference = dat2 - dat1

print(f'Diferença: {difference}')
