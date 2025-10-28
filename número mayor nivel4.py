def mayor_de_varios_numeros(*args):
    if not args:
        raise ValueError("Se requieren al menos un número.")
    return max(args)

if __name__ == "__main__":
    raw = input("Ingrese los números separados por espacios: ")
    nums = [float(x) for x in raw.split()] if raw.strip() else []
    if nums:
        print("El mayor es:", mayor_de_varios_numeros(*nums))
    else:
        print("No ingresaste números.")