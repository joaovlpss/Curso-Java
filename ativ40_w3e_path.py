import pathlib as pt
import os

p = pt.Path(__file__)
p_dir = p.parent

files = []
for i in p_dir.iterdir():
    if i.is_file():
        stats = os.stat(i)
        #getattr tenta pegar st_birthtime (nao e sempre disponivel)
        #caso nao consiga, pega st_ctime
        nasc = getattr(stats, 'st_birthtime', stats.st_ctime)
        files.append((i.name, nasc))

#funcao lambda retorna o segundo membro da tupla (i.name, nasc)
#sorted usa o segundo membro (nasc) para sortear a lista
files = sorted(files, key=lambda x: x[1])

print(f'Arquivos em ordem:')
for fname, _ in files:
    print(fname)

        

'''
Coisas importantes em path:

__file__  = variavel global do caminho do arquivo atualmente executando

p = Path('caminho/para/alguma/coisa')
novo_p = p / 'nova'

p.exists() = checar se o caminho existe
p.is_file() = checar se e um arquivo
p.is_dir() = checar se e um diretorio

p.parent = diretorio contendo p.
p.name = nome do diretorio ou arquivo, sem o caminho.
p.stem = nome do arquivo sem o suffix.
p.suffix = sufixo (extensao) do arquivo.

'''