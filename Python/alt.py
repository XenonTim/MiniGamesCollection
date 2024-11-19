game = int(input("Введіть '1', щоб обрати Камінь, ножиці, папір або '2', щоб обрати Хрестики-нулики: "))
if game == 2:
    from random import choice
    def create_board():
        return [[' ' for _ in range(3)] for _ in range(3)]
    def check_winner(board, symbol):
        for row in board:
            if all(cell == symbol for cell in row):
                return True
        for col in range(3):
            if all(board[row][col] == symbol for row in range(3)):
                return True
        if all(board[i][i] == symbol for i in range(3)) or all(board[i][2 - i] == symbol for i in range(3)):
            return True
        return False
    def is_full(board):
        return all(cell != ' ' for row in board for cell in row)
    def player_move(board, row, col):
        if board[row][col] == ' ':
            board[row][col] = 'X'
        return board
    def computer_move(board):
        empty_cells = [(r, c) for r in range(3) for c in range(3) if board[r][c] == ' ']
        row, col = choice(empty_cells)
        board[row][col] = 'O'
        return board
    def print_board(board):
        for row in board:
            print('|'.join(row))
            print('-' * 5)
    def main():
        board = create_board()
        while True:
            print_board(board)
            row, col = map(int, input("Ваш хід (рядок і стовпець): ").split())
            board = player_move(board, row, col)
            if check_winner(board, 'X'):
                print("Ви перемогли!")
                break
            if is_full(board):
                print("Нічия!")
                break
            board = computer_move(board)
            if check_winner(board, 'O'):
                print("Комп'ютер переміг!")
                break
    if __name__ == "__main__":
        main()
elif game == 1:
    import random
    def get_computer_choice():
        choices = ["камінь", "ножиці", "папір"]
        return random.choice(choices)
    def determine_winner(player, computer):
        if player == computer:
            return "Нічия!"
        elif (player == "камінь" and computer == "ножиці") or \
             (player == "ножиці" and computer == "папір") or \
             (player == "папір" and computer == "камінь"):
            return "Ви перемогли!"
        else:
            return "Комп'ютер переміг!"
    def main():
        player_choice = input(("Введіть ваш вибір: 'камінь', 'ножиці' або 'папір': "))
        if player_choice not in ["камінь", "ножиці", "папір"]:
            print("Неправильний вибір.")
        computer_choice = get_computer_choice()
        result = determine_winner(player_choice, computer_choice)
        print(result)

    if __name__ == "__main__":
        main()
else:
    print("Неккоректний ввод")
