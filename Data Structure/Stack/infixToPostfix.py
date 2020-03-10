class Conversion:
    def __init__(self, capacity):
        self.top = -1
        self.array = []
        self.capacity = capacity
        self.output = []
        self.precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}

    def isEmpty(self):
        return True if self.top == -1 else False

    def peek(self):
        return self.array[-1]

    def push(self, ele):
        self.top += 1
        self.array.append(ele)

    def pop(self):
        if not self.isEmpty():
            self.top -= 1
            self.array.pop()
        else:
            return "$"

    def isOperand(self, ch):
        return ch.isalpha()

    def notGreater(self, i):
        try:
            a = self.precedence[i]
            b = self.precedence[self.peek()]
            return True if a <= b else False
        except KeyError:
            return False


    def infixtopostfix(self,expr):
        for i in expr:
            if self.isOperand(i):
                self.output.append(i)

            elif i == '(':
                self.push(i)

            elif i == ')':
                
            
