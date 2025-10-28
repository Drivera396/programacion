import tkinter as tk
from tkinter import simpledialog, messagebox

def edad():
    edad = simpledialog.askstring("Edad", "Ingresa tu edad:")
    if edad:
        messagebox.showinfo("Resultado", f"Tu edad es: {edad} años")

if __name__ == "__main__":
    edad()