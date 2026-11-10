alunos = {
    "Anna": [ 8.5, 7.0, 4.5 ],
    "Bob": [ 4.5, 2.5, 5.0 ],
    "Joca": [ 9.5, 7.5, 8.0 ],
    "Maria": [ 10.0, 9.5, 8.5 ],
}


def calcular_media_sala():
    soma_total = 0
    media_sala = 0
    for notas in alunos.values():
        soma_total += sum(notas)
    media_sala = soma_total / len(alunos)
    print(f"\n A média da sala é: {media_sala:.2f}")



def calcular_media_aluno():
    for aluno, notas in alunos.items():
        media = sum(notas) / len(notas)
        print(f"\n A média do aluno {aluno} é: {media:.2f}")



def calcular_quantidade_aprovados_reprovados():
    aprovados = 0
    reprovados = 0
    for notas in alunos.values():
        media = sum(notas)/len(notas)
        if media >= 7.0:
            aprovados += 1
        else:
            reprovados += 1
    print(f"\n Quantidade de aprovados: {aprovados}")
    print(f"\n Quantidade de reprovados: {reprovados}")

def gerar_relatorio():
    for aluno, notas in alunos.items():
        media = sum(notas) / len(notas)
        status = "Aprovado" if media >= 7.0 else "Reprovado"
        print(f"\n Aluno: {aluno} | Média: {media:.2f} | Status: {status}")



def exibir_menu():   
    while True:    
        print("\n--- MENU DE OPÇÕES ---")
        print("\n 1 - Calcular média da sala")
        print("\n 2 - Calcular média de cada aluno")
        print("\n 3 - Mostrar quantidade de aprovados e reprovados")
        print("\n 4 - Geração de relatório da turma")
        print("\n 5 - Sair")

        try:
            opcao_escolhida = int(input('\n Escolha uma opção: '))

            if opcao_escolhida == 1:
                calcular_media_sala()

            elif opcao_escolhida == 2:
                calcular_media_aluno()

            elif opcao_escolhida == 3:
                calcular_quantidade_aprovados_reprovados()

            elif opcao_escolhida == 4:
                gerar_relatorio()

            elif opcao_escolhida == 5:
                print("\n Saindo...")
                break
            else:
                print("\n Opção inválida. Tente novamente.")
        except ValueError:
            print("\n Digite uma opção válida.")


def main():
    exibir_menu()

if __name__ == "__main__":
    main()