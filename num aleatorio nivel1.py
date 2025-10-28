import random

def num_aleatorio():
    objetivo = random.randint(1, 100)
    print("Adivina el número entre 1 y 100.")
    while True:
        try:
            intento = int(input("Tu intento: "))
        except ValueError:
            print("Ingrese un número válido.")
            continue
        if intento < objetivo:
            print("El número es mayor.")
        elif intento > objetivo:
            print("El número es menor.")
        else:
            print("¡Felicitaciones, adivinaste el número!")
            break

if __name__ == "__main__":
    num_aleatorio()