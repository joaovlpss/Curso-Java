'''
Determina o perfil de programas em Python
Para rodar, basta inserir no terminal:
python perfil_script.py <nome_arquivo>
'''
import cProfile as cpr
import sys
import importlib.machinery as im

# Funcao para fazer o perfil do codigo.
def perfil_codigo(nome_arquivo):
    loader = im.SourceFileLoader('modulo', nome_arquivo)
    module = loader.load_module()
    profiler = cpr.Profile()
    profiler.enable()

    try:
        # Assumindo que ha uma funcao main
        module.main()
    except Exception as e:
        print(f'Um erro ocorreu: {e}')
    
    profiler.disable()
    profiler.print_stats(sort='cumulative')

if __name__ == "__main__":

    #Checagem se foi tudo passado corretamente
    if len(sys.argv) != 2:
        print("Uso: python perfil_script.py <nome_arquivo>")
        sys.exit(1)
    
    inp = sys.argv[1]
    perfil_codigo(inp)   