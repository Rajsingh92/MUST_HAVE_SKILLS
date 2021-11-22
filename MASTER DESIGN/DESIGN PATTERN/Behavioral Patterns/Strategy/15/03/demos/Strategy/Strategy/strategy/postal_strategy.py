from strategy.strategy_abc import AbsStrategy

class PostalStrategy(AbsStrategy):
    def calculate(self, order):
        return 5.00