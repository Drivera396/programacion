def multiplicar_lista(lista, numero):
    return [x * numero for x in lista]

if __name__ == "__main__":
    raw = input("Ingresa los números que desea sean parte de la lista separados por espacios: ")
    lista = [float(x) for x in raw.split()] if raw.strip() else []
    n = float(input("El número por el cual se va a multipliar la lista es: "))
    print(multiplicar_lista(lista, n))
