import tkinter as tk
from tkinter import simpledialog, messagebox

def suma():
    a = simpledialog.askfloat("Suma", "Ingresa el primer número:")
    b = simpledialog.askfloat("Suma", "Ingresa el segundo número:")
    if a is not None and b is not None:
        messagebox.showinfo("Resultado", f"La suma es: {a + b}")

if __name__ == "__main__":
    suma()