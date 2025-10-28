import math

def calcular_area(radio, altura):
    return 2 * math.pi * radio * altura + 2 * math.pi * (radio ** 2)

if __name__ == "__main__":
    r = float(input("Radio: "))
    h = float(input("Altura: "))
    print("Área del cilindro:", calcular_area(r, h))
