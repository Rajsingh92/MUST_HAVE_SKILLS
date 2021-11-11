from board import Board
from dice import Dice
from logger import App_Logger
import sys
from player import Player
import json
f = open('config.json')
data = json.load(f)


class TestFailed(Exception):
    def __init__(self, m):
        self.message = m

    def __str__(self):
        return self.message


class Main:
    def __init__(self):
        self.logger = App_Logger()
        self.players = []

        for p in data['players']:
            self.players.append(Player(p['name'],p['pos']))

    def play(self):
        my_board = Board()
        dice = Dice()
        game_on = True

        log_file = open("my_logs.txt", 'a+')
        try:
            while game_on:
                if data['board_size'] > 1000:
                    raise TestFailed('board size should be less than 1000')

                for player in self.players:
                    print(player.get_name())
                    dice_val = dice.throw_dice()
                    print(dice_val)
                    next_pos = player.get_pos() + dice_val

                    if next_pos <= data['board_size']:
                        if my_board.board[next_pos][0]:
                            print("meet ladder or snake here")
                            next_pos = my_board.board[next_pos][1]

                        player.set_pos(next_pos)
                        print(next_pos)
                        if next_pos == data['board_size']:
                            print()
                            print("Hurrah " + player.get_name() + " Has Won The Game")
                            game_on = False
                            break
                    else:
                        print("Out Of Bound")

            print("Thank you for playing")
            self.logger.log(log_file, "  Player Won successfully!!")
        except Exception as e:
            self.logger.log(log_file, "failed because:: %s" % e)
            log_file.close()
            sys.exit(1)


if __name__ == "__main__":
    m = Main()
    m.play()



