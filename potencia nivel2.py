import tkinter as tk
from tkinter import simpledialog, messagebox

def calcular_potencia():
    root = tk.Tk()
    root.withdraw()
    try:
        base = simpledialog.askfloat("Potencia", "Ingresa la base:")
        exponente = simpledialog.askfloat("Potencia", "Ingresa el exponente:")
        if base is not None and exponente is not None:
            resultado = base ** exponente
            messagebox.showinfo("Resultado", f"{base} elevado a {exponente} nos da como resultado: {resultado}")
    except Exception:
        messagebox.showerror("Error", "Entrada inválida")

if __name__ == "__main__":
    calcular_potencia()