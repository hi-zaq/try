import tkinter
from tkinter import messagebox
import subprocess

def delete(event):
    Editbox1.delete(0, tkinter.END)
    Editbox2.delete(0, tkinter.END)
    Editbox3.delete(0, tkinter.END)
    Editbox4.delete(0, tkinter.END)
    Editbox5.delete(0, tkinter.END)

def calc(event):
    # irradiation time
    if Editbox1.get():
        time = Editbox1.get()
    else:
        time = 0
    # irradiation conditions
    if action2.get() == 0:
        condition = 0
        depth = Editbox2.get()
    else:
        condition = 1
        depth = 0
    # volume
    if eq.get():
        value = eval(eq.get())
    else:
        value = 0
    val_arr = str(time)+' '+str(value)+' '+str(action1.get())+' '+str(condition)+' '+str(depth)
    # bare or Cd covered
    if Editbox4.get():
        thick = Editbox4.get()
    else:
        thick = 0
    op_arr = str(thick)
    input_arr = val_arr +' '+ op_arr
    # execute activation calculation program
    cover = action4.get()
    if cover == 0:
        p = subprocess.Popen(['python3','activation_calc_ver2.py'], stdin = subprocess.PIPE, stdout = subprocess.PIPE)
    else:
        p = subprocess.Popen(['python3','activation_calc_withCd_ver2.py'], stdin = subprocess.PIPE, stdout = subprocess.PIPE)
    p.stdin.write(input_arr.encode('utf-8'))
    out = p.communicate()[0]
    output = out.decode('utf-8')
    result.set(output)

def state0():
    check0 = action2.get()
    if check0 == 0:
        Editbox2.configure(state = 'normal')
    else:
        Editbox2.delete(0, tkinter.END)
        Editbox2.configure(state = 'disabled')

def state1():
    check1 = action3.get()
    if check1 == 1:
        action1.set(0)
        element2.configure(state = 'disabled')
        element3.configure(state = 'disabled')
        option2.configure(state = 'normal')

    else:
        action4.set(0)
        Editbox4.configure(state = 'disabled')
        option2.configure(state = 'disabled')
        element2.configure(state = 'normal')
        element3.configure(state = 'normal')

def state2():
    check2 = action4.get()
    if check2 == 1:
        Editbox4.configure(state = 'normal')
    else:
        Editbox4.configure(state = 'disabled')

root = tkinter.Tk()
root.title('activity calculation for iBNCT')
root.geometry('450x550')

# variable definition
check1 = tkinter.BooleanVar()
check1.set(False)

action1 = tkinter.IntVar()
action1.set(0)

action2 = tkinter.IntVar()
action2.set(0)

action3 = tkinter.IntVar()
action3.set(0)

action4 = tkinter.IntVar()
action4.set(0)

eq = tkinter.StringVar()
eq.set('')

result = tkinter.StringVar()
result.set('')

# component
mode = tkinter.Checkbutton(text='rough', variable = check1)
mode.place(x = 300,y =70)

frame0 = tkinter.Frame(root, relief = 'ridge')
frame0.place(x = 70,y =30)

tkinter.Label(frame0, text = 'irradiation time[sec]').pack(anchor = 'w')
Editbox1 = tkinter.Entry(frame0)
Editbox1.pack(anchor = 'w')
Editbox1.focus_set()

frame1 = tkinter.LabelFrame(root, text = 'element', relief = 'ridge',labelanchor = 'nw')
frame1.place(x = 70,y =90)
element1 = tkinter.Radiobutton(frame1, text= '197Au', variable = action1, value = 0)
element1.pack(fill = 'x')
element2 = tkinter.Radiobutton(frame1, text= '115In', variable = action1, value = 1)
element2.pack(fill = 'x')
element3 = tkinter.Radiobutton(frame1, text= '55Mn', variable = action1, value = 2)
element3.pack(fill = 'x')

frame2 = tkinter.LabelFrame(root, text = 'conditions', relief = 'ridge',labelanchor = 'nw')
frame2.place(x = 170,y =90)
condition1 = tkinter.Radiobutton(frame2, text= 'water phantom', variable = action2, value = 0, command = state0)
condition1.pack(fill = 'x')
tkinter.Label(frame2, text = 'depth[cm]').pack(anchor = 'w')
Editbox2 = tkinter.Entry(frame2, width = 15)
Editbox2.pack()
condition3 = tkinter.Radiobutton(frame2, text= 'free beam', variable = action2, value = 1, command = state0)
condition3.pack(fill = 'x')
condition3 = tkinter.Radiobutton(frame2, text= 'moderator for LiCaAlF6', variable = action2, value = 2, command = state0)
condition3.pack(fill = 'x')

frame3 = tkinter.LabelFrame(root, text = 'type', relief = 'ridge',labelanchor = 'nw')
frame3.place(x = 70,y =200)
type1 = tkinter.Radiobutton(frame3, text= 'foil', variable = action3, value = 0, command = state1)
type1.pack(fill = 'x')
type2 = tkinter.Radiobutton(frame3, text= 'wire', variable = action3, value = 1, command = state1)
type2.pack(fill = 'x')

frame4 = tkinter.Frame(root, relief = 'ridge')
frame4.place(x = 170,y =250)
tkinter.Label(frame4, text = 'volume[cm3]').pack(anchor = 'w')
Editbox3 = tkinter.Entry(frame4, textvariable = eq)
Editbox3.pack(anchor = 'w')

frame5 = tkinter.LabelFrame(root, text = 'option', relief = 'ridge',labelanchor = 'nw')
frame5.place(x = 70,y =310)
option1 = tkinter.Radiobutton(frame5, text = 'bare', variable = action4, value = 0, command = state2)
option1.pack(fill = 'x')
option2 = tkinter.Radiobutton(frame5, text = 'Cd covered', variable = action4, value = 1, command = state2, state = 'disabled')
option2.pack(fill = 'x')

frame6 = tkinter.Frame(root, relief = 'ridge')
frame6.place(x = 200,y =330)
tkinter.Label(frame6, text = 'Cd thickness[cm]').pack(anchor = 'w')
Editbox4 = tkinter.Entry(frame6,state = 'disabled', width = 15)
Editbox4.pack(anchor = 'w')

Button1 = tkinter.Button(root, text = 'calc')
Button1.bind('<Button-1>', calc)
Button1.place(x = 170,y =410)

Button2 = tkinter.Button(root, text = 'clear')
Button2.bind('<Button-1>', delete)
Button2.place(x = 240,y =410)

frame7 = tkinter.Frame(root, relief = 'ridge')
frame7.place(x = 170,y =460)

tkinter.Label(frame7, text = 'calculation result[Bq]').pack(anchor = 'w')
Editbox5 = tkinter.Entry(frame7, textvariable = result)
Editbox5.pack(anchor = 'w')

root.mainloop()
