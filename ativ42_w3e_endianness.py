import sys
import textwrap

module_name = ', '.join(sorted(sys.builtin_module_names))
print(textwrap.fill(module_name, width=70))

if sys.byteorder == "little":
    print("Little-Endian platform")
else:
    print("Big-Endian platform")
