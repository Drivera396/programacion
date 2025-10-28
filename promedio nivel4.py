def promedio(*args):
    if not args:
        raise ValueError("Se requieren al menos un número.")
    return sum(args) / len(args)

if __name__ == "__main__":
    raw = input("Ingresa los números que deseas promediar separados por espacios : ")
    nums = [float(x) for x in raw.split()] if raw.strip() else []
    if nums:
        print("Promedio:", promedio(*nums))
    else:
        print("No ingresaste números.")