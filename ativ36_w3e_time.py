import time as tm

time_start = tm.time()

for i in range(0,5):
    print(f'Printando pela {i} vez.')

time_end = tm.time()

elapsed_time = time_end - time_start
print(f'Tempo passado: {elapsed_time:.6f} segundos.')

