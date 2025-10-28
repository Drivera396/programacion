def palindromo(palabra):
    s = ''.join(ch.lower() for ch in palabra if ch.isalnum())
    return s == s[::-1]

if __name__ == "__main__":
    prueba = input("Ingresa una palabra o frase para comprobar palíndromo: ")
    print(palindromo(prueba))