#Questão 15

grossSalary = float(input("Digite o salario bruto: "))
loanValue = float(input("Digite o valor do emprestimo desejado: "))

#Prestação <= 0.25 do salário bruto

if(loanValue <= grossSalary * 0.25):
    print("O emprestimo pode ser concedido!")
else:
    print("O emprestimo não pode ser concedido.")

