from random import randint


class Snake:
    def __init__(self, start_pos, end_pos):
        self.start_pos = start_pos
        self.end_pos = end_pos

    def get_start_pos(self):
        return self.start_pos

    def get_end_pos(self):
        return self.end_pos

    def set_start_pos(self, start_pos):
        self.start_pos = start_pos

    def set_end_pos(self, end_pos):
        self.end_pos = end_pos


class Ladder:
    def __init__(self, start_pos, end_pos):
        self.start_pos = start_pos
        self.end_pos = end_pos

    def get_start_pos(self):
        return self.start_pos

    def get_end_pos(self):
        return self.end_pos

    def set_start_pos(self, start_pos):
        self.start_pos = start_pos

    def set_end_pos(self, end_pos):
        self.end_pos = end_pos


class Player:
    def __init__(self, name, pos):
        self.name = name
        self.pos = pos

    def get_name(self):
        return self.name

    def get_pos(self):
        return self.pos

    def set_name(self, name):
        self.name = name

    def set_pos(self, pos):
        self.pos = pos


class Dice:
    def __init__(self):
        self.number = None

    def get_number(self):
        return self.number

    def throw_dice(self):
        self.number = randint(1, 6)
        return self.number


class Board:
    def __init__(self, size, snakes, ladders):
        self.board = [[False, None] for _ in range(size + 1)]

        for snake in snakes:
            start_pos = snake.get_start_pos()
            self.board[start_pos][0] = True
            self.board[start_pos][1] = snake.get_end_pos()

        for ladder in ladders:
            start_pos = ladder.get_start_pos()
            self.board[start_pos][0] = True
            self.board[start_pos][1] = ladder.get_end_pos()


# game configuration
class Constants:
    def __init__(self):
        self.board_size = 50  # set board size
        self.snakes = [Snake(13, 17)]  # set snakes between two blocks
        self.ladders = [Ladder(2, 15), Ladder(14, 30)]  # set ladders between two blocks
        self.players = [Player("Raj", 1), Player("Para", 1)]  # set players with name and initial position


def main():
    const = Constants()
    my_board = Board(const.board_size, const.snakes, const.ladders)
    dice = Dice()
    game_on = True

    try:
        while game_on:
            for player in const.players:
                print(player.get_name())
                dice_val = dice.throw_dice()
                print(dice_val)
                next_pos = player.get_pos() + dice_val

                if next_pos <= const.board_size:
                    if my_board.board[next_pos][0]:
                        print("meet ladder or snake here")
                        next_pos = my_board.board[next_pos][1]

                    player.set_pos(next_pos)
                    print(next_pos)
                    if next_pos == const.board_size:
                        print()
                        print("Hurrah " + player.get_name() + " Has Won The Game")
                        game_on = False
                        break
                else:
                    print("Out Of Bound")
        print("Thank you for playing")
    except Exception as e:
        print(e)


if __name__ == "__main__":
    main()



