def sep_cores (l1, l2):
    kekw = []

    for i in l1:
        if i not in l2:
            continue
        else:
            kekw.append(i)
    
    return kekw

cores_1 = ['Branco', 'Preto', 'Azul']
cores_2 = ['Azul', 'Marrom', 'Cinza']

res = sep_cores(cores_1, cores_2)
print(res)