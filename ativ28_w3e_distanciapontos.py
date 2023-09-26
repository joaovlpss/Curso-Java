#calcula a distancia entre dois pontos
import numpy as np


def dist(nums):
    final = []
    k = (nums[2] - nums[0]) 
    j = (nums[3] - nums[1])

    k *= k
    j *= j
    i = k + j
    final.append(i)
    return np.sqrt(final)[0]

inp = [int(i) for i in input('Insira x1,y1,x2,y2 em ordem: ').strip().split(',')]
result = dist(inp)

print(f'A distancia entre os dois e igual a: {result}')