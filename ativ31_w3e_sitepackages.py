#localizar os pacotes de site do python
import site

print(f'Pacotes: {site.getsitepackages()}')