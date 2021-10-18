from logger import App_Logger
import sys
from ladder import Ladder
from snake import Snake
import json
f = open('config.json')
data = json.load(f)


class Board:
    def __init__(self):
        self.board = [[False, None] for _ in range(data['board_size'] + 1)]
        self.logger = App_Logger()
        self.log_file = open("my_logs.txt", 'a+')

        try:
            for s in data['snakes']:
                snake = Snake(s[0],s[1])
                start_pos = snake.get_start_pos()
                self.board[start_pos][0] = True
                self.board[start_pos][1] = snake.get_end_pos()

            for l in data['ladders']:
                ladder = Ladder(l[0],l[1])
                start_pos = ladder.get_start_pos()
                self.board[start_pos][0] = True
                self.board[start_pos][1] = ladder.get_end_pos()
        except Exception as e:
            self.logger.log(self.log_file, "failed because:: %s" % e)
            self.log_file.close()
            sys.exit(1)

