from observer import AbsObserver

class CurrentKPIs(AbsObserver):
    open_tickets = -1
    closed_tickets = -1
    new_tickets = -1
    
    def __init__(self, kpis):
        self._kpis = kpis
        kpis.attach(self)
        
    def update(self):
        self.open_tickets = self._kpis.open_tickets
        self.closed_tickets = self._kpis.closed_tickets
        self.new_tickets = self._kpis.new_tickets
        self.display()
        
    def display(self):
        print('Current open tickets: {}'.format(self.open_tickets))
        print('New tickets in last hour: {}'.format(self.closed_tickets))
        print('Tickets closed in last hour: {}'.format(self.new_tickets))          
        print('*****\n')
        