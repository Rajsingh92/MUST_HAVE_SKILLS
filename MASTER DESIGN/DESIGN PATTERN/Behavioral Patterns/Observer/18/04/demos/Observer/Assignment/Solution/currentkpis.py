from observer import AbsObserver

class CurrentKPIs(AbsObserver):
    open_tickets = -1
    closed_tickets = -1
    new_tickets = -1
    
    def __init__(self, kpis):
        self._kpis = kpis
        kpis.attach(self)
        
    def update(self, values):
        self.open_tickets, self.closed_tickets, self.new_tickets = values
        self.display()
        
    def display(self):
        print('Current open tickets: {}'.format(self.open_tickets))
        print('New tickets in last hour: {}'.format(self.closed_tickets))
        print('Tickets closed in last hour: {}'.format(self.new_tickets))          
        print('*****\n')
        
    def __exit__(self, exc_type, exc_value, traceback):
        self._kpis.detach(self)
   