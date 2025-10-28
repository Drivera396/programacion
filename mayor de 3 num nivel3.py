def mayor_de_tres_numeros(n1, n2, n3):
    return max(n1, n2, n3)

if __name__ == "__main__":
    a = float(input("Número 1: "))
    b = float(input("Número 2: "))
    c = float(input("Número 3: "))
    print("El mayor es:", mayor_de_tres_numeros(a, b, c))