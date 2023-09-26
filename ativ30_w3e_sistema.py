# informacoes basicas sobre o sistema. 
# fiz esse para entender mais sobre a biblioteca platform
import platform as pl

print(f'Versao do interpretador: {pl.python_compiler()}')
print(f'Maquina: {pl.machine()}')
print(f'Plataforma: {pl.platform(True)}')
