def cont_vocales():
    texto = input("Ingresa una cadena: ")
    vocales = "aeiouáéíóúAEIOUÁÉÍÓÚ"
    contador = sum(1 for ch in texto if ch in vocales)
    print("Número de vocales:", contador)
    return contador

if __name__ == "__main__":
    cont_vocales()