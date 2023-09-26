# queria saber mais sobre o modulo multiprocessing
import multiprocessing as mp

def print_func(continent = 'America'):
    print('O nome do continente e: ', continent)


if __name__ == '__main__':
    print('Testes do modulo multiprocessing.')
    print(f'Contagem de CPUS: {mp.cpu_count()}')
    nomes = ['Asia', 'Europa', 'Africa']
    procs = []

    #instanciando processo sem argumentos
    proc = mp.Process(target = print_func)
    procs.append(proc)
    proc.start()

    #instanciando processo com os argumentos
    for name in nomes:
        proc = mp.Process(target=print_func, args=(name,))
        procs.append(proc)
        proc.start()

    #completando os processos
    for proc in procs:
        proc.join()

'''
O modulo parece mt interessante para utilizar varios processos ao mesmo tempo.
Efetivamente permitindo tirar o maximo de vantagem das varias CPUS.
'''