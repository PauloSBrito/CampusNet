# Questão 01
# thisList = []

# aux = 1
# while aux != 0:
#     thisList.append(int(input("Digite um número: ")))
#     print(list)
#     aux = int(input("Digite [0] se você deseja parar: "))

# Get user input and split it into a list
# user_input = input("Enter elements separated by space: ").split()

# print("List:", user_input)

# Questão 02
# thisList = []

# # Get the number of elements
# num = int(input("Enter the number of elements: "))

# # Append elements to the list
# for i in range(num):
#     element = input(f"Enter a integer element {i+1}: ")
#     thisList.append(element)

# print("List:", thisList)

# sum = 0
# for i in range(num):
#    sum += int(thisList[i])

# print(F"A soma dos elemntos da lista é: {sum}")

#Questão 03
# thisList = []

# num = int(input("Digite a quantidade de elementos da lista: "))

# for i in range(num):
#     element = int(input(F"Digite o {i + 1}º número inteiro: "))
#     thisList.append(element)

# print("Lista: ", thisList)

# highest = thisList[0]
# lower = thisList[0]

# for i in range(num):
#     if thisList[i] > highest:
#         highest = thisList[i]

# print(F"O maior valor é: {highest}")

# for i in range(num):
#     if thisList[i] < lower:
#         lower = thisList[i]

# print(F"O menor valor é: {lower}")

# Questão 04

# thisList = []

# num = int(input("Quantos números inteiros você quer digitar? "))

# for i in range(num):
#     element = float(input(F"Digite o {i + 1}º elemento: "))
#     thisList.append(element)
# sum = 0

# for i in range(len(thisList)):
#     sum += thisList[i]

# print(F"A média entre os elementos da lista é: {sum / len(thisList)}")

# Questão 05

# thisList = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# print("Lista: ", thisList)

# num = int(input("Digite um número para multipicar os elementos da lista: "))

# for i in range(len(thisList)):
#     print(F"{thisList[i]} x {num} = {thisList[i] * num}")

# Questão 06

# thisList = []

# num = int(input("Digite uma quantidade de elementos para a lista: "))

# for i in range(num):
#     element = float(input("Digite um número: "))
#     thisList.append(element)

# print("A quantidade de elementos dessa lista é: ", len(thisList))

# Questão 07

# thisList = []

# num = int(input("Quantos números você que adicionar a lista? "))

# for i in range(num):
#     element = float(input(F"Digite o {i + 1}º número: "))
#     thisList.append(element)

# print("Lista: ", thisList)

# squaredList = []
# for i in range(len(thisList)):
#     squaredList.append(thisList[i] ** 2)

# print("Lista com números elevados ao quadrado: ", squaredList)

# Questão 08

# num = int(input("Digite um número de 1 a 12: "))

# # sem case

# thisList = ["Janeiro", "Fevereiro", "Março", 
#             "Abril", "Maio", "Junho", "Julho",
#             " Agosto", "Setembro", "Outubro ", 
#             "Novembro", "Dezembro"]

# result = ""
# for i in range(num):
#     result = thisList[i]

# print("O mês correspondente é: ", result)

# Questão 09

# num = int(input("Digite a quantidade de números da lista: "))

# thisList = []

# for i in range(num):
#     element = float(input(F"Digite o {i + 1} número: "))
#     thisList.append(element)

# pairList = []
# oddList = []
# for i in range(len(thisList)):
#     if thisList[i] % 2 == 0:
#         pairList.append(thisList[i])
#     else:
#         oddList.append(thisList[i])

# if len(pairList) != 0:
#     print("Lista de números pares: ", pairList)
# else:
#     print("Você não digitou nenhum número par.")

# if len(oddList) != 0:
#     print("Lista de números ímpares: ", oddList)
# else:
#     print("Você não digitou nenhum número ímpar.")

# Questão 10

# thisList = ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"]

# response = input("Digite um dia da semana: ")

# check = False
# for i in range(len(thisList)):
#     if response == thisList[i]:
#         check = True

# print(check)

# Questão 11

# thisList = []

# num = 10

# for i in range(num):
#     element = float(input(F"Digite o {i + 1}º número: "))
#     thisList.append(element)

# pairSum = 0
# for i in range(len(thisList)):
#     if thisList[i] % 2 == 0:
#         pairSum += thisList[i]

# print(F"A soma dos números pares dessa lista é: {pairSum}")

# Questão 12

# thisList = [1, -2, 4, 5, 6, -4, -89, -9, 0, -5]

# negativeQuantity = 0
# for i in range(len(thisList)):
#     if thisList[i] < 0:
#         negativeQuantity += 1
    
# print(F"A qauntidade de números negativos nessa lista é: {negativeQuantity}")

# Questão 13
# import statistics #Biblioteca de cálculos estatísticos

# thisList = [1, 2, 3, 4, 5, 6, 7, 8, 9,]
# print("Lista: ", thisList)
# # orderedList = sorted(thisList)
# # print("Lista ordenada: ", thisList)

# print("A mediana é: ", statistics.median(thisList))

# Questão 14

thisList = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

num = int(input("Digite um número: "))

check = False
for i in range(len(thisList)):
    if num == thisList[i]:
        check = True

if check == True:
    print("Esse número pertence a lista.")
else:
    print("Esse número não pertence a lista.")
