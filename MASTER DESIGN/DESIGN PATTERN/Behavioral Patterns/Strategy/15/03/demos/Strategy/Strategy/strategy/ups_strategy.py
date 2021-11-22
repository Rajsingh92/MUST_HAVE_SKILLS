from strategy.strategy_abc import AbsStrategy

class UPSStrategy(AbsStrategy):
    def calculate(self, order):
        return 4.00