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