from strategy.strategy_abc import AbsStrategy

class FedExStrategy(AbsStrategy):
    def calculate(self, order):
        return 3.00