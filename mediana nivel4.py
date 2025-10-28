def calcular_mediana(*args):
    if not args:
        raise ValueError("Se requieren al menos un número.")
    nums = sorted(args)
    n = len(nums)
    mid = n // 2
    if n % 2 == 1:
        return nums[mid]
    else:
        return (nums[mid - 1] + nums[mid]) / 2

if __name__ == "__main__":
    raw = input("Ingresa los números separados por espacios para calcular la mediana: ")
    nums = [float(x) for x in raw.split()] if raw.strip() else []
    if nums:
        print("Mediana:", calcular_mediana(*nums))
    else:
        print("No ingresaste números.")