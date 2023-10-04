from pathlib import Path

def file_copy(src, dest):
    p1 = Path(src)
    if(p1.is_file() == False):
        print('O primeiro parametro nao e um caminho valido.')
        return False
    
    with open(src, 'rb') as f, open(dest, 'wb') as d:
        #ler e escrever em chunks
        chunk_size = 4096
        while True:
            chunk = f.read(chunk_size)
            if not chunk:
                break
            d.write(chunk)

    return True


f1 = input('Insira o caminho do primeiro arquivo (com a extensao): ')
f2 = input('Insira o nome do arquivo resultado, com a mesma extensao(ou o caminho para o arquivo ser levado: )')

if (file_copy(f1,f2) is True):
    print('Arquivo copiado.')
