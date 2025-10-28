def buscar_palabra(cadena, palabra):
    return palabra.lower() in cadena.lower()

if __name__ == "__main__":
    c = input("Ingresa la cadena: ")
    p = input("Ingresa la palabra a buscar: ")
    print(buscar_palabra(c, p))