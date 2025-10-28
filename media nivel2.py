import tkinter as tk
from tkinter import simpledialog, messagebox

def calcular_media():
    root = tk.Tk()
    root.withdraw()
    try:
        numeros = simpledialog.askstring("Media", "Ingresa números separados por espacios:")
        if numeros:
            lista = [float(x) for x in numeros.split()]
            media = sum(lista) / len(lista)
            messagebox.showinfo("Resultado", f"La media es: {media}")
        else:
            messagebox.showwarning("Advertencia", "No ingresaste ningún número.")
    except Exception:
        messagebox.showerror("Error", "Entrada inválida")

if __name__ == "__main__":
    calcular_media()
